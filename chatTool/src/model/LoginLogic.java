package model;

import DAO.AccountDAO;

public class LoginLogic {

	public UserAccount execute(FormParameter login) {

		DataBaseObject db = new DataBaseObject();
		AccountDAO dao = new AccountDAO(db.getJDBC_URL(), db.getDB_USER(), db.getDB_PASS());
		UserAccount result = dao.findByUser(login);
		return result;
	}
}
