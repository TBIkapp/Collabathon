package com.acellere.collabathon_vaadin;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.PopupView;

public class OffersPopup implements PopupView.Content {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1449936688366564999L;

	private final HorizontalLayout layout;

    public OffersPopup() {
    	Image img = new Image();
    	img.setSource(new ThemeResource("offers.png"));
    	img.setHeight("400px");
        layout = new HorizontalLayout(img);
    }

    @Override
    public final Component getPopupComponent() {
        return layout;
    }

    @Override
    public final String getMinimizedValueAsHTML() {
        return "Get me an offer!";
    }
}
