package pidevs.socialsaddict;

import java.text.DecimalFormat;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity {

	TextView facebook1, twitter1, tumblr1, instagram1, whatsapp1, facebook2,
			twitter2, tumblr2, instagram2, whatsapp2, facebook3, twitter3,
			tumblr3, instagram3, whatsapp3, kik1, kik2, kik3, ask1, ask2, ask3,
			bbm1, bbm2, bbm3, state, service3, service2, service1, totalhour,
			usage, snap1, snap2, snap3, kikm1, kikm2, kikm3;

	String facebooksec, twittersec, tumblrsec, instagramsec, whatsappsec,
			facebookmin, twittermin, tumblrmin, instagrammin, whatsappmin,
			facebookhour, twitterhour, tumblrhour, instagramhour, whatsapphour,
			kiksec, kikmin, kikhour, asksec, askmin, askhour, bbmsec, bbmmin,
			bbmhour, servicehour, servicesec, servicemin, starti, states,
			total, ser1, ser2, ser3, yy, kikmmin, kikmhour, kikmsec, snapsec,
			snaphour, snapmin, bootchk, firstboot;

	ImageView imageView1, imageView2, imageView3, imageView4, imageView5,
			imageView6, imageView7, imageView8;

	SharedPreferences spf;
	CompoundButton start;
	Double x, y, y1, usaget;
	int z;

	int currentapiVersion = android.os.Build.VERSION.SDK_INT;

	android.support.v7.app.ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main2);

		// Setting action bar color/title/icons..etc
		FontsOverride.setDefaultFont(this, "DEFAULT", "Roboto-Regular.ttf");
		FontsOverride.setDefaultFont(this, "MONOSPACE", "Roboto-Regular.ttf");
		FontsOverride.setDefaultFont(this, "SANS_SERIF", "Roboto-Regular.ttf");

		actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(0xff01579b));
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar
				.setTitle(Html
						.fromHtml("<font color='#ffffff'> <b> Socials Addict </b> </font>"));

		// Changes the compound button according to the API
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {

			start = (Switch) findViewById(R.id.start);

		} else {

			start = (CheckBox) findViewById(R.id.start);

		}

		// Text views, many text views
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
		snap1 = (TextView) findViewById(R.id.snap1);
		snap2 = (TextView) findViewById(R.id.snap2);
		snap3 = (TextView) findViewById(R.id.snap3);
		kikm1 = (TextView) findViewById(R.id.kikm1);
		kikm2 = (TextView) findViewById(R.id.kikm2);
		kikm3 = (TextView) findViewById(R.id.kikm3);
		state = (TextView) findViewById(R.id.state);
		usage = (TextView) findViewById(R.id.textView6);

		// This method loads the sharedprefrences of the activity
		load();

		/*
		 * Start the tracking service here
		 */
		start.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

				if (arg1 == true) {
					
					save("start", "true");

					if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP
							|| currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {

						startService(new Intent(MainActivity.this,
								LollipopService.class));

					} else {

						startService(new Intent(MainActivity.this,
								ServiceSocial.class));

					}

					Toast.makeText(getApplicationContext(),
							"Socials Addict started", Toast.LENGTH_SHORT)
							.show();


				} else {

					save("start", "false");

					
					if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP
							|| currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {

						stopService(new Intent(MainActivity.this,
								LollipopService.class));

					} else {

						stopService(new Intent(MainActivity.this,
								ServiceSocial.class));

					}

				}

			}
		});

	}

	/*
	 * 
	 * The method that save the shared prefrences as strings
	 */
	public void save(String key, String value) {

		spf = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit = spf.edit();
		edit.putString(key, value);
		edit.commit();

	}

	public void load() {

		spf = PreferenceManager.getDefaultSharedPreferences(this);

		
		
		 
		String fbcheck = spf.getString("facebook", "true");
		String kikcheck = spf.getString("kik", "true");
		String bbmcheck = spf.getString("bbm", "true");
		String askcheck = spf.getString("ask", "true");
		String twcheck = spf.getString("twitter", "true");
		String instacheck = spf.getString("instagram", "true");
		String tumblrcheck = spf.getString("tumblr", "true");
		String whatsappcheck = spf.getString("whatsapp", "true");
		String kikmcheck = spf.getString("kikm", "true");
		String snapcheck = spf.getString("snapchat", "true");

		starti = spf.getString("start", "false");
		states = spf.getString("state", "low");
		total = spf.getString("total", "0");
		bootchk = spf.getString("boot", "true");
		firstboot = spf.getString("first", "true");

		ser1 = spf.getString("servicehour", "0");
		ser2 = spf.getString("servicemin", "0");
		ser3 = spf.getString("servicesec", "0");

		if (firstboot.isEmpty() || firstboot.equals("true")) {

		    startActivity(new Intent(MainActivity.this , Welcome.class));
			save("first", "false");

		} else {

		}

		if (snapcheck.isEmpty()) {

			save("snapchat", "true");

		} else {
		}

		if (kikmcheck.isEmpty()) {

			save("kikm", "true");

		} else {
		}

		if (ser1.isEmpty()) {

			save("servicehour", "0");

		} else {

			z = Integer.parseInt(ser1);
		}

		if (ser2.isEmpty()) {

			save("servicemin", "0");

		} else {
		}

		if (ser3.isEmpty()) {

			save("servicesec", "0");

		} else {
		}

		if (fbcheck.isEmpty()) {

			save("facebook", "true");

		} else {
		}

		if (kikcheck.isEmpty()) {

			save("kik", "true");

		} else {
		}

		if (bbmcheck.isEmpty()) {

			save("bbm", "true");

		} else {
		}

		if (askcheck.isEmpty()) {

			save("ask", "true");

		} else {
		}

		if (twcheck.isEmpty()) {

			save("twitter", "true");

		} else {
		}

		if (instacheck.isEmpty()) {

			save("instagram", "true");

		} else {
		}

		if (tumblrcheck.isEmpty()) {

			save("tumblr", "true");

		} else {
		}

		if (whatsappcheck.isEmpty()) {

			save("whatsapp", "true");

		} else {
		}

		if (bootchk.isEmpty()) {

			save("boot", "true");

		} else {
		}

		if (total.isEmpty()) {

			save("total", "0 Hours");

		} else {
			DecimalFormat df = new DecimalFormat("#.##");

			x = Double.parseDouble(total);

			totalhour.setText(df.format(x) + " Hours");

			if (z > 24) {

				y = ((double) z / 24.0);

				yy = df.format(y);

				y1 = Double.parseDouble(yy);

				usaget = (x / y1);

				usage.setText(df.format(usaget) + " Hour/Day");

			} else {

				usage.setText("0 Hour/Day");
			}

		}

		if (states.isEmpty()) {

			save("state", "low");

		} else {

		}

		states = spf.getString("state", "low");

		if (states.equals("low")) {

			state.setText("Low");
			state.setTextColor(Color.parseColor("#32CD32"));

		}

		else if (states.equals("Average")) {

			state.setText("Average");
			state.setTextColor(Color.parseColor("#32CD32"));

		} else if (states.equals("attention")) {

			state.setText("ATTENTION");
			state.setTextColor(Color.parseColor("#fcce1c"));

		} else if (states.equals("Addicted")) {

			state.setText("Addcited");
			state.setTextColor(Color.parseColor("#FF9933"));

		} else if (states.equals("DANGER")) {

			state.setText("Danger");
			state.setTextColor(Color.parseColor("#CC0000"));

		} else {

			state.setText("Low");
			state.setTextColor(Color.parseColor("#32CD32"));

		}

		if (starti.equals("true") && isMyServiceRunning(ServiceSocial.class)
				|| isMyServiceRunning(LollipopService.class)
				&& starti.equals("true")) {

			start.setChecked(true);

		} else {
			start.setChecked(false);

		}

		facebooksec = spf.getString("facebooksec", "00");
		if (facebooksec.isEmpty()) {
			save("facebooksec", "00");
		} else {
			facebook3.setText(facebooksec);
		}

		facebookmin = spf.getString("facebookmin", "00");
		if (facebookmin.isEmpty()) {
			save("facebookmin", "00");
		} else {
			facebook2.setText(facebookmin);
		}

		facebookhour = spf.getString("facebookhour", "00");
		if (facebookhour.isEmpty()) {
			save("facebookhour", "00");
		} else {
			facebook1.setText(facebookhour);
		}

		twittersec = spf.getString("twittersec", "00");
		if (twittersec.isEmpty()) {
			save("twittersec", "00");
		} else {
			twitter3.setText(twittersec);
		}

		twittermin = spf.getString("twittermin", "00");
		if (twittermin.isEmpty()) {
			save("twittermin", "00");
		} else {
			twitter2.setText(twittermin);
		}

		twitterhour = spf.getString("twitterhour", "00");
		if (twitterhour.isEmpty()) {
			save("twitterhour", "00");
		} else {
			twitter1.setText(twitterhour);
		}

		tumblrsec = spf.getString("tumblrsec", "00");
		if (tumblrsec.isEmpty()) {
			save("tumblrsec", "00");
		} else {
			tumblr3.setText(tumblrsec);
		}

		tumblrmin = spf.getString("tumblrmin", "00");
		if (tumblrmin.isEmpty()) {
			save("tumblrmin", "00");
		} else {
			tumblr2.setText(tumblrmin);
		}

		tumblrhour = spf.getString("tumblrhour", "00");
		if (tumblrhour.isEmpty()) {
			save("tumblrhour", "00");
		} else {
			tumblr1.setText(tumblrhour);
		}

		whatsappsec = spf.getString("whatsappsec", "00");
		if (whatsappsec.isEmpty()) {
			save("whatsappsec", "00");
		} else {
			whatsapp3.setText(whatsappsec);
		}

		whatsappmin = spf.getString("whatsappmin", "00");
		if (whatsappmin.isEmpty()) {
			save("whatsappmin", "00");
		} else {
			whatsapp2.setText(whatsappmin);
		}

		whatsapphour = spf.getString("whatsapphour", "00");
		if (whatsapphour.isEmpty()) {
			save("whatsapphour", "00");
		} else {
			whatsapp1.setText(whatsapphour);
		}

		instagramsec = spf.getString("instagramsec", "00");
		if (instagramsec.isEmpty()) {
			save("instagramsec", "00");
		} else {
			instagram3.setText(instagramsec);
		}

		instagrammin = spf.getString("instagrammin", "00");
		if (instagrammin.isEmpty()) {
			save("instagrammin", "00");
		} else {
			instagram2.setText(instagrammin);
		}

		instagramhour = spf.getString("instagramhour", "00");
		if (instagramhour.isEmpty()) {
			save("instagramhour", "00");
		} else {
			instagram1.setText(instagramhour);
		}

		kiksec = spf.getString("kiksec", "00");
		if (kiksec.isEmpty()) {
			save("kiksec", "00");
		} else {
			kik3.setText(kiksec);
		}

		kikhour = spf.getString("kikhour", "00");
		if (kikhour.isEmpty()) {
			save("kikhour", "00");
		} else {
			kik1.setText(kikhour);
		}

		bbmsec = spf.getString("bbmsec", "00");
		if (bbmsec.isEmpty()) {
			save("bbmsec", "00");
		} else {
			bbm3.setText(bbmsec);
		}

		kikmin = spf.getString("kikmin", "00");
		if (kikmin.isEmpty()) {
			save("kikmin", "00");
		} else {
			kik2.setText(kikmin);
		}

		bbmmin = spf.getString("bbmmin", "00");
		if (bbmmin.isEmpty()) {
			save("bbmmin", "00");
		} else {
			bbm2.setText(bbmmin);
		}

		bbmhour = spf.getString("bbmhour", "00");
		if (bbmhour.isEmpty()) {
			save("bbmhour", "00");
		} else {
			bbm1.setText(bbmhour);
		}

		asksec = spf.getString("asksec", "00");
		if (asksec.isEmpty()) {
			save("asksec", "00");
		} else {
			ask3.setText(asksec);
		}

		askmin = spf.getString("askmin", "00");
		if (askmin.isEmpty()) {
			save("askmin", "00");
		} else {
			ask2.setText(askmin);
		}

		askhour = spf.getString("askhour", "00");
		if (askhour.isEmpty()) {
			save("askhour", "00");
		} else {
			ask1.setText(askhour);
		}

		kikmmin = spf.getString("kimmin", "00");
		if (kikmmin.isEmpty()) {
			save("kimmin", "00");
		} else {
			kikm2.setText(kikmmin);
		}

		kikmsec = spf.getString("kikmsec", "00");
		if (kikmsec.isEmpty()) {
			save("kikmsec", "00");
		} else {
			kikm3.setText(kikmsec);
		}

		kikmhour = spf.getString("kikmhour", "00");
		if (kikmhour.isEmpty()) {
			save("kikmhour", "00");
		} else {
			kikm1.setText(kikmhour);
		}

		snapmin = spf.getString("snapmin", "00");
		if (snapmin.isEmpty()) {
			save("snapmin", "00");
		} else {
			snap2.setText(snapmin);
		}

		snapsec = spf.getString("snapsec", "00");
		if (snapsec.isEmpty()) {
			save("snapsec", "00");
		} else {
			snap3.setText(snapsec);
		}

		snaphour = spf.getString("snaphour", "00");
		if (snaphour.isEmpty()) {
			save("snaphour", "00");
		} else {
			snap1.setText(snaphour);
		}
		// ///////////////////////////////////////////////
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
			startActivity(new Intent(MainActivity.this, Setting.class));

		}

		if (item.getItemId() == R.id.sharet) {
			Intent sharingIntent = new Intent(Intent.ACTION_SEND);
			sharingIntent.setType("text/plain");
			String shareBody = "#Socials_Addict\n"
					+ "I used Social networks for : "
					+ totalhour.getText().toString()
					+ "\n\nGet socials addict here : https://play.google.com/store/apps/details?id=pidevs.socialsaddict";

			sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
			startActivity(Intent.createChooser(sharingIntent, "Share using"));

		}

		if (item.getItemId() == R.id.sharea) {

			Intent sharingIntent = new Intent(Intent.ACTION_SEND);
			sharingIntent.setType("text/plain");
			String shareBody = "#Socials_Addict\n"
					+ "My Average Rate of using social networks is : "
					+ usage.getText().toString()
					+ "\nMy Addiction State is : "
					+ state.getText().toString()
					+ "\n\nGet socials addict here : https://play.google.com/store/apps/details?id=pidevs.socialsaddict";

			sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
			startActivity(Intent.createChooser(sharingIntent, "Share using"));

		}

		return super.onOptionsItemSelected(item);

	}

	// Check if the service is running to set the checkbox state
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