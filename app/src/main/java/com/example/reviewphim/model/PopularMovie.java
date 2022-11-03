package com.example.reviewphim.model;

public class PopularMovie {

    String name, category, releaseDate;
    Integer poster;
    Float rating;

    public PopularMovie(String name, String category, String releaseDate, Integer poster, Float rating) {
        this.name = name;
        this.category = category;
        this.releaseDate = releaseDate;
        this.poster = poster;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getPoster() {
        return poster;
    }

    public void setPoster(Integer poster) {
        this.poster = poster;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
