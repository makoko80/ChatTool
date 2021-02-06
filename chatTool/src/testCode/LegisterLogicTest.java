package testCode;

import org.junit.jupiter.api.Test;

import model.FormParameter;
import model.LegisterLogic;


public class LegisterLogicTest {

	@Test
	void checkTest1(){
		FormParameter fp = new FormParameter("柏くん","1232");
		LegisterLogic legisterLogic = new LegisterLogic();
		boolean result = legisterLogic.check(fp);
		if(result) {
			System.out.println("登録できる状態です");//期待値
		}else {
			System.out.println("名前が存在します");
		}
	}
	@Test
	void checkTest2() {
		FormParameter fp = new FormParameter("桜木くん","1234");
		LegisterLogic legisterLogic = new LegisterLogic();
		boolean result = legisterLogic.check(fp);
		if(result) {
			System.out.println("登録できる状態です");
		}else {
			System.out.println("名前が存在します");//期待値
		}
	}
	@Test
	void executeTest1() {
		FormParameter fp = new FormParameter("茂木くん","1234");
		LegisterLogic legisterLogic = new LegisterLogic();
		boolean result = legisterLogic.execute(fp);
		if(result) {
			System.out.println("登録できました");
		}else {
			System.out.println("登録できませんでした");
		}
	}
	@Test
	void executeTest2() {
		FormParameter fp = new FormParameter("テストコード","1234");
		LegisterLogic legisterLogic = new LegisterLogic();
		boolean result = legisterLogic.execute(fp);
		if(result) {
			System.out.println("登録できました");
		}else {
			System.out.println("登録できませんでした");//期待値
		}
	}

}
