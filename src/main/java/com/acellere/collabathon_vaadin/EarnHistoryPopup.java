package com.acellere.collabathon_vaadin;

import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class EarnHistoryPopup implements PopupView.Content {
    private final Component layout;
    private final TextField textField = new TextField(
            "Minimized HTML content", "Click to edit");

    public EarnHistoryPopup() {
        layout = getBrands();
    }

    public static Component getBrands() {
    	VerticalLayout layout = new VerticalLayout();
        	Label lblBrands = new Label("These Brands looking for your data");
		lblBrands.setStyleName("h1");
		layout.addComponent(lblBrands);
		
		HorizontalLayout hlayout1 = new HorizontalLayout();
		hlayout1.setSpacing(true);
		hlayout1.setMargin(true);
		hlayout1.setSizeFull();
		
    	Image img = new Image();
    	img.setSource(new ThemeResource("brands.png"));
    	img.setHeight("150px");
    	hlayout1.addComponent(img);
		/*
		String imgRes = "coca-cola-05.jpg";
		Image brand1 = new Image();
		brand1.setSource(new ThemeResource(imgRes));
		brand1.setWidth("30%");
		hlayout1.addComponent(brand1);

		imgRes = "googlelogo_color_284x96dp.png";
		Image brand2 = new Image();
		brand2.setSource(new ThemeResource(imgRes));
		brand2.setWidth("30%");
		hlayout1.addComponent(brand2);
		
		imgRes = "Logo-ERGO-SoMeShare.jpg";
		Image brand3 = new Image();
		brand3.setSource(new ThemeResource(imgRes));
		brand3.setWidth("30%");
		hlayout1.addComponent(brand3);*/
		layout.addComponent(hlayout1);
		return layout;
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

    @Override
    public final Component getPopupComponent() {
        return layout;
    }

    @Override
    public final String getMinimizedValueAsHTML() {
        return "Earn now!";
    }
};