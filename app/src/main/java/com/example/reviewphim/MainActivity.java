package com.example.reviewphim;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_login, btn_signUp, btn_login_fb, btn_login_gg;
    EditText et_username, et_password;
    TextView tv_result, tv_forgotpassword, tv_signUp, tv_test;
    private Context context;
    private ProgressBar progressBar;

    protected int _splashTime = 1500;
    boolean isAllFieldsChecked = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        overridePendingTransition(android.R.anim.slide_in_left, R.anim.zoom_out_fade_out);

        context = this;
        setContentView(R.layout.activity_main);
        btn_signUp = findViewById(R.id.btn_signUp);

        getView();

        tv_signUp = (TextView) findViewById(R.id.tv_loginNow);
        tv_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        btn_login = findViewById(R.id.btn_login);
        tv_test = findViewById(R.id.tv_test);
        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                if(username.equals(""))
                {
                    et_username.setError("Required!");
                    et_username.setFocusable(true);
                }
                if(password.equals(""))
                {
                    et_password.setError("Required!");
                    et_password.setFocusable(true);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            finish();
                            Intent i = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(i);
                        }
                    }, _splashTime);
                }
            }
        });

        btn_login_fb = findViewById(R.id.btn_login_fb);
        btn_login_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile();
                String Slogin = new String("Facebook");

                Intent i = new Intent(getApplicationContext(), profile.class);
                i.putExtra("value1", Slogin);
                startActivity(i);
            }
        });

        btn_login_gg = findViewById(R.id.btn_signUp_gg);
        btn_login_gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile();
            }
        });

        tv_forgotpassword = (TextView) findViewById(R.id.tv_forgotpassword);
        tv_forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgotpassword();
            }
        });
    }

    public void showText(){

    }

    public void profile(){
        Intent profile = new Intent(MainActivity.this, profile.class);
        startActivity(profile);
    }

    public void register(){
        Intent register = new Intent(MainActivity.this, register.class);
        startActivity(register);
    }

    public void forgotpassword(){
        Intent forgotpassword = new Intent(MainActivity.this,forgotPassword.class);
        startActivity(forgotpassword);
    }

    public void changePassword(){
        Intent changePassword = new Intent(MainActivity.this,changePassword.class);
        startActivity(changePassword);
    }

    private void getView(){

    }

    public void PrintToast(String message){
        Toast.makeText(getApplicationContext(), message,
        Toast.LENGTH_LONG).show();
    }

    public  void setName(){

    }

    private boolean CheckAllFields() {
        if (et_username.length() == 0) {
            et_username.setError("This field is required");
            return false;
        }

        if (et_password.length() == 0) {
            et_password.setError("Password is required");
            return false;
        }
        return false;
    }
}