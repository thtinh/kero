/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007, 2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package mvc.client;

import com.extjs.gxt.ui.client.data.BaseModel;

public class BillItem extends BaseModel
{

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
