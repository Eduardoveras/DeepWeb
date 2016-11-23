package com.evapps.UI;


import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Eduardo veras on 22-Nov-16.
 */



@SpringUI
@Theme("valo")
public class MainUI extends UI {

    private VerticalLayout layout = new VerticalLayout();


    @Override
    protected void init(VaadinRequest request) {

            setupLayout();
            addHeader();
        }


    public void setupLayout()
    {
        Page.getCurrent().setTitle("Spring Vaadin Calendar");

        layout= new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);
        layout.setSizeFull();
        layout.setDefaultComponentAlignment(Alignment.TOP_CENTER);
        setContent(layout);

    }

    public void addHeader()
    {
        Label header = new Label("THE CALENDAR OF LIFE");
        header.addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        layout.addComponent(header);
    }





}