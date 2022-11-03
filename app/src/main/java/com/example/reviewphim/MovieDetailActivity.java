package com.example.reviewphim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView movieThumbnailImg, detail_cover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_movie_detail);

        String movieName = getIntent().getExtras().getString("name");
        int imageResourceId = getIntent().getExtras().getInt("poster");
        movieThumbnailImg = findViewById(R.id.detail_img);
        movieThumbnailImg.setImageResource(imageResourceId);
        movieThumbnailImg = findViewById(R.id.detail_cover);
        movieThumbnailImg.setImageResource(imageResourceId);
    }
}