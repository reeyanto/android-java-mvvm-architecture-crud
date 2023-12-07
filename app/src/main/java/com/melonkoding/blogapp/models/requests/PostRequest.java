package com.melonkoding.blogapp.models.requests;

public class PostRequest {

    private String title, description;

    public PostRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
