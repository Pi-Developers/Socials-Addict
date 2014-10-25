package pidevs.socialsaddict;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class Setting extends ActionBarActivity {

	static CheckBox facebookbox, whatsappbox, instagrambox, twitterbox, askbox,
			bbmbox, kikbox, tumblrbox,boot;
	Button about, clear, pi, shareapp , website;
	String fbcheck, whatsappcheck, tumblrcheck, instacheck, twcheck, askcheck,
			bbmcheck, kikcheck,bootchk;

	static SharedPreferences spfs;

	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);

		about = (Button) findViewById(R.id.aboutapp);

		clear = (Button) findViewById(R.id.clear);

		pi = (Button) findViewById(R.id.pi);

		ColorDrawable cd = new ColorDrawable(getResources().getColor(android.R.color.transparent));
		cd.setBounds(0, 0, 0, 0);

		facebookbox = (CheckBox) findViewById(R.id.facebookbox);
		whatsappbox = (CheckBox) findViewById(R.id.whatsappbox);
		instagrambox = (CheckBox) findViewById(R.id.instagrambox);
		twitterbox = (CheckBox) findViewById(R.id.twitterbox);
		tumblrbox = (CheckBox) findViewById(R.id.tumblrbox);
		askbox = (CheckBox) findViewById(R.id.askbox);
		bbmbox = (CheckBox) findViewById(R.id.bbmbox);
		kikbox = (CheckBox) findViewById(R.id.kikbox);

		boot = (CheckBox) findViewById(R.id.checkBox1);
		spfs = PreferenceManager.getDefaultSharedPreferences(this);

		load();
		
		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		getSupportActionBar().setIcon(cd);

		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setBackgroundDrawable(new ColorDrawable(0xff01579b));
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(Html.fromHtml("<font color='#ffffff'> <b> Settings  </b> </font>"));

		
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


		

		clear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				new AlertDialog.Builder(Setting.this)
						.setTitle("Clear")
						.setMessage("Are you sure you want to reset all timers ?")
						.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int which) {


										save("facebooksec", "0");
										save("facebookmin", "0");
										save("facebookhour", "0");

	
										save("twittersec", "0");
										save("twittermin", "0");
										save("twitterhour", "0");


										save("whatsappsec", "0");
										save("whatsappmin", "0");
										save("whatsapphour", "0");

										save("tumblrsec", "0");
										save("tumblrmin", "0");
										save("tumblrhour", "0");


										save("instagramsec", "0");
										save("instagrammin", "0");
										save("instagramhour", "0");

								
										save("asksec", "0");
										save("askmin", "0");
										save("askhour", "0");

										save("bbmsec", "0");
										save("bbmmin", "0");
										save("bbmhour", "0");


										save("kiksec", "0");
										save("kikmin", "0");
										save("kikhour", "0");

										save("servicesec", "0");
										save("servicemin", "0");
										save("servicehour", "0");

										Toast.makeText(getApplicationContext(), "Results cleared successfully !", Toast.LENGTH_SHORT).show(); 
										
									
									}})
									
						.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {public void onClick(DialogInterface dialog, int which) {}}).setIcon(R.drawable.icon).show();
			}
		});

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void save(String key, String value) {
		spfs = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit = spfs.edit();
		edit.putString(key, value);
		edit.commit();

	}
	
	

	public void load() {

		
		bootchk =  spfs.getString("boot" , "true");
		
		if (bootchk.isEmpty()) {

		} else {
			if (bootchk.equals("true")) {
				boot.setChecked(true);
			} else {
				boot.setChecked(false);
			}
		}	
		

		
		
		
		
		fbcheck = spfs.getString("facebook", "true");

		if (fbcheck.isEmpty()) {

		} else {
			if (fbcheck.equals("true")) {
				facebookbox.setChecked(true);
			} else {
				facebookbox.setChecked(false);
			}
		}
		

		kikcheck = spfs.getString("kik", "true");

		if (kikcheck.isEmpty()) {

		} else {
			if (kikcheck.equals("true")) {
				kikbox.setChecked(true);
			} else {
				kikbox.setChecked(false);
			}
		}
		
		
		bbmcheck = spfs.getString("bbm", "true");

		if (bbmcheck.isEmpty()) {

		} else {
			if (bbmcheck.equals("true")) {
				bbmbox.setChecked(true);
			} else {
				bbmbox.setChecked(false);
			}
		}
		
		askcheck = spfs.getString("ask", "true");

		if (askcheck.isEmpty()) {

		} else {
			if (askcheck.equals("true")) {
				askbox.setChecked(true);
			} else {
				askbox.setChecked(false);
			}
		}
		
		
		twcheck = spfs.getString("twitter", "true");

		if (twcheck.isEmpty()) {

		} else {
			if (twcheck.equals("true")) {
				twitterbox.setChecked(true);
			} else {
				twitterbox.setChecked(false);
			}
		}
		
		instacheck = spfs.getString("instagram", "true");

		if (instacheck.isEmpty()) {

		} else {
			if (instacheck.equals("true")) {
				instagrambox.setChecked(true);
			} else {
				instagrambox.setChecked(false);
			}
		}
		
		tumblrcheck = spfs.getString("tumblr", "true");

		if (tumblrcheck.isEmpty()) {

		} else {
			if (tumblrcheck.equals("true")) {
				tumblrbox.setChecked(true);
			} else {
				tumblrbox.setChecked(false);
			}
		}
		
		
		whatsappcheck = spfs.getString("whatsapp", "true");

		if (whatsappcheck.isEmpty()) {

		} else {
			if (whatsappcheck.equals("true")) {
				whatsappbox.setChecked(true);
			} else {
				whatsappbox.setChecked(false);
			}
		}

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