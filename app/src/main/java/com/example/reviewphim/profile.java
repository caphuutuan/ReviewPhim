package com.example.reviewphim;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class profile extends AppCompatActivity {

    Button btn_logOut;
    TextView tv_fl_fb, tv_fl_ins, tv_email, tv_rules, tv_name, tv_account;
    ImageView img_pen, logoImageView;
    protected int _splashTime = 1000;
    Animation zoom_in, zoom_out;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME="myref";
    private static final String KEY_NAME="name";

    private ScaleGestureDetector scaleGestureDetector;
    private float mScaleFactor = 1.0f;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        overridePendingTransition(R.anim.zoom_in_fade_in, android.R.anim.fade_out);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        initUi();
        initListener();

//        Toast.makeText(getApplicationContext(), "name: "+ tv_name,Toast.LENGTH_LONG).show();
//        if(name !=null){
//            tv_name.setText(name);
//        }

        //chua fix
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if(acct!=null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            tv_name.setText(personName);
            tv_email.setText(personEmail);
        }
    }
    private void initUi(){
        tv_fl_fb = findViewById(R.id.tv_fl_fb);
        btn_logOut = findViewById(R.id.btn_back);
        tv_rules = findViewById(R.id.tv_rules);
        tv_email = findViewById(R.id.tv_email);
        img_pen = findViewById(R.id.img_pen);
        tv_account = findViewById(R.id.tv_account);
        tv_fl_ins = findViewById(R.id.tv_fullName_infor);
        logoImageView = findViewById(R.id.logoImageView);
    }

    private void initListener(){

        btn_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SharedPreferences.Editor editor=sharedPreferences.edit();
//                editor.clear();
//                editor.commit();
                Toast.makeText(getApplicationContext(),"????ng xu???t th??nh c??ng", Toast.LENGTH_SHORT).show();
                signOut();
                finish();
            }
        });

        tv_fl_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                String url = "http://www.facebook.com/charlestuan1214";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        tv_fl_ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                String url = "https://www.instagram.com/charles.tuna/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        tv_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                String url = "mailto:caphuutuan1@gmail.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        tv_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                String url = "tel:0398272747";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        tv_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                account();
            }
        });

        img_pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeName();
            }
        });

        logoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               zoom_out= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
//               logoImageView.setVisibility(View.VISIBLE);
//               logoImageView.startAnimation(zoom_out);
            }
        });
    }

    public boolean logOut() {
        Intent logOut = new Intent(profile.this, HomeActivity.class);
        startActivity(logOut);
        return false;
    }

    void signOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(profile.this, HomeActivity.class));
            }
        });
    }

    public void account() {
        Intent account = new Intent(profile.this, account.class);
        startActivity(account);
    }

    public void changeName() {
        Intent changeName = new Intent(getApplicationContext(), profile.class);
        startActivity(changeName);
    }
}