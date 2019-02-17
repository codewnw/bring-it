package com.bringit.dao.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMetaDataUtil {

	public static boolean isTableExists(String tableName) {
		try {
			Connection con = DbUtil.getConn();
			DatabaseMetaData dbmd = con.getMetaData();

			ResultSet rs = dbmd.getTables(null, null, "%", null);
			while (rs.next()) {
				if (rs.getString(3).equalsIgnoreCase(tableName)) {
					System.out.println(tableName + " table is already exists.");
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
