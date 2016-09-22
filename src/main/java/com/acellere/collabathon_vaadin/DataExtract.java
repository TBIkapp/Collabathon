package com.acellere.collabathon_vaadin;

import java.io.IOException;
import java.lang.reflect.Field;

import me.figo.FigoException;
import me.figo.FigoSession;
import me.figo.models.Payment;

public class DataExtract {

	public static void main(String[] args) {
		FigoSession session = new FigoSession(
				"ASHWLIkouP2O6_bgA2wWReRhletgWKHYjLqDaqb0LFfamim9RjexTo22ujRIP_cjLiRiSyQXyt2kM1eXU2XLFZQ0Hro15HikJQT_eNeT_9XQ");

		try {
			for (Payment transaction : session.getPayments()) {

				for (Field field : transaction.getClass().getDeclaredFields()) {
					field.setAccessible(true);
					String name = field.getName();
					Object value = field.get(transaction);
					System.out.print(name + ": " + value + "; ");
				}
				System.out.println("");

			}
		} catch (FigoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
