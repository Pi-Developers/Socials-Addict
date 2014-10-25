package pidevs.socialsaddict;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class close extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent it = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
		context.sendBroadcast(it);
		Intent service = new Intent();
		service.setComponent(new ComponentName(context, ServiceSocial.class));
		context.stopService(service);

	}

}
