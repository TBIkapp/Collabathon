package com.acellere.collabathon_vaadin;

import com.vaadin.server.ClassResource;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;

public class OffersPopup implements PopupView.Content {
    private final HorizontalLayout layout;

    final ExternalResource classResource = new ExternalResource(
            "https://www.dropbox.com/s/mha5n58r8odq6dc/offers.png?raw=1");

    public OffersPopup() {
    	Image img = new Image();
    	img.setSource(classResource);
    	img.setWidth("60%");
       	img.setHeight("60%");
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
