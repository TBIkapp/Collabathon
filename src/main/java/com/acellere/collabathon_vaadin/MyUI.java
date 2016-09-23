package com.acellere.collabathon_vaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3676760974554356266L;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);

		Label h1 = new Label("The Glory 7 - Monitize your Transactions");
		h1.setStyleName("h1");
		h1.setHeight("10%");
		layout.addComponent(h1);
		
		
		TabSheet tabsheet = new TabSheet();
		layout.addComponent(tabsheet);
		tabsheet.addTab(WelcomePage.getPage(), "Welcome");
		tabsheet.addTab(SavingsUI.getContractUI(), "Savings");
		tabsheet.addTab(ContractVaultUI.getTable(), "Contract Vault");
		
		
		
//		tabsheet.addTab(FigoAccountGrid.getGrid(), "Accounts");
//		tabsheet.addTab(FigoTransactionGrid.getGrid(), "Transactions");
//		tabsheet.addTab(FigoPaymentGrid.getGrid(), "Payments");
		
		setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1393518393268652896L;
	}
}
