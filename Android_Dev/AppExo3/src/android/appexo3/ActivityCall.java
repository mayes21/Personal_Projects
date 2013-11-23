package android.appexo3;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class ActivityCall extends Activity{

	
	final Context context = this;
	
	private String phone;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_call);
		
		
		ImageButton call = new ImageButton(context);
		
		call = (ImageButton) findViewById(R.id.imageButtonCall);
		
		phone = getIntent().getExtras().getString("KEY_CALL");
		
		Log.d("call", phone);
		
		call.setOnClickListener(new OnClickListener() {
			
			
			
			@Override
			public void onClick(View v)
			{
				
				Intent call = new Intent(Intent.ACTION_CALL);
				call.setData(Uri.parse("tel:" + phone));
				startActivity(call);
				
				
			}
		});
		
		
		
	}

}
