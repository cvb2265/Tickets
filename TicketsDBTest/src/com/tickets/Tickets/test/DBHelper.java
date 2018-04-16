package com.tickets.Tickets.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private String dbdriver;
	private String dburl;
	private String dbusername;
	private String dbpassword;
	public String getDbdriver() {
		return dbdriver;
	}
	public void setDbdriver(String dbdriver) {
		this.dbdriver = dbdriver;
	}
	public String getDburl() {
		return dburl;
	}
	public void setDburl(String dburl) {
		this.dburl = dburl;
	}
	public String getDbusername() {
		return dbusername;
	}
	public void setDbusername(String dbusername) {
		this.dbusername = dbusername;
	}
	public String getDbpassword() {
		return dbpassword;
	}
	public void setDbpassword(String dbpassword) {
		this.dbpassword = dbpassword;
	}

	public synchronized Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(dbdriver);
		Connection connection = DriverManager.getConnection(dburl,dbusername,dbpassword);
		return connection;
	}
}