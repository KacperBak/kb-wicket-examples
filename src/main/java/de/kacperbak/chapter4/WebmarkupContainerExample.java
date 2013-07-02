package de.kacperbak.chapter4;

import de.kacperbak.panels.PayLoadPanel;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

/**
 * User: bakka
 * Date: 03.06.13
 */
public class WebmarkupContainerExample extends WebPage {

    private WebMarkupContainer webMarkupContainer;
    private Label payLoadLabel;
    private Panel payLoadPanel;
    private boolean isWebMarkupContainerVisible = true;

    public WebmarkupContainerExample() {
        add(displayImageLink());
        add(hideImageLink());
        add(webmarkupContainer());
        add(payLoadPanel());
    }

    private Component displayImageLink(){
        return new AjaxFallbackLink("displayImageLink") {

            @Override
            public void onClick(AjaxRequestTarget target) {
                displayWebMarkupContainer();
                if(target != null){
                    target.add(webMarkupContainer, payLoadPanel);
                }
            }
        };
    }

    private Component hideImageLink(){
        return new AjaxFallbackLink("hideImageLink") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                hideWebMarkupContainer();
                if(target != null){
                    target.add(webMarkupContainer, payLoadPanel);
                }
            }
        };
    }

    private Component webmarkupContainer(){
        payLoadLabel = new Label("payLoadLabel", "payLoadLabel text text ...");
        webMarkupContainer = new WebMarkupContainer("webmarkupContainer"){
            @Override
            protected void onConfigure() {
                super.onConfigure();
                setVisible(isWebMarkupContainerVisible);
            }
        };
        webMarkupContainer.add(payLoadLabel);
        webMarkupContainer.setOutputMarkupPlaceholderTag(true);
        return webMarkupContainer;
    }

    private Component payLoadPanel(){
        payLoadPanel = new PayLoadPanel("payLoadPanel", new PropertyModel<Boolean>(this,"isWebMarkupContainerVisible"), " payLoadPanelText ...");
        payLoadPanel.setOutputMarkupPlaceholderTag(true);
        return payLoadPanel;
    }

    private void displayWebMarkupContainer(){
        isWebMarkupContainerVisible = true;
    }

    private void hideWebMarkupContainer(){
        isWebMarkupContainerVisible = false;
    }

}
