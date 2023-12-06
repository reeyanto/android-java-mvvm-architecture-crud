package com.melonkoding.blogapp.services;

import com.melonkoding.blogapp.models.responses.PostResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {

    @GET("/api/posts")
    Call<PostResponse[]> getAllPosts();
}
