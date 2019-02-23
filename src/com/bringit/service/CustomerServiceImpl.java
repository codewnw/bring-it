package com.bringit.service;

import java.util.List;

import com.bringit.dao.CustomerDao;
import com.bringit.dao.CustomerDaoImpl;
import com.bringit.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao CustomerDao;

	public CustomerServiceImpl() {
		CustomerDao = new CustomerDaoImpl();
	}

	@Override
	public int saveCustomer(Customer Customer) {
		return CustomerDao.saveCustomer(Customer);
	}

	@Override
	public int updateCustomer(Customer Customer) {
		return CustomerDao.updateCustomer(Customer);
	}

	@Override
	public int deleteCustomer(String CustomerId) {
		return CustomerDao.deleteCustomer(CustomerId);
	}

	@Override
	public Customer getCustomer(String CustomerId) {
		return CustomerDao.getCustomer(CustomerId);
	}

	@Override
	public List<Customer> getCustomers() {
		return CustomerDao.getCustomers();
	}

	@Override
	public void createCustomerTable() {
		CustomerDao.createCustomerTable();
	}

}
