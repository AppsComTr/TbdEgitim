package egitim.tbd.org.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

        //RecyclerView'a ulaşıyoruz.
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Nasıl görüneceği kısmını da adapter içerisinde hallediyoruz.
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,models);
        recyclerView.setAdapter(adapter);
    }
}
