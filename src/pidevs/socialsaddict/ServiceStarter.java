package pidevs.socialsaddict;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;


/**
 * 
 * @author Mohamed Rashad
 *
 **/

/**
 * 
 * This is a broadcast receiver, used to trigger the service in boot time, if user choose to do this.
 * 
 **/

public class ServiceStarter extends BroadcastReceiver {
	
	SharedPreferences spf;

	@Override
	public void onReceive(Context context, Intent intent) {

		spf = PreferenceManager.getDefaultSharedPreferences(context);

		//Gets the values from spf
		String bootchk = spf.getString("boot", "true");
		String starti = spf.getString("start", "false");

		if (bootchk.equals("true") && starti.equals("true")) {

			
			//Since we have 2 services
			//We choose the suitable one here
			
			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

				context.startService(new Intent(context, LollipopService.class));
				
				Toast.makeText(context, "Socials Addict started", Toast.LENGTH_SHORT).show();

			} else {

				context.startService(new Intent(context, ServiceSocial.class));
				
				Toast.makeText(context, "Socials Addict started",Toast.LENGTH_SHORT).show();

			}
		}

	}
}