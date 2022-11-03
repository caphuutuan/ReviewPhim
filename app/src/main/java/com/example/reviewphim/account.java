package com.example.reviewphim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class account extends AppCompatActivity {

    Button btn_saveChange;


    @Override
    protected void onPostCreate( Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.account);
        getSupportActionBar().hide();
        overridePendingTransition(android.R.anim.slide_in_left, R.anim.zoom_out_fade_out);

        btn_saveChange=findViewById(R.id.btn_saveChange);
        btn_saveChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
    }

    public void back(){
        Intent back = new Intent(getApplicationContext(), profile.class);
        startActivity(back);
    }
}
