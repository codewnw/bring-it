package com.bringit.model;

public class Customer {

	private String id;

	private String name;

	private Double price;

	private String imageUrl;

	private String description;

	private int quantity;

	private String category;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Customer(String id, String name, Double price, String imageUrl, String description, int quantity,
			String category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
		this.description = description;
		this.quantity = quantity;
		this.category = category;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuanity() {
		return quantity;
	}

	public void setQuanity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	

}
