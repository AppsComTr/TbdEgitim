package egitim.tbd.org.internetbluetoothstatedetect;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView internetState,bluetoothState;
    private BroadcastReceiver internetStateBroadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            internetState.setText(isInternetAvailable()?"ON":"OFF");
        }
    };

    private BroadcastReceiver bluetoothStateBroadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            bluetoothState.setText(isBluetoothAvailable()?"ON":"OFF");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        internetState=(TextView)findViewById(R.id.internet_state);
        bluetoothState=(TextView)findViewById(R.id.bluetooth_state);

        internetState.setText(isInternetAvailable()?"ON":"OFF");
        bluetoothState.setText(isBluetoothAvailable()?"ON":"OFF");

        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(internetStateBroadcastReceiver, filter);

        filter = new IntentFilter();
        filter.addAction( BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(bluetoothStateBroadcastReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(internetStateBroadcastReceiver);
    }

    private boolean isInternetAvailable(){
        boolean result=true;
        try{
            ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            if (activeNetwork != null && activeNetwork.isConnected()) {
                result= true;
            }else {
                result= false;
            }
        }
        catch (Exception e){
            result=false;
        }
        return result;
    }


    private boolean isBluetoothAvailable(){
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            return false;
        } else {
            return mBluetoothAdapter.isEnabled();
        }
    }

}
