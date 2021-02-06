package model;

import java.io.Serializable;

public class UserAccount implements Serializable  {
	private int id;
	private String name;
	private String pass;

	public UserAccount() {}
	public UserAccount(int id,String name,String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getPass() {
		return this.pass;
	}
}
