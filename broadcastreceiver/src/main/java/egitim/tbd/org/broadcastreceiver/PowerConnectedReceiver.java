package egitim.tbd.org.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

//Cihazın güç kablosu takıldığında yaydığı yayını yakalayan receiver
public class PowerConnectedReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        //Yayın yakalandığında buraya düşer
        Log.e("POWER", "Power Connected Received");
        Toast.makeText(context,"Power Connected",Toast.LENGTH_LONG).show();
    }
}
