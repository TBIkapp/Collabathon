package com.acellere.collabathon_vaadin;

import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class EarnMoney {
	public static VerticalLayout getGrid() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(new MarginInfo(true, false, false, false));
		layout.setSpacing(true);
		
		Label headline = new Label("Your Data from last 6 months could be worth 40€");
		headline.setStyleName("h1");
		
		layout.addComponent(headline);
		
		HorizontalLayout hlayout = new HorizontalLayout();
		hlayout.setSizeFull();
		hlayout.setSpacing(true);
		hlayout.setMargin(true);
		
		String imgRes = "imgLow.jpg";
		Image imglow = new Image();
		imglow.setWidth("30%");
		imglow.setSource(new ThemeResource(imgRes));
		hlayout.addComponent(imglow);
		
		imgRes = "imgMed.jpg";
		Image imgMed = new Image();
		imgMed.setSource(new ThemeResource(imgRes));
		imgMed.setWidth("30%");
		hlayout.addComponent(imgMed);
		
		imgRes = "imgHot.jpg";
		Image imgHot = new Image();
		imgHot.setSource(new ThemeResource(imgRes));
		imgHot.setWidth("30%");
		hlayout.addComponent(imgHot);
		
		layout.addComponent(hlayout);
		
		Label lblBrands = new Label("These Brands looking for your data");
		lblBrands.setStyleName("h1");
		layout.addComponent(lblBrands);
		
		HorizontalLayout hlayout1 = new HorizontalLayout();
		hlayout1.setSpacing(true);
		hlayout1.setMargin(true);
		hlayout1.setSizeFull();
		
		imgRes = "coca-cola-05.jpg";
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
		hlayout1.addComponent(brand3);
		
		layout.addComponent(hlayout1);
		
		return layout;
		
	}
}
