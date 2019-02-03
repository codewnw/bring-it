package com.bringit.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bringit.model.Item;
import com.bringit.service.ItemService;
import com.bringit.service.ItemServiceImpl;

@WebServlet({ "/items/save", "/items/update", "/items/delete/*", "/items/get/*", "/items" })
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ItemService itemService;

	public ItemServlet() {
		itemService = new ItemServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		System.out.println(url);
		if (url.contains("get")) {
			System.out.println("--------");
			String[] urlArray = url.split("/");
			Item item = itemService.getItem(urlArray[urlArray.length - 1]);
			System.out.println(item);
		}else if(url.contains("delete")) {
			String[] urlArray = url.split("/");
			int i = itemService.deleteItem(urlArray[urlArray.length - 1]);
			if(i > 0) {
				System.out.println("Deleted");
			}else {
				System.out.println("Not found");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
