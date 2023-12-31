package com.melonkoding.blogapp.services;

import com.melonkoding.blogapp.models.requests.PostRequest;
import com.melonkoding.blogapp.models.responses.PostResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PostService {

    @GET("/api/posts")
    Call<List<PostResponse>> getAllPosts();

    @POST("/api/posts")
    Call<PostResponse> storePost(@Body PostRequest postRequest);

    @DELETE("/api/posts/{id}")
    Call<PostResponse> destroyPost(@Path("id") int postId);

    @PUT("/api/posts/{id}")
    Call<PostResponse> updatePost(@Path("id") int postId, @Body PostRequest postRequest);
}
