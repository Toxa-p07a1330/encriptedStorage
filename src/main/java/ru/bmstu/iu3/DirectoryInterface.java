package ru.bmstu.iu3;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.File;

public class DirectoryInterface extends WebPage {
    String wayToDirs = "C:\\Users\\User\\Desktop\\SandBox";
    private static final long serialVersionUID = 1L;

    public DirectoryInterface(final PageParameters parameters) {
        super(parameters);

        Link toEditor = new Link<Void>("toEditor") {
            @Override
            public void onClick() {
                PageParameters params = new PageParameters();
                params.add("way", "test");                  //todo передавать текст из инпута
                setResponsePage(Editor.class, params);
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
        menu.add(toEditor);

        add(menu);

        File directory = new File(wayToDirs);
        String files = new String();
        for (File i : directory.listFiles())
            files+=i.toString()+"\n";
        TextArea listOfFiles = new TextArea("files", Model.of(""));
        listOfFiles.setEnabled(false);
        listOfFiles.setDefaultModelObject(files);
        System.out.println(files);
        add(listOfFiles);


    }
}
