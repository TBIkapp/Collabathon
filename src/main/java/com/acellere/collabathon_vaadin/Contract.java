package com.acellere.collabathon_vaadin;

public class Contract {
	
	String name, id, keyWords, description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Contract(String name, String id, String keyWords, String description) {
		this.name = name;
		this.id = id;
		this.keyWords = keyWords;
		this.description = description;
	}

}
