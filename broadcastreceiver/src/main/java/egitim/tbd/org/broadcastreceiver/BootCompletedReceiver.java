package egitim.tbd.org.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

//Cihaz yeniden başlayıp boot işlemi sonlandığında yaydığı yayını yakalayan receiver
public class BootCompletedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Yayın yakalandığında buraya düşer
        Log.e("BOOT", "Boot Completed Received");
        Toast.makeText(context,"Boot Completed Received",Toast.LENGTH_LONG).show();
    }
}
