package app.android.apptest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView text = null;
	private String hello = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        hello = getResources().getString(R.string.hello_world);
        
        hello = hello.replace("world", "les zéros");
        
        
        text = new TextView(this);
        text.setText(hello);
        setContentView(text);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
