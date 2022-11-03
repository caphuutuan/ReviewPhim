package com.example.reviewphim.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.reviewphim.R;
import com.example.reviewphim.model.MovieOnClickListener;
import com.example.reviewphim.model.PopularMovie;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class PopularMovieAdapter extends RecyclerView.Adapter<PopularMovieAdapter.PopularMovieViewHolder> {

    Context context;
    List<PopularMovie> popularMovieList;
    MovieOnClickListener movieOnClickListener;

    public PopularMovieAdapter(Context context, List<PopularMovie> popularMovieList, MovieOnClickListener listener) {
        this.context = context;
        this.popularMovieList = popularMovieList;
        movieOnClickListener = listener;
    }

    @NonNull
    @Override
    public PopularMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_movie_item, parent, false);
        return new PopularMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMovieViewHolder holder, int position) {

        holder.imagePoster.setImageResource(popularMovieList.get(position).getPoster());
        holder.textName.setText(popularMovieList.get(position).getName());
        holder.textCategory.setText(popularMovieList.get(position).getCategory());
        holder.textReleaseDate.setText(popularMovieList.get(position).getReleaseDate());
        holder.ratingBar.setRating(popularMovieList.get(position).getRating());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, MovieDetailActivity.class);
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return popularMovieList.size();
    }

    public class PopularMovieViewHolder extends RecyclerView.ViewHolder {

        TextView textName, textCategory, textReleaseDate;
        RoundedImageView imagePoster;
        RatingBar ratingBar;

        public PopularMovieViewHolder(@NonNull View itemView) {
            super(itemView);

            imagePoster = itemView.findViewById(R.id.imagePoster);
            textName = itemView.findViewById(R.id.textName);
            textCategory = itemView.findViewById(R.id.textCategory);
            textReleaseDate = itemView.findViewById(R.id.textReleaseDate);
            ratingBar = itemView.findViewById(R.id.ratingBar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movieOnClickListener.onMovieClick(popularMovieList.get(getAdapterPosition()), imagePoster);
                }
            });

        }
    }
}
