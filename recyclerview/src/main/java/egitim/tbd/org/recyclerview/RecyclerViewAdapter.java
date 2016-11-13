package egitim.tbd.org.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private String[] models;
    private LayoutInflater inflater;

    //Adapter'un yapıcı metodu. İçerisine Context'i (Activity) ve data modelini kabul eder.
    public RecyclerViewAdapter(Context context, String[] models) {
        this.models=models;

        //Inflater objesi .xml layout deklarasyonlarını ekrana yerleştirilecek view haline getiren objedir.
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //Tutucu (holder) kullanmak recyclerview içerisinde zorunlu hale getirilmiştir.
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(View v) {
            super(v);
            textView=(TextView)v.findViewById(R.id.text);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Child view'ı yaratıyoruz ve holder objesine iliştiriyoruz.
        View view=inflater.inflate(R.layout.listview_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Adapter bize sadece göstereceği child view'ın holder objesini veriyor.
        //Biz de o holder gösterdiklerini position parametresine göre değiştiriyoruz.
        holder.textView.setText(models[position]);
    }

    //Adapter'un liste içerisinde kaç eleman görüneceğinden haberdar olduğu metod.
    @Override
    public int getItemCount() {
        return models.length;
    }

}
