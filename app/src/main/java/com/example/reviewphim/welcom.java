package com.example.reviewphim;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;

public class welcom extends MainActivity {

    protected boolean _active = true;
    protected int _splashTime = 2000;
    boolean isAllFieldsChecked = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcom);
        getSupportActionBar().hide();
        overridePendingTransition(R.anim.zoom_in_fade_in, R.anim.fade_out);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
                Intent i = new Intent(welcom.this, HomeActivity.class);
                startActivity(i);
            }
        }, _splashTime);
    }
}