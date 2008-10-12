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

import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.store.ListStore;

public class BillModel extends BaseTreeModel
{

    private Folder utility, internet, other;
    //XmlLoader loader;
    public BillModel()
    {
        //loader = new XmlLoader();
        utility = new Folder("Utility");
        internet = new Folder("Internet");
        other = new Folder("Other");

       //ListStore<BillItem> utilityBill = loader.getUtilityBills();

       // utility.set("children", utilityBill);
        add(utility);
        add(internet);
        add(other);

    }
    
    public Folder getUtilityBills()
    {
        return utility;
    }
    public Folder getInternetBills()
    {
        return internet;
    }
    public Folder getOtherBills()
    {
        return other;
    }
}
