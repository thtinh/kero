/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007, 2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package mvc.client;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.Format;
import com.extjs.gxt.ui.client.util.Params;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class BillItemPanel extends ContentPanel
{

    private ContentPanel content;
    private Html header;
    private String headerHTML = "<div class=mail-item-detail><h1>{0}</h1><h2><b>From:</b> {1}</h2><h3><b>To:</b> {2}</h3></div>";

    public BillItemPanel()
    {
        setHeaderVisible(false);
        setLayout(new FitLayout());

        content = new ContentPanel();
        content.setBodyBorder(false);
        content.setHeaderVisible(false);
        content.setScrollMode(Scroll.AUTO);

        header = new Html();
        header.setStyleName("mail-item-detail");
        content.setTopComponent(header);

        add(content);
    }

    public void showItem(BillItem item)
    {
        if (item != null)
        {
            Params p = new Params();
            p.add(item.getSubject());
            p.add(item.getSender());
            p.add(item.getEmail());

            String s = Format.substitute(headerHTML, p);
            header.getElement().setInnerHTML(s);

            content.removeAll();
            content.addText("<div style='padding: 12px;font-size: 12px'>" + item.getBody() + "</div>");

            layout();

        }
        else
        {
            header.setHtml("");
            content.removeAll();
        }
    }
}
