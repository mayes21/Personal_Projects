package android.monapp3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity {

	
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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editTextNom = (EditText) findViewById(R.id.EditTextNom);
		
	}

	

}
