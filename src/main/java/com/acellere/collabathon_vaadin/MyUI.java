package com.acellere.collabathon_vaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ClassResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
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

		HorizontalLayout hl = new HorizontalLayout();
		
		
		Label h1 = new Label("CapCash");
		h1.setStyleName("h1");
		h1.setHeight("10%");
		hl.addComponent(h1);
	
		Image logo = new Image();
		logo.setSource(new ThemeResource("Logo.png"));
		logo.setWidth("100");
		hl.addComponent(logo);
		
	
		
		hl.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		hl.setSizeFull();
		hl.setComponentAlignment(logo, Alignment.TOP_RIGHT);
		
		layout.addComponent(hl);
		TabSheet tabsheet = new TabSheet();
		layout.addComponent(tabsheet);
		
		tabsheet.addTab(WelcomePage.getPage(), "Welcome").setIcon(FontAwesome.BOOKMARK);
		tabsheet.addTab(SavingsUI.getContractUI(), "Save Money").setIcon(FontAwesome.CALCULATOR);
		tabsheet.addTab(ContractVaultUI.getTable(), "Digital Locker").setIcon(FontAwesome.LOCK);

		tabsheet.addTab(EarnMoney.getGrid(), "Earn Money").setIcon(FontAwesome.MONEY);
		tabsheet.addTab(MarketPlace.getGrid(), "Marketplace").setIcon(FontAwesome.ROCKET);
		
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
