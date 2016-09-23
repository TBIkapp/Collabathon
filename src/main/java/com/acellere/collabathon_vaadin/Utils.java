package com.acellere.collabathon_vaadin;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.vaadin.ui.TreeTable;

import me.figo.models.Transaction;

public class Utils {

	public static Map<String, Collection<String>> getCategories() {
		Map<String, Collection<String>> map = new HashMap<String, Collection<String>>();

		map.put("Versicherung", Arrays.asList("Fidibus Versicherungen Ag", "Techniker Krankenkasse"));
		map.put("Strom", Arrays.asList("Mainova Energiedienste Gmbh", "Lichtblick Ag"));
		map.put("Spenden", Arrays.asList("Greenpeace", "Christoffel Blindenmission"));
		map.put("Entertainment", Arrays.asList("United Domains")); // Unitymedia?
		map.put("Telefon", Arrays.asList("Vodafone Gmbh"));
		map.put("Mitgliedsbeiträge", Arrays.asList("Corpora Fitness Gmbh& Co.Kg"));

		return map;
	}

	private static double sum(List<Transaction> list) {
		return list.stream().mapToDouble(x -> x.getAmount().doubleValue()).sum();
	}

	public static void setTTableContent(TreeTable ttable) {

		Map<String, List<Transaction>> categories = MMUtils.getTransactionsByCategory(MMUtils.getAllTransactions(),
				getCategories());
		int i = 1;
		Iterator<Entry<String, List<Transaction>>> c = categories.entrySet().iterator();
		while (c.hasNext()) {
			Entry<String, List<Transaction>> category = c.next();
			Map<String, List<Transaction>> subcategories = MMUtils.getTransactionsByName(category.getValue());

			ttable.addItem(new Object[] { category.getKey(), sum(category.getValue()) }, i);

			Iterator<Entry<String, List<Transaction>>> itsub = subcategories.entrySet().iterator();
			int j = 0;
			while (itsub.hasNext()) {
				Entry<String, List<Transaction>> subcategory = itsub.next();

				ttable.addItem(new Object[] { subcategory.getKey(), sum(subcategory.getValue()) }, (i * 10000) + j);

				
				int tmp = (i * 10000) + j;
				ttable.setParent(tmp, i);
				int k = 1;
				List<Transaction> itdesc = subcategory.getValue();
				for (Transaction transaction : itdesc) {
					ttable.addItem(new Object[] { transaction.getPurposeText(), transaction.getAmount().doubleValue()}, tmp * 10000 + k);
					ttable.setParent(tmp * 10000 + k, tmp);
					k++;
				}
				j++;
				
			}
			i++;

		}

		// ttable.addItem(new Object[] { "Versicherung", new Double(50.0) }, 0);
		// ttable.addItem(new Object[] { "Fidibus", new Double(30.0) }, 1);
		// ttable.addItem(new Object[] { "Techniker Krankenkasse", new
		// Double(20.0) }, 2);
		// ttable.addItem(new Object[] { "TransactionDescription (Clickable)",
		// null }, 99);
		//
		// ttable.setParent(1, 0);
		// ttable.setParent(2, 0);
		// ttable.setParent(99, 2);
		//
		// ttable.addItem(new Object[] { "Strom", null }, 3);
		// ttable.addItem(new Object[] { "Mainova", null }, 4);
		// ttable.addItem(new Object[] { "Lichtblick", null }, 5);
		// ttable.setParent(4, 3);
		// ttable.setParent(5, 3);
		//
		// ttable.addItem(new Object[] { "Spenden", null }, 6);
		// ttable.addItem(new Object[] { "Greenpeace", null }, 7);
		// ttable.addItem(new Object[] { "Christoffel Blindenmission", null },
		// 8);
		// ttable.setParent(7, 6);
		// ttable.setParent(8, 6);
		//
		// ttable.addItem(new Object[] { "Entertainment", null }, 9);
		// ttable.addItem(new Object[] { "Unitymedia", null }, 10);
		// ttable.setParent(10, 11);
		//
		// ttable.addItem(new Object[] { "Telefon", null }, 11);
		// ttable.addItem(new Object[] { "Vodafone", null }, 12);
		// ttable.setParent(11, 12);

		// ttable.addItem(new Object[] { "Mitgliedsbeiträge", null, null }, 13);
		// ttable.addItem(new Object[] { null, "Corpora Fitness", null }, 14);
		// ttable.setParent(13, 14);

	}

}
