package pidevs.socialsaddict;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.widget.Toast;

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
	float totalsec, totalmin, totalhour, totalall;
	 SharedPreferences spf;
	int f, t, tu, w, i, k, b, a, total;
	double addict;
	public static int facebooktemp1, facebooktemp2, facebooktemp3,
			twittertemp1, twittertemp2, twittertemp3, instagramtemp1,
			instagramtemp2, instagramtemp3, whatsapptemp1, whatsapptemp2,
			whatsapptemp3, tumblrtemp1, tumblrtemp2, tumblrtemp3, kiktemp1,
			kiktemp2, kiktemp3, asktemp1, asktemp3, asktemp2, bbmtemp1,
			bbmtemp2, bbmtemp3, servicetemp1, servicetemp2, servicetemp3;

	String fbcheck, whatsappcheck, tumblrcheck, instacheck, twcheck, askcheck,
			bbmcheck, kikcheck, starti, fb1, fb2, fb3, whats1, whats2, whats3,
			twittr1, twittr2, twittr3, kiki1, kiki2, kiki3, tmblr1, tmblr2,
			tmblr3, ask1, ask2, ask3, bbm1, bbm2, bbm3, insta1, insta2, insta3;

	;

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	public void load() {


		fbcheck = spf.getString("facebook", "true");
		kikcheck = spf.getString("kik", "true");
		bbmcheck = spf.getString("bbm", "true");
		askcheck = spf.getString("ask", "true");
		twcheck = spf.getString("twitter", "true");
		instacheck = spf.getString("instagram", "true");
		tumblrcheck = spf.getString("tumblr", "true");
		whatsappcheck = spf.getString("whatsapp", "true");
		starti = spf.getString("start", "false");

		fb1 = spf.getString("facebooksec", "0");
		fb2 = spf.getString("facebookmin", "0");
		fb3 = spf.getString("facebookhour", "0");

		twittr1 = spf.getString("twittersec", "0");
		twittr2 = spf.getString("twittermin", "0");
		twittr3 = spf.getString("twitterhour", "0");

		ask1 = spf.getString("asksec", "0");
		ask2 = spf.getString("askmin", "0");
		ask3 = spf.getString("askhour", "0");

		insta1 = spf.getString("instagramsec", "0");
		insta2 = spf.getString("instagrammin", "0");
		insta3 = spf.getString("instagramhour", "0");

		tmblr1 = spf.getString("tumblrsec", "0");
		tmblr2 = spf.getString("tumblrmin", "0");
		tmblr3 = spf.getString("tumblrhour", "0");

		bbm1 = spf.getString("bbmsec", "0");
		bbm2 = spf.getString("bbmmin", "0");
		bbm3 = spf.getString("bbmhour", "0");

		whats1 = spf.getString("whatsappsec", "0");
		whats2 = spf.getString("whatsappmin", "0");
		whats3 = spf.getString("whatsapphour", "0");

		kiki1 = spf.getString("kiksec", "0");
		kiki2 = spf.getString("kikmin", "0");
		kiki3 = spf.getString("kikhour", "0");

		facebooktemp1 = Integer.parseInt(fb3);
		facebooktemp2 = Integer.parseInt(fb2);
		facebooktemp3 = Integer.parseInt(fb1);
		twittertemp1 = Integer.parseInt(twittr3);
		twittertemp2 = Integer.parseInt(twittr2);
		twittertemp3 = Integer.parseInt(twittr1);
		whatsapptemp1 = Integer.parseInt(whats3);
		whatsapptemp2 = Integer.parseInt(whats2);
		whatsapptemp3 = Integer.parseInt(whats1);
		tumblrtemp1 = Integer.parseInt(tmblr3);
		tumblrtemp2 = Integer.parseInt(tmblr2);
		tumblrtemp3 = Integer.parseInt(tmblr1);
		instagramtemp1 = Integer.parseInt(insta3);
		instagramtemp2 = Integer.parseInt(insta2);
		instagramtemp3 = Integer.parseInt(insta1);
		bbmtemp1 = Integer.parseInt(bbm3);
		bbmtemp2 = Integer.parseInt(bbm2);
		bbmtemp3 = Integer.parseInt(bbm1);
		asktemp1 = Integer.parseInt(ask3);
		asktemp2 = Integer.parseInt(ask2);
		asktemp3 = Integer.parseInt(ask1);
		kiktemp1 = Integer.parseInt(kiki3);
		kiktemp2 = Integer.parseInt(kiki2);
		kiktemp3 = Integer.parseInt(kiki1);

	}

	// On Creating Service
	@Override
	public void onCreate() {

		showNotification();
		
		Toast.makeText(getApplicationContext(), "Socials Addict started", Toast.LENGTH_SHORT).show();

	}

	@SuppressLint("HandlerLeak")
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		spf = PreferenceManager.getDefaultSharedPreferences(this);

		super.onStartCommand(intent, flags, startId);

		try {

			load();

		} catch (NullPointerException nullPointerException) {

		}

		mainhandler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);

				try {

					total = (int) (facebooktemp1 + twittertemp1 + whatsapptemp1 + instagramtemp1 + tumblrtemp1 + kiktemp1 + bbmtemp1 + asktemp1);

					save("total", String.valueOf(total));

					servicetemp3++;

					if (servicetemp3 >= 60) {
						servicetemp3 = 00;
						servicetemp2 += 1;

					}
					if (servicetemp2 >= 60) {
						servicetemp2 = 00;
						servicetemp1 += 1;

					}

					save("servicesec", String.valueOf(servicetemp3));
					save("servicemin", String.valueOf(servicetemp2));
					save("servicehour", String.valueOf(servicetemp3));

					totalall = (float) (servicetemp3);

					addict = (total / totalall);
					
				} catch (NullPointerException nullPointerException) {

					
					
					
					
					
					
					
				}

				if (totalhour > 1) {

					if (addict < 0.1) {

						save("state", "low");

					} else {

						if (addict < 0.2 && addict > 0.1) {

							save("state", "average");

						} else {

							if (addict < 0.45 && addict > 0.3) {

								save("state", "attention");

								Not3();

							} else {

								if (addict < 0.55 && addict > 0.45) {

									save("state", "addicted");

									Not4();

								} else {

									if (addict > 0.7) {

										save("state", "danger");

										Not5();

									}
								}
							}
						}
					}
				} else {

					save("state", "low");

				}

				ActivityManager am = (ActivityManager) getApplicationContext()
						.getSystemService(Activity.ACTIVITY_SERVICE);
				packageName = am.getRunningTasks(1).get(0).topActivity
						.getPackageName();

				if (starti.equals("true")) {

					if (fbcheck.equals("true")) {
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

					if (twcheck.equals("true")) {
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

					if (bbmcheck.equals("true")) {

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

					if (askcheck.equals("true")) {
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

					if (kikcheck.equals("true")) {
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

					if (whatsappcheck.equalsIgnoreCase("true")) {

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

					if (tumblrcheck.equalsIgnoreCase("true")) {
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

					if (instacheck.equals("true")) {
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

	public void saveint(String key, int integer) {

		spf = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit = spf.edit();
		edit.putInt(key, integer);
		edit.commit();

	}

	@SuppressLint("InlinedApi")
	private void showNotification() {

		Intent deleteIntent = new Intent(this, close.class);
		PendingIntent pendingIntentCancel = PendingIntent.getBroadcast(this, 0,
				deleteIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		Intent settingIntent = new Intent(this, settinggg.class);
		PendingIntent pendingIntentCancel1 = PendingIntent.getBroadcast(this,
				0, settingIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		Intent reprt = new Intent(this, report.class);
		PendingIntent pendingIntentCancel2 = PendingIntent.getBroadcast(this,
				0, reprt, PendingIntent.FLAG_UPDATE_CURRENT);

		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this);
		mBuilder.setContentTitle("Socials Addict");
		mBuilder.setContentText("Monitroring Usage..");
		mBuilder.setTicker("Socials Addict");
		mBuilder.setSmallIcon(R.drawable.ic_launcher);
		mBuilder.addAction(0, "Stop service", pendingIntentCancel);
		mBuilder.addAction(0, "Setting", pendingIntentCancel1);
		mBuilder.addAction(0, "Report", pendingIntentCancel2);

		mBuilder.setOngoing(true);

		Intent resultIntent = new Intent(this, MainActivity.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(MainActivity.class);

		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
				PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(2, mBuilder.build());

	}

	public void onDestroy() {
		super.onDestroy();
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.cancelAll();
	}

	public void save(String key, String value) {
		Editor edit = spf.edit();
		edit.putString(key, value);
		edit.commit();

	}

	private Runnable updateTimerThreadfacebook = new Runnable() {

		public void run() {

			try {

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (facebook = true) {

				facebooktemp3++;

				if (facebooktemp3 >= 60) {
					facebooktemp3 = 0;
					facebooktemp2 += 1;

				}
				if (facebooktemp2 >= 60) {
					facebooktemp2 = 0;
					facebooktemp1 += 1;
				}

				Log.d("hey", String.valueOf(twittertemp3));

				save("facebooksec", String.valueOf(facebooktemp3));
				save("facebookmin", String.valueOf(facebooktemp2));
				save("facebookhour", String.valueOf(facebooktemp1));

				customHandlerfacebook.postDelayed(this, 0);

			}
		}

	};

	private Runnable updateTimerThreadtwitter = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (twitter = true) {

				twittertemp3++;

				if (twittertemp3 >= 60) {
					twittertemp3 = 0;
					twittertemp2 += 1;

				}

				if (twittertemp2 >= 60) {
					twittertemp2 = 0;
					twittertemp1 += 1;

				}

				Log.d("hey", String.valueOf(twittertemp3));

				save("twittersec", String.valueOf(twittertemp3));
				save("twittermin", String.valueOf(twittertemp2));
				save("twitterhour", String.valueOf(twittertemp1));

				customHandlertwitter.postDelayed(this, 0);

			}
		}

	};

	private Runnable updateTimerThreadwhatsapp = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (whatsapp = true) {

				whatsapptemp3++;
				Log.d("hey", String.valueOf(whatsapptemp3));

				if (whatsapptemp3 >= 60) {
					whatsapptemp3 = 0;
					whatsapptemp2 += 1;

				}
				if (whatsapptemp2 >= 60) {
					whatsapptemp2 = 0;
					whatsapptemp1 += 1;

				}

				Log.d("hey", String.valueOf(whatsapptemp3));

				save("whatsappsec", String.valueOf(whatsapptemp3));
				save("whatsappmin", String.valueOf(whatsapptemp2));
				save("whatsapphour", String.valueOf(whatsapptemp1));

				customHandlerwhatsapp.postDelayed(this, 0);

			}
		}

	};

	private Runnable updateTimerThreadtumblr = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (tumblr = true) {

				tumblrtemp3++;

				if (tumblrtemp3 >= 60) {
					tumblrtemp3 = 0;
					tumblrtemp2 += 1;

				}
				if (tumblrtemp2 >= 60) {
					tumblrtemp2 = 0;
					tumblrtemp1 += 1;

				}
				Log.d("hey", String.valueOf(twittertemp3));

				save("tumblrsec", String.valueOf(tumblrtemp3));
				save("tumblrmin", String.valueOf(tumblrtemp2));
				save("tumblrhour", String.valueOf(tumblrtemp1));

				customHandlertumblr.postDelayed(this, 0);

			}
		}

	};

	private Runnable updateTimerThreadinstagram = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (instagram = true) {

				instagramtemp3++;

				if (instagramtemp3 >= 60) {
					instagramtemp3 = 0;
					instagramtemp2 += 1;

				}
				if (instagramtemp2 >= 60) {
					instagramtemp2 = 0;
					instagramtemp1 += 1;

				}
				Log.d("hey", String.valueOf(twittertemp3));

				save("instagramsec", String.valueOf(instagramtemp3));
				save("instagrammin", String.valueOf(instagramtemp2));
				save("instagramhour", String.valueOf(instagramtemp1));

				customHandlerinstagram.postDelayed(this, 0);

			}
		}

	};

	private Runnable updateTimerThreadkik = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (kik = true) {

				kiktemp3++;

				if (kiktemp3 >= 60) {
					kiktemp3 = 0;
					kiktemp2 += 1;

				}

				if (kiktemp2 >= 60) {
					kiktemp2 = 0;
					kiktemp1 += 1;

				}

				Log.d("hey", String.valueOf(twittertemp3));

				save("kiksec", String.valueOf(kiktemp3));
				save("kikmin", String.valueOf(kiktemp2));
				save("kikhour", String.valueOf(kiktemp1));

				customHandlerkik.postDelayed(this, 0);

			}
		}

	};

	private Runnable updateTimerThreadask = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (ask = true) {

				asktemp3++;

				if (asktemp3 >= 60) {
					asktemp3 = 0;
					asktemp2 += 1;

				}
				if (asktemp2 >= 60) {
					asktemp2 = 0;
					asktemp1 += 1;

				}
				Log.d("hey", String.valueOf(twittertemp3));

				save("asksec", String.valueOf(asktemp3));
				save("askmin", String.valueOf(asktemp2));
				save("askhour", String.valueOf(asktemp1));

				customHandlerask.postDelayed(this, 0);

			}
		}

	};

	private Runnable updateTimerThreadbbm = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (bbm = true) {

				bbmtemp3++;

				if (bbmtemp3 >= 60) {
					bbmtemp3 = 0;
					bbmtemp2 += 1;

				}
				if (bbmtemp2 >= 60) {
					bbmtemp2 = 0;
					bbmtemp1 += 1;

				}
				Log.d("hey", String.valueOf(bbmtemp3));

				save("bbmsec", String.valueOf(bbmtemp3));
				save("bbmmin", String.valueOf(bbmtemp2));
				save("bbmhour", String.valueOf(bbmtemp1));

				customHandlerbbm.postDelayed(this, 0);

			}
		}

	};

	private void Not5() {
		Intent deleteIntent = new Intent(this, close.class);
		PendingIntent pendingIntentCancel = PendingIntent.getBroadcast(this, 0,
				deleteIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		Intent settingIntent = new Intent(this, settinggg.class);
		PendingIntent pendingIntentCancel1 = PendingIntent.getBroadcast(this,
				0, settingIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this);
		mBuilder.setContentTitle("Socials Addict");
		mBuilder.setContentText("Monitroring Usage..");
		mBuilder.setTicker("You reached the danger rate of using social networks, go & do something useful");
		mBuilder.setSmallIcon(R.drawable.ic_launcher);
		mBuilder.addAction(0, "Stop service", pendingIntentCancel);
		mBuilder.addAction(0, "Setting", pendingIntentCancel1);
		mBuilder.setOngoing(true);

		Intent resultIntent = new Intent(this, MainActivity.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(MainActivity.class);

		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
				PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		mNotificationManager.notify(2, mBuilder.build());

	}

	private void Not4() {
		Intent deleteIntent = new Intent(this, close.class);
		PendingIntent pendingIntentCancel = PendingIntent.getBroadcast(this, 0,
				deleteIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		Intent settingIntent = new Intent(this, settinggg.class);
		PendingIntent pendingIntentCancel1 = PendingIntent.getBroadcast(this,
				0, settingIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		Intent reprt = new Intent(this, report.class);

		PendingIntent pendingIntentCancel2 = PendingIntent.getBroadcast(this,
				0, reprt, PendingIntent.FLAG_UPDATE_CURRENT);

		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this);
		mBuilder.setContentTitle("Socials Addict");
		mBuilder.setContentText("Monitroring Usage..");
		mBuilder.setTicker("You are addicted socializer,cut down usage!");
		mBuilder.setSmallIcon(R.drawable.ic_launcher);
		mBuilder.addAction(0, "Stop service", pendingIntentCancel);
		mBuilder.addAction(0, "Setting", pendingIntentCancel1);
		mBuilder.setOngoing(true);
		mBuilder.addAction(0, "Report", pendingIntentCancel2);

		Intent resultIntent = new Intent(this, MainActivity.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(MainActivity.class);

		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
				PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		mNotificationManager.notify(2, mBuilder.build());

	}

	private void Not3() {
		Intent deleteIntent = new Intent(this, close.class);
		PendingIntent pendingIntentCancel = PendingIntent.getBroadcast(this, 0,
				deleteIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		Intent settingIntent = new Intent(this, settinggg.class);
		PendingIntent pendingIntentCancel1 = PendingIntent.getBroadcast(this,
				0, settingIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		Intent reprt = new Intent(this, report.class);

		PendingIntent pendingIntentCancel2 = PendingIntent.getBroadcast(this,
				0, reprt, PendingIntent.FLAG_UPDATE_CURRENT);

		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this);
		mBuilder.setContentTitle("Socials Addict");
		mBuilder.setContentText("ATTENTION!! ADDICTION IS NEAR!!");
		mBuilder.setTicker("Socials Addict");
		mBuilder.setSmallIcon(R.drawable.ic_launcher);
		mBuilder.addAction(0, "Stop service", pendingIntentCancel);
		mBuilder.addAction(0, "Setting", pendingIntentCancel1);
		mBuilder.setOngoing(true);
		mBuilder.addAction(0, "Report", pendingIntentCancel2);

		Intent resultIntent = new Intent(this, MainActivity.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(MainActivity.class);

		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
				PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		mNotificationManager.notify(2, mBuilder.build());

	}

};
