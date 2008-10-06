/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007, 2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package mvc.client;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.widget.LayoutContainer;

public class ContactView extends View
{

    private ContactPanel panel;

    public ContactView(Controller controller)
    {
        super(controller);
    }

    @Override
    protected void initialize()
    {
        panel = new ContactPanel();
    }

    @Override
    protected void handleEvent(AppEvent event)
    {
        if (event.type == AppEvents.NavContacts)
        {
            LayoutContainer wrapper = (LayoutContainer) Registry.get("center");
            wrapper.removeAll();
            wrapper.add(panel);
            wrapper.layout();
        }
    }
}
