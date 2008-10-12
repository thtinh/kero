/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.client;

import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.junit.client.GWTTestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Froggy
 */
public class XmlLoaderTest
{

    public XmlLoaderTest()
    {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    /**
     * Test of getUtilityBills method, of class XmlLoader.
     */
    @Test
    public void testGetUtilityBills()
    {
        System.out.println("getUtilityBills");
        XmlLoader instance = new XmlLoader();
        ListStore<BillItem> expResult = null;
        ListStore<BillItem> result = instance.getUtilityBills();
        assertEquals(expResult, result);


    }
}