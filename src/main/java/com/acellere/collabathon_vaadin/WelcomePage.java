package com.acellere.collabathon_vaadin;

import java.util.Iterator;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class WelcomePage {

	public static Component getPage() {
		VerticalLayout layout = new VerticalLayout();
		layout.setStyleName("labelcenter");
		Label headline0 = new Label("Introduction");

		Label content0 = new Label("1.    Would you like to make money on your banking transactions ? - to audience ");
		Label content1 = new Label("2.    Would you like to make money on your customers’ banking transactions ? - to jury");
		Label content8 = new Label("Well we have a solution which could do that - presenting Glorious 7");
		Label headline = new Label("Get more out of your transactions");

		Label content = new Label(
				"Glorious 7 is a platform which enables its users to make money on their transaction data and gives the banks the opportunities to monetise the data at the same time. Throughout the process the customer has full control about what he wants to share and monetise and no data is shared with anyone without explicit consent of the customer.");

		Label headline2 = new Label("How does it work ?");

		Label content2 = new Label("1.   Create an account on G7");
		Label content4 = new Label("2.   Connect all your bank accounts and credit card accounts (if available) to your account on G7 a single sign on (supported through APIs like Figo)");
		Label content5 = new Label(
				"3.   We will then aggregate all your transactions into various categories (e.g. Utility Bills, Insurance premiums, payment to  vendors like Rewe, Adidas, Lufthansa etc.");
		Label content7 = new Label(
				"5.	 In addition, we also offer the opportunity for our users to have a personal digital locker to upload and securely store their documents related to transactions (e.g. energy, telecom, insurance contracts etc.)");
		Label content6 = new Label(
				"4	 Based on the above, it then intelligently suggests (through comparison with whats available in the market), alternatives which may help you save money on them.");
		Label headline3 = new Label("How you as a customer can make money");

		Label content3 = new Label(
				"Save money by comparing your recurring spendings like energy bills, telecom bills, insurance premium to the current offers in the market, which are lesser than what you spend today. (Money saved = Money earned) \n Earn discounts / deals from selected partners like Hugo Boss, Rewe, Kaufhoff etc. by reaching some spending goals on certain brands (style / categories) then they can offer deals to them.");

		layout.setSizeFull();

		layout.setHeight("100%");
		layout.setWidth("100%");

		Image sample = new Image();
		sample.setSource(new ThemeResource("sparschwein.jpg"));
		sample.setWidth("25%");

		Image sample2 = new Image();
		sample2.setSource(new ThemeResource("TransactionFlow.JPG"));
		sample2.setWidth("50%");

		Image sample3 = new Image();
		sample3.setSource(new ThemeResource("FlowDigitalLocker.JPG"));
		sample3.setWidth("50%");
		// layout.addComponent((Component) jl);

		layout.addComponent(headline);
		layout.setComponentAlignment(headline, Alignment.TOP_CENTER);
		layout.addComponent(headline0);
		layout.setComponentAlignment(headline0, Alignment.MIDDLE_CENTER);
		layout.addComponent(content0);
		layout.setComponentAlignment(content0, Alignment.MIDDLE_CENTER);
		layout.addComponent(content1);
		layout.setComponentAlignment(content1, Alignment.MIDDLE_CENTER);
		layout.addComponent(content8);
		layout.setComponentAlignment(content8, Alignment.MIDDLE_CENTER);
		layout.addComponent(content);
		layout.setComponentAlignment(content, Alignment.MIDDLE_CENTER);
		layout.addComponent(sample);
		layout.setComponentAlignment(sample, Alignment.MIDDLE_CENTER);
		layout.addComponent(headline2);
		layout.setComponentAlignment(headline2, Alignment.MIDDLE_CENTER);
		layout.addComponent(content2);
		layout.setComponentAlignment(content2, Alignment.MIDDLE_CENTER);
		layout.addComponent(content4);
		layout.setComponentAlignment(content4, Alignment.MIDDLE_CENTER);
		layout.addComponent(content5);
		layout.setComponentAlignment(content5, Alignment.MIDDLE_CENTER);
		layout.addComponent(content6);
		layout.setComponentAlignment(content6, Alignment.MIDDLE_CENTER);
		layout.addComponent(sample2);
		layout.setComponentAlignment(sample2, Alignment.MIDDLE_CENTER);
		layout.addComponent(content7);
		layout.setComponentAlignment(content7, Alignment.MIDDLE_CENTER);
		layout.addComponent(sample3);
		layout.setComponentAlignment(sample3, Alignment.MIDDLE_CENTER);
		layout.addComponent(headline3);
		layout.setComponentAlignment(headline3, Alignment.MIDDLE_CENTER);
		layout.addComponent(content3);
		layout.setComponentAlignment(content3, Alignment.MIDDLE_CENTER);

		Iterator<Component> cit = layout.getComponentIterator();
		while (cit.hasNext()){
			cit.next().setStyleName("labelcenter");
		}
		
		headline.addStyleName("h1");
		headline0.addStyleName("h1");
		headline2.addStyleName("h1");
		headline3.addStyleName("h1");
		
		return layout;
	}

}
