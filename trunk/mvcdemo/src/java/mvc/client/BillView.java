/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007, 2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package mvc.client;

import java.util.List;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;

public class BillView extends View
{

    private LayoutContainer container;
    private BillListPanel mailListPanel;
    private BillItemPanel mailItemPanel;

    public BillView(Controller controller)
    {
        super(controller);
    }

    protected void handleEvent(AppEvent event)
    {
        if (event.type == AppEvents.NavBills)
        {
            LayoutContainer wrapper = (LayoutContainer) Registry.get("center");
            wrapper.removeAll();
            wrapper.add(container);
            wrapper.layout();
        }

        if (event.type == AppEvents.ViewBillItems)
        {
            LayoutContainer wrapper = (LayoutContainer) Registry.get("center");

            Folder f = (Folder) event.getData("folder");
            mailListPanel.setHeading(f.getName());

            ListStore<BillItem> store = mailListPanel.getStore();
            store.removeAll();
            store.add((List) event.data);

            wrapper.layout();

            List items = (List) event.data;
            if (items.size() > 0)
            {
                mailListPanel.getBinder().setSelection((BillItem) items.get(0));
            }
            else
            {
                mailItemPanel.showItem(null);
            }
        }

        if (event.type == AppEvents.ViewBillItem)
        {
            BillItem item = (BillItem) event.data;
            mailItemPanel.showItem(item);
        }
    }

    @Override
    protected void initialize()
    {
        container = new LayoutContainer();

        BorderLayout layout = new BorderLayout();
        layout.setEnableState(false);
        container.setLayout(layout);

        mailListPanel = new BillListPanel();
        container.add(mailListPanel, new BorderLayoutData(LayoutRegion.CENTER));

        mailItemPanel = new BillItemPanel();
        BorderLayoutData southData = new BorderLayoutData(LayoutRegion.SOUTH, .5f, 200, 1000);
        southData.setSplit(true);
        southData.setMargins(new Margins(5, 0, 0, 0));
        container.add(mailItemPanel, southData);
    }
}
