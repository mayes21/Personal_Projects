package android.appexo3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OtherActivity extends Activity implements OnClickListener
{
	private String prenom;
	private String nom;
	private String age;
	private String skills;
	private String phone;
    
	final Context cont = this;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_other);
    	
    	Bundle objetbunble  = this.getIntent().getBundleExtra("KEY_BUNDLE");
    	
    	Button ok =  (Button) findViewById(R.id.button1);
    			
    	Button retour = (Button) findViewById(R.id.button2);
    	
    	TextView famName = (TextView)findViewById(R.id.textViewFamName);
    	TextView firName = (TextView)findViewById(R.id.textViewFirName);
    	TextView ag = (TextView)findViewById(R.id.textViewAg);
    	TextView skill = (TextView)findViewById(R.id.textViewSki);
    	TextView phon = (TextView)findViewById(R.id.textViewPh);
    	
	    //On récupère les données du Bundle
    	if(objetbunble == null)
    	{
    		Log.d("objectBundle", "it's null");
    	}
    	else
    	{
    		Log.d("objectBundle", "it's not null");
    	}
    	
	    if (objetbunble != null && objetbunble.containsKey(MainActivity.keyPrenom) && objetbunble.containsKey(MainActivity.keyNom) 
	    		&& objetbunble.containsKey(MainActivity.keyAge) && objetbunble.containsKey(MainActivity.keySkills)
	    		&& objetbunble.containsKey(MainActivity.keyPhone)) 
	    {
	    	prenom = this.getIntent().getBundleExtra("KEY_BUNDLE").getString(MainActivity.keyPrenom);
	        nom = this.getIntent().getBundleExtra("KEY_BUNDLE").getString(MainActivity.keyNom);
	        age = this.getIntent().getBundleExtra("KEY_BUNDLE").getString(MainActivity.keyAge);
	        skills = this.getIntent().getBundleExtra("KEY_BUNDLE").getString(MainActivity.keySkills);
	        phone = this.getIntent().getBundleExtra("KEY_BUNDLE").getString(MainActivity.keyPhone);
	    }
	    else
	    {
	    	//Erreur
	    	prenom = "Error";
	    	nom = "Error";
	    	age = "Error";
	    	skills = "Error";
	    	phone = "Error";
	    }
	    
	    
	    famName.setText(nom);
	    firName.setText(prenom);
	    ag.setText(age);
	    skill.setText(skills);
	    phon.setText(phone);
	
	    Toast.makeText(this, nom+" "+prenom+" "+age+" "+skills+" "+phone , Toast.LENGTH_LONG).show();
	    
	    ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent int2 = new Intent(cont, ActivityCall.class);
				int2.putExtra("KEY_CALL", phone);
				startActivity(int2);
				
			}
		});
	    
	    retour.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				OtherActivity.this.finish();	
			}
		});
	    
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
	


