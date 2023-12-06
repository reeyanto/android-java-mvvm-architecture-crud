package com.melonkoding.blogapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.melonkoding.blogapp.models.responses.PostResponse;
import com.melonkoding.blogapp.services.PostService;
import com.melonkoding.blogapp.services.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {

    private PostService postService;

    public PostRepository() {
        postService = RetrofitClient.getInstance().create(PostService.class);
    }

    public LiveData<PostResponse[]> getAllPosts() {
        MutableLiveData<PostResponse[]> posts = new MutableLiveData<>();
        postService.getAllPosts().enqueue(new Callback<PostResponse[]>() {
            @Override
            public void onResponse(Call<PostResponse[]> call, Response<PostResponse[]> response) {
                if (response.isSuccessful() && response.body() != null) {
                    posts.setValue(response.body());
                } else {
                    posts.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PostResponse[]> call, Throwable t) {
                posts.setValue(null);
            }
        });
        return posts;
    }
}
