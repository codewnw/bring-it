package com.bringit.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bringit.model.Customer;
import com.bringit.service.CustomerService;
import com.bringit.service.CustomerServiceImpl;
import com.bringit.util.IdUtil;

@WebServlet({ "/Customers/save", "/Customers/update", "/Customers/delete/*", "/Customers/get/*", "/Customers/all" })
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerService CustomerService;

	public CustomerServlet() {
		CustomerService = new CustomerServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		System.out.println(url);
		if (url.contains("get")) {
			System.out.println("--------");
			String[] urlArray = url.split("/");
			Customer Customer = CustomerService.getCustomer(urlArray[urlArray.length - 1]);
			System.out.println(Customer);
		} else if (url.contains("delete")) {
			String[] urlArray = url.split("/");
			int i = CustomerService.deleteCustomer(urlArray[urlArray.length - 1]);
			if (i > 0) {
				System.out.println("Deleted");
			} else {
				System.out.println("Not found");
			}
		}else if (url.contains("all")) {
			List<Customer> Customers = CustomerService.getCustomers();
			request.setAttribute("Customers", Customers);
			request.getRequestDispatcher("../Customers.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		String id = IdUtil.getCustomerId();
		Customer Customer = new Customer();
		CustomerService.saveCustomer(Customer);
	}

}
