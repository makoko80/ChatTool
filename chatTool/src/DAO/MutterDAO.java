package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Mutter;
import model.UserAccount;

public class MutterDAO {
	private final String JDBC_URL;
	private final String DB_USER;
	private final String DB_PASS;

	public MutterDAO(String JDBC_URL, String DB_USER, String DB_PASS) {
		this.JDBC_URL = JDBC_URL;
		this.DB_USER = DB_USER;
		this.DB_PASS = DB_PASS;
	}

	public int create(Mutter mutter) {
		int determine;

		//テストコード-----
		if (mutter.getId() == 0) {
			return 0;
		}
		//-----------------

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//INSERT文を準備
			String sql = "INSERT INTO MUTTER(TEXT,MUTTERDATE,USERID,REPLYID) VALUES(?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, mutter.getText());
			pStmt.setString(2, mutter.getDateNow());
			pStmt.setInt(3, mutter.getUserId());
			pStmt.setInt(4, mutter.getReplyId());

			//INSERT文を実行しテーブルに追加
			determine = pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			determine = 0;
		}
		return determine;

	}

	public List<Mutter> findMutter(List<Mutter> mutterList, UserAccount loginUser) {

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文準備 ユーザーIDでそのIDで投稿したデータを取ってくる
			String sql = "SELECT MUTTER.ID,TEXT,MUTTERDATE,USERID,REPLY,REPLY.ID AS REPLYID FROM MUTTER JOIN USER ON  MUTTER.USERID = USER.ID JOIN REPLY ON MUTTER.REPLYID = REPLY.ID WHERE USER.ID = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, loginUser.getId());

			ResultSet rs = pStmt.executeQuery();//SQL実行

			while (rs.next()) {
				int id = rs.getInt("ID");
				String text = rs.getString("TEXT");
				String mutterDate = rs.getString("MUTTERDATE");
				int userId = rs.getInt("USERID");
				String reply = rs.getString("REPLY");
				int replyId = rs.getInt("REPLYID");
				Mutter mutter = new Mutter(id, text, mutterDate, userId, reply, replyId);
				mutterList.add(mutter);//つぶやきを追加
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}

	public Mutter findReply(Mutter mutter, int replyId) {

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文
			String sql = "SELECT REPLY FROM REPLY WHERE ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, replyId);

			//SELECT文を実行しREPLYを取得
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {//取得したREPLYをmutterに入れる

				mutter.setReply(rs.getString("REPLY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return mutter;
	}
}
