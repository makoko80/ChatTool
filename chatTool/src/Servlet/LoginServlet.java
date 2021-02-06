package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FormParameter;
import model.LoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("/chatTool/MainServlet");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		FormParameter fp = new FormParameter(name, pass);
		LoginLogic loginLogic = new LoginLogic();
		int determine = loginLogic.execute(fp, request);//ユーザーデータがあるか判定する
		RequestDispatcher dispatcher = null;

		switch (determine) {//データが存在しPASSが一致した場合、一致しなかった場合、データがなかった場合の処理
		case 1://データが存在しPASSが一致した場合の処理

			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginSuccess.jsp");
			dispatcher.forward(request, response);
			break;
		case 2://データが存在しパスワードが一致しなかった場合の処理
			request.setAttribute("errorMsg", "パスワードが一致しません");
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			break;
		case 3://データが存在しなかった場合の処理
			request.setAttribute("errorMsg", "データが存在しません");
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			break;
		}
		dispatcher.forward(request, response);

	}

}
