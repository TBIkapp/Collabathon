package com.acellere.collabathon_vaadin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.stream.Stream;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Link;
import com.vaadin.ui.PopupView;
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
	
	public static Vector<Contract> getContracts(){
		Vector<Contract> contracts = new Vector<Contract>();
		
		contracts.add(new Contract( "Fidibus Versicherungen Ag", "Versicherung", new PopupView(new OffersPopup()), "20.06.2017"));
		contracts.add(new Contract( "Techniker Krankenkasse", "Versicherung", new PopupView(new OffersPopup()), "01.01.2019"));
		contracts.add(new Contract( "Greenpeace", "Spenden", new PopupView(new OffersPopup()), "31.08.2017"));
		contracts.add(new Contract( "Christoffel Blindenmission", "Spenden", new PopupView(new OffersPopup()), "31.08.2017"));
		contracts.add(new Contract( "Mainova", "Strom", new PopupView(new OffersPopup()), "20.06.2017"));
		contracts.add(new Contract( "Lichtblick", "Strom", new PopupView(new OffersPopup()), "10.09.2017"));
		contracts.add(new Contract( "United Domains", "Entertainment", new PopupView(new OffersPopup()), "15.02.2017"));
		contracts.add(new Contract( "Vodafone Gmbh", "Telefon", new PopupView(new OffersPopup()), "20.06.2017"));
		contracts.add(new Contract( "Corpora Fitness Gmbh& Co.Kg", "Mitgliedsbeiträge", new PopupView(new OffersPopup()), "20.06.2017"));
		
		return contracts;
	}

	private static double sum(Stream<Transaction> stream) {
		return stream.mapToDouble(x -> x.getAmount().doubleValue()).sum();
	}

	private static double sum(List<Transaction> list) {
		return sum(list.stream());
	}

	private static double sumFromDate(List<Transaction> list, Date from) {
		return sum(list.stream().filter(x -> x.getBookingDate().after(from)));
	}

	public static Object[] createItem(String name, List<Transaction> transactions) {
		return new Object[] {
				name,
				sum(transactions),
				sumFromDate(transactions, (new GregorianCalendar(2014, 1, 1)).getTime()) };
	}
	
	public static void setTTableContent(TreeTable ttable) {

		Map<String, List<Transaction>> categories = MMUtils.getTransactionsByCategory(MMUtils.getAllTransactions(),
				getCategories());
		int i = 1;
		Iterator<Entry<String, List<Transaction>>> c = categories.entrySet().iterator();
		while (c.hasNext()) {
			Entry<String, List<Transaction>> category = c.next();
			Map<String, List<Transaction>> subcategories = MMUtils.getTransactionsByName(category.getValue());

			ttable.addItem(createItem(category.getKey(), category.getValue()), i);

			Iterator<Entry<String, List<Transaction>>> itsub = subcategories.entrySet().iterator();
			int j = 0;
			while (itsub.hasNext()) {
				Entry<String, List<Transaction>> subcategory = itsub.next();

				ttable.addItem(
						createItem(
								subcategory.getKey(),
								subcategory.getValue()), (i * 10000) + j);

				int tmp = (i * 10000) + j;
				ttable.setParent(tmp, i);
				int k = 1;
				List<Transaction> itdesc = subcategory.getValue();
				for (Transaction transaction : itdesc) {
					ttable.addItem(
							new Object[] {
									transaction.getPurposeText(),
									transaction.getAmount().doubleValue(),
									0.0									
							}, tmp * 10000 + k);
					ttable.setParent(tmp * 10000 + k, tmp);
					k++;
				}
				j++;
				
			}
			i++;

		}
	}
}
