package com.acellere.collabathon_vaadin;

public class Contract {
	
	private String category;
	private String seller; 
	private Double amount;

	public Contract(String category, String seller, Double amount) {
		this.setCategory(category);
		this.setSeller(seller);
		this.setAmount(amount);
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
