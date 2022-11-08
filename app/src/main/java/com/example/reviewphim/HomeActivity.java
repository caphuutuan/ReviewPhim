package com.example.reviewphim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.reviewphim.adapter.PopularMovieAdapter;
import com.example.reviewphim.adapter.RecommendMovieAdapter;
import com.example.reviewphim.model.MovieOnClickListener;
import com.example.reviewphim.model.PopularMovie;
import com.example.reviewphim.model.RecommendMovie;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity implements MovieOnClickListener {

    private RecyclerView popularRecycler, recommendRecycler;
    private PopularMovieAdapter popularMovieAdapter;
    private RecommendMovieAdapter recommendMovieAdapter;
    private TextView tv_view_more;
    private CircleImageView round_profile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        //Popular List Movie
        List<PopularMovie> popularMovieList = new ArrayList<>();
        popularMovieList.add(new PopularMovie("Duyên ma", "Comedy, Horrified", "August 12, 2022", R.drawable.one, 4.5f));
        popularMovieList.add(new PopularMovie("Ngôi đền kỳ quái 3", "Horrified", "August 12, 2022", R.drawable.ngoiden, 4.8f));
        popularMovieList.add(new PopularMovie("Bố già", "Comedy", "September 2, 2022", R.drawable.three, 4.5f));
        popularMovieList.add(new PopularMovie("Đôi mắt âm dương", "Horrified", "September 2, 2022", R.drawable.four, 4.4f));
        popularMovieList.add(new PopularMovie("Shut In", "Science Fiction", "September 2, 2016", R.drawable.two, 4.8f));

        setPopularRecycler(popularMovieList);
        //Setup Recommend Movie
        recommendRecycler = findViewById(R.id.recommend_recycler);
        recommendMovieAdapter = new RecommendMovieAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recommendRecycler.setLayoutManager(linearLayoutManager);
        recommendMovieAdapter.setData(getListRecommend());
        recommendRecycler.setAdapter(recommendMovieAdapter);

        //Intent ListviewPage
        tv_view_more = findViewById(R.id.tv_view_more);
        tv_view_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ListMovieActivity.class);
                startActivity(intent);

            }
        });

        round_profile = findViewById(R.id.round_profile);
        round_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(HomeActivity.this, profileNull.class);
                startActivity(i);
            }
        });
    }

    private void setPopularRecycler(List<PopularMovie> popularMovieList) {
        popularRecycler = findViewById(R.id.popular_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        popularRecycler.setLayoutManager(layoutManager);
        popularMovieAdapter = new PopularMovieAdapter(this, popularMovieList, this);
        popularRecycler.setAdapter(popularMovieAdapter);
    }

    private List<RecommendMovie> getListRecommend() {
        List<RecommendMovie> recommendMovieList = new ArrayList<>();
        recommendMovieList.add(new RecommendMovie("Spider-Man: No Way Home", "Science Fiction", "August 12, 2022", "4.5", R.drawable.spiderman));
        recommendMovieList.add(new RecommendMovie("Thor: Tình yêu và sấm sét", "Science Fiction", "July 6, 2022", "4.8", R.drawable.thor));
        recommendMovieList.add(new RecommendMovie("Minions: Sự trỗi dậy của Gru", "Science Fiction", "August 12, 2022", "4.6", R.drawable.minions));
        recommendMovieList.add(new RecommendMovie("Resident Evil: Quỷ dữ trỗi dậy", "Horror/Action", "November 24, 2021", "4.7", R.drawable.residenevil));
        recommendMovieList.add(new RecommendMovie("Alive", "Sensational/Drama", "June 24, 2020", "4.6", R.drawable.alive));

        recommendMovieList.add(new RecommendMovie("Spider-Man: No Way Home", "Science Fiction", "August 12, 2022", "4.5", R.drawable.spiderman));
        recommendMovieList.add(new RecommendMovie("Thor: Tình yêu và sấm sét", "Science Fiction", "July 6, 2022", "4.8", R.drawable.thor));
        recommendMovieList.add(new RecommendMovie("Minions: Sự trỗi dậy của Gru", "Science Fiction", "August 12, 2022", "4.6", R.drawable.minions));
        recommendMovieList.add(new RecommendMovie("Resident Evil: Quỷ dữ trỗi dậy", "Horror/Action", "November 24, 2021", "4.7", R.drawable.residenevil));
        recommendMovieList.add(new RecommendMovie("Alive", "Sensational/Drama", "June 24, 2020", "4.6", R.drawable.alive));

        recommendMovieList.add(new RecommendMovie("Spider-Man: No Way Home", "Science Fiction", "August 12, 2022", "4.5", R.drawable.spiderman));
        recommendMovieList.add(new RecommendMovie("Thor: Tình yêu và sấm sét", "Science Fiction", "July 6, 2022", "4.8", R.drawable.thor));
        recommendMovieList.add(new RecommendMovie("Minions: Sự trỗi dậy của Gru", "Science Fiction", "August 12, 2022", "4.6", R.drawable.minions));
        recommendMovieList.add(new RecommendMovie("Resident Evil: Quỷ dữ trỗi dậy", "Horror/Action", "November 24, 2021", "4.7", R.drawable.residenevil));
        recommendMovieList.add(new RecommendMovie("Alive", "Sensational/Drama", "June 24, 2020", "4.6", R.drawable.alive));

        return recommendMovieList;
    }


    @Override
    public void onMovieClick(PopularMovie popularMovie, ImageView movieImageView) {

        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra("name", popularMovie.getName());
        intent.putExtra("poster", popularMovie.getPoster());
        startActivity(intent);

        Toast.makeText(this,  popularMovie.getName(), Toast.LENGTH_LONG).show();
    }
}