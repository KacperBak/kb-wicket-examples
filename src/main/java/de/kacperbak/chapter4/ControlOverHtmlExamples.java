package de.kacperbak.chapter4;

import de.kacperbak.panels.ImagePanel;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

/**
 * User: bakka
 * Date: 22.05.13
 */
public class ControlOverHtmlExamples extends WebPage {

    private static final String FRAGMENT_CONTAINER = "fragmentContainer";

    //wicket components
    private Link counterLink;
    private Fragment currentFragment;
    private Fragment enabledFragment;
    private Fragment disabledFragment;

    //application logic
    private int counter = 0;
    private boolean isCounterLinkEnabled = true;
    private WebMarkupContainer webMarkupContainer;

    public ControlOverHtmlExamples() {
        add(counterLink());
        add(disableLink());
        add(enableLink());
        add(counter());
        add(eg3Label());
        add(eg4Label());
        add(eg5Label());
        add(eg6Container());
        add(eg7FragmentContainer());
    }

    private Component counterLink(){
        counterLink = new Link("counterLink"){
            @Override
            public void onClick() {
                increaseCounter();
            }

            @Override
            protected void onConfigure() {
                super.onConfigure();
                setEnabled(isCounterLinkEnabled);
            }
        };
        counterLink.setOutputMarkupPlaceholderTag(true);
        return counterLink;
    }

    /**
     * AJAX
     * @return
     */
    private Component disableLink(){
        return new AjaxFallbackLink("disableLink") {
            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                //noJsCase
                disableCounterLink();

                //ajax case
                if(ajaxRequestTarget != null){
                    ajaxRequestTarget.add(counterLink, webMarkupContainer , currentFragment);
                }
            }
        };
    }

    /**
     * AJAX
     * @return
     */
    private Component enableLink(){
        return  new AjaxFallbackLink("enableLink") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                //noJsCase
                enableCounterLink();

                //ajax case
                if(target != null){
                    target.add(counterLink, webMarkupContainer,  currentFragment);
                }
            }
        };
    }

    private Component counter(){
        return new Label("counter", new PropertyModel<Integer>(this, "counter"));
    }

    private void increaseCounter(){
        this.counter++;
    }

    private void enableCounterLink(){
        isCounterLinkEnabled = true;
        webMarkupContainer.setVisible(false);
        swapFragments();
    }

    private void disableCounterLink(){
        isCounterLinkEnabled = false;
        webMarkupContainer.setVisible(true);
        swapFragments();
    }

    /**
     * AtributeModifier
     * @return
     */
    private Component eg3Label(){
        Label label = new Label("eg3Label", "... black NOT red label ...");
        label.add(new AttributeModifier("style", "color: black"));
        return label;
    }

    /**
     * AttributeAppender
     * @return
     */
    private Component eg4Label(){
        Label label = new Label("eg4Label", "... red AND bold label ...");
        label.add(new AttributeAppender("style", "font-weight: bold"));
        return label;
    }

    /**
     * setMarkupId()
     * @return
     */
    private Component eg5Label(){
        Label label = new Label("eg5Label", "label with custim ID");
        label.setMarkupId("ID_42_IS_THE_ANSWER");
        return label;
    }

    /**
     * WebmarkupContainer
     * @return
     */
    private Component eg6Container(){
        webMarkupContainer = new WebMarkupContainer("eg6Container");
        webMarkupContainer.add(new Label("containerMessage", "Counter has been disabled!"));
        webMarkupContainer.setVisible(false);
        webMarkupContainer.setOutputMarkupPlaceholderTag(true);
        return webMarkupContainer;
    }

    /**
     * Fragments with AJAX
     * @return
     */
    private Component eg7FragmentContainer(){
        enabledFragment = currentFragment = enabledMessageFragment();
        disabledFragment = disabledMessageFragment();
        return currentFragment;
    }

    private void swapFragments(){
        Fragment fragment = (isCounterLinkEnabled) ? enabledFragment : disabledFragment;
        currentFragment.replaceWith(fragment);
        currentFragment = fragment;
    }

    private Fragment enabledMessageFragment(){
        Fragment enabledMessageFragment = new Fragment(FRAGMENT_CONTAINER, "enableFragment" , this);
        enabledMessageFragment.add(new Label("enabledMessage", "Fragment: Counter is enabled"));
        enabledMessageFragment.setOutputMarkupPlaceholderTag(true);
        return enabledMessageFragment;
    }

    private Fragment disabledMessageFragment(){
        Fragment disabledMessageFragment = new Fragment(FRAGMENT_CONTAINER, "disableFragment", this);
        disabledMessageFragment.add(new Label("disabledMessage", "Fragment: Counter is disabled"));
        disabledMessageFragment.setOutputMarkupPlaceholderTag(true);
        return disabledMessageFragment;
    }
}
