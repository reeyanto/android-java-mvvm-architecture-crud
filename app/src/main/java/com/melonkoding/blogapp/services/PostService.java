package com.melonkoding.blogapp.services;

import com.melonkoding.blogapp.models.requests.PostRequest;
import com.melonkoding.blogapp.models.responses.PostResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostService {

    @GET("/api/posts")
    Call<PostResponse[]> getAllPosts();

    @POST("/api/posts")
    Call<PostResponse> storePost(@Body PostRequest postRequest);
}
