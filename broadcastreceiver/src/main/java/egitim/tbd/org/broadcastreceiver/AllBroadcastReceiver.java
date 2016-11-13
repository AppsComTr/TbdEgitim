package egitim.tbd.org.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AllBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case Intent.ACTION_POWER_CONNECTED:
                Log.e("POWER", "Power Connected Received");
                Toast.makeText(context,"Power Connected",Toast.LENGTH_LONG).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Log.e("POWER", "Power Disconnected Received");
                Toast.makeText(context,"Power Disconnected",Toast.LENGTH_LONG).show();
                break;
            case Intent.ACTION_BOOT_COMPLETED:
                Log.e("BOOT", "Boot Completed Received");
                Toast.makeText(context,"Boot Completed Received",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
