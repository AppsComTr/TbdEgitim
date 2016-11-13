package egitim.tbd.org.demoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEdittext,passwordEdittext;
    private Button loginButton;

    //Bu activity henüz giriş yapmamis olan kullaniciya gösterilecek login formunu temsil eder.
    //Kullanici dogru bilgileri girdigi takdirde home ekranına yonlendirilir.
    //Yanlis bilgiler girilirse toast mesajı gosterilir
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Shared preferences alanindaki login bilgisi sorgulanir
        //Eger varolan bir login mevcut ise direk home ekranina yonlendirilir
        //Varolan bir login yok ise bu activity'nin ekrana yerlesmesi beklenir
        SharedPrefManager sharedPrefManager=SharedPrefManager.getInstance(this);
        if(sharedPrefManager.getLoginState()){
            startHomeActivity(sharedPrefManager.getUsername());
        }
        else{
            bindViews();
            setViewActions();
        }
    }

    //Layout icerisindeki elemanlara ulastigimiz metod
    private void bindViews(){
        usernameEdittext=(EditText)findViewById(R.id.username);
        passwordEdittext=(EditText)findViewById(R.id.password);
        loginButton=(Button)findViewById(R.id.login_button);
    }

    //Kullanicinin etkilesime girebilecegi view elemanina etkilesim sonunda ne yapacaginin atamasini yaptigimiz metod
    private void setViewActions() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginIfUserIsValid();
            }
        });
    }

    //Girilen bilgileri kontrol ettiren eger dogruysa home ekranini actiran
    private void loginIfUserIsValid(){
        String username=usernameEdittext.getText().toString();
        String password=passwordEdittext.getText().toString();
        if(checkUserAuth(username,password)){
            SharedPrefManager sharedPrefManager= SharedPrefManager.getInstance(this);
            sharedPrefManager.setLoginState(true);
            sharedPrefManager.setUsername(username);
            startHomeActivity(username);
        }
        else{
            Toast.makeText(this,getString(R.string.hatali_kullanici_bilgisi),Toast.LENGTH_LONG).show();
        }
    }

    //Kullanici bilgilerini kontrol eden metod
    private boolean checkUserAuth(String username,String password){
        return (username.equals("user1")&&password.equals("1234"))||(username.equals("user2")&&password.equals("5678"))||(username.equals("user3")&&password.equals("9876"));
    }

    //Home ekranini acan metod
    private void startHomeActivity(String username){
        Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
        //Home ekranina gonderecegimiz bilgiyi intent'in icerisine yerlestiriyoruz
        intent.putExtra("username",username);
        startActivity(intent);
        finish();
    }
}
