package technologysociety.socialsaddict;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	static TextView facebook1, twitter1, tumblr1, instagram1, whatsapp1,
			facebook2, twitter2, tumblr2, instagram2, whatsapp2, facebook3,
			twitter3, tumblr3, instagram3, whatsapp3, kik1, kik2, kik3, ask1,
			ask2, ask3, bbm1, bbm2, bbm3, state, service3, service2, service1,
			totalhour;

	static String facebooksec, twittersec, tumblrsec, instagramsec,
			whatsappsec, facebookmin, twittermin, tumblrmin, instagrammin,
			whatsappmin, facebookhour, twitterhour, tumblrhour, instagramhour,
			whatsapphour, kiksec, kikmin, kikhour, asksec, askmin, askhour,
			bbmsec, bbmmin, bbmhour, servicehour, servicesec, servicemin;

	static CompoundButton start;

	static ImageView imageView1, imageView2, imageView3, imageView4,
			imageView5, imageView6, imageView7, imageView8;

	public void loadservicehour() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		servicehour = ServiceSocial.spf.getString("servicehour", "");
		if (servicehour.isEmpty()) {

		} else {
			service1.setText(servicehour);
		}

	}

	public void loadservicesec() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		servicesec = ServiceSocial.spf.getString("servicesec", "");
		if (servicesec.isEmpty()) {

		} else {
			service3.setText(servicesec);
		}

	}

	public void loadservicemin() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		servicemin = ServiceSocial.spf.getString("servicemin", "");
		if (servicemin.isEmpty()) {

		} else {
			service2.setText(servicemin);
		}

	}

	public void loadfacebooksec() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		facebooksec = ServiceSocial.spf.getString("facebooksec", "");
		if (facebooksec.isEmpty()) {

		} else {
			facebook3.setText(facebooksec);
		}

	}

	public void loadfacebookmin() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		facebookmin = ServiceSocial.spf.getString("facebookmin", "");
		if (facebookmin.isEmpty()) {

		} else {
			facebook2.setText(facebookmin);
		}

	}

	public void loadfacebookhour() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		facebookhour = ServiceSocial.spf.getString("facebookhour", "");
		if (facebookhour.isEmpty()) {

		} else {
			facebook1.setText(facebookhour);
		}

	}

	public void loadtwittersec() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		twittersec = ServiceSocial.spf.getString("twittersec", "");
		if (twittersec.isEmpty()) {

		} else {
			twitter3.setText(twittersec);
		}

	}

	public void loadtwittermin() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		twittermin = ServiceSocial.spf.getString("twittermin", "");
		if (twittermin.isEmpty()) {

		} else {
			twitter2.setText(twittermin);
		}

	}

	public void loadtwitterhour() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		twitterhour = ServiceSocial.spf.getString("twitterhour", "");
		if (twitterhour.isEmpty()) {

		} else {
			twitter1.setText(twitterhour);
		}

	}

	public void loadtumblrsec() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		tumblrsec = ServiceSocial.spf.getString("tumblrsec", "");
		if (tumblrsec.isEmpty()) {

		} else {
			tumblr3.setText(tumblrsec);
		}

	}

	public void loadtumblrmin() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		tumblrmin = ServiceSocial.spf.getString("tumblrmin", "");
		if (tumblrmin.isEmpty()) {

		} else {
			tumblr2.setText(tumblrmin);
		}

	}

	public void loadtumblrhour() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		tumblrhour = ServiceSocial.spf.getString("tumblrhour", "");
		if (tumblrhour.isEmpty()) {

		} else {
			tumblr1.setText(tumblrhour);
		}

	}

	public void loadwhatsappsec() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		whatsappsec = ServiceSocial.spf.getString("whatsappsec", "");
		if (whatsappsec.isEmpty()) {

		} else {
			whatsapp3.setText(whatsappsec);
		}

	}

	public void loadwhatsappmin() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		whatsappmin = ServiceSocial.spf.getString("whatsappmin", "");
		if (whatsappmin.isEmpty()) {

		} else {
			whatsapp2.setText(whatsappmin);
		}

	}

	public void loadwhatsapphour() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		whatsapphour = ServiceSocial.spf.getString("whatsapphour", "");
		if (whatsapphour.isEmpty()) {

		} else {
			whatsapp1.setText(whatsapphour);
		}

	}

	public void loadinstagramsec() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		instagramsec = ServiceSocial.spf.getString("instagramsec", "");
		if (instagramsec.isEmpty()) {

		} else {
			instagram3.setText(instagramsec);
		}

	}

	public void loadinstagrammin() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		instagrammin = ServiceSocial.spf.getString("instagrammin", "");
		if (instagrammin.isEmpty()) {

		} else {
			instagram2.setText(instagrammin);
		}

	}

	public void loadinstagramhour() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		instagramhour = ServiceSocial.spf.getString("instagramhour", "");
		if (instagramhour.isEmpty()) {

		} else {
			instagram1.setText(instagramhour);
		}

	}

	public void loadkiksec() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		kiksec = ServiceSocial.spf.getString("kiksec", "");
		if (kiksec.isEmpty()) {

		} else {
			kik3.setText(kiksec);
		}

	}

	public void loadkikmin() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		kikmin = ServiceSocial.spf.getString("kikmin", "");
		if (kikmin.isEmpty()) {

		} else {
			kik2.setText(kikmin);
		}

	}

	public void loadkikhour() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		kikhour = ServiceSocial.spf.getString("kikhour", "");
		if (kikhour.isEmpty()) {

		} else {
			kik1.setText(kikhour);
		}

	}

	public void loadbbmsec() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		bbmsec = ServiceSocial.spf.getString("bbmsec", "");
		if (bbmsec.isEmpty()) {

		} else {
			bbm3.setText(bbmsec);
		}

	}

	public void loadbbmmin() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		bbmmin = ServiceSocial.spf.getString("bbmmin", "");
		if (bbmmin.isEmpty()) {

		} else {
			bbm2.setText(bbmmin);
		}

	}

	public void loadbbmhour() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		bbmhour = ServiceSocial.spf.getString("bbmhour", "");
		if (bbmhour.isEmpty()) {

		} else {
			bbm1.setText(bbmhour);
		}

	}

	public void loadasksec() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		asksec = ServiceSocial.spf.getString("asksec", "");
		if (asksec.isEmpty()) {

		} else {
			ask3.setText(asksec);
		}

	}

	public void loadaskmin() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		askmin = ServiceSocial.spf.getString("askmin", "");
		if (askmin.isEmpty()) {

		} else {
			ask2.setText(askmin);
		}

	}

	public void loadaskhour() {

		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		askhour = ServiceSocial.spf.getString("askhour", "");
		if (askhour.isEmpty()) {

		} else {
			ask1.setText(askhour);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == R.id.share) {

			Intent sharingIntent = new Intent(Intent.ACTION_SEND);
			sharingIntent.setType("text/plain");
			String shareBody = "#Socials_Addict\n"
					+ "Facebook " + facebook1.getText() + ":"+ facebook2.getText() + "\n" 
					+ "Twitter " + twitter1.getText() + ":" + twitter2.getText() + "\n"
					+ "Whatsapp " + whatsapp1.getText() + ":"+ whatsapp2.getText() +"\n"
					+ "Instagram " + instagram1.getText() + ":" + instagram2.getText() +"\n"
					+ "Tumblr "+ tumblr1.getText() + ":" + tumblr2.getText() + "\n" 
					+ "Ask " + ask1.getText() + ":" + ask2.getText() + "\n"
					+ "Kik " + kik1.getText() + ":" + kik2.getText() + "\n"
					+ "BBM " + bbm1.getText() + ":" + bbm2.getText();
					
			sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
			startActivity(Intent.createChooser(sharingIntent, "Share via"));
		}

		if (item.getItemId() == R.id.setting) {

			Intent intent = new Intent(MainActivity.this, Setting.class);
			startActivity(intent);

		}

		return super.onOptionsItemSelected(item);

	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			moveTaskToBack(true);
			return true;
		}
		return true;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (Integer.valueOf(android.os.Build.VERSION.SDK) >= 14) {
			setContentView(R.layout.activity_main);
			start = (Switch) findViewById(R.id.start);

		} else {
			setContentView(R.layout.activity_main2);
			start = (CheckBox) findViewById(R.id.start);

		}

		totalhour = (TextView) findViewById(R.id.total);

		facebook1 = (TextView) findViewById(R.id.facebook1);
		facebook2 = (TextView) findViewById(R.id.facebook2);
		facebook3 = (TextView) findViewById(R.id.facebook3);

		kik1 = (TextView) findViewById(R.id.kik1);
		kik2 = (TextView) findViewById(R.id.kik2);
		kik3 = (TextView) findViewById(R.id.kik3);

		bbm1 = (TextView) findViewById(R.id.bbm1);
		bbm2 = (TextView) findViewById(R.id.bbm2);
		bbm3 = (TextView) findViewById(R.id.bbm3);

		ask1 = (TextView) findViewById(R.id.ask1);
		ask2 = (TextView) findViewById(R.id.ask2);
		ask3 = (TextView) findViewById(R.id.ask3);

		twitter1 = (TextView) findViewById(R.id.twitter1);
		twitter2 = (TextView) findViewById(R.id.twitter2);
		twitter3 = (TextView) findViewById(R.id.twitter3);

		tumblr1 = (TextView) findViewById(R.id.tumblr1);
		tumblr2 = (TextView) findViewById(R.id.tumblr2);
		tumblr3 = (TextView) findViewById(R.id.tumblr3);

		instagram1 = (TextView) findViewById(R.id.instagram1);
		instagram2 = (TextView) findViewById(R.id.instagram2);
		instagram3 = (TextView) findViewById(R.id.instagram3);

		whatsapp1 = (TextView) findViewById(R.id.whatsapp1);
		whatsapp2 = (TextView) findViewById(R.id.whatsapp2);
		whatsapp3 = (TextView) findViewById(R.id.whatsapp3);

		state = (TextView) findViewById(R.id.state);
		service1 = (TextView) findViewById(R.id.servicehour);
		service2 = (TextView) findViewById(R.id.servicemin);
		service3 = (TextView) findViewById(R.id.servicesec);

		loadfacebookmin();
		loadfacebooksec();
		loadfacebookhour();

		loadservicesec();
		loadservicemin();
		loadservicehour();

		loadkikmin();
		loadkiksec();
		loadkikhour();

		loadaskmin();
		loadasksec();
		loadaskhour();

		loadbbmmin();
		loadbbmsec();
		loadbbmhour();

		loadinstagrammin();
		loadinstagramsec();
		loadinstagramhour();

		loadtumblrmin();
		loadtumblrsec();
		loadtumblrhour();

		loadtwittermin();
		loadtwittersec();
		loadtwitterhour();

		loadwhatsappmin();
		loadwhatsappsec();
		loadwhatsapphour();

		
		
		start.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub

				if (arg1 == true) {

					Intent intent = new Intent(MainActivity.this, Setting.class);
					startActivity(intent);

					startService(new Intent(MainActivity.this,
							ServiceSocial.class));

				} else {
					stopService(new Intent(MainActivity.this,
							ServiceSocial.class));

				}

			}
		});
		
	}

}
