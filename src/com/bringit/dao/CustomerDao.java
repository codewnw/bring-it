package com.bringit.dao;

import java.util.List;

import com.bringit.model.Customer;

public interface CustomerDao {
	void createCustomerTable();
	
	int saveCustomer(Customer Customer);

	int updateCustomer(Customer Customer);

	int deleteCustomer(String CustomerId);

	Customer getCustomer(String CustomerId);

	List<Customer> getCustomers();
}
