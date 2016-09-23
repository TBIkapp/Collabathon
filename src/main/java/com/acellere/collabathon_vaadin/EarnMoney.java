package com.acellere.collabathon_vaadin;

import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;


public class EarnMoney {
	public static Component EarnHistoryButton() {
		Button addButton = new Button("Earn history");
		HorizontalLayout l2 = new HorizontalLayout();
		l2.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT)	;
		l2.addComponent(new PopupView(new EarnHistoryPopup()));
		l2.setWidth("100%");
		return l2;
	}
	
	public static Component getTable() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(new MarginInfo(true, false, false, false));
		layout.setSpacing(true);

		Table table = new Table("Your Earn History");
		table.setWidth("100%");

		// Define two columns for the built-in container
		table.addContainerProperty("Month", String.class, null);
		table.addContainerProperty("Amount", String.class, null);
		table.addContainerProperty("Company paying", String.class, null);
		table.addItem(new Object[] { "Jan", "5€", "Google" }, 1);
		table.addItem(new Object[] { "Feb", "10€", "Amazon" }, 2);
		table.addItem(new Object[] { "Mar", "3€", "Coca-Cola" }, 3);
		
		table.setPageLength(3);

		layout.addComponent(table);
		return layout;
	}

	public static VerticalLayout getGrid() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(new MarginInfo(true, false, false, false));
		layout.setSpacing(true);
		
		HorizontalLayout hl = new HorizontalLayout();
		Label headline = new Label("Your Data from last 6 months could be worth 40€");
		headline.setStyleName("h1");
	
		
		hl.addComponent(headline);
		hl.addComponent(EarnHistoryButton());
		layout.addComponent(hl);
		
		HorizontalLayout hl2 = new HorizontalLayout();
		hl2.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		hl2.setSizeFull();
		hl2.addComponent(new Label("Low - 7€"));
		hl2.addComponent(new Label("Medium - 10€"));
		hl2.addComponent(new Label("Hot - 23€"));
		layout.addComponent(hl2);

		HorizontalLayout hlayout = new HorizontalLayout();
		hlayout.setSizeFull();
		hlayout.setSpacing(true);
		hlayout.setMargin(true);

		String imgRes = "imgLow.jpg";
		Image imglow = new Image();
		imglow.setWidth("80%");
		imglow.setSource(new ThemeResource(imgRes));
		hlayout.addComponent(imglow);
		
		imgRes = "imgMed.jpg";
		Image imgMed = new Image();
		imgMed.setSource(new ThemeResource(imgRes));
		imgMed.setWidth("80%");
		hlayout.addComponent(imgMed);
		
		imgRes = "imgHot.jpg";
		Image imgHot = new Image();
		imgHot.setSource(new ThemeResource(imgRes));
		imgHot.setWidth("80%");
		hlayout.addComponent(imgHot);
		
		layout.addComponent(hlayout);

		layout.addComponent(getTable());

		
		//layout.addComponent(hlayout1);
		
		return layout;
		
	}
}
