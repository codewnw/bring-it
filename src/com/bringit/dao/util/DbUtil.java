package com.bringit.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	private static Connection connection;

	public static Connection getConn() throws SQLException {
		if (connection == null || connection.isClosed()) {
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		}
		return connection;
	}

}
