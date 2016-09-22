package com.acellere.collabathon_vaadin;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Utils {

	public static Map<String, Collection<String>> getCategories() {
		Map<String, Collection<String>> map = new HashMap<String, Collection<String>>();

		map.put("Versicherung", Arrays.asList("Fidibus", "Techniker Krankenkasse"));
		map.put("Strom", Arrays.asList("Mainova", "Lichtblick"));
		map.put("Spenden", Arrays.asList("Greenpeace", "Christoffel Blindenmission"));
		map.put("Entertainment", Arrays.asList("Unitymedia"));
		map.put("Telefon", Arrays.asList("Vodafone"));
		map.put("Mitgliedsbeiträge", Arrays.asList("Corpora Fitness"));
		
		return map;
	}

}
