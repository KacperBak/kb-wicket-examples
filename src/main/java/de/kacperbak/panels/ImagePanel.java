package de.kacperbak.panels;

import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.PackageResourceReference;

/**
 * User: bakka
 * Date: 26.05.13
 */
public class ImagePanel extends GenericPanel<Boolean> {

    private final static String fileName = "kb.png";
    private Image image;

    public ImagePanel(String id, IModel<Boolean> isVisibleModel) {
        super(id, isVisibleModel);
        PackageResourceReference resourceReference = new PackageResourceReference(getClass(),fileName);
        image = new Image("picture", resourceReference);
        add(image);
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        setVisibilityAllowed(getModelObject());
    }
}
