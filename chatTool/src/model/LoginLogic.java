package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DAO.AccountDAO;

public class LoginLogic {

		public int execute(FormParameter login,HttpServletRequest request) {
			int determine = 0;
			DataBaseObject db = new DataBaseObject();
			AccountDAO dao = new AccountDAO(db.getJDBC_URL(),db.getDB_USER(),db.getDB_PASS());
			UserAccount result = dao.findByUser(login);

			if(result != null && login.getPass().equals(result.getPass())) {
				determine = 1;
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", result);

			}else if(result != null) {
				determine = 2;
			}else {
				determine = 3;
			}

			return determine;
		}
}
