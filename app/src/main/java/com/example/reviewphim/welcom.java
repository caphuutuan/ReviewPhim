package com.example.reviewphim;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

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