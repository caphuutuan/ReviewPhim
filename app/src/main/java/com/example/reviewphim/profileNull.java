package com.example.reviewphim;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class profileNull extends profile {

    Button btn_login,btn_login_fb, btn_login_gg, btn_back;
    TextView tv_nightMode, tv_rules, tv_securityRules, tv_email, tv_fl_fb, tv_fl_ins;
    protected int _splashTime = 1000;
    protected int _splashTime1 = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilenull);
        getSupportActionBar().hide();
        overridePendingTransition( R.anim.zoom_in_fade_in,android.R.anim.fade_out);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    public void run() {
//                        finish();
//                        Intent i = new Intent(profileNull.this, MainActivity.class);
//                        startActivity(i);
//                    }
//                }, _splashTime);
                Intent i = new Intent(profileNull.this, profile.class);
                startActivity(i);
                finish();
            }
        });

        btn_login_fb = findViewById(R.id.btn_login_fb);
        btn_login_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        finish();
                        Intent i = new Intent(profileNull.this, profile.class);
                        startActivity(i);
                    }
                }, _splashTime);
            }
        });

        btn_login_gg = findViewById(R.id.btn_login_gg);
        btn_login_gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        finish();
                        Intent i = new Intent(profileNull.this, profile.class);
                        startActivity(i);
                    }
                }, _splashTime);
            }
        });

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    public void run() {
//                        home();
//                    }
//                },_splashTime1);
                home();
                finish();

            }
        });

        tv_fl_fb=findViewById(R.id.tv_fl_fb);
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

        tv_fl_ins=findViewById(R.id.tv_fl_ins);
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

        tv_email=findViewById(R.id.tv_email);
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

        tv_rules=findViewById(R.id.tv_rules);
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

        tv_securityRules=findViewById(R.id.tv_securityRules);
        tv_securityRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                String url = "tel:0398272747";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }
    public void profile(){
        Intent profile = new Intent(profileNull.this, profile.class);
        startActivity(profile);
    }

    public void home(){
        Intent home = new Intent(profileNull.this, HomeActivity.class);
        startActivity(home);
    }
}