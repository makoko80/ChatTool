package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.FormParameter;
import model.UserAccount;

public class AccountDAO {
	private String JDBC_URL;
	private String DB_USER;
	private String DB_PASS;

	public AccountDAO(String JDBC_URL, String DB_USER, String DB_PASS) {
		this.JDBC_URL = JDBC_URL;
		this.DB_USER = DB_USER;
		this.DB_PASS = DB_PASS;
	}

	public UserAccount findByUser(FormParameter user) {
		UserAccount userAccount = null;

		//データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "SELECT * FROM USER WHERE NAME = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getName());

			//SELECT文を実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();

			//nameと一致したデータが存在した場合
			//そのユーザーのUserAccountインスタンスを生成
			if (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				userAccount = new UserAccount(id, name, pass);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userAccount;

	}

	public int execute(FormParameter legisterUser) {
		int determine;

//		if(legisterUser.getName().equals("LegisterLogicテストコード")) {
//			return 0;
//		}

		//データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//INSERT文を準備
			String sql = "INSERT INTO USER(NAME,PASS) VALUES(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, legisterUser.getName());
			pStmt.setString(2, legisterUser.getPass());

			//INSERT文の実行
			determine = pStmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
			determine = 0;
		}
		return determine;
	}

}
