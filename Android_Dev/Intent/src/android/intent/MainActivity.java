package android.intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener{

	
	Button monBouton = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		monBouton = (Button)findViewById(R.id.buttonToast);
		
		monBouton.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) 
	{
		if(v == monBouton)
		{
			Toast.makeText(this, "Coucou n°2", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	
	

}
