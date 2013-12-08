package android.sqliteexample;

import java.util.ArrayList;
import java.util.List;

import android.classes.Contact;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper
{
	
	// All Static variables
	
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "contactsManager";
 
    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";
    
    public DatabaseHandler(Context context) 
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables 
    /*
     * 
     * These is where we need to write create table statements. This is called when database is created.
     * 
     */
    
    @Override
    public void onCreate(SQLiteDatabase db) 
    {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    
    /*
     * 
     * This method is called when database is upgraded like modifying the table structure, adding constraints to database etc.,
     * 
     */
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
 
        // Create tables again
        onCreate(db);
    }
    
    // Adding new contact
    /*
     * 
     * The addContact() method accepts Contact object as parameter. We need to build ContentValues parameters using 
     * Contact object. Once we inserted data in database we need to close the database connection.
     * 
     */
    public void addContact(Contact contact) 
    {
    	SQLiteDatabase db = this.getWritableDatabase();
    	 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // Contact Name
        values.put(KEY_PH_NO, contact.getPhoneNumber()); // Contact Phone Number
     
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
     
    // Getting single contact
    /*
     * 
     * 
     * The following method getContact() will read single contact row.
     * It accepts id as parameter and will return the matched row from the database.
     * 
     */
    public Contact getContact(int id) 
    {
    	SQLiteDatabase db = this.getReadableDatabase();
    	 
        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
     
        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
        // return contact
        return contact;
    }
     
    // Getting All Contacts
    /*
     * 
     * getAllContacts() will return all contacts from database in array list format of Contact class type.
     * You need to write a for loop to go through each contact.
     * 
     */
    public List<Contact> getAllContacts() 
    {
    	List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        
     // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        
     // return contact list
        return contactList;
    }
     
    // Getting contacts Count
    /*
     * 
     * getContactsCount() will return total number of contacts in SQLite database.
     * 
     */
    public int getContactsCount() 
    {
    	String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor cursor = db.rawQuery(countQuery, null);
    	cursor.close();
    	 
    	// return count
    	return cursor.getCount();
    }
    
    // Updating single contact
    /*
     * 
     * updateContact() will update single contact in database. This method accepts Contact class object as parameter.
     * 
     */
    public int updateContact(Contact contact)
    {
    	SQLiteDatabase db = this.getWritableDatabase();
    	 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());
     
        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }
     
    // Deleting single contact
    /*
     * 
     * deleteContact() will delete single contact from database.
     * 
     */
    public void deleteContact(Contact contact) 
    {
    	SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }
    
}
