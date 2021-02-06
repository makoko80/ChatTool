package model;

import DAO.AccountDAO;

public class LegisterLogic {

	private boolean determine;
	private DataBaseObject db;
	private AccountDAO dao;

	public LegisterLogic() {
		this.determine = false;
		this.db = new DataBaseObject();
		this.dao = new AccountDAO(db.getJDBC_URL(), db.getDB_USER(), db.getDB_PASS());
	}

	public boolean check(FormParameter legisterUser) {

		UserAccount result = this.dao.findByUser(legisterUser);

		if (result == null) {
			this.determine = true;
		} else {
			this.determine = false;
		}
		return this.determine;

	}

	public boolean execute(FormParameter legisterUser) {
		int result = this.dao.execute(legisterUser);
		boolean ret = false;

		if (result == 1) {
//			HttpSession session = request.getSession();
//			session.invalidate();
			ret = true;
		}
		 return ret;
	}
}
