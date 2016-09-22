package com.acellere.collabathon_vaadin;

import java.util.List;
import java.util.Vector;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.HeaderCell;
import com.vaadin.ui.Grid.HeaderRow;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TreeTable;
import com.vaadin.ui.VerticalLayout;

public class ContractManagementUI {

	private static List<Contract> contracts = new Vector<Contract>();
	private static BeanItemContainer<Contract> contractContainer;

	public ContractManagementUI() {
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
		layouth1.addComponent(createContractGrid());

		layout.addComponent(layouth1);

		return layout;
	}

	private static Component createTableTree() {
		TreeTable ttable = new TreeTable("Contracts");
		ttable.setWidth("100%");
		ttable.addContainerProperty("Category", String.class, null);
		ttable.addContainerProperty("Amount", Double.class, null);

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

	private static Grid createContractGrid() {
		Grid grid = new Grid();
		grid.setCaption("My Contracts");

		contractContainer = new BeanItemContainer<Contract>(Contract.class, contracts);
		grid.setContainerDataSource(contractContainer);
		grid.setWidth("100%");

		HeaderRow filterRow = grid.appendHeaderRow();

		// Set up a filter for all columns
		for (Object pid : grid.getContainerDataSource().getContainerPropertyIds()) {
			HeaderCell cell = filterRow.getCell(pid);

			// Have an input field to use for filter
			TextField filterField = new TextField();
			// filterField.setColumns(10);

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
		return grid;
	}

	// private static FormLayout createPopupForm() {
	// FormLayout popupForm = new FormLayout();
	// popupForm.setWidth("400px");
	//
	// TextField tfName = new TextField("Contract Name");
	// tfName.setIcon(FontAwesome.USER);
	// tfName.setRequired(true);
	// tfName.addValidator(new NullValidator("Must be given", false));
	// popupForm.addComponent(tfName);
	//
	// TextField tfNumber = new TextField("Contract ID");
	// tfNumber.setIcon(FontAwesome.BARCODE);
	// popupForm.addComponent(tfNumber);
	//
	// TextField tfDescription = new TextField("Description");
	// tfDescription.setIcon(FontAwesome.ENVELOPE);
	// popupForm.addComponent(tfDescription);
	//
	// TextField tfKeyWords = new TextField("Search Key Words");
	// tfKeyWords.setIcon(FontAwesome.KEYBOARD_O);
	// popupForm.addComponent(tfKeyWords);
	//
	// Button btnAddContract = new Button("Add Contract");
	// btnAddContract.addClickListener(new ClickListener() {
	//
	// /**
	// *
	// */
	// private static final long serialVersionUID = -9205690656219838892L;
	//
	// @Override
	// public void buttonClick(ClickEvent event) {
	// contractContainer.addBean(new Contract(tfName.getValue(),
	// tfNumber.getValue(), tfKeyWords.getValue(),
	// tfDescription.getValue()));
	// }
	// });
	// popupForm.addComponent(btnAddContract);
	// return popupForm;
	// }

}
