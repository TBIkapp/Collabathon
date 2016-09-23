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
		
		HorizontalLayout hlayout = new HorizontalLayout();
		String imgRes = "imgLow.jpg";
		Image imglow = new Image();
		imglow.setSource(new ThemeResource(imgRes));
		hlayout.addComponent(imglow);
		
		imgRes = "imgMed.jpg";
		Image imgMed = new Image();
		imglow.setSource(new ThemeResource(imgRes));
		hlayout.addComponent(imgMed);
		
		imgRes = "imgHot.jpg";
		Image imgHot = new Image();
		imglow.setSource(new ThemeResource(imgRes));
		hlayout.addComponent(imgHot);
		
		layout.addComponent(hlayout);
		
		
		
		return layout;
		
	}
}
