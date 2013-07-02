package de.kacperbak.chapter9models;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Date;

/**
 * User: bakka
 * Date: 16.06.13
 */
public class ModelsExamples extends WebPage {

    private IModel<String> customModel = new Model<String>(){
        @Override
        public String getObject() {
            return new Date().toString();
        }
    };

    public ModelsExamples() {
        add(new Label("label1", customModel));
        add(new Label("label2", customModel));
        add(escapedMarkupLabel());
        add(notEscapedMarkupLabel());
    }

    private Component escapedMarkupLabel(){
        String markupString = "<tr>" +
                "<td>1</td>" +
                "<td>2</td>" +
                "<td>3</td>" +
                "</tr>";
        IModel markupModel = new Model<String>(markupString);
        Label label = new Label("label3", markupModel);
        return label;
    }

    private Component notEscapedMarkupLabel(){
        String markupString = "<tr>" +
                "<td>1</td>" +
                "<td>2</td>" +
                "<td>3</td>" +
                "</tr>";
        IModel markupModel = new Model<String>(markupString);
        Label label = new Label("label4", markupModel);
        label.setEscapeModelStrings(false);
        return label;
    }



}
