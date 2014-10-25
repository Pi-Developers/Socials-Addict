package pidevs.socialsaddict;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class settinggg extends BroadcastReceiver {

	@SuppressLint("InlinedApi")
	@Override
	public void onReceive(Context context, Intent intent) {
		Intent it = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
		context.sendBroadcast(it); 
		Intent intentone = new Intent(context.getApplicationContext(),
				Setting.class);
		intentone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
				| Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intentone);

	}

}
