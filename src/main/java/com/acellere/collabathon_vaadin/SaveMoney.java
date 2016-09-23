package com.acellere.collabathon_vaadin;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class SaveMoney {
	
	public static VerticalLayout getGrid() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(new MarginInfo(true, false, false, false));
		layout.setSpacing(true);
		Grid grid = new Grid();
		grid.setCaption("Save Money");
		
		Label headline0 = new Label("Savings");
		headline0.setStyleName("h1");
		
		Label content0 = new Label("Do you want to optimize your monthly spending’s on insurances, utility bills or telephone bill? With Glory 7 you are enabled to optimize your spending’s via contract comparison. Using your bank transactions and you will receive a complete analysis of your recurring payments and provide direct feedback listing possible savings and contract improvements It is the easiest way to get a clearly arranged summary of your contracts. Glorious 7 will use its strong algorithms so you have more money you can spend on fun things you really want.");		
		
		layout.setSizeFull();
		layout.setHeight("100%");
		layout.setWidth("100%");
	
		layout.addComponent(headline0);
		layout.setComponentAlignment(headline0, Alignment.TOP_CENTER);
		layout.addComponent(content0);
		layout.setComponentAlignment(content0, Alignment.MIDDLE_CENTER);
		
		
		return layout;
		
	}
}
