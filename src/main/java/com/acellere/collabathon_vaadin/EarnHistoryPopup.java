package com.acellere.collabathon_vaadin;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class EarnHistoryPopup implements PopupView.Content {
    private final HorizontalLayout layout;
    private final TextField textField = new TextField(
            "Minimized HTML content", "Click to edit");

    public EarnHistoryPopup() {
        layout = new HorizontalLayout(getTable());
    }

	
	public static Component getTable() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(new MarginInfo(true, false, false, false));
		layout.setSpacing(true);

		Table table = new Table("Your Earn History");
		table.setWidth("100%");

		// Define two columns for the built-in container
		table.addContainerProperty("Month", String.class, null);
		table.addContainerProperty("Amount", String.class, null);
		table.addContainerProperty("Company paying", String.class, null);
		table.addItem(new Object[] { "Jan", "5€", "Google" }, 1);
		table.addItem(new Object[] { "Feb", "10€", "Amazon" }, 2);
		table.addItem(new Object[] { "Mar", "3€", "Coca-Cola" }, 3);
		
		table.setPageLength(3);

		layout.addComponent(table);
		return layout;
	}

    @Override
    public final Component getPopupComponent() {
        return layout;
    }

    @Override
    public final String getMinimizedValueAsHTML() {
        return "Earn history";
    }
};