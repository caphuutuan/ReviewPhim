package com.example.reviewphim.model;

public class RecommendMovie {

    String name, category, releaseDate, rate;
    Integer poster;

    public RecommendMovie(String name, String category, String releaseDate, String rate, Integer poster) {
        this.name = name;
        this.category = category;
        this.releaseDate = releaseDate;
        this.rate = rate;
        this.poster = poster;
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

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getPoster() {
        return poster;
    }

    public void setPoster(Integer poster) {
        this.poster = poster;
    }
}
