package com.acellere.collabathon_vaadin;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class ContractVaultUI {

	public static Component getTable() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(new MarginInfo(true, false, false, false));
		layout.setSpacing(true);

		Label content = new Label("Are you scared about searching information in contracts in many different physical folders.We offer you a secure place were you can store all your important contracts and documents and find all relevant information in one place.You will have the opportunity to search through your contracts and documents and to link it with your transactions.");
		layout.addComponent(content);
		
		Button addButton = new Button("Add contract");
		HorizontalLayout l2 = new HorizontalLayout();
		l2.setDefaultComponentAlignment(Alignment.MIDDLE_RIGHT);
		l2.addComponent(addButton);
		l2.setWidth("100%");
		layout.addComponent(l2);
		Table table = new Table("Digital Locker");
		table.setWidth("100%");

		// Define two columns for the built-in container
		table.addContainerProperty("Name", String.class, null);
		table.addContainerProperty("Description", String.class, null);
		table.addContainerProperty("Cancelation Date", String.class, null);
		table.addContainerProperty("Link", Component.class, null);
		int i = 0;
		for (Contract contract : Utils.getContracts()) {
			table.addItem(new Object[] { contract.getName(), contract.getDescription(), contract.getCanceldate(),
					contract.getLink() }, i++);
		}
		table.setPageLength(table.size());

		layout.addComponent(table);
		return layout;
	}

}
