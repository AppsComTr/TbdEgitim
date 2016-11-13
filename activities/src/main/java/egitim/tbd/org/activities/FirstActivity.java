package egitim.tbd.org.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends Activity {

    /*Bu örnek bir activity'nin genel yaşam döngüsünü gösterir.
      Activity ekrana gelmeden önce onCreate,onStart,onResume evrelerinden geçer ve kullanıcıya görünür hale gelir.
      Activity sonlandırılacağında ise sırasıyla onPause,onStop ve onDestroy evrelerinden geçer ve ekrandan kaldırılarak yok edilir.
      Eğer yok edilmeden ikinci bir activity'e gecis varsa ilk activity'nin sadece onPause ve onStop evresi çalışır. Geri tuşuna basıldığında ise ilk activity ekrana yeniden gelmek
      zorunda olduğu için tekrardan onStart ve onResume evresinden geçer, ekrana yeniden çizilir.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //Asagidaki kod satirinda layout icerisinde yer alan butonu burada kendi java objemize bagliyoruz
        Button button=(Button)findViewById(R.id.button);

        //O butona yine bu obje yardımıyla ulasip bir click dinleyicisi atamasi yapiyoruz
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Butona basildiginda calisacak olan kod govdesi burasidir.
                //Burada second activity'i acma istegimizi gonderiyoruz
                Intent i=new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });

        Log.e("Activity LifeCycle","ON CREATE");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Activity LifeCycle","ON START");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Activity LifeCycle","ON RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Activity LifeCycle","ON PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Activity LifeCycle","ON STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Activity LifeCycle","ON DESTROY");
    }
}
