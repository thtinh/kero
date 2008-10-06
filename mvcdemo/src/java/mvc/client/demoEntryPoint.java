/*
 * demoEntryPoint.java
 *
 * Created on October 6, 2008, 12:00 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package mvc.client;

import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author Froggy
 */
public class demoEntryPoint implements EntryPoint
{

    /** Creates a new instance of demoEntryPoint */
    public demoEntryPoint()
    {
    }

    /** 
    The entry point method, called automatically by loading a module
    that declares an implementing class as an entry-point
     */
    public void onModuleLoad()
    {
//        ButtonBar bar = new ButtonBar();
//        Button button = new Button("Click me");
//        bar.add(button);
//
//        RootPanel.get().add(bar);
        Dispatcher dispatcher = Dispatcher.get();
        Label label1 = new Label();
        
        dispatcher.addController(new AppController());
        dispatcher.addController(new ContactController());
        dispatcher.dispatch(AppEvents.Init); 
        label1.setText(dispatcher.toString());
        RootPanel.get().add(label1);
    }
}
