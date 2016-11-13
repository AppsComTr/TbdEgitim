package egitim.tbd.org.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter{

    private String[] models;
    private LayoutInflater inflater;

    //Adapter'un yapıcı metodu. İçerisine Context'i (Activity) ve data modelini kabul eder.
    public ListAdapter(Context context, String[] models){
        this.models=models;

        //Inflater objesi .xml layout deklarasyonlarını ekrana yerleştirilecek view haline geitren objedir.
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //Adapter'un liste içerisinde kaç eleman görüneceğinden haberdar olduğu metod.
    @Override
    public int getCount() {
        return models.length;
    }


    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //Listview içerisindeki her bir child view'ı çizip verdiğimiz metod.
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //Adapter bize bosa çıkan view'ları tekrardan verir. Nullcheck yapılır eğer içi boşsa doldurulur.
        if(view==null){
            view=inflater.inflate(R.layout.listview_item,null,false);

            //View'a holder (tutucu) iliştirilir. Holder içerisinde göstericiler vardır
            //Bu göstericiler tekrar tekrar findViewById kullanılmasını engeller.
            ViewHolder holder=new ViewHolder();
            holder.textView=(TextView)view.findViewById(R.id.text);
            view.setTag(holder);
        }

        //View içerisinden holder objesi çekilir.
        //Holder'ın içerisinde zaten o view'ın içerisindeki elemanları gösteren göstericiler bulunur.
        //Bu göstericiler yardımıyla direk manipule edilir.
        ViewHolder viewholder=(ViewHolder) view.getTag();
        viewholder.textView.setText(models[i]);
        return view;
    }

    //Holder objesi deklarasyonu
    class ViewHolder{
        //Gostericiler
        TextView textView;
    }
}
