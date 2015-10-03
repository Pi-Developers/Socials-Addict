package pidevs.socialsaddict;

/**
 * 
 * @author rashad
 * 
 * 
 * **/

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class close extends BroadcastReceiver {

	int currentapiVersion = android.os.Build.VERSION.SDK_INT;

	SharedPreferences spf;

	@Override
	public void onReceive(Context context, Intent intent) {
		
		
		spf = PreferenceManager.getDefaultSharedPreferences(context);

		/**
		 * 
		 * This is for the notification action close it closes the services
		 * 
		 * */

		if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP
				|| currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {

			Intent it = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
			context.sendBroadcast(it);
			Intent service = new Intent();
			service.setComponent(new ComponentName(context,
					LollipopService.class));
			context.stopService(service);

			save("close", "yes");

		} else {

			Intent it = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
			context.sendBroadcast(it);
			Intent service = new Intent();
			service.setComponent(new ComponentName(context, ServiceSocial.class));
			context.stopService(service);

			save("close", "yes");

		}

	}

	public void save(String key, String value) {

		Editor edit = spf.edit();
		edit.putString(key, value);
		edit.commit();

	}

}
