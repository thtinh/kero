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
import com.google.gwt.user.client.rpc.AsyncCallback;


public class BillController extends Controller
{

    private BillFolderView folderView;
    private BillView mailView;

    public BillController()
    {
        registerEventTypes(AppEvents.Init);
        registerEventTypes(AppEvents.NavMail);
        registerEventTypes(AppEvents.ViewMailItems);
        registerEventTypes(AppEvents.ViewMailItem);
    }

    @Override
    public void handleEvent(AppEvent event)
    {
        switch (event.type)
        {
            case AppEvents.Init:
                forwardToView(folderView, event);
                break;
            case AppEvents.NavMail:
                forwardToView(folderView, event);
                forwardToView(mailView, event);
                break;
            case AppEvents.ViewMailItems:
                onViewMailItems(event);
                break;
            case AppEvents.ViewMailItem:
                forwardToView(mailView, event);
                break;
        }
    }

    private void onViewMailItems(final AppEvent<Folder> event)
    {
        final Folder f = event.data;
        if (f != null)
        {
           
                 //   forwardToView(mailView, ae);
        }

    }

    public void initialize()
    {


        folderView = new BillFolderView(this);
        mailView = new BillView(this);
    }
}
