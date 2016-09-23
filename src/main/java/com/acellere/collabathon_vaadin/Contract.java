package com.acellere.collabathon_vaadin;

import com.vaadin.ui.Link;

public class Contract {
	
	public String name;
	public String description; 
	public Link link;
	private String canceldate;

	public Contract(String name, String description, Link link, String canceldate) {
		this.setName(name);
		this.setDescription(description);
		this.setLink(link);
		this.setCanceldate(canceldate);
	}

	@Override
	public String toString() {
		return name + " - " + description + " - " + link;
	}
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Link getLink() {
		return link;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	public String getCanceldate() {
		return canceldate;
	}

	public void setCanceldate(String canceldate) {
		this.canceldate = canceldate;
	}

}
