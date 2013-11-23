package android.testactivities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AppActivity extends Activity implements OnClickListener 
{
	
	Button button;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		addListenerOnButton();
	}
	
	public void addListenerOnButton() 
	{
		final Context context = this;
 
		button = (Button) findViewById(R.id.button1);
		
		button.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				 Intent intent = new Intent(context, AppActivity2.class);
                 startActivity(intent);   
			}
		});
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
