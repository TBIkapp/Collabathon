package com.acellere.collabathon_vaadin;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.HeaderCell;
import com.vaadin.ui.Grid.HeaderRow;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class ContractVaultUI {

	private static BeanItemContainer<Contract> contractContainer;

	public static Component getContractUI() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(new MarginInfo(true, false, false, false));
		layout.setSpacing(true);
		Grid grid = new Grid("Contract Vault");

		contractContainer = new BeanItemContainer<Contract>(Contract.class, Utils.getContracts());
		grid.setContainerDataSource(contractContainer);
		grid.setWidth("100%");

		grid.setColumnOrder("name", "description", "link");

		HeaderRow filterRow = grid.appendHeaderRow();

		// Set up a filter for all columns
		for (Object pid : grid.getContainerDataSource().getContainerPropertyIds()) {
			HeaderCell cell = filterRow.getCell(pid);

			// Have an input field to use for filter
			TextField filterField = new TextField();
			// filterField.setColumns(8);

			// Update filter When the filter input is changed
			filterField.addTextChangeListener(change -> {
				// Can't modify filters so need to replace
				contractContainer.removeContainerFilters(pid);

				// (Re)create the filter if necessary
				if (!change.getText().isEmpty())
					contractContainer.addContainerFilter(new SimpleStringFilter(pid, change.getText(), true, false));
			});
			cell.setComponent(filterField);
		}

		layout.addComponent(grid);
		return layout;
	}

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
