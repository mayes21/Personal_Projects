package android.geoip;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;











import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity
{

	
	private EditText editTextIpAdd = null;
	private String host = null;
	private Button searchButt = null;
	
	public String urlRoot = "http://freegeoip.net/xml/";

	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	
	 static final String RESPONSE_ITEM = "Response"; // parent node
	 static final String KEY_IP = "Ip";
	 static final String KEY_COUNTRY_NAME = "CountryName";
	 static final String KEY_REGION_NAME = "RegionName";
	 static final String KEY_LATITUDE = "Latitude";
	 static final String KEY_LONGITUDE = "Longitude";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StrictMode.setThreadPolicy(policy);			
					
		
		editTextIpAdd = (EditText) findViewById(R.id.editTextIpAdd);
		
		searchButt = (Button) findViewById(R.id.buttonSear);
		
		final XMLParser parser = new XMLParser();
		
		searchButt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String host = editTextIpAdd.getText().toString(); 
				String URL = urlRoot+host;
				
				
				String xml = parser.getXmlFromUrl(URL);
				
				// getting DOM element
				Document doc = parser.getDomElement(xml); 
				
				NodeList nl = doc.getElementsByTagName(RESPONSE_ITEM);
				
				Element e = (Element) nl.item(0);
				
				String ip = parser.getValue(e, KEY_IP);
				String countryName = parser.getValue(e, KEY_COUNTRY_NAME);
				String regionName = parser.getValue(e, KEY_REGION_NAME);
				String latitude = parser.getValue(e, KEY_LATITUDE);
				String longitude = parser.getValue(e, KEY_LONGITUDE);
				
				Toast.makeText(MainActivity.this, ip+" - "+countryName+" - "+regionName+" - "+latitude+" - "+longitude , Toast.LENGTH_LONG).show();
				/*Document doc = parser.getDomElement(xml);
				
				NodeList nl = doc.getElementsByTagName(RESPONSE_ITEM);
				
				
				  for (int i = 0; i < nl.getLength(); i++) 
				  {
					   Element e = (Element) nl.item(i);
					   
					   String ip = parser.getValue(e, KEY_IP);
					   Toast.makeText(MainActivity.this, ip , Toast.LENGTH_LONG).show();
					   
				  }
				*/
				/*host = editTextIpAdd.getText().toString();
				Toast.makeText(MainActivity.this, host , Toast.LENGTH_LONG).show();*/
				 
				
				
			}
		});	
		
							
	}

}
		

	


