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

@WebServlet({ "/items/save", "/items/update/*", "/items/delete/*", "/items/get/*", "/items/all" })
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
			request.setAttribute("item", item);
			System.out.println(item);
			request.getRequestDispatcher("../../item.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			String[] urlArray = url.split("/");
			int i = itemService.deleteItem(urlArray[urlArray.length - 1]);
			response.sendRedirect("../all");
		} else if (url.contains("update")) {
			String[] urlArray = url.split("/");
			Item item = itemService.getItem(urlArray[urlArray.length - 1]);
			request.setAttribute("item", item);
			request.getRequestDispatcher("../../add-item.jsp").forward(request, response);
		} else if (url.contains("all")) {
			List<Item> items = itemService.getItems();
			request.setAttribute("items", items);
			request.getRequestDispatcher("../items.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Double price = Double.parseDouble(request.getParameter("price"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		String imageUrl = request.getParameter("image");
		String category = request.getParameter("category");

		String url = request.getRequestURI();
		if (url.contains("save")) {
			String id = IdUtil.getItemId();

			Item item = new Item();
			item.setName(name);
			item.setDescription(description);
			item.setCategory(category);
			item.setImageUrl(imageUrl);
			item.setQuantity(quantity);
			item.setId(id);
			item.setPrice(price);

			int i = itemService.saveItem(item);
			if (i > 0) {
				response.sendRedirect("all");
			} else {
				response.sendRedirect("../add-item.jsp");
			}

		} else {
			String id = request.getParameter("id");
			Item item = new Item();
			item.setName(name);
			item.setDescription(description);
			item.setCategory(category);
			item.setImageUrl(imageUrl);
			item.setQuantity(quantity);
			item.setId(id);
			item.setPrice(price);
			int i = itemService.updateItem(item);
			if (i > 0) {
				response.sendRedirect("../../all");
			} else {
				response.sendRedirect("../add-item.jsp");
			}
		}
	}

}
