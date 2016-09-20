package com.acellere.collabathon_vaadin;

import me.figo.FigoSession;

public class Figo {
	private static FigoSession session;

	public Figo() {

		// print out a list of accounts including its balance
		// try {
		// for (Account account : session.getAccounts()) {
		// System.out.println(account.getAccountId());
		// System.out.println(account.getName());
		// System.out.println(session.getAccountBalance(account).getBalance());
		// }
		//
		//// // print out the list of all transactions on a specific account
		// System.out.println("ID | Account Number | Amount | Purpose");
		// for (Transaction transaction :
		// session.getTransactions(session.getAccount("A1.2"))) {
		// System.out.print(transaction.getAccountId() + " | " +
		// transaction.getAccountNumber() +" | ");
		// System.out.print(transaction.getAmount() + " | ");
		// System.out.print(transaction.getPurposeText());
		// System.out.println("");
		// }
		// } catch (FigoException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	public static FigoSession getSession() {
		if (session == null)
			session = new FigoSession(
					"ASHWLIkouP2O6_bgA2wWReRhletgWKHYjLqDaqb0LFfamim9RjexTo22ujRIP_cjLiRiSyQXyt2kM1eXU2XLFZQ0Hro15HikJQT_eNeT_9XQ");
		return session;
	}
}
