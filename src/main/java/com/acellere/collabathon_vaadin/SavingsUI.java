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

		Label headline = new Label("Savings");
		headline.setStyleName("h1");

		Label content = new Label(
				"Do you want to optimize your monthly spending’s on insurances, utility bills or telephone bill? With CapCash you are enabled to optimize your spending’s via contract comparison. Using your bank transactions and you will receive a complete analysis of your recurring payments and provide direct feedback listing possible savings and contract improvements It is the easiest way to get a clearly arranged summary of your contracts. Glorious 7 will use its strong algorithms so you have more money you can spend on fun things you really want.");

		layout.addComponent(headline);
		layout.addComponent(content);
		layout.addComponent(createTableTree());

		return layout;
	}

	private static Component createTableTree() {
		TreeTable ttable = new TreeTable("Savings");
		ttable.setWidth("100%");
		ttable.addContainerProperty("Category", String.class, null);
		ttable.addContainerProperty("Total amount", Double.class, null);
		ttable.addContainerProperty("Last year", Double.class, null);
		ttable.addContainerProperty("Comparison", Component.class, null);

		Utils.setTTableContent(ttable);

//		for (Object itemId : ttable.getContainerDataSource().getItemIds()) {
//			ttable.setCollapsed(itemId, false);
//
//			// As we're at it, also disallow children from
//			// the current leaves
//			if (!ttable.hasChildren(itemId))
//				ttable.setChildrenAllowed(itemId, false);
//		}
		return ttable;
	}
}
