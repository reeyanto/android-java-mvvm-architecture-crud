package com.melonkoding.blogapp.models.responses;

import com.google.gson.annotations.SerializedName;

public class PostResponse {

    private int id;
    private String title, description;

    @SerializedName("created_at")
    private String createdAt;

    public PostResponse(int id, String title, String description, String createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
