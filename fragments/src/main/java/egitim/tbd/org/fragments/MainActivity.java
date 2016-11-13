package egitim.tbd.org.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Activity içerisine yerleşmesi gereken layout'u belirtiyoruz
        setContentView(R.layout.activity_main);

        //Activity'e yerleştirdiğimiz layout içerisinde content id'sine sahip bir FrameLayout var
        //FramaLayout, fragment'ları taşıyan layouttur.
        //Activity'nin fragmentManager'ını çağırıp content framelayout'una MyFragment'ın yerleşmesini sağlıyoruz.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content,new MyFragment())
                .commit();
    }


    //Fragment içerisinden çağırdığımız toast methodu.
    public void onButtonClicked(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

}
