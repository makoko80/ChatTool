package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.MutterListLogic;
import model.UserAccount;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, IndexOutOfBoundsException {

		HttpSession session = request.getSession();
		UserAccount loginUser = (UserAccount) session.getAttribute("loginUser");
		if (loginUser == null) {//ログインユーザー情報がなければメニューへリダイレクト
			response.sendRedirect("/chatTool/MenuServlet");
		} else {
			List<Mutter> mutterList = new ArrayList<Mutter>();
			MutterListLogic mutterListLogic = new MutterListLogic();
			mutterList = mutterListLogic.getMutter(loginUser);
			if (mutterList.isEmpty()) {//初回ログイン時
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String d = sdf.format(date);
				String reply = "どうも！会話Botです！なんでもおっしゃってください！";
				Mutter mutter = new Mutter(0, "", d, loginUser.getId(), reply, 9999);
				mutterList.add(mutter);
			}
			session.setAttribute("mutterList", mutterList);
			Collections.reverse(mutterList);
			request.setAttribute("saidMutterList", mutterList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, IndexOutOfBoundsException {

		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");//テキストフォームを取得
		//セッションスコープからloginUserとmutteListを取得
		HttpSession session = request.getSession();
		List<Mutter> mutterList = (List<Mutter>) session.getAttribute("mutterList");
		UserAccount loginUser = (UserAccount) session.getAttribute("loginUser");

		Mutter lastMutter = mutterList.get(mutterList.size() - 1);//最後のmutterを取得
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String d = sdf.format(date);
		Mutter mutter = new Mutter(lastMutter.getId() + 1, text, d, loginUser.getId());//投稿情報を作成
		MutterListLogic mutterListLogic = new MutterListLogic();
		mutter = mutterListLogic.getReply(mutter);//Replyを取得
		mutterListLogic.postMutter(mutter);//投稿情報をデータベースに登録
		mutterList.add(mutter);
		Collections.reverse(mutterList);//mutteristを反転する
		request.setAttribute("saidMutterList", mutterList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
