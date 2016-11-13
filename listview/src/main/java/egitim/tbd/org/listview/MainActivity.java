package egitim.tbd.org.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adapter'un kullanıldığı scrollable veya swipable yapılarda temel iki unsur vardır.
        //Data modeli (ham data) ve bu dataların ekrandaki gösterim şekli.

        //Data modelini burada oluşturuyoruz.
        String[] models=new String[]{
          "Bu 1. eleman",
          "Bu 2. eleman",
          "Bu 3. eleman",
          "Bu 4. eleman",
          "Bu 5. eleman",
          "Bu 6. eleman",
          "Bu 7. eleman",
          "Bu 8. eleman",
          "Bu 9. eleman",
          "Bu 10. eleman",
          "Bu 11. eleman",
          "Bu 12. eleman",
          "Bu 13. eleman",
        };

        //Nasıl görüneceği kısmını da adapter içerisinde hallediyoruz.
        ListView listView=(ListView)findViewById(R.id.listview);
        ListAdapter adapter=new ListAdapter(this,models);
        listView.setAdapter(adapter);
    }
}
