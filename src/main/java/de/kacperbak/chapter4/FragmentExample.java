package de.kacperbak.chapter4;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;

/**
 * User: bakka
 * Date: 06.06.13
 */
public class FragmentExample extends WebPage {

    private static final String FRAGMENT_CONTAINER = "fragmentContainer";

    //state
    private boolean isEnabled = true;

    //fragments
    private Fragment currentFragment;
    private Fragment enabledFragment;
    private Fragment disabledFragment;


    public FragmentExample() {
        add(enableLink());
        add(disableLink());
        add(fragmentContainer());
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
                    ajaxRequestTarget.add(currentFragment);
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
                    target.add(currentFragment);
                }
            }
        };
    }

    private void enableCounterLink(){
        isEnabled = true;
        swapFragments();
    }

    private void disableCounterLink(){
        isEnabled = false;
        swapFragments();
    }

    private void swapFragments(){
        Fragment fragment = (isEnabled) ? enabledFragment : disabledFragment;
        currentFragment.replaceWith(fragment);
        currentFragment = fragment;
    }

    private Component fragmentContainer(){
        enabledFragment = currentFragment = enabledMessageFragment();
        disabledFragment = disabledMessageFragment();
        return currentFragment;
    }

    private Fragment enabledMessageFragment(){
        Fragment enabledMessageFragment = new Fragment(FRAGMENT_CONTAINER, "enableFragment" , this);
        enabledMessageFragment.add(new Label("enabledMessage", "Fragment with ENABLED message "));
        enabledMessageFragment.setOutputMarkupPlaceholderTag(true);
        return enabledMessageFragment;
    }

    private Fragment disabledMessageFragment(){
        Fragment disabledMessageFragment = new Fragment(FRAGMENT_CONTAINER, "disableFragment", this);
        disabledMessageFragment.add(new Label("disabledMessage", "Fragment is DISABLED message "));
        disabledMessageFragment.setOutputMarkupPlaceholderTag(true);
        return disabledMessageFragment;
    }




}
