package de.kacperbak.chapter10;

import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * User: bakka
 * Date: 01.07.13
 */
public class CustomFeedbackPanel extends FeedbackPanel {
    public CustomFeedbackPanel(String id) {
        super(id);
    }

    public CustomFeedbackPanel(String id, IFeedbackMessageFilter filter) {
        super(id, filter);
    }
}
