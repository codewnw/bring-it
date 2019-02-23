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
import com.bringit.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public int saveCustomer(Customer Customer) {
		try (Connection con = DbUtil.getConn();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO BIT_Customer VALUES(?, ?, ?)")) {
			pstmt.setString(1, Customer.getId());
			pstmt.setString(2, Customer.getName());
			pstmt.setDouble(3, Customer.getPrice());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateCustomer(Customer Customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCustomer(String CustomerId) {
		try (Connection con = DbUtil.getConn(); Statement stmt = con.createStatement()) {
			return stmt.executeUpdate("DELETE FROM BIT_Customer WHERE ID = '" + CustomerId + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Customer getCustomer(String CustomerId) {
		try (Connection con = DbUtil.getConn(); Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM BIT_Customer WHERE ID = '" + CustomerId + "'");
			rs.next();
			return new Customer();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getCustomers() {
		try (Connection con = DbUtil.getConn(); Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM BIT_Customer");
			List<Customer> Customers = new ArrayList<>();
			while (rs.next()) {
				Customers.add(new Customer());
			}
			return Customers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public void createCustomerTable() {
		if (!DatabaseMetaDataUtil.isTableExists("bit_Customer")) {
			try (Connection con = DbUtil.getConn(); Statement stmt = con.createStatement()) {
				boolean b = stmt.execute(
						"CREATE TABLE bit_Customer(ID VARCHAR, NAME VARCHAR(50), DESCRIPTION VARCHAR(200), IMAGE_URL VARCHAR(200), CATEGORY VARCHAR(50), PRICE DECIMAL, QUANTITY NUMBER);");
				if (!b) {
					System.out.println("Customer Table created successfully.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
