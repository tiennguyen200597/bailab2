package tien.demo.bailab2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyBr extends BroadcastReceiver {

@Override
public void onReceive(final Context context, Intent intent) {
        Bundle ee=intent.getExtras();
        String num=ee.getString(TelephonyManager.EXTRA_STATE);
        /*int num=ee.getInt(TelephonyManager.EXTRA_INCOMING_NUMBER);*/
        Toast.makeText(context, num, Toast.LENGTH_SHORT).show();

}
        }