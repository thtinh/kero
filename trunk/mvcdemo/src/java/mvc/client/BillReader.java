/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.client;

import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.DataReader;
import com.extjs.gxt.ui.client.data.HttpProxy;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelType;
import com.extjs.gxt.ui.client.data.TreeModelReader;
import com.extjs.gxt.ui.client.data.XmlReader;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import java.util.List;


/**
 *
 * @author Froggy
 */
public class BillReader implements DataReader<ModelData, List<? extends ModelData>> 
{
    public static final String PATH = "";
    public static final String FILENAME = "unit2.xml";
    private ListStore<BillItem> store;
    private BaseListLoader loader;
    ListLoadResult result;
    private TreeModelReader treeReader;
    
    public BillReader()
    {
        treeReader = new TreeModelReader();
    }

    public void getBills()
    {
        // use a http proxy to get the data
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "unit2.xml");
        try
        {
            builder.sendRequest(null, new RequestCallback()
            {

                public void onError(Request request, Throwable exception)
                {
                    requestFailed(exception);
                }

                public void onResponseReceived(Request request, Response response)
                {
                    ModelType type = new ModelType();
                    type.root = "Bills";
                    type.recordName = "Bill";
                    type.addField("name");
                    type.addField("startDate");
                    type.addField("endDate");
                    type.addField("amount");
                    XmlReader reader = new XmlReader(type);
                    result = reader.read(null, response.getText());                 
                }
            });
            
        }
        catch (RequestException ex)
        {
            requestFailed(ex);
        }
    }  
    private void requestFailed(Throwable exception)
    {
        Window.alert("Failed to send the request.  The error message was: " + exception.getMessage());
    }

    public List<? extends ModelData> read(ModelData loadConfig, Object data)
    {
        if (result != null)
        {
            List list = result.getData();
            for (Object object :  list)
            {
                BaseModelData item = (BaseModelData)object;
                Folder bill = new Folder((String)item.get("name"));
                /*@todo build a hierachy bill with a bill name retrived from item
               *  
               */
                
            }
        }
        return null;
    }
    
}
