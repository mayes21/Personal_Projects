package android.intenttest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	Button monBouton = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		Button monBouton = (Button)findViewById(R.id.buttonToast);
		monBouton.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {

		//Toast.makeText(this, "Coucou n°2", Toast.LENGTH_LONG).show();
		Intent monIntent = new Intent(this, OtherActivity.class);
		startActivity(monIntent);		
		
	}



}
