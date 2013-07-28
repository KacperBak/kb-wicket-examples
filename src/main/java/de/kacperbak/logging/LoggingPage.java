package de.kacperbak.logging;

import de.kacperbak.BasePage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: bakka
 * Date: 28.07.13
 */
public class LoggingPage extends BasePage {

    private static final transient Logger logger = LoggerFactory.getLogger(LoggingPage.class);

    private int counter;

    public LoggingPage() {
        add(counter());
        add(addOne());
        add(secondLink());
        counter = 0;
    }

    private Component counter(){
        return new Label("counter", new PropertyModel(this, "counter"));
    }

    public Component addOne(){
        return new Link("addOne") {
            @Override
            public void onClick() {

                int figureToAdd = 1;
                increment(figureToAdd);
                logger.debug("increment by {}, final value: {}", figureToAdd, counter);
                logger.info("LoggingPage.addOne() info");
                logger.warn("LoggingPage.addOne() warn");
                logger.error("LoggingPage.addOne() error");
            }
        };
    }

    public Component secondLink(){
        return new Link("addTwo") {
            @Override
            public void onClick() {

                int figureToAdd = 2;
                increment(figureToAdd);
                logger.debug("increment by {}, final value: {}", figureToAdd, counter);
            }
        };
    }

    private void increment(int by){
        counter = counter + by;
    }
}
