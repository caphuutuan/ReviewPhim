package com.example.reviewphim;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class changePassword extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
        getSupportActionBar().hide();
        overridePendingTransition(android.R.anim.slide_in_left, R.anim.zoom_out_fade_out);

    }
}
