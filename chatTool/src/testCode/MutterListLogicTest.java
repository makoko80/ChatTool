package testCode;

import org.junit.jupiter.api.Test;

import model.Mutter;
import model.MutterListLogic;

class MutterListLogicTest {

	@Test
	void getReplytest1() {//REPLY取得成功時
		Mutter mutter = new Mutter(1, "初めまして", "2222", 1);
		Mutter mutter2 = new Mutter(1, "わかりません", "2222", 1);
		MutterListLogic mutterListLogic = new MutterListLogic();

		mutter = mutterListLogic.getReply(mutter);
		mutter2 = mutterListLogic.getReply(mutter2);
		System.out.println(mutter.getReplyId());
		System.out.println(mutter2.getReplyId());
		System.out.println(mutter.getReply());//期待値「おやすみなさい」
		System.out.println(mutter2.getReply());//期待値「すみませんわかりません」

	}

	//	@Test
	//	void getMutterTest() {
	//		UserAccount loginUser = new UserAccount(51, "ひろし", "123");
	//		UserAccount loginUser2 = new UserAccount(1, "柏木くん", "1234");
	//		List<Mutter> mutterList = new ArrayList<>();
	//		MutterListLogic mutterListLogic = new MutterListLogic();
	//
	//		mutterList = mutterListLogic.getMutter(loginUser);
	//		for (Mutter mutter : mutterList) {
	//			System.out.println(mutter.getText());//期待値「おらごくう」
	//			System.out.println(mutter.getReply());//期待値「すみませんわかりません」
	//		}
	//		mutterList = mutterListLogic.getMutter(loginUser2);
	//		for (Mutter mutter : mutterList) {
	//			System.out.println(mutter.getText());//期待値「初めまして」「こんにちわ」×2
	//			System.out.println(mutter.getReply());//期待値「初めまして」×3
	//		}
	//	}
	//
	//	@Test
	//	void postMutterTest1() {//登録成功時
	//		Mutter mutter = new Mutter(1, "test", "2021/2/4", 51, "すみませんわかりません", 100);
	//		MutterListLogic mutterListLogic = new MutterListLogic();
	//		boolean result = mutterListLogic.postMutter(mutter);
	//		if (result) {
	//			System.out.println("登録成功");//期待値
	//		} else {
	//			System.out.println("登録失敗");
	//		}
	//	}
	//
	//	@Test
	//	void postMutterTest2() {//登録失敗時
	//		Mutter mutter = new Mutter(0, "test", "2021/2/4", 51, "すみませんわかりません", 100);
	//		MutterListLogic mutterListLogic = new MutterListLogic();
	//		boolean result = mutterListLogic.postMutter(mutter);
	//		if (result) {
	//			System.out.println("登録成功");
	//		} else {
	//			System.out.println("登録失敗");//期待値
	//		}
	//}
}
