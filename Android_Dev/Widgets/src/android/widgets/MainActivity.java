package android.widgets;

import android.os.Bundle;
import android.app.Activity;
import android.text.InputType;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView textView = new TextView(this);
		textView.setTextColor(0x112233);
		
		EditText editText = new EditText(this);
		editText.setHint(R.string.editText);
		editText.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
		editText.setLines(5);
		
		Button button = new Button(this);
		editText.setText(R.string.button);
		
		CheckBox checkBox1 = new CheckBox(this);
		checkBox1.setText(R.string.checkBox1);
		checkBox1.setChecked(true);
		if(checkBox1.isChecked())
		{
			
		}
		
		CheckBox checkBox2 = new CheckBox(this);
		checkBox2.setText(R.string.checkBox2);
		checkBox2.setChecked(false);
		if(checkBox2.isChecked())
		{
			textView.setText("Bonjour amayas");
		}
	}

}
