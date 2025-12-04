package com.example.streamplayerapp.model;

public class Movie {
    private String id;
    private String title;
    private String posterUrl;
    private String streamUrl;
    private String description;
    private String year;
    private String genre;
    private boolean isFavorite;

    public Movie(String id, String title, String posterUrl, String streamUrl, String description, String year, String genre) {
        this.id = id;
        this.title = title;
        this.posterUrl = posterUrl;
        this.streamUrl = streamUrl;
        this.description = description;
        this.year = year;
        this.genre = genre;
        this.isFavorite = false;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }

    public String getStreamUrl() { return streamUrl; }
    public void setStreamUrl(String streamUrl) { this.streamUrl = streamUrl; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public boolean isFavorite() { return isFavorite; }
    public void setFavorite(boolean favorite) { isFavorite = favorite; }
}