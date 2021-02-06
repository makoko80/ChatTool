package model;

public class DataBaseObject {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/chatTool";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public String getJDBC_URL() {
		return this.JDBC_URL;
	}
	public String getDB_USER() {
		return this.DB_USER;
	}
	public String getDB_PASS() {
		return this.DB_PASS;
	}

}
