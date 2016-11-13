package egitim.tbd.org.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPrefManager {

    //Bu class shared preferences yoneticisi olarak adlandirilabilir.
    //Shared preferences icerisinde sakladiginiz bilgilere tekrardan ulasmanizi saglar ve onlari manipule etmenize yardimci olur.

    private static SharedPrefManager sm;
    private Context context;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private SharedPrefManager(Context mContext) {
        context = mContext;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
    }

    //Shared Preferences yoneticisini cagirirken her zaman bu metodu kullaniyoruz.
    //Singleton bir yapiya sahip oldugu icin SharedPrefManager objesi eger yaratilmamissa yaratilip bize gonderiliyor.
    //Zaten yaratilmis ise direk gonderiliyor.
    public static SharedPrefManager getInstance(Context context){
        if(sm==null){
            sm=new SharedPrefManager(context);
        }
        return sm;
    }

    //Bu metod acik/kapali bilgisini doner.
    //Donecegi boolean bilgisi 'on_off_state' key'ine bagli olan bilgidir.
    public boolean getOnOffState(){
        return pref.getBoolean("on_off_state",false);
    }

    //Bu metod acik/kapali bilgisi icin atama yapar.
    //Atama yapacagi boolean bilgisi 'on_off_state' key'ine bagli olan bilgidir.
    public void setOnOffState(boolean onOffState){
        editor.putBoolean("on_off_state",onOffState);
        editor.commit();
    }
}
