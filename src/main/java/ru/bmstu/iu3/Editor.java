package ru.bmstu.iu3;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Editor extends WebPage {
	private static final long serialVersionUID = 1L;
	String way = new String();


	public Editor(final PageParameters parameters) {
		super(parameters);
		Label debud = new Label("debug", "");				//debug
		add(debud);
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

		TextField wayToSaveFile = new TextField("wayToSaveFile", Model.of(""));
		Button saveButton = new Button("save")
		{
			@Override
			public void onSubmit() {
					super.onSubmit();
					File file = new File(DirectoryInterface.wayToDirs+"/" + wayToSaveFile.getInput());
					try
					{
						FileWriter fw = new FileWriter(file);
						fw.write(textArea.getDefaultModelObject().toString());
						fw.close();
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
						debud.setDefaultModelObject(e.getMessage());
					}

				}
		};

		form.add(wayToSaveFile);
		form.add(textArea);
		form.add(saveButton);

		add(form);


	}
}
