package egitim.tbd.org.layoutexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView metodu bu activity'e hangi layout'un yerlesecegini gösterir.
        //layout_example2,layout_example3,layout_example4 olarak değiştirip calistirabilirsiniz.
        setContentView(R.layout.layout_example1);
    }
}
