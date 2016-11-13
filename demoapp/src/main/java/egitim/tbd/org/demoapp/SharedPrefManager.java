package egitim.tbd.org.demoapp;

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

    //Bu metod login bilgisini doner.
    //Donecegi boolean bilgisi 'login_state' key'ine bagli olan bilgidir.
    public boolean getLoginState(){
        return pref.getBoolean("login_state",false);
    }

    //Bu metod login bilgisi icin atama yapar.
    //Atama yapacagi boolean bilgisi 'login_state' key'ine bagli olan bilgidir.
    public void setLoginState(boolean onOffState){
        editor.putBoolean("login_state",onOffState);
        editor.commit();
    }

    //Bu metod username bilgisini doner.
    //Donecegi username bilgisi 'username' key'ine bagli olan bilgidir.
    public String getUsername(){
        return pref.getString("username","");
    }

    //Bu metod username bilgisi icin atama yapar.
    //Atama yapacagi username bilgisi 'username' key'ine bagli olan bilgidir.
    public void setUsername(String username){
        editor.putString("username",username);
        editor.commit();
    }

}
