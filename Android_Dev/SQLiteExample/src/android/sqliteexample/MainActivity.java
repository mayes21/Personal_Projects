package android.sqliteexample;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.classes.Contact;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		DatabaseHandler db = new DatabaseHandler(this);
		/**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert_db", "Inserting contacts.."); 
        
        Contact c1 =  new Contact("Ravi", "9100000000");
        Contact c2 =  new Contact("Srinivas", "9199999999");
        Contact c3 =  new Contact("Tommy", "9522222222");
        Contact c4 =  new Contact("Karthik", "9533333333");
        
        
        db.addContact(c1);        
        db.addContact(c2);
        db.addContact(c3);
        db.addContact(c4);
		
        // Reading all contacts
        Log.d("Reading", "Reading all contacts.."); 
        List<Contact> contacts = db.getAllContacts();       
         
        for (Contact cn : contacts)
        {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
        
        // Deleting all contacts
        
        Log.d("deleting", "Deleting all contacts.."); 
        for (Contact cn : contacts)
        {
            db.deleteContact(cn);
            Log.d("delete", "Contact deleted...");
        }
        
        db.addContact(c1);        
        db.addContact(c2);
        db.addContact(c3);
        db.addContact(c4);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
