package com.acellere.collabathon_vaadin;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Utils {

	public static void main(String[] args) {
		Utils utils = new Utils();
		
		System.out.println(utils.getCategories());
	}
	
	public Utils() {
		// TODO Auto-generated constructor stub
	}

	public Map<String, String> getCategories() {
		Map<String, String> map = new HashMap<String, String>();//
		try {
			Properties properties = new Properties();
			BufferedInputStream stream = new BufferedInputStream(new FileInputStream("category.properties"));
			properties.load(stream);

			for (final String name : properties.stringPropertyNames()){
				map.put(name, properties.getProperty(name));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}

}
