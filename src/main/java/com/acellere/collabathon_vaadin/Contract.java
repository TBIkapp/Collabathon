package com.acellere.collabathon_vaadin;

import com.vaadin.ui.PopupView;

public class Contract {
	
	public String name;
	public String description; 
	public PopupView popup;
	private String canceldate;

	public Contract(String name, String description, PopupView popupView, String canceldate) {
		this.setName(name);
		this.setDescription(description);
		this.setLink(popupView);
		this.setCanceldate(canceldate);
	}

	@Override
	public String toString() {
		return name + " - " + description + " - " + popup;
	}
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public PopupView getLink() {
		return popup;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLink(PopupView popup) {
		this.popup = popup;
	}

	public String getCanceldate() {
		return canceldate;
	}

	public void setCanceldate(String canceldate) {
		this.canceldate = canceldate;
	}

}
