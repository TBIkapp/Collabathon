package com.acellere.collabathon_vaadin;

import java.io.IOException;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.HeaderCell;
import com.vaadin.ui.Grid.HeaderRow;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import me.figo.FigoException;
import me.figo.models.Account;

public class FigoAccountGrid {

	public static VerticalLayout getGrid() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(new MarginInfo(true, false, false, false));
		layout.setSpacing(true);
		Grid grid = new Grid();
		grid.setCaption("Figo Accounts");
		try {

			BeanItemContainer<Account> transactionContainer = new BeanItemContainer<Account>(Account.class,
					Figo.getSession().getAccounts());
			grid.setContainerDataSource(transactionContainer);
			grid.setWidth("100%");

			HeaderRow filterRow = grid.appendHeaderRow();

			// Set up a filter for all columns
			for (Object pid : grid.getContainerDataSource().getContainerPropertyIds()) {
				HeaderCell cell = filterRow.getCell(pid);

				// Have an input field to use for filter
				TextField filterField = new TextField();
				filterField.setColumns(8);

				// Update filter When the filter input is changed
				filterField.addTextChangeListener(change -> {
					// Can't modify filters so need to replace
					transactionContainer.removeContainerFilters(pid);

					// (Re)create the filter if necessary
					if (!change.getText().isEmpty())
						transactionContainer
								.addContainerFilter(new SimpleStringFilter(pid, change.getText(), true, false));
				});
				cell.setComponent(filterField);
			}
		} catch (FigoException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		layout.addComponent(grid);
		return layout;
	}
}
