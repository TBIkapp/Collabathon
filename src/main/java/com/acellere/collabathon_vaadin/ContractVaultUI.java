package com.acellere.collabathon_vaadin;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;

public class ContractVaultUI {

	public static Component getContractUI() {

		Table table = new Table("Contract Vault");

		// Define two columns for the built-in container
		table.addContainerProperty("Name", String.class, null);
		table.addContainerProperty("Description", String.class, null);
		table.addContainerProperty("Contract", Component.class, null);

		table.setContainerDataSource(new BeanItemContainer<Contract>(Contract.class,
				Utils.getContracts()));
		
		// Add a few other rows using shorthand addItem()

		return table;
	}

}
