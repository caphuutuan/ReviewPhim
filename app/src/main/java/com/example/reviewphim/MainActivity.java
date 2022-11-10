package com.example.reviewphim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Key;
import java.util.Random;
import java.util.UUID;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class MainActivity extends AppCompatActivity {

    private Button btn_login, btn_signUp, btn_login_fb, btn_login_gg;
    private EditText et_username, et_password;
    private TextView tv_result, tv_forgotpassword, tv_signUp, tv_test;
    private Context context;
    private ProgressBar progressBar;
    private CheckBox checkBox;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME="myref";
    private static final String KEY_NAME="name";

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    protected int _splashTime = 1500;
    boolean isAllFieldsChecked = false;

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://flshop-59363-default-rtdb.firebaseio.com/");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        overridePendingTransition(android.R.anim.slide_in_left, R.anim.zoom_out_fade_out);

        initUi();
        initListener();
        context = this;

        // lay thong tin dang nhap dua vao profile
//        sharedPreferences =getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//
//        String name = sharedPreferences.getString(KEY_NAME,null);
//        if(name !=null){
//            Intent i = new Intent(getApplicationContext(), HomeActivity.class);
//            startActivity(i);
//        }

//        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        sp.edit().putString(KEY_NAME, et_username.getText().toString().trim()).commit();

        //luu dang nhap
        sharedPreferences=getSharedPreferences("dataLogin", MODE_PRIVATE);

        et_username.setText(sharedPreferences.getString("taikhoan",""));
        et_password.setText(sharedPreferences.getString("matkhau",""));
        checkBox.setChecked(sharedPreferences.getBoolean("checked",false));

    }

    private void initUi() {
        et_username =findViewById(R.id.et_username);
        et_password =findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        tv_test = findViewById(R.id.tv_test);
        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        tv_signUp = (TextView) findViewById(R.id.tv_loginNow);
        tv_forgotpassword = (TextView) findViewById(R.id.tv_forgotpassword);
        btn_login_gg = findViewById(R.id.btn_signUp_gg);
        btn_login_fb = findViewById(R.id.btn_login_fb);
        checkBox = findViewById(R.id.checkBox);
    }

    private void initListener() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                if(TextUtils.isEmpty(username)){
                    et_username.setError("Vui lòng nhập lại");
                }
                else if(TextUtils.isEmpty(password)){
                    et_password.setError("Vui lòng nhập lại");
                }
                else {
                    databaseReference.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(username)){
                                String getPassword = snapshot.child(username).child("password").getValue(String.class);
                                if(getPassword.equals(password)){

//                                    //editor : lay thong tin dang nhap
//                                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                                    editor.putString(KEY_NAME, et_username.getText().toString().trim());
//                                    editor.apply();

                                    Toast.makeText(MainActivity.this,"Đăng nhập thành công !",Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(MainActivity.this,profile.class));
                                    finish();
                                    //luu username nhap vao neu co checkbox
                                    if(checkBox.isChecked()){
                                        //editor : lay thong tin dang nhap
                                        SharedPreferences.Editor editor1 =sharedPreferences.edit();
                                        editor1.putString("taikhoan", username);
                                        editor1.putString("matkhau", password);
                                        editor1.putBoolean("checked", true);
                                        editor1.commit();

                                        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME ,Context.MODE_PRIVATE);
                                    }
                                    else{
                                        SharedPreferences.Editor editor1 =sharedPreferences.edit();
                                        editor1.remove("taikhoan");
                                        editor1.remove("matkhau");
                                        editor1.remove("checked");
                                        editor1.commit();
                                    }
                                }else {
                                    Toast.makeText(MainActivity.this,"Mật khẩu không đúng!",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(MainActivity.this,"Username hoặc Password không đúng !",Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {}
                    });
                }
            }
        });

        tv_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

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

        btn_login_gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile();
            }
        });

        tv_forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgotpassword();
            }
        });
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