/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007, 2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package mvc.client;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;

public class AppController extends Controller
{

    private AppView appView;
    public AppController()
    {
        registerEventTypes(AppEvents.Init);
        registerEventTypes(AppEvents.Login);
        registerEventTypes(AppEvents.Error);
    }

    public void handleEvent(AppEvent event)
    {
        switch (event.type)
        {
            case AppEvents.Init:
                onInit(event);
                break;
            case AppEvents.Login:
                onLogin(event);
                break;
            case AppEvents.Error:
                onError(event);
                break;
        }
    }

    public void initialize()
    {
        appView = new AppView(this);
    }

    protected void onError(AppEvent ae)
    {
        System.out.println("error: " + ae.data);
    }

    private void onInit(AppEvent event)
    {
        forwardToView(appView, event);
        
    }

    private void onLogin(AppEvent event)
    {
        forwardToView(appView, event);
    }
}
