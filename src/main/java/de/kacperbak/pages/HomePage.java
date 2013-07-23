package de.kacperbak.pages;

import de.kacperbak.chapter10.ValidatorExample;
import de.kacperbak.chapter10NestedForm.NestedFormPage;
import de.kacperbak.chapter10WrappedModel.WrappedModelPage;
import de.kacperbak.chapter10formcomponentpanel.FormComponentPage;
import de.kacperbak.chapter10submitlink.TwoFormsTwoSubmits;
import de.kacperbak.chapter11.AddressListViewPage;
import de.kacperbak.chapter4.ControlOverHtmlExamples;
import de.kacperbak.chapter4.EnclosureExample;
import de.kacperbak.chapter4.FragmentExample;
import de.kacperbak.chapter4.WebmarkupContainerExample;
import de.kacperbak.chapter9forms.PersonPage;
import de.kacperbak.chapter9forms.SimpleFormExample;
import de.kacperbak.chapter9models.CompoundPropertyModelExample;
import de.kacperbak.chapter9models.ModelsExamples;
import de.kacperbak.chapter9models.PropertyModelExample;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);
        add(chapter4PageLink());
        add(enclosureExampleLink());
        add(webMarkupContainerExample());
        add(fragmentExample());
        add(modelsExample());
        add(propertyModelExample());
        add(compoundPropertyModelExample());
        add(simpleFormExample());
        add(personFormExample());
        add(addressListViewExample());
        add(validatorExample());
        add(twoFormsTwoSubmitsExample());
        add(formComponentPanelExample());
        add(nestedFormPageExample());
        add(wrappedModelPageExample());
    }

    private Component chapter4PageLink(){
        return new Link("chapter4PageLink") {

            /**
             * a new instance of the referenced page will be created
             */
            @Override
            public void onClick() {
                setResponsePage(ControlOverHtmlExamples.class);
            }
        };
    }

    private Component enclosureExampleLink(){
        return new Link("enclosureExampleLink") {
            @Override
            public void onClick() {
                setResponsePage(EnclosureExample.class);
            }
        };
    }

    private Component webMarkupContainerExample(){
        return new Link("webMarkupContainerExample") {
            @Override
            public void onClick() {
                setResponsePage(WebmarkupContainerExample.class);
            }
        };
    }

    private Component fragmentExample(){
        return new Link("fragmentExample") {
            @Override
            public void onClick() {
                setResponsePage(FragmentExample.class);
            }
        };
    }

    private Component modelsExample(){
        return new Link("modelsExample") {
            @Override
            public void onClick() {
                setResponsePage(ModelsExamples.class);
            }
        };
    }

    private Component propertyModelExample(){
        return new Link("propertyModelExample") {
            @Override
            public void onClick() {
                setResponsePage(PropertyModelExample.class);
            }
        };
    }

    private Component compoundPropertyModelExample(){
        return new Link("compoundPropertyModelExample") {
            @Override
            public void onClick() {
                setResponsePage(CompoundPropertyModelExample.class);
            }
        };
    }

    private Component simpleFormExample(){
        return new Link("simpleFormExample") {
            @Override
            public void onClick() {
                setResponsePage(SimpleFormExample.class);
            }
        };
    }

    private Component personFormExample(){
        return new Link("personFormExample") {
            @Override
            public void onClick() {
                setResponsePage(PersonPage.class);
            }
        };
    }

    private Component addressListViewExample(){
        return new Link("addressListViewExample") {
            @Override
            public void onClick() {
                setResponsePage(AddressListViewPage.class);
            }
        };
    }

    private Component validatorExample(){
        return new Link("validatorExample") {
            @Override
            public void onClick() {
                setResponsePage(ValidatorExample.class);
            }
        };
    }

    private Component twoFormsTwoSubmitsExample(){
        return new Link("twoFormsTwoSubmitsExample"){
            @Override
            public void onClick() {
                setResponsePage(TwoFormsTwoSubmits.class);
            }
        };
    }

    private Component formComponentPanelExample(){
        return new Link("formComponentPanelExample") {
            @Override
            public void onClick() {
                setResponsePage(FormComponentPage.class);
            }
        };
    }

    private Component nestedFormPageExample(){
        return new Link("nestedFormPageExample") {
            @Override
            public void onClick() {
                setResponsePage(NestedFormPage.class);
            }
        };
    }

    private Component wrappedModelPageExample(){
        return new Link("wrappedModelPageExample") {
            @Override
            public void onClick() {
                setResponsePage(WrappedModelPage.class);
            }
        };
    }
}
