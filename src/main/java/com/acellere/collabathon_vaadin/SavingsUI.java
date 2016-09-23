package com.acellere.collabathon_vaadin;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TreeTable;
import com.vaadin.ui.VerticalLayout;

public class SavingsUI {

	public SavingsUI() {
	}

	public static VerticalLayout getContractUI() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(new MarginInfo(true, false, false, false));
		layout.setSpacing(false);

		Label headline = new Label("Contract Management");
		headline.setStyleName("h1");

		VerticalLayout layouth1 = new VerticalLayout();
		layouth1.setWidth("100%");

		layouth1.addComponent(createTableTree());
//		layouth1.addComponent(createContractGrid());

		layout.addComponent(layouth1);

		return layout;
	}

	private static Component createTableTree() {
		TreeTable ttable = new TreeTable("Contracts");
		ttable.setWidth("100%");
		ttable.addContainerProperty("Category", String.class, null);
		ttable.addContainerProperty("Total amount", Double.class, null);
		ttable.addContainerProperty("Last year", Double.class, null);
		ttable.addContainerProperty("Comparison", Component.class, null);

		Utils.setTTableContent(ttable);

		for (Object itemId : ttable.getContainerDataSource().getItemIds()) {
			ttable.setCollapsed(itemId, false);

			// As we're at it, also disallow children from
			// the current leaves
			if (!ttable.hasChildren(itemId))
				ttable.setChildrenAllowed(itemId, false);
		}
		return ttable;
	}
}
