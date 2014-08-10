package technologysociety.socialsaddict;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class Setting extends ActionBarActivity {

	static CheckBox facebookbox, whatsappbox, instagrambox, twitterbox, askbox,
			bbmbox, kikbox, tumblrbox;
	Button about, clear, pi, shareapp , website;
	String fbcheck, whatsappcheck, tumblrcheck, instacheck, twcheck, askcheck,
			bbmcheck, kikcheck, dailycheck;

	static SharedPreferences spfs;

	public void save(String key, String value) {
		ServiceSocial.spf = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit = ServiceSocial.spf.edit();
		edit.putString(key, value);
		edit.commit();

	}

	public void loadfbcheck() {

		spfs = PreferenceManager.getDefaultSharedPreferences(this);
		fbcheck = spfs.getString("facebook", "");

		if (fbcheck.isEmpty()) {

		} else {
			if (fbcheck.equals("true")) {
				facebookbox.setChecked(true);
			} else {
				facebookbox.setChecked(false);
			}
		}
	}

	public void loadkikcheck() {

		spfs = PreferenceManager.getDefaultSharedPreferences(this);
		kikcheck = spfs.getString("kik", "");

		if (kikcheck.isEmpty()) {

		} else {
			if (kikcheck.equals("true")) {
				kikbox.setChecked(true);
			} else {
				kikbox.setChecked(false);
			}
		}
	}

	public void loadbbmcheck() {

		spfs = PreferenceManager.getDefaultSharedPreferences(this);
		bbmcheck = spfs.getString("bbm", "");

		if (bbmcheck.isEmpty()) {

		} else {
			if (bbmcheck.equals("true")) {
				bbmbox.setChecked(true);
			} else {
				bbmbox.setChecked(false);
			}
		}
	}

	public void loadaskcheck() {

		spfs = PreferenceManager.getDefaultSharedPreferences(this);
		askcheck = spfs.getString("ask", "");

		if (askcheck.isEmpty()) {

		} else {
			if (askcheck.equals("true")) {
				askbox.setChecked(true);
			} else {
				askbox.setChecked(false);
			}
		}
	}

	public void loadtwitter() {

		spfs = PreferenceManager.getDefaultSharedPreferences(this);
		twcheck = spfs.getString("twitter", "");

		if (twcheck.isEmpty()) {

		} else {
			if (twcheck.equals("true")) {
				twitterbox.setChecked(true);
			} else {
				twitterbox.setChecked(false);
			}
		}
	}

	public void loadinstagram() {

		spfs = PreferenceManager.getDefaultSharedPreferences(this);
		instacheck = spfs.getString("instagram", "");

		if (instacheck.isEmpty()) {

		} else {
			if (instacheck.equals("true")) {
				instagrambox.setChecked(true);
			} else {
				instagrambox.setChecked(false);
			}
		}
	}

	public void loadtumblr() {

		spfs = PreferenceManager.getDefaultSharedPreferences(this);
		tumblrcheck = spfs.getString("tumblr", "");

		if (tumblrcheck.isEmpty()) {

		} else {
			if (tumblrcheck.equals("true")) {
				tumblrbox.setChecked(true);
			} else {
				tumblrbox.setChecked(false);
			}
		}
	}

	public void loadwhatsapp() {

		spfs = PreferenceManager.getDefaultSharedPreferences(this);
		whatsappcheck = spfs.getString("whatsapp", "");

		if (whatsappcheck.isEmpty()) {

		} else {
			if (whatsappcheck.equals("true")) {
				whatsappbox.setChecked(true);
			} else {
				whatsappbox.setChecked(false);
			}
		}
	}

	// End Save Preferences

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);

		about = (Button) findViewById(R.id.aboutapp);

		clear = (Button) findViewById(R.id.clear);

		pi = (Button) findViewById(R.id.pi);

		shareapp = (Button) findViewById(R.id.shareapp);

		website = (Button) findViewById(R.id.web);

		facebookbox = (CheckBox) findViewById(R.id.facebookbox);
		whatsappbox = (CheckBox) findViewById(R.id.whatsappbox);
		instagrambox = (CheckBox) findViewById(R.id.instagrambox);
		twitterbox = (CheckBox) findViewById(R.id.twitterbox);
		tumblrbox = (CheckBox) findViewById(R.id.tumblrbox);
		askbox = (CheckBox) findViewById(R.id.askbox);
		bbmbox = (CheckBox) findViewById(R.id.bbmbox);
		kikbox = (CheckBox) findViewById(R.id.kikbox);

		loadkikcheck();
		loadbbmcheck();
		loadaskcheck();

		loadfbcheck();
		loadtumblr();
		loadinstagram();
		loadtwitter();
		loadwhatsapp();

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		facebookbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

				if (arg1 == true) {
					save("facebook", "true");

				} else {
					save("facebook", "false");

				}

			}
		});
		
		
		website.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				String url = "http://pi-developers.tk";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});

		askbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

				if (arg1 == true) {
					save("ask", "true");

				} else {
					save("ask", "false");

				}

			}
		});

		bbmbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

				if (arg1 == true) {
					save("bbm", "true");

				} else {
					save("bbm", "false");

				}

			}
		});

		kikbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

				if (arg1 == true) {
					save("kik", "true");

				} else {
					save("kik", "false");

				}

			}
		});

		twitterbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

				if (arg1 == true) {
					save("twitter", "true");

				} else {
					save("twitter", "false");

				}

			}
		});

		instagrambox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

				if (arg1 == true) {
					save("instagram", "true");

				} else {
					save("instagram", "false");

				}

			}
		});

		tumblrbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

				if (arg1 == true) {
					save("tumblr", "true");

				} else {
					save("tumblr", "false");

				}

			}
		});

		whatsappbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

				if (arg1 == true) {
					save("whatsapp", "true");

				} else {
					save("whatsapp", "false");

				}

			}
		});

		about.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				new AlertDialog.Builder(Setting.this)
						.setTitle("About")
						.setMessage(R.string.about)
						.setPositiveButton(android.R.string.yes,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int which) {
									}
								})

						.setIcon(R.drawable.icon).show();
			}
		});

		pi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				new AlertDialog.Builder(Setting.this)
						.setTitle("About Pi")
						.setMessage(R.string.pi)
						.setPositiveButton(android.R.string.yes,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int which) {
									}
								})

						.setIcon(R.drawable.icon).show();
			}
		});

		shareapp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent share = new Intent(Intent.ACTION_SEND);

				share.setType("text/plain");
				share.putExtra(
						Intent.EXTRA_TEXT,
						"I love 'Socials Addict' you should download now \nhttp://goo.gl/Gp3eHv \n#Socials_Addict");

				startActivity(Intent.createChooser(share, "Share app!"));

			}
		});

		

		clear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				new AlertDialog.Builder(Setting.this)
						.setTitle("Clear")
						.setMessage(
								"Are you sure you want to reset all numbers ?")
						.setPositiveButton(android.R.string.yes,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int which) {

										MainActivity.facebook1.setText("00");
										MainActivity.facebook2.setText("00");
										MainActivity.facebook3.setText("00");
										save("facebooksec", "");
										save("facebookmin", "");
										save("facebookhour", "");

										MainActivity.twitter1.setText("00");
										MainActivity.twitter2.setText("00");
										MainActivity.twitter3.setText("00");
										save("twittersec", "");
										save("twittermin", "");
										save("twitterhour", "");

										MainActivity.whatsapp1.setText("00");
										MainActivity.whatsapp2.setText("00");
										MainActivity.whatsapp3.setText("00");
										save("whatsappsec", "");
										save("whatsappmin", "");
										save("whatsapphour", "");

										MainActivity.tumblr1.setText("00");
										MainActivity.tumblr2.setText("00");
										MainActivity.tumblr3.setText("00");
										save("tumblrsec", "");
										save("tumblrmin", "");
										save("tumblrhour", "");

										MainActivity.instagram1.setText("00");
										MainActivity.instagram2.setText("00");
										MainActivity.instagram3.setText("00");
										save("instagramsec", "");
										save("instagrammin", "");
										save("instagramhour", "");

										MainActivity.ask1.setText("00");
										MainActivity.ask2.setText("00");
										MainActivity.ask3.setText("00");
										save("asksec", "");
										save("askmin", "");
										save("askhour", "");

										MainActivity.bbm1.setText("00");
										MainActivity.bbm2.setText("00");
										MainActivity.bbm3.setText("00");
										save("bbmsec", "");
										save("bbmmin", "");
										save("bbmhour", "");

										MainActivity.kik1.setText("00");
										MainActivity.kik2.setText("00");
										MainActivity.kik3.setText("00");
										save("kiksec", "");
										save("kikmin", "");
										save("kikhour", "");

										MainActivity.service1.setText("00");
										MainActivity.service3.setText("00");
										MainActivity.service2.setText("00");
										save("servicesec", "");
										save("servicemin", "");
										save("servicehour", "");

										finish();
									}
								})
						.setNegativeButton(android.R.string.no,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int which) {
										// do nothing
									}
								}).setIcon(android.R.drawable.ic_dialog_alert)
						.show();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.setting, menu);
		return true;
	}

	public boolean onOptionsItemSelected(Menu menu) {
		onBackPressed();
		return true;
	}
}