package com.acellere.collabathon_vaadin;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class ContractVaultUI {

	private static BeanItemContainer<Contract> contractContainer;

	public static Component getTable() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(new MarginInfo(true, false, false, false));
		layout.setSpacing(true);

		Table table = new Table("My Contracts");
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
