package ru.bmstu.iu3;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.File;

public class DirectoryInterface extends WebPage {
    String wayToDirs = "C:\\Users\\User\\Desktop\\SandBox";
    private static final long serialVersionUID = 1L;

    public DirectoryInterface(final PageParameters parameters) {
        super(parameters);
        wayToDirs = "/usr/local/share/filesForEditor";
        Link toEditor = new Link<Void>("toEditor") {
            @Override
            public void onClick() {
                setResponsePage(Editor.class);
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
        directory.mkdirs();
        for (File i : directory.listFiles())
            files+=i.toString()+"\n";
        TextArea listOfFiles = new TextArea("files", Model.of(""));
        listOfFiles.setEnabled(false);
        listOfFiles.setDefaultModelObject(files);
        add(listOfFiles);

        StatelessForm chooseFileForOpen = new StatelessForm("selector");
        TextArea name = new TextArea("name", Model.of(""));
        chooseFileForOpen.add(name);
        AjaxButton opener = new AjaxButton("opener", Model.of(""))
        {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                super.onSubmit(target);
                PageParameters pp = new PageParameters();
                pp.add("way", name.getValue());
                setResponsePage(Editor.class, pp);
            }
        };
        chooseFileForOpen.add(opener);
        add(chooseFileForOpen);

    }
}