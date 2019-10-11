package ru.bmstu.iu3;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class Theory extends WebPage {
    private static final long serialVersionUID = 1L;

    public Theory(final PageParameters parameters) {
        super(parameters);
		Link toDirectoryInterface = new Link<Void>("toDirectoryInterface") {
			@Override
			public void onClick() {
				setResponsePage(DirectoryInterface.class);
			}
		};
		Link toEditor = new Link<Void>("toEditor") {
			@Override
			public void onClick() {
				setResponsePage(Editor.class);
			}
		};
		WebMarkupContainer menu = new WebMarkupContainer("menu");
		menu.add(toDirectoryInterface);
		menu.add(toEditor);

		add(menu);



    }
}
