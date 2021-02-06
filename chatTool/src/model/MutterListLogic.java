package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.MutterDAO;

public class MutterListLogic {

	private DataBaseObject db;
	private MutterDAO dao;

	public MutterListLogic() {
		this.db = new DataBaseObject();
		this.dao = new MutterDAO(db.getJDBC_URL(), db.getDB_USER(), db.getDB_PASS());
	}

	public boolean postMutter(Mutter mutter) {
		boolean determine = false;
		int result = this.dao.create(mutter);
		if (result == 1) {
			determine = true;
		}
		return determine;
	}

	public List<Mutter> getMutter(UserAccount loginUser) {
		List<Mutter> mutterList = new ArrayList<>();
		mutterList = this.dao.findMutter(mutterList, loginUser);
		return mutterList;
	}

	public Mutter getReply(Mutter mutter) {
		//正規表現の配列、、、データベースにしたほうが良いか？
		String regex[] = { "初めまして", "こんにちは", "おはようございます", "おやすみなさい" ,"疲れた","ありがとう","はい"};
		for (int i = 0; i < regex.length; i++) {
			Pattern p = Pattern.compile(regex[i]);
			Matcher m = p.matcher(mutter.getText());
			if (m.find()) {

				int replyId = i + 1;
				mutter.setReplyId(replyId);
				mutter = this.dao.findReply(mutter, replyId);
				return mutter;
			}

		}
		mutter.setReplyId(100);
		mutter = this.dao.findReply(mutter, 100);
		return mutter;

	}

}
