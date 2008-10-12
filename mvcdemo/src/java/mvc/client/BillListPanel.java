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

import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.HttpProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelType;
import com.extjs.gxt.ui.client.data.XmlReader;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.table.TableColumn;
import com.extjs.gxt.ui.client.widget.table.TableColumnModel;
import com.google.gwt.http.client.RequestBuilder;

public class BillListPanel extends ContentPanel
{

    final Grid grid;
    final BaseListLoader loader;
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
        
        List<ColumnConfig> columns = new ArrayList<ColumnConfig>();

        columns.add(new ColumnConfig("startDate", "From", 200));
        columns.add(new ColumnConfig("endDate", "To", 200));
        columns.add(new ColumnConfig("amount", "Amount", 200));

        ColumnModel cm = new ColumnModel(columns);
        ModelType type = new ModelType();
        type.root = "Bills";
        type.recordName = "Bill";
        type.addField("startDate");
        type.addField("endDate");
        type.addField("amount");

        // use a http proxy to get the data
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "Unit.xml");
        HttpProxy proxy = new HttpProxy(builder);

        // need a load, proxy, and reader
        XmlReader reader = new XmlReader(type);

        loader = new BaseListLoader(proxy, reader);
        
        ListStore<BillItem> store = new ListStore<BillItem>(loader);
        grid = new Grid<BillItem>(store, cm);
        
        add(grid);
        setLayout(new FitLayout());
    }

    public void load(String name)
    {
        loader.load();
    }

    private void showMailItem(BillItem item)
    {
        AppEvent evt = new AppEvent(AppEvents.ViewBillItem, item);
        Dispatcher.forwardEvent(evt);
    }
}
