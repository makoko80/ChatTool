package model;

import java.io.Serializable;

public class FormParameter implements Serializable  {


	private String name;
	private String pass;

	public FormParameter() {
	}

	public FormParameter(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public String getName() {
		return this.name;
	}
	public String getPass() {
		return this.pass;
	}

}
