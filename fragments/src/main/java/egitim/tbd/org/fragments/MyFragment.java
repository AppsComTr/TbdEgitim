package egitim.tbd.org.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyFragment extends Fragment {


    //Fragment'ın içerisine yerleşecek layout'u belirlediğimiz evre.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.myfragment, container, false);
    }

    //Fragment'ın bize içerisindeki layout'a ait tüm view'ları yaratma işlemini bitirdiğini söylediği evre.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Bu evrede getView().findViewById() methodunu kullanarak fragment içerisindeki herhangi bir view objesine ulaşabiliriz.
        Button button=(Button)getView().findViewById(R.id.button);

        //Ulaştığımız butona click dinleyicisi atıyoruz.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Butona basıldığında dinleyici bize burada haber veriyor.
                //Activity'e butona basıldığına dair bilgi veriyoruz.
                ((MainActivity)getActivity()).onButtonClicked("Butona basıldı");
            }
        });
    }


}
