package ru.bmstu.iu3;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class DirectoryInterface extends WebPage {
    String wayToDirs = "\\files";
    private static final long serialVersionUID = 1L;

    public DirectoryInterface(final PageParameters parameters) {
        super(parameters);

        Link toEditor = new Link<Void>("toEditor") {
            @Override
            public void onClick() {
                setResponsePage(DirectoryInterface.class);
            }
        };
        Link toTheory = new Link<Void>("toTheory") {
            @Override
            public void onClick() {
                setResponsePage(Editor.class);
            }
        };
        WebMarkupContainer menu = new WebMarkupContainer("menu");
        menu.add(toTheory);
        menu.add(toEditor);

        add(menu);


    }
}
