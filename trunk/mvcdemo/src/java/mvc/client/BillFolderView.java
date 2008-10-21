/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007, 2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package mvc.client;

import com.extjs.gxt.ui.client.Events;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.binder.TreeBinder;
import com.extjs.gxt.ui.client.data.BaseTreeLoader;
import com.extjs.gxt.ui.client.data.LoadEvent;
import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.data.TreeModelReader;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.LoadListener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.TreeBuilder;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.tree.Tree;

public class BillFolderView extends View
{
    BillModel billModel = new BillModel();
    private Tree tree;
    private TreeStore<BillModel> store;
    private TreeBinder<BillModel> binder;
    private TreeLoader<BillModel> loader;
    
    public BillFolderView(Controller controller)
    {
        super(controller);
    }

    protected void initialize()
    {
    }

    protected void initUI()
    {
        ContentPanel west = (ContentPanel) Registry.get("west");
        west.setLayout(new AccordionLayout());
        
        ContentPanel bill = new ContentPanel();
        bill.setHeading("Bills");
        bill.addListener(Events.Expand, new Listener<ComponentEvent>()
        {

            public void handleEvent(ComponentEvent be)
            {
                Dispatcher.get().dispatch(AppEvents.NavBills);
            }
        });

        tree = new Tree();
        
        tree.getStyle().setLeafIconStyle("tree-folder");
        //TreeBuilder.buildTree(tree, billModel);
        
        loader = new BaseTreeLoader(new TreeModelReader());
        store = new TreeStore<BillModel>(loader);
        
        
        binder = new TreeBinder<BillModel>(tree, store);
        
        binder.setAutoLoad(true);
        binder.setAutoSelect(true);
        binder.setDisplayProperty("name");
        loader.load(billModel);
        binder.addSelectionChangedListener(new SelectionChangedListener<ModelData>()
        {

            public void selectionChanged(SelectionChangedEvent se)
            {
                Folder f = (Folder) se.getSelection().get(0);
                AppEvent evt = new AppEvent(AppEvents.ViewBillItems, f);
                fireEvent(evt);
            }
        });
        
        bill.add(tree);
       
        west.add(bill);
    }

    protected void handleEvent(AppEvent event)
    {
        switch (event.type)
        {
            case AppEvents.Init:
                initUI();
                break;
        }

        if (event.type == AppEvents.NavBills)
        {
            BillModel f = (BillModel) event.data;
            BillReader reader = new BillReader();
            reader.getBills();
            if (f != null)
            {
                loader.addListener(Loader.Load, new LoadListener()
                {

                    @Override
                    public void loaderLoad(LoadEvent le)
                    {
                        loader.removeLoadListener(this);
                    }
                });
                loader.load(f);
            }

        }
    }
}
