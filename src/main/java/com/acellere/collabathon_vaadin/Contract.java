package com.acellere.collabathon_vaadin;

import com.vaadin.ui.Link;

public class Contract {
	
	private String name;
	private String description; 
	private Link link;

	public Contract(String name, String description, Link link) {
		this.setName(name);
		this.setDescription(description);
		this.setLink(link);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

}
