package testCode;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import DAO.MutterDAO;
import model.DataBaseObject;
import model.Mutter;
import model.UserAccount;

public class MutterDAOTest {

	@Test
	void createTest1() {//投稿データ登録成功時
		Mutter mutter = new Mutter(1, "こんにちわ", "2021/02/03", 1);
		DataBaseObject db = new DataBaseObject();
		MutterDAO dao = new MutterDAO(db.getJDBC_URL(), db.getDB_USER(), db.getDB_PASS());
		int result = dao.create(mutter);
		if (result == 1) {
			System.out.println("登録成功しました");//期待値
		} else {
			System.out.println("登録失敗しました");
		}
	}

	@Test
	void createTest2() {//登録失敗時
		Mutter mutter = new Mutter(1, null, "2021/02/03", 1);
		DataBaseObject db = new DataBaseObject();
		MutterDAO dao = new MutterDAO(db.getJDBC_URL(), db.getDB_USER(), db.getDB_PASS());
		int result = dao.create(mutter);
		//SQLExceptionエラー
	}

	@Test
	void findMutterTest1() {//投稿データの取得成功時
		List<Mutter> mutterList = new ArrayList<>();
		UserAccount loginUser = new UserAccount(1, "柏木くん", "1234");
		DataBaseObject db = new DataBaseObject();
		MutterDAO dao = new MutterDAO(db.getJDBC_URL(), db.getDB_USER(), db.getDB_PASS());
		mutterList = dao.findMutter(mutterList, loginUser);
		if (mutterList != null) {
			for (Mutter mutter : mutterList) {
				System.out.println(mutter.getText());//期待値
			}
		} else {
			System.out.println("取得に失敗しました");
		}

	}

	@Test
	void findMutterTest2() {//投稿データの取得失敗時
		List<Mutter> mutterList = null;
		UserAccount loginUser = new UserAccount(100, "柏木くん", "1234");
		DataBaseObject db = new DataBaseObject();
		MutterDAO dao = new MutterDAO(db.getJDBC_URL(), db.getDB_USER(), db.getDB_PASS());
		mutterList = dao.findMutter(mutterList, loginUser);
		if (mutterList != null) {
			for (Mutter mutter : mutterList) {
				System.out.println(mutter.getText());
			}
		} else {
			System.out.println("取得に失敗しました");//期待値
		}
	}

	@Test
	void findMutterTest3() {//データベースアクセスエラー
		List<Mutter> mutterList = new ArrayList<>();
		UserAccount loginUser = new UserAccount(100, "柏木くん", "1234");
		DataBaseObject db = new DataBaseObject();
		MutterDAO dao = new MutterDAO("DataBaseAccessTest", db.getDB_USER(), db.getDB_PASS());
		mutterList = dao.findMutter(mutterList, loginUser);
		if (mutterList != null) {
			for (Mutter mutter : mutterList) {
				System.out.println(mutter.getText());
			}
		} else {
			System.out.println("取得に失敗しました");//期待値
		}
	}

	@Test
	void findReply1() {//REPLYデータ取得成功時
		Mutter mutter = new Mutter(1, "初めまして", "2021/02/03", 1);
		int replyId = 1;
		DataBaseObject db = new DataBaseObject();
		MutterDAO dao = new MutterDAO(db.getJDBC_URL(), db.getDB_USER(), db.getDB_PASS());
		Mutter reply = dao.findReply(mutter, replyId);
		if (reply != null) {
			System.out.println(reply.getReply());//期待値
		} else {
			System.out.println("reply取得に失敗しました");
		}
	}

	@Test
	void findReply2() {//REPLYデータ取得失敗時
		Mutter mutter = new Mutter(1, "初めまして", "2021/02/03", 1);
		int replyId = 10000;
		DataBaseObject db = new DataBaseObject();
		MutterDAO dao = new MutterDAO(db.getJDBC_URL(), db.getDB_USER(), db.getDB_PASS());
		Mutter reply = dao.findReply(mutter, replyId);
		if (reply.getReply() == null) {
			System.out.println("reply取得に失敗しました");//期待値
		} else {
			System.out.println(reply.getReply());
		}

	}

	@Test
	void findReply3() {//データベースアクセスエラー
		Mutter mutter = new Mutter(1, "初めまして", "2021/02/03", 1);
		int replyId = 10000;
		DataBaseObject db = new DataBaseObject();
		MutterDAO dao = new MutterDAO("DataBaseAccessTest", db.getDB_USER(), db.getDB_PASS());
		Mutter reply = dao.findReply(mutter, replyId);

		if (reply != null) {
			System.out.println(reply.getReply());
		} else {
			System.out.println("reply取得に失敗しました");//期待値
		}
	}

}
