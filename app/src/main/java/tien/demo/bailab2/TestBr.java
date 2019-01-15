package tien.demo.bailab2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TestBr extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String dd= intent.getStringExtra("name");
        Toast.makeText(context, "dd "+dd, Toast.LENGTH_SHORT).show();
    }
}
