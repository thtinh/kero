/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007, 2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package mvc.client;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.binder.TableBinder;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.table.Table;
import com.extjs.gxt.ui.client.widget.table.TableColumn;
import com.extjs.gxt.ui.client.widget.table.TableColumnModel;
import com.extjs.gxt.ui.client.widget.toolbar.TextToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

public class BillListPanel extends ContentPanel
{

    private Table table;
    private ListStore<BillItem> store;
    private TableBinder<BillItem> binder;

    public BillListPanel()
    {
        
        
        /*
        ToolBar toolBar = new ToolBar();
        TextToolItem create = new TextToolItem("Create");
        create.setIconStyle("icon-email-add");
        toolBar.add(create);

        TextToolItem reply = new TextToolItem("Reply");
        reply.setIconStyle("icon-email-reply");
        toolBar.add(reply);

        setTopComponent(toolBar);
        */
        
        /*insert xmlgrid here*/
        List<TableColumn> columns = new ArrayList<TableColumn>();
        
        columns.add(new TableColumn("startDate", "From", .2f));
        columns.add(new TableColumn("endDate", "To", .3f));
        columns.add(new TableColumn("amount", "Amount", .5f));

        TableColumnModel cm = new TableColumnModel(columns);

        table = new Table(cm);
        table.setSelectionMode(SelectionMode.MULTI);
        table.setBorders(false);

        add(table);

        store = new ListStore<BillItem>();

        binder = new TableBinder<BillItem>(table, store);
        binder.setAutoSelect(true);
        binder.addSelectionChangedListener(new SelectionChangedListener<BillItem>()
        {

            public void selectionChanged(SelectionChangedEvent<BillItem> event)
            {
                BillItem m = event.getSelectedItem();
                showMailItem(m);
            }
        });

        setLayout(new FitLayout());
    }

    public ListStore<BillItem> getStore()
    {
        return store;
    }

    public TableBinder<BillItem> getBinder()
    {
        return binder;
    }

    private void showMailItem(BillItem item)
    {
        AppEvent evt = new AppEvent(AppEvents.ViewMailItem, item);
        Dispatcher.forwardEvent(evt);
    }
}
