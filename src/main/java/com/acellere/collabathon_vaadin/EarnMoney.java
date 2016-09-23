package com.acellere.collabathon_vaadin;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

public class EarnMoney {
	public static VerticalLayout getGrid() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(new MarginInfo(true, false, false, false));
		layout.setSpacing(true);
		Grid grid = new Grid();
		grid.setCaption("Earn Money");
		return layout;
		
	}
}
