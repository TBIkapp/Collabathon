package com.acellere.collabathon_vaadin;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import me.figo.FigoException;
import me.figo.models.Transaction;


public class MMUtils {

	public static void main(String[] args) {
		List<Transaction> t = getAllTransactions();
		System.out.println(t.size());
		System.out.println(getTransactionsByCategory(t, Utils.getCategories()).get("Spenden").size());
		System.out.println(getTransactionsByName(t).keySet());
	}
	
	public static List<Transaction> getAllTransactions() {
		try {
			return Figo.getSession().getTransactions();
		} catch (FigoException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public static Map<String, List<Transaction>> getTransactionsByCategory(
		List<Transaction> transactions,
		Map<String, Collection<String>> categories)
	{
			Map<String, String> name2catMap = new HashMap<>();
		    categories
		    	.entrySet()
		    	.stream()
		    	.forEach(kv -> kv.getValue().stream().forEach(n -> name2catMap.put(n, kv.getKey())));
			
		    return
				transactions
					.stream()
					.filter(t -> name2catMap.containsKey(t.getName()))
					.collect(
						Collectors.groupingBy(t -> name2catMap.get(t.getName())));
	}

	public static Map<String, List<Transaction>> getTransactionsByName(List<Transaction> transactions)
	{
			return transactions.stream().collect(
						Collectors.groupingBy(t -> t.getName()));
	}
}
