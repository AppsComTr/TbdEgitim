package egitim.tbd.org.externallibraries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import net.mskurt.flexitagslibrary.FlexiTags;
import net.mskurt.flexitagslibrary.Tag;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gradle dependency olarak ekledigimiz picasso kutuphanesinin kullanimi asagidaki gibidir
        ImageView image=(ImageView)findViewById(R.id.image);
        Picasso.with(this).load("http://4pps.co/stuff/resim.jpg").into(image);

        //kaynak kodlarıyla direkt olarak projeye dahil ettiğimiz flexitags kutuphanesinin kullanimi asagidaki gibidir
        FlexiTags flexiTags=(FlexiTags)findViewById(R.id.flexitags);
        flexiTags.setOnTagClickListener(new FlexiTags.OnTagClickListener() {
            @Override
            public void onTagClick(Tag tag) {
                Toast.makeText(MainActivity.this,(tag.getTagname()),Toast.LENGTH_LONG).show();
            }
        });
        flexiTags.showTime();

    }
}
