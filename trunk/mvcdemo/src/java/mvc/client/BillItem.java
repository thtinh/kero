/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007, 2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package mvc.client;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.TreeModel;
import java.util.List;

public class BillItem extends BaseModel implements TreeModel 
{

    public void add(TreeModel child)
    {
        throw new UnsupportedOperationException("This is a leaf");
    }

    public TreeModel getChild(int index)
    {
        return this;
    }

    public int getChildCount()
    {
        return 1;
    }

    public List getChildren()
    {
        throw new UnsupportedOperationException("This is a leaf");
    }

    public TreeModel getParent()
    {
        return null;
    }

    public int indexOf(TreeModel child)
    {
        return 1;
    }

    public void insert(TreeModel child, int index)
    {
        throw new UnsupportedOperationException("This is a leaf");
    }

    public boolean isLeaf()
    {
        return true;
    }

    public void remove(TreeModel child)
    {
        throw new UnsupportedOperationException("This is a leaf");
    }

    public void removeAll()
    {
        throw new UnsupportedOperationException("This is a leaf");
    }

    public void setParent(TreeModel parent)
    {
        throw new UnsupportedOperationException("This is a leaf");
    }

    public BillItem()
    {
    }

    public BillItem(String name, String startDate, String endDate, float amount)
    {
        setName(name);
        setStartDate(startDate);
        setStartDate(endDate);
        setAmount(amount);       
    }

    public BillItem(String name, String startDate, String endDate, float amount, String body)
    {
        this(name,startDate,endDate,amount);
        set("body", body);
    }

    public String getName()
    {
        return (String) get("name");
    }

    public void setName(String name)
    {
        set("name", name);
    }

    public void setStartDate(String StartDate)
    {
        set("startDate", StartDate);
    }

    public String getStartDate()
    {
        return (String) get("startDate");
    }

    public String getBody()
    {
        return (String) get("body");
    }
    public void setEndDate(String endDate)
    {
        set("endDate", endDate);
    }

    public String getEndDate()
    {
        return (String) get("endDate");
    }
   public void setAmount(float amount)
    {
        set("amount", amount);
    }

    public float getAmount()
    {
        return Float.valueOf((String)get("amount"));
    }
}
