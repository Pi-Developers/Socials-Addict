package pidevs.socialsaddict;

/**
 * @author Mohamed rashad
 * 
 */

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class LollipopService extends Service {

	/**
	 * 
	 * This is the service of the counter of socials addict. it works to detect
	 * the apps runnning then trigger custom timers when the certain app is
	 * running.
	 * 
	 **/

	private Handler mainhandler;
	private Handler customHandlerfacebook = new Handler();
	private Handler customHandlertwitter = new Handler();
	private Handler customHandlerinstagram = new Handler();
	private Handler customHandlertumblr = new Handler();
	private Handler customHandlerwhatsapp = new Handler();
	private Handler customHandlerbbm = new Handler();
	private Handler customHandlerkik = new Handler();
	private Handler customHandlerask = new Handler();
	private Handler customHandlersnap = new Handler();
	private Handler customHandlerkikm = new Handler();

	Boolean facebook, twitter, tumblr, whatsapp, instagram, kik, bbm, ask,
			kikm, snapchatt;

	double total, totalsec, totalmin, totalall, totalall1, totalall2;

	SharedPreferences spf;

	int f, t, tu, w, i, k, b, a, s, km;

	int x = 60;

	int y = 3600;

	double addict;

	public static int facebooktemp1, facebooktemp2, facebooktemp3,
			twittertemp1, twittertemp2, twittertemp3, instagramtemp1,
			instagramtemp2, instagramtemp3, whatsapptemp1, whatsapptemp2,
			whatsapptemp3, tumblrtemp1, tumblrtemp2, tumblrtemp3, kiktemp1,
			kiktemp2, kiktemp3, asktemp1, asktemp3, asktemp2, bbmtemp1,
			bbmtemp2, bbmtemp3, servicetemp1, servicetemp2, servicetemp3,
			kikm1, kikm2, kikm3, snap1, snap2, snap3;

	public static String fbcheck, whatsappcheck, tumblrcheck, instacheck,
			twcheck, askcheck, bbmcheck, kikcheck, starti, fb1, fb2, fb3,
			whats1, whats2, whats3, twittr1, twittr2, twittr3, kiki1, kiki2,
			kiki3, tmblr1, tmblr2, tmblr3, ask1, ask2, ask3, bbm1, bbm2, bbm3,
			insta1, insta2, insta3, ser1, ser2, ser3, kikmsec, kikmhour,
			kikmmin, snaphour, snapmin, snapsec, snapcheck, kikmcheck, not,
			clear, rich, state, totals, start;

	private String[] getLollipop() {

		final int PROCESS_STATE_TOP = 2;

		try {
			Field processStateField = ActivityManager.RunningAppProcessInfo.class
					.getDeclaredField("processState");

			List<ActivityManager.RunningAppProcessInfo> processes = activityManager()
					.getRunningAppProcesses();

			for (ActivityManager.RunningAppProcessInfo process : processes) {

				if (
				// Filters out most non-activity processes
				process.importance <= ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND
						&&
						// Filters out processes that are just being
						// _used_ by the process with the activity
						process.importanceReasonCode == 0) {

					int state = processStateField.getInt(process);

					if (state == PROCESS_STATE_TOP)
						/*
						 * If multiple candidate processes can get here, it's
						 * most likely that apps are being switched. The first
						 * one provided by the OS seems to be the one being
						 * switched to, so we stop here.
						 */
						return process.pkgList;
				}
			}
		} catch (NoSuchFieldException e) {

			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {

		}

		return new String[] {};
	}

	private ActivityManager activityManager() {

		return (ActivityManager) getApplicationContext().getSystemService(
				Context.ACTIVITY_SERVICE);
	}

	@Override
	public IBinder onBind(Intent arg0) {

		return null;
	}

	/**
	 * 
	 * This Method loads the values of timers from shared preferences. values
	 * are strings converted to intgers then used in handlers
	 * 
	 * 
	 **/

	public void load() {

		fbcheck = spf.getString("facebook", "true");
		kikcheck = spf.getString("kik", "true");
		bbmcheck = spf.getString("bbm", "true");
		askcheck = spf.getString("ask", "true");
		twcheck = spf.getString("twitter", "true");
		instacheck = spf.getString("instagram", "true");
		tumblrcheck = spf.getString("tumblr", "true");
		whatsappcheck = spf.getString("whatsapp", "true");
		snapcheck = spf.getString("snapchat", "true");
		kikmcheck = spf.getString("kikm", "true");
		rich = spf.getString("rich", "false");
		totals = spf.getString("total", "0.0");

		state = spf.getString("state", "low");
		ser1 = spf.getString("servicehour", "0");
		ser2 = spf.getString("servicemin", "0");
		ser3 = spf.getString("servicesec", "0");

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

		kikmsec = spf.getString("kikmsec", "0");
		kikmhour = spf.getString("kikhour", "0");
		kikmmin = spf.getString("kikmin", "0");

		snaphour = spf.getString("snaphour", "0");
		snapmin = spf.getString("snapmin", "0");
		snapsec = spf.getString("snapsec", "0");

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

		kikm1 = Integer.parseInt(kikmhour);
		kikm2 = Integer.parseInt(kikmmin);
		kikm3 = Integer.parseInt(kikmsec);

		snap1 = Integer.parseInt(snaphour);
		snap2 = Integer.parseInt(snapmin);
		snap3 = Integer.parseInt(snapsec);

		servicetemp3 = Integer.parseInt(ser3);
		servicetemp2 = Integer.parseInt(ser2);
		servicetemp1 = Integer.parseInt(ser1);

	}

	@Override
	public void onCreate() {

		// not is abbreviated "notification"

		spf = PreferenceManager.getDefaultSharedPreferences(this);

		not = spf.getString("not", "false");

		clear = spf.getString("clear", "false");

		if (not.isEmpty()) {

			save("not", "false");

		}

		if (clear.isEmpty()) {

			save("clear", "false");

		}

		if (!not.equals("true")) {

			load();

			showNotification("State : " + state);

		}

	}

	@SuppressLint({ "HandlerLeak", "SimpleDateFormat" })
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		spf = PreferenceManager.getDefaultSharedPreferences(this);

		super.onStartCommand(intent, flags, startId);

		mainhandler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);

				try {

					if (clear.equals("true")) {
						Calendar c = Calendar.getInstance();
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
						String strDate = sdf.format(c.getTime());

						if (strDate.equals("00:00:00")) {

							save("facebooksec", "00");
							save("facebookmin", "00");
							save("facebookhour", "00");

							save("twittersec", "00");
							save("twittermin", "00");
							save("twitterhour", "00");

							save("whatsappsec", "00");
							save("whatsappmin", "00");
							save("whatsapphour", "00");

							save("tumblrsec", "00");
							save("tumblrmin", "00");
							save("tumblrhour", "00");

							save("instagramsec", "00");
							save("instagrammin", "00");
							save("instagramhour", "00");

							save("asksec", "00");
							save("askmin", "00");
							save("askhour", "00");

							save("bbmsec", "00");
							save("bbmmin", "00");
							save("bbmhour", "00");

							save("kiksec", "00");
							save("kikmin", "00");
							save("kikhour", "00");

							save("snaphour", "00");
							save("snapsec", "00");
							save("snapmin", "00");

							save("kikmmin", "00");
							save("kikmsec", "00");
							save("kikmhour", "00");

							save("servicesec", "00");
							save("servicemin", "00");
							save("servicehour", "00");


							save("state", "low");
							save("total", "0");

						}

					}

					load();

					// This is the total consumption

					totalmin = (double) (facebooktemp2 + twittertemp2
							+ whatsapptemp2 + instagramtemp2 + tumblrtemp2
							+ kiktemp2 + bbmtemp2 + asktemp2 + kikm2 + snap2);

					totalsec = (double) (facebooktemp3 + twittertemp3
							+ whatsapptemp3 + instagramtemp3 + tumblrtemp3
							+ kiktemp3 + bbmtemp3 + asktemp3 + kikm3 + snap3);

					totalall1 = ((double) totalmin / (double) x);

					totalall2 = ((double) totalsec / (double) y);

					totalall = (double) (totalall1 + totalall2);

					total = (double) (facebooktemp1 + twittertemp1
							+ whatsapptemp1 + instagramtemp1 + tumblrtemp1
							+ kiktemp1 + bbmtemp1 + asktemp1 + totalall + kikm1 + snap1);

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
					save("servicehour", String.valueOf(servicetemp1));

					addict = ((double) total / (double) servicetemp1);

				} catch (NullPointerException nullPointerException) {
				}

				if (servicetemp1 > 4) {

					if (addict < 0.1) {

						save("state", "low");

						showNotification("State : Low");

					} else {

						if (addict < 0.2 && addict > 0.1) {

							save("state", "Average");

							showNotification("State : Average");

						} else {

							if (addict < 0.3 && addict > 0.2) {

								save("state", "attention");

								showNotification("State : Attention");

							} else {

								if (addict < 0.5 && addict > 0.4) {

									save("state", "Addicted");

									showNotification("State : Addicted");

								} else {

									if (addict > 0.6) {

										save("state", "DANGER");

										showNotification("State : DANGER");

									}
								}
							}
						}
					}
				}

				if (starti.equals("true")) {

					String[] activePackages = getLollipop();

					for (String activePackage : activePackages) {

						if (fbcheck.equals("true")) {

							if (activePackage.equals("com.facebook.katana")
									|| activePackage
											.equals("com.facebook.orca")
									|| activePackage
											.equals("app.fastfacebook.com")
									|| activePackage
											.equals("com.rapid.facebook.magicdroid")
									|| activePackage
											.equals("com.androdb.fastlitefb")
									|| activePackage
											.equals("com.abewy.klyph_beta")
									|| activePackage
											.equals("uk.co.senab.blueNotifyFree")
									|| activePackage
											.equals("com.platinumapps.facedroid")
									|| activePackage
											.equals("com.spatiolabs.spatio")
									|| activePackage
											.equals("com.for_wd.streampro")
									|| activePackage.contains("facebook")) {

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
						} else {

							if (f == 1) {

								facebook = false;

								customHandlerfacebook
										.removeCallbacks(updateTimerThreadfacebook);
								f = 2;
							}

						}

						if (twcheck.equals("true")) {

							if (activePackage.equals("com.twitter.android")
									|| activePackage
											.equals("com.levelup.touiteur")
									|| activePackage
											.equals("com.handmark.tweetcaster")
									|| activePackage
											.equals("com.hootsuite.droid.full")
									|| activePackage.equals("com.echofon")
									|| activePackage
											.equals("org.mariotaku.twidere")
									|| activePackage.contains("twitter")) {

								if (t == 1) {

								}

								else {

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

						} else {

							if (t == 1) {

								twitter = false;

								customHandlertwitter
										.removeCallbacks(updateTimerThreadtwitter);
								t = 2;
							}
						}

						// ////////////////

						if (bbmcheck.equals("true")) {

							if (activePackage.equals("com.bbm")
									|| activePackage.contains("bbm")) {

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
						} else {
							if (b == 1) {

								bbm = false;

								customHandlerbbm
										.removeCallbacks(updateTimerThreadbbm);
								b = 2;
							}
						}

						if (askcheck.equals("true")) {
							if (activePackage.equals("com.askfm")) {

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
						} else {

							if (a == 1) {

								ask = false;

								customHandlerask
										.removeCallbacks(updateTimerThreadask);
								a = 2;
							}
						}

						if (kikcheck.equals("true")) {

							if (activePackage
									.equals("com.google.android.apps.plus")
									|| activePackage
											.equals("com.google.android.talk")) {

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
						} else {
							if (k == 1) {

								kik = false;

								customHandlerkik
										.removeCallbacks(updateTimerThreadkik);
								k = 2;
							}
						}

						// //////

						if (whatsappcheck.equalsIgnoreCase("true")) {

							if (activePackage.equals("com.whatsapp")
									|| activePackage.contains("whatsapp")) {

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

						} else {

							if (w == 1) {

								whatsapp = false;

								customHandlerwhatsapp
										.removeCallbacks(updateTimerThreadwhatsapp);
								w = 2;
							}
						}

						if (tumblrcheck.equalsIgnoreCase("true")) {

							if (activePackage.equals("com.tumblr")) {

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
						} else {
							if (tu == 1) {

								tumblr = false;

								customHandlertumblr
										.removeCallbacks(updateTimerThreadtumblr);
								tu = 2;
							}
						}

						// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

						if (kikmcheck.equals("true")) {

							if (activePackage.equals("kik.android")) {

								if (km == 1) {

								} else {

									km = 1;
									kikm = true;
									customHandlerkikm.postDelayed(
											updateTimerThreadkikm, 0);
								}

							} else {

								if (km == 1) {

									kikm = false;
									customHandlerkikm
											.removeCallbacks(updateTimerThreadkikm);
									k = 2;
									System.gc();
								}
							}
						} else {

							if (km == 1) {

								kikm = false;
								customHandlerkikm
										.removeCallbacks(updateTimerThreadkikm);
								km = 2;
								System.gc();

							}

						}

						// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

						if (snapcheck.equals("true")) {

							if (activePackage.equals("com.snapchat.android")) {

								if (s == 1) {

								} else {

									s = 1;
									snapchatt = true;

									customHandlersnap.postDelayed(
											updateTimerThreadsnap, 0);
								}

							} else {

								if (s == 1) {

									snapchatt = false;

									customHandlersnap
											.removeCallbacks(updateTimerThreadsnap);
									s = 2;
									System.gc();

								}
							}
						} else {

							if (s == 1) {

								snapchatt = false;

								customHandlersnap
										.removeCallbacks(updateTimerThreadsnap);
								s = 2;
								System.gc();

							}

						}
						// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

						if (instacheck.equals("true")) {

							if (activePackage.equals("com.instagram.android")) {

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
	private void showNotification(String m) {

		load();

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

		if (rich.equals("true")) {

			DecimalFormat df = new DecimalFormat("#.##");
			Double D = Double.parseDouble(totals);

			mBuilder.setContentText("Monitoring Usage" + " | " + m + " | "
					+ "Total : " + df.format(D) + " Hours");

			mBuilder.setTicker("Socials Addict" + "You are in " + m + " Level");

		} else {

			mBuilder.setContentText("Monitoring Usage..");
			mBuilder.setTicker("Socials Addict");

		}

		mBuilder.setSmallIcon(R.drawable.ic_launcher);
		mBuilder.addAction(0, "Stop service", pendingIntentCancel);
		mBuilder.addAction(0, "Setting", pendingIntentCancel1);
		mBuilder.addAction(0, "Usage", pendingIntentCancel2);

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

	// when service is turned off
	// Notification is killed
	
	public void onDestroy() {

		super.onDestroy();

		start = spf.getString("start", "true");

		String close = spf.getString("close", "no");

		
		if (start.equals("true")  && close.equals("no")  ) {

			NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
			mNotificationManager.cancelAll();
			
			startService(new Intent(LollipopService.this, LollipopService.class));

		} else if(start.equals("true") && close.equals("yes") ){

		  NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		  mNotificationManager.cancelAll();
		
		}else{
			
			  NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
			  mNotificationManager.cancelAll();
			
		}
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

				String facesec, facemin, facehour;

				if (facebooktemp3 >= 60) {
					facebooktemp3 = 0;
					facebooktemp2 += 1;

				}
				if (facebooktemp2 >= 60) {
					facebooktemp2 = 0;
					facebooktemp1 += 1;
				}

				facemin = "" + facebooktemp1;
				facesec = "" + facebooktemp3;
				facehour = "" + facebooktemp1;

				// --------------------------------

				if (facebooktemp3 < 10) {

					facesec = "0" + facebooktemp3;

				}

				if (facebooktemp2 < 10) {

					facemin = "0" + facebooktemp2;

				}

				if (facebooktemp1 < 10) {

					facehour = "0" + facebooktemp1;

				}

				// --------------------------------

				save("facebooksec", facesec);
				save("facebookmin", facemin);
				save("facebookhour", facehour);

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

				String tsec, tmin, thour;

				if (twittertemp3 >= 60) {
					twittertemp3 = 0;
					twittertemp2 += 1;

				}

				if (twittertemp2 >= 60) {
					twittertemp2 = 0;
					twittertemp1 += 1;

				}

				tmin = "" + twittertemp2;
				tsec = "" + twittertemp3;
				thour = "" + twittertemp1;

				// --------------------------------

				if (twittertemp3 < 10) {

					tsec = "0" + twittertemp3;

				}

				if (twittertemp2 < 10) {

					tmin = "0" + twittertemp2;

				}

				if (twittertemp1 < 10) {

					thour = "0" + twittertemp1;

				}

				// --------------------------------

				save("twittersec", tsec);
				save("twittermin", tmin);
				save("twitterhour", thour);

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

				String wsec, whour, wmin;

				if (whatsapptemp3 >= 60) {
					whatsapptemp3 = 0;
					whatsapptemp2 += 1;

				}
				if (whatsapptemp2 >= 60) {
					whatsapptemp2 = 0;
					whatsapptemp1 += 1;

				}

				wmin = "" + whatsapptemp2;
				wsec = "" + whatsapptemp3;
				whour = "" + whatsapptemp1;

				// --------------------------------

				if (whatsapptemp3 < 10) {

					wsec = "0" + whatsapptemp3;

				}

				if (whatsapptemp2 < 10) {

					wmin = "0" + whatsapptemp2;

				}

				if (whatsapptemp1 < 10) {

					whour = "0" + whatsapptemp1;

				}

				// --------------------------------

				save("whatsappsec", wsec);
				save("whatsappmin", wmin);
				save("whatsapphour", whour);

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

				String ttsec, tthour, ttmin;

				if (tumblrtemp3 >= 60) {
					tumblrtemp3 = 0;
					tumblrtemp2 += 1;

				}
				if (tumblrtemp2 >= 60) {
					tumblrtemp2 = 0;
					tumblrtemp1 += 1;

				}

				ttmin = "" + tumblrtemp2;
				ttsec = "" + tumblrtemp3;
				tthour = "" + tumblrtemp1;

				// --------------------------------

				if (tumblrtemp3 < 10) {

					ttsec = "0" + tumblrtemp3;

				}

				if (tumblrtemp2 < 10) {

					ttmin = "0" + tumblrtemp2;

				}

				if (tumblrtemp1 < 10) {

					tthour = "0" + tumblrtemp1;

				}

				// --------------------------------

				save("tumblrsec", ttsec);
				save("tumblrmin", ttmin);
				save("tumblrhour", tthour);

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

				String isec, ihour, imin;

				if (instagramtemp3 >= 60) {
					instagramtemp3 = 0;
					instagramtemp2 += 1;

				}
				if (instagramtemp2 >= 60) {
					instagramtemp2 = 0;
					instagramtemp1 += 1;

				}

				imin = "" + instagramtemp2;
				isec = "" + instagramtemp3;
				ihour = "" + instagramtemp2;

				// --------------------------------

				if (instagramtemp3 < 10) {

					isec = "0" + instagramtemp3;

				}

				if (instagramtemp2 < 10) {

					imin = "0" + instagramtemp2;

				}

				if (instagramtemp1 < 10) {

					ihour = "0" + instagramtemp1;

				}

				// --------------------------------

				save("instagramsec", isec);
				save("instagrammin", imin);
				save("instagramhour", ihour);

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

				String ksec, khour, kmin;

				if (kiktemp3 >= 60) {
					kiktemp3 = 0;
					kiktemp2 += 1;

				}

				if (kiktemp2 >= 60) {
					kiktemp2 = 0;
					kiktemp1 += 1;

				}

				kmin = "" + kiktemp2;
				ksec = "" + kiktemp3;
				khour = "" + kiktemp1;

				// --------------------------------

				if (kiktemp3 < 10) {

					ksec = "0" + kiktemp3;

				}

				if (kiktemp2 < 10) {

					kmin = "0" + kiktemp2;

				}

				if (kiktemp1 < 10) {

					khour = "0" + kiktemp1;

				}

				// --------------------------------

				save("kiksec", ksec);
				save("kikmin", kmin);
				save("kikhour", khour);

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

				String asec, ahour, amin;

				if (asktemp3 >= 60) {
					asktemp3 = 0;
					asktemp2 += 1;

				}
				if (asktemp2 >= 60) {
					asktemp2 = 0;
					asktemp1 += 1;

				}

				amin = "" + asktemp2;
				asec = "" + asktemp3;
				ahour = "" + asktemp1;

				// --------------------------------

				if (asktemp3 < 10) {

					asec = "0" + asktemp3;

				}

				if (asktemp2 < 10) {

					amin = "0" + asktemp2;

				}

				if (asktemp1 < 10) {

					ahour = "0" + asktemp1;

				}

				// --------------------------------

				save("asksec", asec);
				save("askmin", amin);
				save("askmin", ahour);

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

				String bsec, bhour, bmin;

				if (bbmtemp3 >= 60) {
					bbmtemp3 = 0;
					bbmtemp2 += 1;

				}
				if (bbmtemp2 >= 60) {
					bbmtemp2 = 0;
					bbmtemp1 += 1;

				}

				bmin = "" + bbmtemp2;
				bsec = "" + bbmtemp3;
				bhour = "" + bbmtemp1;

				// --------------------------------

				if (bbmtemp3 < 10) {

					bsec = "0" + bbmtemp3;

				}

				if (bbmtemp2 < 10) {

					bmin = "0" + bbmtemp2;

				}

				if (bbmtemp1 < 10) {

					bhour = "0" + bbmtemp1;

				}

				// --------------------------------

				save("bbmsec", bsec);
				save("bbmmin", bmin);
				save("bbmhour", bhour);

				customHandlerbbm.postDelayed(this, 0);

			}
		}

	};

	private Runnable updateTimerThreadkikm = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (kikm = true) {

				kikm3++;

				String kksec, kkhour, kkmin;

				if (kikm3 >= 60) {
					kikm3 = 0;
					kikm2 += 1;

				}
				if (kikm2 >= 60) {
					kikm2 = 0;
					kikm1 += 1;

				}

				kkmin = "" + kikm2;
				kksec = "" + kikm3;
				kkhour = "" + kikm1;

				// --------------------------------

				if (kikm3 < 10) {

					kksec = "0" + kikm3;

				}

				if (kikm2 < 10) {

					kkmin = "0" + kikm2;

				}

				if (kikm1 < 10) {

					kkhour = "0" + kikm1;

				}

				// --------------------------------

				save("kikmhour", kkhour);
				save("kikmsec", kkmin);
				save("kikmmin", kksec);

				customHandlerkikm.postDelayed(this, 0);

			}
		}

	};

	private Runnable updateTimerThreadsnap = new Runnable() {

		public void run() {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (snapchatt = true) {

				snap3++;
				String ssec, shour, smin;

				if (snap3 >= 60) {
					snap3 = 0;
					snap2 += 1;

				}
				if (snap2 >= 60) {
					snap2 = 0;
					snap1 += 1;
				}

				ssec = "" + snap2;
				smin = "" + snap3;
				shour = "" + snap1;

				// --------------------------------

				if (snap3 < 10) {

					ssec = "0" + snap3;

				}

				if (snap2 < 10) {

					smin = "0" + snap2;

				}

				if (snap1 < 10) {

					shour = "0" + snap1;

				}

				// --------------------------------

				save("snapsec", ssec);
				save("snapmin", smin);
				save("snaphour", shour);

				customHandlersnap.postDelayed(this, 0);

			}
		}

	};

};