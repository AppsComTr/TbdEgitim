package egitim.tbd.org.googlemaps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Google'dan gelen map tile'lar layout'umuzda olan 'map' id'li fragment'ın içerisine dolacak.
        //Bu yüzden o fragment'ı alıp, getMapAsync() metodunu çağırarak map göterim isteğini başlatıyoruz.
        //getMapAsync içerisine verdiğimiz parametre OnMapReadyCallback interface'i. Bu class (MainActivity)
        // OnMapReadyCallback interface'ini implemente ettiği için this parametresi kullanılıyor.
        // Bu interface sayesinde GoogleMap objesinin hazır olduğu haberini alabiliyoruz.
        // Hazır olduktan sonra üzerinden istediğimiz işlemi gerçekleştirebiliriz (dokunma, pin ekleme, belli bir bölgeye focus...vb)
        SupportMapFragment mapFragment =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Gelen GoogleMap objesini kendi GoogleMap referansımızda tutuyoruz.
        this.googleMap=googleMap;

        //GoogleMap objemizse click dinleyicisi tanımlıyoruz.
        this.googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                //Click olduğun kod buraya düşüyor.
                //Click olan noktaya marker ekliyoruz.
                MainActivity.this.googleMap.addMarker(new MarkerOptions().position(latLng));
            }
        });
    }
}
