package de.kacperbak.chapter4;

import de.kacperbak.panels.PayLoadPanel;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

/**
 * User: bakka
 * Date: 27.05.13
 */
public class EnclosureExample extends WebPage {

    private boolean isPayLoadVisible = true;
    private Panel payLoadLabel1;
    private Label enclosedLabel1;
    private Panel payLoadLabel2;
    private Label enclosedLabel2;

    public EnclosureExample() {
        add(displayPayLoadLink());
        add(hidePayLoadLink());
        add(dynamicPayLoad1());
        add(dynamicPayLoad2());
        add(enclosedText());
        add(enclosedText2());
    }

    private Component displayPayLoadLink(){
        return new AjaxFallbackLink("displayPayLoadLink") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                displayPayLoad();
                if(target != null){
                    addRequestTargets(target);
                }
            }
        };
    }

    private Component hidePayLoadLink(){
        return new AjaxFallbackLink("hidePayLoadLink") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                hidePayLoad();
                if(target != null){
                    addRequestTargets(target);
                }
            }
        };
    }

    private void addRequestTargets(AjaxRequestTarget target){
        target.add(payLoadLabel1, enclosedLabel1, enclosedLabel2 , payLoadLabel2);
    }

    private Component dynamicPayLoad1(){
        payLoadLabel1 =  new PayLoadPanel("dynamicPayLoad1", new PropertyModel<Boolean>(this, "isPayLoadVisible"), "Text payload Panel 1");
        payLoadLabel1.setOutputMarkupPlaceholderTag(true);
        return payLoadLabel1;
    }

    private Component dynamicPayLoad2(){
        payLoadLabel2 =  new PayLoadPanel("dynamicPayLoad2", new PropertyModel<Boolean>(this, "isPayLoadVisible"), "Text payload Panel 2");
        payLoadLabel2.setOutputMarkupPlaceholderTag(true);
        return payLoadLabel2;
    }

    private Component enclosedText(){
        enclosedLabel1 = new Label("enclosedText", "Enclosed Text with Image");
        enclosedLabel1.setOutputMarkupPlaceholderTag(true);
        return enclosedLabel1;
    }

    private Component enclosedText2(){
        enclosedLabel2 = new Label("enclosedText2", "Enclosed Text with Image Nr. 2");
        enclosedLabel2.setOutputMarkupPlaceholderTag(true);
        return enclosedLabel2;
    }

    private void displayPayLoad(){
        isPayLoadVisible = true;
    }

    private void hidePayLoad(){
        isPayLoadVisible = false;
    }
}
