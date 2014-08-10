package technologysociety.socialsaddict;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.preference.PreferenceManager;

public class ServiceSocial extends Service {

	static String packageName;
	private Handler mainhandler;
	private Handler customHandlerfacebook = new Handler();
	private Handler customHandlertwitter = new Handler();
	private Handler customHandlerinstagram = new Handler();
	private Handler customHandlertumblr = new Handler();
	private Handler customHandlerwhatsapp = new Handler();
	private Handler customHandlerbbm = new Handler();
	private Handler customHandlerkik = new Handler();
	private Handler customHandlerask = new Handler();

	Boolean facebook, twitter, tumblr, whatsapp, instagram, kik, bbm, ask;
	public static int facebooktemp1, facebooktemp2, facebooktemp3,
			twittertemp1, twittertemp2, twittertemp3, instagramtemp1,
			instagramtemp2, instagramtemp3, whatsapptemp1, whatsapptemp2,
			whatsapptemp3, tumblrtemp1, tumblrtemp2, tumblrtemp3, kiktemp1,
			kiktemp2, kiktemp3, asktemp1, asktemp3, asktemp2, bbmtemp1,
			bbmtemp2, bbmtemp3, servicetemp1, servicetemp2, servicetemp3;

	float totalsec, totalmin, totalhour, totalall;

	static SharedPreferences spf;

	int f, t, tu, w, i, k, b, a, total;

	double addict;

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	// On Creating Service
	@Override
	public void onCreate() {

		showNotification();

	}

	@SuppressLint("InlinedApi")
	@SuppressWarnings("deprecation")
	private void showNotification() {

		Notification notification = new Notification(R.drawable.icon, "Tracking in progress", System.currentTimeMillis());

		Intent main = new Intent(this, MainActivity.class);
		main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_SINGLE_TOP
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, main, PendingIntent.FLAG_UPDATE_CURRENT);

		notification.setLatestEventInfo(this, "Socials Addict",
				"Tracking In Progress", pendingIntent);
		notification.flags |= Notification.FLAG_ONGOING_EVENT
				| Notification.FLAG_FOREGROUND_SERVICE
				| Notification.FLAG_NO_CLEAR;

		startForeground(2, notification);

	}

	// End Of On Creating Service

	// Save Preferences
	public void save(String key, String value) {
		spf = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit = spf.edit();
		edit.putString(key, value);
		edit.commit();

	}

	public void saveint(String key, int integer) {
		spf = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit = spf.edit();
		edit.putInt(key, integer);
		edit.commit();

	}

	// End Save Preferences

	// On Start Service
	@SuppressLint("HandlerLeak")
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		super.onStartCommand(intent, flags, startId);
		
		
		

		mainhandler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);

				servicetemp1 = Integer.parseInt(MainActivity.service1.getText()
						.toString());
				servicetemp2 = Integer.parseInt(MainActivity.service2.getText()
						.toString());
				servicetemp3 = Integer.parseInt(MainActivity.service3.getText()
						.toString());

				totalsec = (Integer.parseInt(MainActivity.facebook3.getText()
						.toString())
						+ Integer.parseInt(MainActivity.twitter3.getText()
								.toString())
						+ Integer.parseInt(MainActivity.whatsapp3.getText()
								.toString())
						+ Integer.parseInt(MainActivity.instagram3.getText()
								.toString())
						+ Integer.parseInt(MainActivity.tumblr3.getText()
								.toString())
						+ Integer.parseInt(MainActivity.kik3.getText()
								.toString())
						+ Integer.parseInt(MainActivity.bbm3.getText()
								.toString()) + Integer
						.parseInt(MainActivity.ask3.getText().toString()));
				totalmin = (Integer.parseInt(MainActivity.facebook2.getText()
						.toString())
						+ Integer.parseInt(MainActivity.twitter2.getText()
								.toString())
						+ Integer.parseInt(MainActivity.whatsapp2.getText()
								.toString())
						+ Integer.parseInt(MainActivity.instagram2.getText()
								.toString())
						+ Integer.parseInt(MainActivity.tumblr2.getText()
								.toString())
						+ Integer.parseInt(MainActivity.kik2.getText()
								.toString())
						+ Integer.parseInt(MainActivity.bbm2.getText()
								.toString()) + Integer
							.parseInt(MainActivity.ask2.getText().toString()))
						+ (totalsec / 60);
				totalhour = (Integer.parseInt(MainActivity.facebook1.getText()
						.toString())
						+ Integer.parseInt(MainActivity.twitter1.getText()
								.toString())
						+ Integer.parseInt(MainActivity.whatsapp1.getText()
								.toString())
						+ Integer.parseInt(MainActivity.instagram1.getText()
								.toString())
						+ Integer.parseInt(MainActivity.tumblr1.getText()
								.toString())
						+ Integer.parseInt(MainActivity.kik1.getText()
								.toString())
						+ Integer.parseInt(MainActivity.bbm1.getText()
								.toString()) + Integer
							.parseInt(MainActivity.ask1.getText().toString()))
						+ (totalmin / 60);
				total = (int) ((Integer.parseInt(MainActivity.facebook1
						.getText().toString())
						+ Integer.parseInt(MainActivity.twitter1.getText()
								.toString())
						+ Integer.parseInt(MainActivity.whatsapp1.getText()
								.toString())
						+ Integer.parseInt(MainActivity.instagram1.getText()
								.toString())
						+ Integer.parseInt(MainActivity.tumblr1.getText()
								.toString())
						+ Integer.parseInt(MainActivity.kik1.getText()
								.toString())
						+ Integer.parseInt(MainActivity.bbm1.getText()
								.toString()) + Integer
						.parseInt(MainActivity.ask1.getText().toString())) + (totalmin / 60));

				MainActivity.totalhour.setText(total + "");

				
				servicetemp3++;

				if (servicetemp3 >= 60) {
					servicetemp3 = 00;
					servicetemp2 += 1;

				}
				if (servicetemp2 >= 60) {
					servicetemp2 = 00;
					servicetemp1 += 1;

				}

				MainActivity.service3.setText(String.valueOf(servicetemp3));
				MainActivity.service2.setText(String.valueOf(servicetemp2));
				MainActivity.service1.setText(String.valueOf(servicetemp1));

				save("servicesec", MainActivity.service3.getText().toString());
				save("servicemin", MainActivity.service2.getText().toString());
				save("servicehour", MainActivity.service1.getText().toString());

				totalall = (Float.parseFloat(MainActivity.service1.getText()
						.toString()))
						+ (Float.parseFloat(MainActivity.service2.getText()
								.toString()) / 60)
						+ (Float.parseFloat(MainActivity.service3.getText()
								.toString()) / 120);

				addict = (totalhour / totalall);

				if (totalhour > 1) {
					
					if (addict < 0.1) {
						MainActivity.state.setText("Low");
						MainActivity.state.setTextColor(Color
								.parseColor("#32CD32"));
			
						
						Not1();
					} else {

						if (addict < 0.2 && addict > 0.1) {
							MainActivity.state.setText("Average");
							MainActivity.state.setTextColor(Color
									.parseColor("#32CD32"));
					Not2();

						} else {

							if (addict < 0.3 && addict > 0.2) {
								MainActivity.state.setText("ATTENTION");
								MainActivity.state.setTextColor(Color
										.parseColor("#FFFF00"));
								
								Not3();
							} else {

								if (addict < 0.4 && addict > 0.3) {
									MainActivity.state.setText("Addcited");
									MainActivity.state.setTextColor(Color
											.parseColor("#FF9933"));
									
									
									Not4();
											
								} else {

									if (addict > 0.5) {
										MainActivity.state
												.setText("Danger rate");
										MainActivity.state.setTextColor(Color
												.parseColor("#CC0000"));
										
										Not5();

									}
								}
							}
						}
					}
				} else {
					MainActivity.state.setText("Low");
					MainActivity.state
							.setTextColor(Color.parseColor("#32CD32"));

				}

				ActivityManager am = (ActivityManager) getApplicationContext()
						.getSystemService(Activity.ACTIVITY_SERVICE);
				packageName = am.getRunningTasks(1).get(0).topActivity
						.getPackageName();

				if (MainActivity.start.isChecked()) {

					if (Setting.facebookbox.isChecked()) {
						if (packageName.equals("com.facebook.katana")
								|| packageName.equals("com.facebook.orca")) {

							if (f == 1) {

							} else {

								f = 1;
								facebook = true;

								customHandlerfacebook.postDelayed(
										updateTimerThreadfacebook, 0);
							}
						} else {
							if (f == 1) {

								facebook = false;

								customHandlerfacebook
										.removeCallbacks(updateTimerThreadfacebook);
								f = 2;
							}
						}
					}

					if (Setting.twitterbox.isChecked()) {
						if (packageName.equals("com.twitter.android")) {

							if (t == 1) {

							} else {

								t = 1;
								twitter = true;
								customHandlertwitter.postDelayed(
										updateTimerThreadtwitter, 0);
							}
						} else {
							if (t == 1) {

								twitter = false;

								customHandlertwitter
										.removeCallbacks(updateTimerThreadtwitter);
								t = 2;
							}
						}
					}

					// ////////////////

					if (Setting.bbmbox.isChecked()) {
						if (packageName.equals("com.bbm")) {

							if (b == 1) {

							} else {

								b = 1;
								bbm = true;
								customHandlerbbm.postDelayed(
										updateTimerThreadbbm, 0);
							}
						} else {
							if (b == 1) {

								bbm = false;

								customHandlerbbm
										.removeCallbacks(updateTimerThreadbbm);
								b = 2;
							}
						}
					}

					if (Setting.askbox.isChecked()) {
						if (packageName.equals("com.askfm")) {

							if (a == 1) {

							} else {

								a = 1;
								ask = true;
								customHandlerask.postDelayed(
										updateTimerThreadask, 0);
							}
						} else {
							if (a == 1) {

								ask = false;

								customHandlerask
										.removeCallbacks(updateTimerThreadask);
								a = 2;
							}
						}
					}

					if (Setting.kikbox.isChecked()) {
						if (packageName.equals("kik.android")) {

							if (k == 1) {

							} else {

								k = 1;
								kik = true;
								customHandlerkik.postDelayed(
										updateTimerThreadkik, 0);
							}
						} else {
							if (k == 1) {

								kik = false;

								customHandlerkik
										.removeCallbacks(updateTimerThreadkik);
								k = 2;
							}
						}
					}

					// //////

					if (Setting.whatsappbox.isChecked()) {

						if (packageName.equals("com.whatsapp")) {

							if (w == 1) {

							} else {

								w = 1;
								whatsapp = true;

								customHandlerwhatsapp.postDelayed(
										updateTimerThreadwhatsapp, 0);
							}
						} else {
							if (w == 1) {

								whatsapp = false;

								customHandlerwhatsapp
										.removeCallbacks(updateTimerThreadwhatsapp);
								w = 2;
							}
						}
					}

					if (Setting.tumblrbox.isChecked()) {
						if (packageName.equals("com.tumblr")) {

							if (tu == 1) {

							} else {

								tu = 1;
								tumblr = true;
								customHandlertumblr.postDelayed(
										updateTimerThreadtumblr, 0);
							}
						} else {
							if (tu == 1) {

								tumblr = false;

								customHandlertumblr
										.removeCallbacks(updateTimerThreadtumblr);
								tu = 2;
							}
						}
					}

					if (Setting.instagrambox.isChecked()) {
						if (packageName.equals("com.instagram.android")) {

							if (i == 1) {

							} else {

								i = 1;
								instagram = true;
								customHandlerinstagram.postDelayed(
										updateTimerThreadinstagram, 0);
							}
						} else {
							if (i == 1) {

								instagram = false;

								customHandlerinstagram
										.removeCallbacks(updateTimerThreadinstagram);
								i = 2;
							}
						}
					}

				}

			}

		};

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {

						Thread.sleep(1000);
						mainhandler.sendEmptyMessage(0);


					} catch (InterruptedException e) {

						e.printStackTrace();
					}

				}

			}
		}).start();
		return START_STICKY;
	}

	// On End Start Service

	// Timer Facebook

	private Runnable updateTimerThreadfacebook = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (facebook = true) {

				facebooktemp1 = Integer.parseInt(MainActivity.facebook1
						.getText().toString());

				facebooktemp2 = Integer.parseInt(MainActivity.facebook2
						.getText().toString());

				facebooktemp3 = Integer.parseInt(MainActivity.facebook3
						.getText().toString());

				facebooktemp3++;

				if (facebooktemp3 >= 60) {
					facebooktemp3 = 0;
					facebooktemp2 += 1;

				}
				if (facebooktemp2 >= 60) {
					facebooktemp2 = 0;
					facebooktemp1 += 1;
				}

				MainActivity.facebook1.setText(String.valueOf(facebooktemp1));
				MainActivity.facebook2.setText(String.valueOf(facebooktemp2));
				MainActivity.facebook3.setText(String.valueOf(facebooktemp3));

				save("facebooksec", MainActivity.facebook3.getText().toString());
				save("facebookmin", MainActivity.facebook2.getText().toString());
				save("facebookhour", MainActivity.facebook1.getText()
						.toString());

				customHandlerfacebook.postDelayed(this, 0);

			}
		}

	};

	// End Timer Facebook

	// Timer Twitter

	private Runnable updateTimerThreadtwitter = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (twitter = true) {

				twittertemp1 = Integer.parseInt(MainActivity.twitter1.getText()
						.toString());
				twittertemp2 = Integer.parseInt(MainActivity.twitter2.getText()
						.toString());
				twittertemp3 = Integer.parseInt(MainActivity.twitter3.getText()
						.toString());

				twittertemp3++;

				if (twittertemp3 >= 60) {
					twittertemp3 = 0;
					twittertemp2 += 1;

				}

				if (twittertemp2 >= 60) {
					twittertemp2 = 0;
					twittertemp1 += 1;

				}

				MainActivity.twitter1.setText(String.valueOf(twittertemp1));
				MainActivity.twitter2.setText(String.valueOf(twittertemp2));
				MainActivity.twitter3.setText(String.valueOf(twittertemp3));

				save("twittersec", MainActivity.twitter3.getText().toString());
				save("twittermin", MainActivity.twitter2.getText().toString());
				save("twitterhour", MainActivity.twitter1.getText().toString());

				customHandlertwitter.postDelayed(this, 0);

			}
		}

	};

	// End Timer Twitter

	// Timer Whatsapp

	private Runnable updateTimerThreadwhatsapp = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (whatsapp = true) {

				whatsapptemp1 = Integer.parseInt(MainActivity.whatsapp1
						.getText().toString());
				whatsapptemp2 = Integer.parseInt(MainActivity.whatsapp2
						.getText().toString());
				whatsapptemp3 = Integer.parseInt(MainActivity.whatsapp3
						.getText().toString());

				whatsapptemp3++;

				if (whatsapptemp3 >= 60) {
					whatsapptemp3 = 0;
					whatsapptemp2 += 1;

				}
				if (whatsapptemp2 >= 60) {
					whatsapptemp2 = 0;
					whatsapptemp1 += 1;

				}

				MainActivity.whatsapp1.setText(String.valueOf(whatsapptemp1));
				MainActivity.whatsapp2.setText(String.valueOf(whatsapptemp2));
				MainActivity.whatsapp3.setText(String.valueOf(whatsapptemp3));

				save("whatsappsec", MainActivity.whatsapp3.getText().toString());
				save("whatsappmin", MainActivity.whatsapp2.getText().toString());
				save("whatsapphour", MainActivity.whatsapp1.getText()
						.toString());

				customHandlerwhatsapp.postDelayed(this, 0);

			}
		}

	};

	// End Timer Whatsapp

	// Timer Tumblr

	private Runnable updateTimerThreadtumblr = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (tumblr = true) {

				tumblrtemp1 = Integer.parseInt(MainActivity.tumblr1.getText()
						.toString());
				tumblrtemp2 = Integer.parseInt(MainActivity.tumblr2.getText()
						.toString());
				tumblrtemp3 = Integer.parseInt(MainActivity.tumblr3.getText()
						.toString());

				tumblrtemp3++;

				if (tumblrtemp3 >= 60) {
					tumblrtemp3 = 0;
					tumblrtemp2 += 1;

				}
				if (tumblrtemp2 >= 60) {
					tumblrtemp2 = 0;
					tumblrtemp1 += 1;

				}

				MainActivity.tumblr1.setText(String.valueOf(tumblrtemp1));
				MainActivity.tumblr2.setText(String.valueOf(tumblrtemp2));
				MainActivity.tumblr3.setText(String.valueOf(tumblrtemp3));

				save("tumblrsec", MainActivity.tumblr3.getText().toString());
				save("tumblrmin", MainActivity.tumblr2.getText().toString());
				save("tumblrhour", MainActivity.tumblr1.getText().toString());

				customHandlertumblr.postDelayed(this, 0);

			}
		}

	};

	// End Timer Tumblr

	// Timer Instagram

	private Runnable updateTimerThreadinstagram = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (instagram = true) {

				instagramtemp1 = Integer.parseInt(MainActivity.instagram1
						.getText().toString());
				instagramtemp2 = Integer.parseInt(MainActivity.instagram2
						.getText().toString());
				instagramtemp3 = Integer.parseInt(MainActivity.instagram3
						.getText().toString());

				instagramtemp3++;

				if (instagramtemp3 >= 60) {
					instagramtemp3 = 0;
					instagramtemp2 += 1;

				}
				if (instagramtemp2 >= 60) {
					instagramtemp2 = 0;
					instagramtemp1 += 1;

				}

				MainActivity.instagram1.setText(String.valueOf(instagramtemp1));
				MainActivity.instagram2.setText(String.valueOf(instagramtemp2));
				MainActivity.instagram3.setText(String.valueOf(instagramtemp3));

				save("instagramsec", MainActivity.instagram3.getText()
						.toString());
				save("instagrammin", MainActivity.instagram2.getText()
						.toString());
				save("instagramhour", MainActivity.instagram1.getText()
						.toString());

				customHandlerinstagram.postDelayed(this, 0);

			}
		}

	};

	// End Timer Instagram

	private Runnable updateTimerThreadkik = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (kik = true) {

				kiktemp1 = Integer.parseInt(MainActivity.kik1.getText()
						.toString());
				kiktemp2 = Integer.parseInt(MainActivity.kik2.getText()
						.toString());
				kiktemp3 = Integer.parseInt(MainActivity.kik3.getText()
						.toString());

				kiktemp3++;

				if (kiktemp3 >= 60) {
					kiktemp3 = 0;
					kiktemp2 += 1;

				}
				if (kiktemp2 >= 60) {
					kiktemp2 = 0;
					kiktemp1 += 1;

				}

				MainActivity.kik1.setText(String.valueOf(kiktemp1));
				MainActivity.kik2.setText(String.valueOf(kiktemp2));
				MainActivity.kik3.setText(String.valueOf(kiktemp3));

				save("kiksec", MainActivity.kik3.getText().toString());
				save("kikmin", MainActivity.kik2.getText().toString());
				save("kikhour", MainActivity.kik1.getText().toString());

				customHandlerkik.postDelayed(this, 0);

			}
		}

	};

	// ////////

	private Runnable updateTimerThreadask = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (ask = true) {

				asktemp1 = Integer.parseInt(MainActivity.ask1.getText()
						.toString());
				asktemp2 = Integer.parseInt(MainActivity.ask2.getText()
						.toString());
				asktemp3 = Integer.parseInt(MainActivity.ask3.getText()
						.toString());

				asktemp3++;

				if (asktemp3 >= 60) {
					asktemp3 = 0;
					asktemp2 += 1;

				}
				if (asktemp2 >= 60) {
					asktemp2 = 0;
					asktemp1 += 1;

				}

				MainActivity.ask1.setText(String.valueOf(asktemp1));
				MainActivity.ask2.setText(String.valueOf(asktemp2));
				MainActivity.ask3.setText(String.valueOf(asktemp3));

				save("asksec", MainActivity.ask3.getText().toString());
				save("askmin", MainActivity.ask2.getText().toString());
				save("askhour", MainActivity.ask1.getText().toString());

				customHandlerask.postDelayed(this, 0);

			}
		}

	};

	// ////////////////

	private Runnable updateTimerThreadbbm = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (bbm = true) {

				bbmtemp1 = Integer.parseInt(MainActivity.bbm1.getText()
						.toString());
				bbmtemp2 = Integer.parseInt(MainActivity.bbm2.getText()
						.toString());
				bbmtemp3 = Integer.parseInt(MainActivity.bbm3.getText()
						.toString());

				bbmtemp3++;

				if (bbmtemp3 >= 60) {
					bbmtemp3 = 0;
					bbmtemp2 += 1;

				}
				if (bbmtemp2 >= 60) {
					bbmtemp2 = 0;
					bbmtemp1 += 1;

				}

				MainActivity.bbm1.setText(String.valueOf(bbmtemp1));
				MainActivity.bbm2.setText(String.valueOf(bbmtemp2));
				MainActivity.bbm3.setText(String.valueOf(bbmtemp3));

				save("bbmsec", MainActivity.bbm3.getText().toString());
				save("bbmmin", MainActivity.bbm2.getText().toString());
				save("bbmhour", MainActivity.bbm1.getText().toString());

				customHandlerbbm.postDelayed(this, 0);

			}
		}

	};


	
	
	
	@SuppressWarnings("deprecation")
	private void Not5() {
		Notification notification5 = new Notification(R.drawable.icon, "Warining ! you reached danger addiction rate..", System.currentTimeMillis());


		Intent main = new Intent(this, MainActivity.class);
		main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_SINGLE_TOP
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, main, PendingIntent.FLAG_UPDATE_CURRENT);

		notification5.setLatestEventInfo(this, "Socials Addict",
				"Addiction Level : Danger rate", pendingIntent);
		notification5.flags |= Notification.FLAG_FOREGROUND_SERVICE;		
		
	}

	@SuppressWarnings("deprecation")
	private void Not4() {
		Notification notification4 = new Notification(R.drawable.icon, "Hey ! you are Addicted to Social networking, go and get a life", System.currentTimeMillis());

		Intent main = new Intent(this, MainActivity.class);
		main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_SINGLE_TOP
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, main, PendingIntent.FLAG_UPDATE_CURRENT);

		notification4.setLatestEventInfo(this, "Socials Addict",
				"Addiction Level : Addicted", pendingIntent);
		notification4.flags |= Notification.FLAG_FOREGROUND_SERVICE;

		startForeground(23, notification4);				
	}

	@SuppressWarnings("deprecation")
	private void Not3() {
		Notification notification3 = new Notification(R.drawable.icon, "ATTENTION! you are close to addiction", System.currentTimeMillis());


		Intent main = new Intent(this, MainActivity.class);
		main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_SINGLE_TOP
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, main, PendingIntent.FLAG_UPDATE_CURRENT);

		notification3.setLatestEventInfo(this, "Socials Addict",
				"Addiction Level : ATTENTION!", pendingIntent);
		notification3.flags |= Notification.FLAG_FOREGROUND_SERVICE;

		startForeground(23, notification3);				
	}

	@SuppressWarnings("deprecation")
	private void Not2() {
		Notification notification2 = new Notification(R.drawable.icon, "Normal Socials usage, nothing to worry about.", System.currentTimeMillis());


		Intent main = new Intent(this, MainActivity.class);
		main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_SINGLE_TOP
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, main, PendingIntent.FLAG_UPDATE_CURRENT);

		notification2.setLatestEventInfo(this, "Socials Addict",
				"Addiction Level : Average", pendingIntent);
		notification2.flags |= Notification.FLAG_FOREGROUND_SERVICE;

		startForeground(23, notification2);				
	}

	@SuppressWarnings("deprecation")
	private void Not1() {
		Notification notification1 = new Notification(R.drawable.icon, "Low addiction, you are normal", System.currentTimeMillis());

		Intent main = new Intent(this, MainActivity.class);
		main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_SINGLE_TOP
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, main, PendingIntent.FLAG_UPDATE_CURRENT);

		notification1.setLatestEventInfo(this, "Socials Addict",
				"Addiction Level : Low", pendingIntent);
		notification1.flags |= Notification.FLAG_FOREGROUND_SERVICE;

		startForeground(23, notification1);				
	}
	



};



	
	
	
	

