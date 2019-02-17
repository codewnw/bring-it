package com.bringit.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.bringit.service.ItemService;
import com.bringit.service.ItemServiceImpl;

@WebListener
public class MyServletContextListener implements ServletContextListener {
	private ItemService itemService;

	public MyServletContextListener() {
		itemService = new ItemServiceImpl();
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Application is up");
		itemService.createItemTable();
	}

}
