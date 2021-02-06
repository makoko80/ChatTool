package model;

import java.io.Serializable;

public class Mutter implements Serializable  {
	private int id;
	private String text;
	private String mutterDate;
	private int userId;
	private String reply;
	private int replyId;

	public Mutter() {
	}
	//投稿した場合
	public Mutter(int id,String text,String date,int userId) {
		this.id = id;
		this.text = text;
		this.mutterDate = date;
		this.userId = userId;
		this.reply = null;
		this.replyId = 1;
	}
	//データベースからMutter情報を取得する場合
	public Mutter(int id,String text,String date,int userId,String reply,int replyId) {
		this.id = id;
		this.text = text;
		this.mutterDate = date;
		this.userId = userId;
		this.reply = reply;
		this.replyId = replyId;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return this.text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDateNow() {
		return this.mutterDate;
	}
	public void setDateNow(String date) {
		this.mutterDate = date;
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getReply() {
		return this.reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public int getReplyId() {
		return this.replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

}
