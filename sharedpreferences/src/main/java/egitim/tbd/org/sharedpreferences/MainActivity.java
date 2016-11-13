package egitim.tbd.org.sharedpreferences;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asagidaki kod satirinda layout icerisinde yer alan butonu burada kendi java objemize bagliyoruz
        final Button button=(Button)findViewById(R.id.button);

        //Shared Preferences yöneticisini cagiriyoruz
        SharedPrefManager sharedPrefManager=SharedPrefManager.getInstance(MainActivity.this);

        //Shared Preferences icerisindeki acik/kapali bilgisine gore
        //Butonumuzun uzerindeki yaziyi duzenliyoruz.
        button.setText(sharedPrefManager.getOnOffState()?getString(R.string.acik):getString(R.string.kapali));

        //O butona yine bu obje yardımıyla ulasip bir click dinleyicisi atamasi yapiyoruz
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Butona basildiginda calisacak olan kod govdesi burasidir.
                //Bu butona basildiginda eger aciksa kapatilmali, kapaliysa da acilmali
                //Ve tekradan butona basilana kadar bu durumun bu sekilde saklanmasi icin shared preferences icerisinde bir boolean bilgisi tutulmali.

                //Shared Preferences yöneticisini cagiriyoruz
                SharedPrefManager sharedPrefManager=SharedPrefManager.getInstance(MainActivity.this);

                if(sharedPrefManager.getOnOffState()){//Eger aciksa
                    //Shared icerisindeki boolean bilgisini duzenliyoruz
                    sharedPrefManager.setOnOffState(false);
                    //Butona gerekli text'i yaziyoruz
                    button.setText(getString(R.string.kapali));
                }
                else{//Eger kapaliysa
                    //Shared icerisindeki boolean bilgisini duzenliyoruz
                    sharedPrefManager.setOnOffState(true);
                    //Butona gerekli text'i yaziyoruz
                    button.setText(getString(R.string.acik));
                }
            }
        });
    }
}
