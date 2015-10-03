package pidevs.socialsaddict;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressWarnings("deprecation")
public class Welcome extends ActionBarActivity {

	
	Button button1;
	
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		button1 = (Button) findViewById(R.id.button1);
		
		
	button1	.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				startActivity(new Intent(Welcome.this , MainActivity.class));
				
				
			}
		});


	}


}
