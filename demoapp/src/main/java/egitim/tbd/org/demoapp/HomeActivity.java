package egitim.tbd.org.demoapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends Activity{

    private TextView wellcomeText;
    private Button logoutButton;
    private String username;

    //Bu activity giris yapmis bir kullaniciya gorunen home ekranini temsil eder
    //Kullanici bu ekran uzerinde bulunan cikis yap butonuna basarsa, shared preferences alani temizlenir ve login ekranina geri donulur
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Login ekranindan gelen bilgiyi intent icerisinden cikariyoruz.
        username=getIntent().getStringExtra("username");
        bindViews();
        setViewAppearances();
        setViewActions();
    }

    //Layout icerisindeki elemanlara ulastigimiz metod
    private void bindViews() {
        wellcomeText=(TextView)findViewById(R.id.wellcome_text);
        logoutButton=(Button)findViewById(R.id.logout_button);
    }

    //Layout icerisindeki view elemanlarinin gorunumlerini duzenledigimiz metod
    private void setViewAppearances() {
        wellcomeText.setText(getString(R.string.wellcome_text,username));
    }

    //Kullanicinin etkilesime girebilecegi view elemanina etkilesim sonunda ne yapacaginin atamasini yaptigimiz metod
    private void setViewActions() {
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPrefManager sharedPrefManager=SharedPrefManager.getInstance(HomeActivity.this);
                sharedPrefManager.setLoginState(false);
                sharedPrefManager.setUsername("");
                Intent intent=new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
