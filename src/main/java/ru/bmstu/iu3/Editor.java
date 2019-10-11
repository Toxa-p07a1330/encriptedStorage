package ru.bmstu.iu3;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.File;
import java.util.Scanner;

public class Editor extends WebPage {
	private static final long serialVersionUID = 1L;
	String way = new String();


	public Editor(final PageParameters parameters) {
		super(parameters);
		way = parameters.get("way").toString();


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
		TextArea textArea = new TextArea("text", Model.of(""));
		System.out.println(way);
		if (way!=null) {
			System.out.println(way+" in ediro");
			String text = new String();
			try {
				Scanner scanner = new Scanner(new File(way));
				while (scanner.hasNextLine())
					text+=scanner.nextLine()+"\n";
			}

			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
			textArea.setDefaultModelObject(text);
		}
		form.add(textArea);
		add(form);

	}
}
