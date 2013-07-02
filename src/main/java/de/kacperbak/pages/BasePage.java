package de.kacperbak.pages;

import de.kacperbak.service.PersonService;
import org.apache.wicket.markup.html.WebPage;

/**
 * User: bakka
 * Date: 18.06.13
 */
public class BasePage extends WebPage {

    protected PersonService service;

    public BasePage() {
        service = PersonService.getPersonService();
    }
}
