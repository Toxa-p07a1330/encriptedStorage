package ru.bmstu.iu3;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Editor extends WebPage {
	private static final long serialVersionUID = 1L;
	String way = new String();


	public Editor(final PageParameters parameters) {
		super(parameters);
		way = parameters.get("way").toString();
		add(new Label("way", way+"Debug"));

		Link toDirectoryInterface = new Link<Void>("toDirectoryInterface") {
			@Override
			public void onClick() {
				setResponsePage(DirectoryInterface.class);
			}
		};
		Link toTheory = new Link<Void>("toTheory") {
			@Override
			public void onClick() {
				setResponsePage(Theory.class);
			}
		};
		WebMarkupContainer menu = new WebMarkupContainer("menu");
		menu.add(toTheory);
		menu.add(toDirectoryInterface);
		add(menu);
		Form form = new Form("form");
		TextArea textArea = new TextArea("text");
		form.add(textArea);
		add(form);

	}
}
