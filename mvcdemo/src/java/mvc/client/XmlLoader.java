/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.client;

import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.HttpProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelType;
import com.extjs.gxt.ui.client.data.XmlReader;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.http.client.RequestBuilder;

/**
 *
 * @author Froggy
 */
public class XmlLoader
{

    public static final String PATH = "";
    public static final String FILENAME = "unit.xml";
    private ListStore<BillItem> store;
    private BaseListLoader loader;
    public XmlLoader()
    {
        // defines the xml structure
        ModelType type = new ModelType();
        type.root = "Bills";
        type.recordName = "Bill";
        type.addField("name");
        type.addField("startDate");
        type.addField("endDate");
        type.addField("amount");

        // use a http proxy to get the data
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, PATH+FILENAME);
        HttpProxy proxy = new HttpProxy(builder);
        
        // need a loader, proxy, and reader
        XmlReader reader = new XmlReader(type);
        loader = new BaseListLoader(proxy, reader);
        store = new ListStore<BillItem>(loader);
    }
    public ListStore<BillItem> getUtilityBills()
    {
        
        return store;
    }
    
}
