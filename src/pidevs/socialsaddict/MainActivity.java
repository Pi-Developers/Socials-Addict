package pidevs.socialsaddict;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
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
			bbmsec, bbmmin, bbmhour, servicehour, servicesec, servicemin,
			starti, states, total;

	static CompoundButton start;

	static ImageView imageView1, imageView2, imageView3, imageView4,
			imageView5, imageView6, imageView7, imageView8;

	static SharedPreferences spf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		// Setting action bar color/title/icons..etc

		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(0xff01579b));
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(Html.fromHtml("<font color='#ffffff'> <b> Socials Addict </b> </font>"));

		start = (CheckBox) findViewById(R.id.start);
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

		load();

		start.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

				if (arg1 == true) {

					startService(new Intent(MainActivity.this,
							ServiceSocial.class));

					save("start", "true");

				} else {

					stopService(new Intent(MainActivity.this,
							ServiceSocial.class));

					save("start", "false");
				}

			}
		});

	}

	public void save(String key, String value) {

		spf = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit = spf.edit();
		edit.putString(key, value);
		edit.commit();

	}

	public void load() {
		spf = PreferenceManager.getDefaultSharedPreferences(this);

		starti = spf.getString("start", "false");
		states = spf.getString("state", "low");
		total = spf.getString("total", "0");

		if (total.isEmpty()) {

			save("total", "0 Hours");
			save("facebook", "true");
			save("kik", "true");
			save("bbm", "true");
			save("ask", "true");
			save("twitter", "true");
			save("instagram", "true");
			save("tumblr", "true");
			save("whatsapp", "true");
			save("boot", "true");

		} else {

			totalhour.setText(total + " Hours");
		}

		if (states.equalsIgnoreCase("low")) {

			MainActivity.state.setText("Low");
			MainActivity.state.setTextColor(Color.parseColor("#32CD32"));
		}

		else if (states.equalsIgnoreCase("average")) {

			MainActivity.state.setText("Average");
			MainActivity.state.setTextColor(Color.parseColor("#32CD32"));

		} else if (states.equalsIgnoreCase("attention")) {
			MainActivity.state.setText("ATTENTION");
			MainActivity.state.setTextColor(Color.parseColor("#FFFF00"));

		} else if (states.equalsIgnoreCase("addicted")) {

			MainActivity.state.setText("Addcited");
			MainActivity.state.setTextColor(Color.parseColor("#FF9933"));

		} else if (states.equalsIgnoreCase("danger")) {

			MainActivity.state.setText("Danger");
			MainActivity.state.setTextColor(Color.parseColor("#CC0000"));
		} else {

			MainActivity.state.setText("Low");
			MainActivity.state.setTextColor(Color.parseColor("#32CD32"));

		}

		if (starti.equals("true") && isMyServiceRunning(ServiceSocial.class)) {
			start.setChecked(true);

		} else {
			start.setChecked(false);

		}

		facebooksec = spf.getString("facebooksec", "0");
		if (facebooksec.isEmpty()) {
			save("facebooksec", "0");
		} else {
			facebook3.setText(facebooksec);
		}

		facebookmin = spf.getString("facebookmin", "0");
		if (facebookmin.isEmpty()) {
			save("facebookmin", "0");
		} else {
			facebook2.setText(facebookmin);
		}

		facebookhour = spf.getString("facebookhour", "0");
		if (facebookhour.isEmpty()) {
			save("facebookhour", "0");
		} else {
			facebook1.setText(facebookhour);
		}

		twittersec = spf.getString("twittersec", "0");
		if (twittersec.isEmpty()) {
			save("twittersec", "0");
		} else {
			twitter3.setText(twittersec);
		}

		twittermin = spf.getString("twittermin", "0");
		if (twittermin.isEmpty()) {
			save("twittermin", "0");
		} else {
			twitter2.setText(twittermin);
		}

		twitterhour = spf.getString("twitterhour", "0");
		if (twitterhour.isEmpty()) {
			save("twitterhour", "0");
		} else {
			twitter1.setText(twitterhour);
		}

		tumblrsec = spf.getString("tumblrsec", "0");
		if (tumblrsec.isEmpty()) {
			save("tumblrsec", "0");
		} else {
			tumblr3.setText(tumblrsec);
		}

		tumblrmin = spf.getString("tumblrmin", "0");
		if (tumblrmin.isEmpty()) {
			save("tumblrmin", "0");
		} else {
			tumblr2.setText(tumblrmin);
		}

		tumblrhour = spf.getString("tumblrhour", "0");
		if (tumblrhour.isEmpty()) {
			save("tumblrhour", "0");
		} else {
			tumblr1.setText(tumblrhour);
		}

		whatsappsec = spf.getString("whatsappsec", "0");
		if (whatsappsec.isEmpty()) {
			save("whatsappsec", "0");
		} else {
			whatsapp3.setText(whatsappsec);
		}

		whatsappmin = spf.getString("whatsappmin", "0");
		if (whatsappmin.isEmpty()) {
			save("whatsappmin", "0");
		} else {
			whatsapp2.setText(whatsappmin);
		}

		whatsapphour = spf.getString("whatsapphour", "0");
		if (whatsapphour.isEmpty()) {
			save("whatsapphour", "0");
		} else {
			whatsapp1.setText(whatsapphour);
		}

		instagramsec = spf.getString("instagramsec", "0");
		if (instagramsec.isEmpty()) {
			save("instagramsec", "0");
		} else {
			instagram3.setText(instagramsec);
		}

		instagrammin = spf.getString("instagrammin", "0");
		if (instagrammin.isEmpty()) {
			save("instagrammin", "0");
		} else {
			instagram2.setText(instagrammin);
		}

		instagramhour = spf.getString("instagramhour", "0");
		if (instagramhour.isEmpty()) {
			save("instagramhour", "0");
		} else {
			instagram1.setText(instagramhour);
		}

		kiksec = spf.getString("kiksec", "0");
		if (kiksec.isEmpty()) {
			save("kiksec", "0");
		} else {
			kik3.setText(kiksec);
		}

		kikhour = spf.getString("kikhour", "0");
		if (kikhour.isEmpty()) {
			save("kikhour", "0");
		} else {
			kik1.setText(kikhour);
		}

		bbmsec = spf.getString("bbmsec", "0");
		if (bbmsec.isEmpty()) {
			save("bbmsec", "0");
		} else {
			bbm3.setText(bbmsec);
		}

		kikmin = spf.getString("kikmin", "0");
		if (kikmin.isEmpty()) {
			save("kikmin", "0");
		} else {
			kik2.setText(kikmin);
		}

		bbmmin = spf.getString("kikmin", "0");
		if (bbmmin.isEmpty()) {
			save("kikmin", "0");
		} else {
			bbm2.setText(bbmmin);
		}

		bbmhour = spf.getString("bbmhour", "0");
		if (bbmhour.isEmpty()) {
			save("bbmhour", "0");
		} else {
			bbm1.setText(bbmhour);
		}

		asksec = spf.getString("asksec", "0");
		if (asksec.isEmpty()) {
			save("asksec", "0");
		} else {
			ask3.setText(asksec);
		}

		askmin = spf.getString("askmin", "0");
		if (askmin.isEmpty()) {
			save("askmin", "0");
		} else {
			ask2.setText(askmin);
		}

		askhour = spf.getString("askhour", "0");
		if (askhour.isEmpty()) {
			save("askhour", "0");
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
			String shareBody = "#Socials_Addict\n" + "Facebook "
					+ facebook1.getText() + ":" + facebook2.getText() + ":"
					+ facebook3.getText() + "\n" + "Twitter "
					+ twitter1.getText() + ":" + twitter2.getText() + ":"
					+ twitter3.getText() + "\n" + "Whatsapp "
					+ whatsapp1.getText() + ":" + whatsapp2.getText() + ":"
					+ whatsapp3.getText() + "\n" + "Instagram "
					+ instagram1.getText() + ":" + instagram2.getText() + ":"
					+ instagram3.getText() + "\n" + "Tumblr "
					+ tumblr1.getText() + ":" + tumblr2.getText() + ":"
					+ tumblr3.getText() + "\n" + "Ask " + ask1.getText() + ":"
					+ ask2.getText() + ":" + ask3.getText() + "\n" + "Kik "
					+ kik1.getText() + ":" + kik2.getText() + ":"
					+ kik3.getText() + "\n" + "BBM " + bbm1.getText() + ":"
					+ bbm2.getText() + ":" + bbm3.getText();

			sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
			startActivity(Intent.createChooser(sharingIntent, "Share using"));
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

	private boolean isMyServiceRunning(Class<?> serviceClass) {
		ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		for (RunningServiceInfo service : manager
				.getRunningServices(Integer.MAX_VALUE)) {
			if (serviceClass.getName().equals(service.service.getClassName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected void onResume() {
		super.onResume();

		load();

	}

	@Override
	protected void onPause() {
		super.onPause();
	}

}
