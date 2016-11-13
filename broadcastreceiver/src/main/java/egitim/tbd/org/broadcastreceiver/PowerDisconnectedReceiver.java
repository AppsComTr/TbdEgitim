package egitim.tbd.org.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

//Cihazın güç kablosu çıkarıldığında yaydığı yayını yakalayan receiver
public class PowerDisconnectedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Yayın yakalandığında buraya düşer
        Log.e("POWER", "Power Disconnected Received");
        Toast.makeText(context,"Power Disconnected",Toast.LENGTH_LONG).show();
    }
}
