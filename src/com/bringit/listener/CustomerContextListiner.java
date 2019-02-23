package com.bringit.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.bringit.service.CustomerService;
import com.bringit.service.CustomerServiceImpl;

@WebListener
public class CustomerContextListiner implements ServletContextListener {
	private CustomerService CustomerService;

	public CustomerContextListiner() {
		CustomerService = new CustomerServiceImpl();
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Application is up");
		CustomerService.createCustomerTable();
	}

}
