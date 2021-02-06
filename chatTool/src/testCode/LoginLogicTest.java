package testCode;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import model.FormParameter;
import model.LoginLogic;

class LoginLogicTest {

	@Test
	void test1() {//ログイン成功時テスト
		FormParameter fp = new FormParameter("桜木くん","1234");
		LoginLogic loginLogic = new LoginLogic();
		HttpServletRequest request = null;
		int determine = loginLogic.execute(fp,request);

		switch(determine) {
		case 1:
			System.out.println("ログイン成功");
			break;
		case 2:
			System.out.println("パスワードが一致しません");
			break;
		case 3:
			System.out.println("データが存在しません");
		}
	}
	@Test
	void test2() {//パスワードミスマッチテスト
		FormParameter fp = new FormParameter("桜木くん","123");
		LoginLogic loginLogic = new LoginLogic();
		HttpServletRequest request = null;
		int determine = loginLogic.execute(fp,request);

		switch(determine) {
		case 1:
			System.out.println("ログイン成功");
			break;
		case 2:
			System.out.println("パスワードが一致しません");
			break;
		case 3:
			System.out.println("データが存在しません");
		}
	}
	@Test
	void test3() {//データベースに登録されていない場合のテスト
		FormParameter fp = new FormParameter("桜くん","1234");
		LoginLogic loginLogic = new LoginLogic();
		HttpServletRequest request = null;
		int determine = loginLogic.execute(fp,request);

		switch(determine) {
		case 1:
			System.out.println("ログイン成功");
			break;
		case 2:
			System.out.println("パスワードが一致しません");
			break;
		case 3:
			System.out.println("データが存在しません");
		}
	}

}
