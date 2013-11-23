package android.testparsingxml;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		StrictMode.setThreadPolicy(policy);
		
		/** Create a new layout to display the view */
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(1);
		
		/** Create a new textview array to display the results */
		TextView name[];
		TextView website[];
		TextView category[];
		
		try {
			URL url = new URL("http://www.androidpeople.com/wp-content/uploads/2010/06/example.xml");
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new InputSource(url.openStream()));
			doc.getDocumentElement().normalize();

			NodeList nodeList = doc.getElementsByTagName("item");
			
			/** Assign textview array lenght by arraylist size */
			name = new TextView[nodeList.getLength()];
			website = new TextView[nodeList.getLength()];
			category = new TextView[nodeList.getLength()];
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);

				name[i] = new TextView(this);
				website[i] = new TextView(this);
				category[i] = new TextView(this);

				Element fstElmnt = (Element) node;
				NodeList nameList = fstElmnt.getElementsByTagName("name");
				Element nameElement = (Element) nameList.item(0);
				nameList = nameElement.getChildNodes();
				name[i].setText("Name = "
						+ ((Node) nameList.item(0)).getNodeValue());

				NodeList websiteList = fstElmnt.getElementsByTagName("website");
				Element websiteElement = (Element) websiteList.item(0);
				websiteList = websiteElement.getChildNodes();
				website[i].setText("Website = "
						+ ((Node) websiteList.item(0)).getNodeValue());

				category[i].setText("Website Category = "
						+ websiteElement.getAttribute("category"));

				layout.addView(name[i]);
				layout.addView(website[i]);
				layout.addView(category[i]);
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/** Set the layout view to display */
		setContentView(layout);
	}
	

}
