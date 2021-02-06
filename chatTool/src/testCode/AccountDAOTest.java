package testCode;

import org.junit.jupiter.api.Test;

import DAO.AccountDAO;
import model.DataBaseObject;
import model.FormParameter;
import model.UserAccount;

class AccountDAOTest {

	@Test
	void finByUserTest1() {//ユーザー取得成功時
		FormParameter fp = new FormParameter("桜木くん","1234");
		DataBaseObject db = new DataBaseObject();
		AccountDAO dao = new AccountDAO(db.getJDBC_URL(),db.getDB_USER(),db.getDB_PASS());
		UserAccount result = dao.findByUser(fp);

		if(result != null &&
				result.getName().equals("桜木くん") &&
				result.getPass().equals("1234")
				) {
			System.out.println("ユーザー" + result.getName() + "が見つかりました");//期待値
		}else {
			System.out.println("ユーザーが見つかりませんでした");
		}
	}
	@Test
	void FindByUserTest2() {//ユーザー取得失敗時
		FormParameter fp = new FormParameter("桜くん","1234");
		DataBaseObject db = new DataBaseObject();
		AccountDAO dao = new AccountDAO(db.getJDBC_URL(),db.getDB_USER(),db.getDB_PASS());
		UserAccount result = dao.findByUser(fp);
		if(result == null) {
			System.out.println("データを取得できませんでした");//期待値
		}else {
			System.out.println("データを取得できました");
		}
	}
	@Test
	void finByUserTest3() {//データベースアクセスエラー
		FormParameter fp = new FormParameter("例外テスト","1234");
		DataBaseObject db = new DataBaseObject();
		AccountDAO dao = new AccountDAO("DataBaseAccessTest",db.getDB_USER(),db.getDB_PASS());
		UserAccount result = dao.findByUser(fp);

	}
	@Test
	void executetTest1() {//登録成功時
		FormParameter fp = new FormParameter("柏木くん","1212");
		DataBaseObject db = new DataBaseObject();
		AccountDAO dao = new AccountDAO(db.getJDBC_URL(),db.getDB_USER(),db.getDB_PASS());
		int result = dao.execute(fp);
		if(result ==1) {
			System.out.println("登録に成功しました");//期待値
		}else {
			System.out.println("登録に失敗しました");
		}
	}
	@Test
	void executeTest2() {//データベースアクセスエラー
		FormParameter fp = new FormParameter("柏木くん","1212");
		DataBaseObject db = new DataBaseObject();
		AccountDAO dao = new AccountDAO("DataBaseAccessTest",db.getDB_USER(),db.getDB_PASS());
		int result = dao.execute(fp);
	}
	@Test
	void executeTest3() {//登録失敗時
		FormParameter fp = new FormParameter(null,"1212");
		DataBaseObject db = new DataBaseObject();
		AccountDAO dao = new AccountDAO(db.getJDBC_URL(),db.getDB_USER(),db.getDB_PASS());
		int result = dao.execute(fp);
		if(result ==1) {
			System.out.println("登録に成功しました");
		}else {
			System.out.println("登録に失敗しました");//期待値
		}
	}

}
