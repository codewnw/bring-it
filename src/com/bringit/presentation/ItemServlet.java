package com.bringit.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bringit.model.Item;
import com.bringit.service.ItemService;
import com.bringit.service.ItemServiceImpl;
import com.bringit.util.IdUtil;

@WebServlet({ "/items/save", "/items/update", "/items/delete/*", "/items/get/*", "/items/all" })
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
		} else if (url.contains("delete")) {
			String[] urlArray = url.split("/");
			int i = itemService.deleteItem(urlArray[urlArray.length - 1]);
			if (i > 0) {
				System.out.println("Deleted");
			} else {
				System.out.println("Not found");
			}
		}else if (url.contains("all")) {
			List<Item> items = itemService.getItems();
			request.setAttribute("items", items);
			request.getRequestDispatcher("../items.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		String id = IdUtil.getItemId();
		Item item = new Item();
		itemService.saveItem(item);
	}

}
