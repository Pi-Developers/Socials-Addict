package pidevs.socialsaddict;

import java.text.DecimalFormat;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class report extends BroadcastReceiver {
	SharedPreferences spf;
	String fb1, fb2, fb3, whats1, whats2, whats3, twittr1, twittr2, twittr3,
			kiki1, kiki2, kiki3, tmblr1, tmblr2, tmblr3, ask1, ask2, ask3,
			bbm1, bbm2, bbm3, insta1, insta2, insta3, total, states,UR,ser1,yy,kikm1,kikm2,kikm3,snap1,snap2,snap3;

	int z ;
	double y1,y,usaget;
	@SuppressLint("InlinedApi")
	@Override
	public void onReceive(Context context, Intent intent) {
		
		
		Intent it = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
		context.sendBroadcast(it); 
		
		
		spf = PreferenceManager.getDefaultSharedPreferences(context);
		states = spf.getString("state", "low");
		

		total = spf.getString("total", "0");
		DecimalFormat df = new DecimalFormat("#.##");    
		
		Double x = Double.parseDouble(total);
		ser1 = spf.getString("servicehour", "0");

		fb1 = spf.getString("facebooksec", "0");
		fb2 = spf.getString("facebookmin", "0");
		fb3 = spf.getString("facebookhour", "0");

		twittr1 = spf.getString("twittersec", "0");
		twittr2 = spf.getString("twittermin", "0");
		twittr3 = spf.getString("twitterhour", "0");

		ask1 = spf.getString("asksec", "0");
		ask2 = spf.getString("askmin", "0");
		ask3 = spf.getString("askhour", "0");

		insta1 =spf.getString("instagramsec", "0");
		insta2 = spf.getString("instagrammin", "0");
		insta3 = spf.getString("instagramhour", "0");

		tmblr1 = spf.getString("tumblrsec", "0");
		tmblr2 = spf.getString("tumblrmin", "0");
		tmblr3 = spf.getString("tumblrhour", "0");

		bbm1 =spf.getString("bbmsec", "0");
		bbm2 = spf.getString("bbmmin", "0");
		bbm3 = spf.getString("bbmhour", "0");

		whats1 = spf.getString("whatsappsec", "0");
		whats2 = spf.getString("whatsappmin", "0");
		whats3 = spf.getString("whatsapphour", "0");

		kiki1 = spf.getString("kiksec", "0");
		kiki2 = spf.getString("kikmin", "0");
		kiki3 = spf.getString("kikhour", "0");
		
		kikm3 = spf.getString("kikmsec", "0");
		kikm1 = spf.getString("kikmhour", "0");
		kikm2 = spf.getString("kikmin", "0");

		snap1 = spf.getString("snaphour", "0");
		snap2 = spf.getString("snapmin", "0");
		snap3 = spf.getString("snapsec", "0");
		
		
		String Total = "Facebook :" + fb3 + ":" + fb2 + ":" + fb1;
		String Total1 = "Twitter :" + twittr3 + ":" + twittr2 + ":" + twittr1;
		String Total2 = "Ask.fm :" + ask3 + ":" + ask2 + ":" + ask1;
		String Total3 = "Instagram :" + insta3 + ":" + insta2 + ":" + insta1;
		String Total4 = "Tumblr :" + tmblr3 + ":" + tmblr2 + ":" + tmblr1;
		String Total5 = "BBM :" + bbm3 + ":" + bbm2 + ":" + bbm1;
		String Total6 = "Whatsapp :" + whats3 + ":" + whats2 + ":" + whats1;
		String Total7 = "Google+ :" + kiki3 + ":" + kiki2 + ":" + kiki1;
		String Total8 = "Kik :" + kikm1 + ":" + kikm2 + ":" + kikm3;
		String Total9 = "snapchat:" + snap1 + ":" + snap2 + ":" + snap3;
		z = Integer.parseInt(ser1);
		
		if (z > 24) {

		     usaget = (x / 24.0);
			
			 y = ((double) z/24.0);
			
			 yy = df.format(y);

			 y1 = Double.parseDouble(yy);
			
			 usaget = (x / y1);

			
	     	    UR = Double.toString(usaget);

		} else {

			  UR = "0 Hour/Day";
		}


		
		Toast.makeText(context, "SOCIALS ADDICT REPORT TOAST\n___________________________________________\n" + "Usage statisitcs :\n\n" + Total + "     " + Total1 + "\n" + Total3 + "    " + Total4 + "\n" + Total2 + "            " + Total5 + "\n" + Total6 + "     " + Total7 + "\n" + Total8 + "     " + Total9 + "\n\n\n " + "Total consumption :    " + df.format(x) + " hours"+ "\n\n\n " + "Addiction state :    " + states +  "\n\n\n " + "Usage Rate:   "  + df.format(usaget) + "  hours/day"  , Toast.LENGTH_LONG).show();

		
	}
}
