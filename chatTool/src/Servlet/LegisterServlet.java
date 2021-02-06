package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FormParameter;
import model.LegisterLogic;

/**
 * Servlet implementation class LegisterServlet
 */
@WebServlet("/LegisterServlet")
public class LegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/legister.jsp");

		if (action == null) {//初回リクエスト時
			FormParameter fp = new FormParameter("", "");//空データ作成しセッションに保存
			session.setAttribute("legisterUser", fp);

		} else if (action.equals("legister")) {
			FormParameter legisterUser = (FormParameter) session.getAttribute("legisterUser");
			LegisterLogic legisterLogic = new LegisterLogic();
			boolean result = legisterLogic.execute(legisterUser);

			if (result) {
				session.invalidate();
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/legisterSuccess.jsp");
			} else {
				request.setAttribute("errorMsg", "登録に失敗しました");
			}
		}

		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		FormParameter legisterUser = new FormParameter(name, pass);
		LegisterLogic legisterLogic = new LegisterLogic();
		boolean result = legisterLogic.check(legisterUser);//同名のnameがあるか確認
		HttpSession session = request.getSession();
		session.setAttribute("legisterUser", legisterUser);
		RequestDispatcher dispatcher = null;
		if (result) {//同名のnameが存在しなかった場合の処理

			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/legisterCheck.jsp");

		} else {//同名のnameが存在する場合の処理

			request.setAttribute("errorMsg", "同じ名前は登録できません。");

			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/legister.jsp");

		}
		dispatcher.forward(request, response);
	}

}
