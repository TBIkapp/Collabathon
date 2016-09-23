package com.acellere.collabathon_vaadin;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class MarketPlace {
	public static VerticalLayout getGrid() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(new MarginInfo(true, false, false, false));
		layout.setSpacing(true);
		Grid grid = new Grid();
		grid.setCaption("Marketplace");
		
		Label headline0 = new Label("Marketplace");
		headline0.setStyleName("h1");
		
		Label content0 = new Label("Let your transactions tell you what you need. Like a modern fridge tells you want you need to buy next based on what is left, Glory 7 will suggest you matches based on your transaction, for example insurances you might have missed to subscribe to,  supplies, finical opportunities and many more. Who else knows it better than your own spending’s? It’s that simple! When using this Service, no personalized Data will be forwarded to third parties. The Data is secure and still belongs only to you.");		
		
		layout.setSizeFull();
		layout.setHeight("100%");
		layout.setWidth("100%");
	
		layout.addComponent(headline0);
		layout.setComponentAlignment(headline0, Alignment.TOP_CENTER);
		layout.addComponent(content0);
		
		return layout;
		
	}
}
