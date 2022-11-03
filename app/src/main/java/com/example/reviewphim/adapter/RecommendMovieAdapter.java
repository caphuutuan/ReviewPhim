package com.example.reviewphim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.reviewphim.R;
import com.example.reviewphim.model.RecommendMovie;

import java.util.List;

public class RecommendMovieAdapter extends RecyclerView.Adapter<RecommendMovieAdapter.RecommendMovieViewHolder> {

    private Context mContext;
    private List<RecommendMovie> recommendMovieList;

    public RecommendMovieAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<RecommendMovie> list) {
        this.recommendMovieList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecommendMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_movie_item, parent, false);
        return new RecommendMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendMovieViewHolder holder, int position) {
        RecommendMovie recommendMovie = recommendMovieList.get(position);
        if (recommendMovie == null){
            return;
        }

        holder.image_Poster.setImageResource(recommendMovie.getPoster());
        holder.tv_name.setText(recommendMovie.getName());
        holder.tv_category.setText(recommendMovie.getCategory());
        holder.tv_release_date.setText(recommendMovie.getReleaseDate());
        holder.tv_rating.setText(recommendMovie.getRate());

    }

    @Override
    public int getItemCount() {
        if (recommendMovieList != null) {
            return recommendMovieList.size();
        }
        return 0;
    }

    public class RecommendMovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_Poster;
        private TextView tv_name, tv_category, tv_release_date, tv_rating;


        public RecommendMovieViewHolder(@NonNull View itemView) {
            super(itemView);

            image_Poster = itemView.findViewById(R.id.img_poster);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_category = itemView.findViewById(R.id.tv_category);
            tv_release_date = itemView.findViewById(R.id.tv_release_date);
            tv_rating = itemView.findViewById(R.id.tv_rating);

        }
    }

}
