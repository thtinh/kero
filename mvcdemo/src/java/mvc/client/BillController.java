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
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;


public class BillController extends Controller
{

    private BillFolderView folderView;
    private BillView billView;
    XmlLoader loader;
    public BillController()
    {
        registerEventTypes(AppEvents.Init);
        registerEventTypes(AppEvents.NavBills);
        registerEventTypes(AppEvents.ViewBillItems);
        registerEventTypes(AppEvents.ViewBillItem);
        loader = new XmlLoader();
    }

    @Override
    public void handleEvent(AppEvent event)
    {
        switch (event.type)
        {
            case AppEvents.Init:
                forwardToView(folderView, event);
                break;
            case AppEvents.NavBills:
                forwardToView(folderView, event);
                forwardToView(billView, event);
                break;
            case AppEvents.ViewBillItems:
                onViewBillItems(event);
                break;
            case AppEvents.ViewBillItem:
                forwardToView(billView, event);
                break;
        }
    }

    private void onViewBillItems(final AppEvent<Folder> event)
    {
        final Folder f = event.data;
        
        if (f != null)
        {
           
           AppEvent ae = new AppEvent(event.type,loader.getUtilityBills());
           
           ae.setData("folder", f);
           forwardToView(billView, ae);
        }

    }

    public void initialize()
    {
        folderView = new BillFolderView(this);
        billView = new BillView(this);
    }
}
