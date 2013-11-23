package android.appexo3;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	public static final String keyPrenom = "KEY_PRENOM";
	public static final String keyNom = "KEY_NOM";
	public static final String keyAge = "KEY_AGE";
	public static final String keySkills = "KEY_SKILLS";
	public static final String keyPhone = "KEY_PHONE";
	
	
	
	private EditText editTextNom;
	private String nom;
	private EditText editTextPrenom;
	private String prenom;
	private EditText editTextAge;
	private String age;
	private EditText editTextSkills;
	private String skills;
	private EditText editTextPhone;
	private String phone;
	private Button button;
	
	final Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editTextNom = (EditText) findViewById(R.id.EditTextNom);
		editTextPrenom = (EditText) findViewById(R.id.EditTextPrenom);
		editTextAge = (EditText) findViewById(R.id.EditTextAge);
		editTextSkills = (EditText) findViewById(R.id.EditTextSkills);
		editTextPhone = (EditText) findViewById(R.id.EditTextPhone);
		
		
        
		button = (Button) findViewById(R.id.ButtonEnvoyer);
		
		button.setOnClickListener(new OnClickListener() {
			
		Bundle objBun = new Bundle();
	        
			@Override
			public void onClick(View v) {
				nom = editTextNom.getText().toString();
		        prenom = editTextPrenom.getText().toString();
		        age = editTextAge.getText().toString();
		        skills = editTextSkills.getText().toString();
		        phone = editTextPhone.getText().toString();
		        
				/*
				 * **************************************************************
				 * 
				 * 				[OK -> exerice 05]
				 * 
				 * **************************************************************
				 * 
				 * AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
				
				alertDialogBuilder.setTitle(nom+" "+prenom);
		 
				alertDialogBuilder
				.setMessage(nom + " "+ prenom +" "+ age +" "+ skills +" "+ phone)
				.setCancelable(false)
				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						
						// if this button is clicked, close
						// current activity
						MainActivity.this.finish();
					}
				})
				.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});
				
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
 
				// show it
				alertDialog.show();*/
		        
		        objBun.putString(keyPrenom, prenom);
		        objBun.putString(keyNom, nom);
		        objBun.putString(keyAge, age);
		        objBun.putString(keySkills, skills);
		        objBun.putString(keyPhone, phone);
		        
		        
		        Intent monIntent = new Intent(context, OtherActivity.class);
		        monIntent.putExtra("KEY_BUNDLE", objBun);
				startActivity(monIntent);	
				
			}
		});
				  	                 
	        
	}
}