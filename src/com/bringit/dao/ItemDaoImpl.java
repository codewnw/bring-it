package com.bringit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bringit.dao.util.DatabaseMetaDataUtil;
import com.bringit.dao.util.DbUtil;
import com.bringit.model.Item;

public class ItemDaoImpl implements ItemDao {

	@Override
	public int saveItem(Item item) {
		try (Connection con = DbUtil.getConn();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO BIT_ITEM VALUES(?, ?, ?)")) {
			pstmt.setString(1, item.getId());
			pstmt.setString(2, item.getName());
			pstmt.setDouble(3, item.getPrice());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateItem(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItem(String itemId) {
		try (Connection con = DbUtil.getConn(); Statement stmt = con.createStatement()) {
			return stmt.executeUpdate("DELETE FROM BIT_ITEM WHERE ID = '" + itemId + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Item getItem(String itemId) {
		try (Connection con = DbUtil.getConn(); Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM BIT_ITEM WHERE ID = '" + itemId + "'");
			rs.next();
			return new Item();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Item> getItems() {
		try (Connection con = DbUtil.getConn(); Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM BIT_ITEM");
			List<Item> items = new ArrayList<>();
			while (rs.next()) {
				items.add(new Item());
			}
			return items;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public void createItemTable() {
		if (!DatabaseMetaDataUtil.isTableExists("bit_item")) {
			try (Connection con = DbUtil.getConn(); Statement stmt = con.createStatement()) {
				boolean b = stmt.execute(
						"CREATE TABLE bit_item(ID VARCHAR, NAME VARCHAR(50), DESCRIPTION VARCHAR(200), IMAGE_URL VARCHAR(200), CATEGORY VARCHAR(50), PRICE DECIMAL, QUANTITY NUMBER);");
				if (!b) {
					System.out.println("Item Table created successfully.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
