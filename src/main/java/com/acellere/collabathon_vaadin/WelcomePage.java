package com.acellere.collabathon_vaadin;

import java.util.Iterator;

import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class WelcomePage {

	public static Component getPage() {
		VerticalLayout layout = new VerticalLayout();
		layout.setStyleName("labelcenter");

		Label headline = new Label("\"Money saved - Money earned\"");
		headline.setStyleName("h1");
		layout.addComponent(headline);
		
		Label headline1 = new Label("Introduction");
		headline1.setStyleName("h2");
		layout.addComponent(headline1);

		Label content1 = new Label("Would you like to make money on your banking transactions ?"
				+ "<br />"
				+ "<i>presenting CapCash</i>"
				+ "<br /><br />"
				+ "CapCash is a platform which enables its users to make money on their transaction data and gives the banks the opportunities to monetise the data at the same time. Throughout the process the customer has full control about what he wants to share and monetise and no data is shared with anyone without explicit consent of the customer.");
		content1.setContentMode(ContentMode.HTML);
		layout.addComponent(content1);
		
		Image piggybank = new Image();
		piggybank.setSource(new ThemeResource("sparschwein.jpg"));
		piggybank.setWidth("25%");
		layout.addComponent(piggybank);


		Label headline2 = new Label("How does it work ?");
		headline2.setStyleName("h2");
		layout.addComponent(headline2);
		
		Label content2 = new Label("1. Create an account on CapCash"
				+ "<br />"
				+ "2. Connect all your bank accounts and credit card accounts (if available) to your account on G7 a single sign on (supported through APIs like Figo)"
				+ "<br />"
				+ "3. We will then aggregate all your transactions into various categories (e.g. Utility Bills, Insurance premiums, payment to  vendors like Rewe, Adidas, Lufthansa etc."
				+ "<br />"
				+ "4. Based on the above, it then intelligently suggests (through comparison with whats available in the market), alternatives which may help you save money on them.");
		content2.setContentMode(ContentMode.HTML);
		layout.addComponent(content2);
		
		Image transactionFlow = new Image();
		transactionFlow.setSource(new ThemeResource("TransactionFlow.JPG"));
		transactionFlow.setWidth("50%");
		layout.addComponent(transactionFlow);
		
		Label content3 = new Label(
				"5.	 In addition, we also offer the opportunity for our users to have a personal digital locker to upload and securely store their documents related to transactions (e.g. energy, telecom, insurance contracts etc.)");
		layout.addComponent(content3);

		Image flowDigitalLocker = new Image();
		flowDigitalLocker.setSource(new ThemeResource("FlowDigitalLocker.JPG"));
		flowDigitalLocker.setWidth("50%");
		layout.addComponent(flowDigitalLocker);
		
		Label headline3 = new Label("How you as a customer can make money");
		headline3.setStyleName("h2");
		layout.addComponent(headline3);

		Label content4 = new Label(
				"Save money by comparing your recurring spendings like energy bills, telecom bills, insurance premium to the current offers in the market, which are lesser than what you spend today. (Money saved = Money earned) \n Earn discounts / deals from selected partners like Hugo Boss, Rewe, Kaufhoff etc. by reaching some spending goals on certain brands (style / categories) then they can offer deals to them.");
		layout.addComponent(content4);
		
		layout.setSizeFull();

		layout.setHeight("100%");
		layout.setWidth("100%");

		Iterator<Component> cit = layout.getComponentIterator();
		while (cit.hasNext()){
			cit.next().addStyleName("labelcenter");
		}
		
		return layout;
	}

}
