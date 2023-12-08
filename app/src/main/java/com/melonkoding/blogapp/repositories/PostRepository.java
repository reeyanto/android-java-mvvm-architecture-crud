package com.melonkoding.blogapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.melonkoding.blogapp.models.requests.PostRequest;
import com.melonkoding.blogapp.models.responses.PostResponse;
import com.melonkoding.blogapp.services.PostService;
import com.melonkoding.blogapp.services.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {

    private PostService postService;

    public PostRepository() {
        postService = RetrofitClient.getInstance().create(PostService.class);
    }

    public LiveData<List<PostResponse>> getAllPosts() {
        MutableLiveData<List<PostResponse>> posts = new MutableLiveData<>();
        postService.getAllPosts().enqueue(new Callback<List<PostResponse>>() {
            @Override
            public void onResponse(Call<List<PostResponse>> call, Response<List<PostResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    posts.setValue(response.body());
                } else {
                    posts.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<PostResponse>> call, Throwable t) {
                posts.setValue(null);
            }
        });
        return posts;
    }

    public LiveData<PostResponse> storePost(PostRequest postRequest) {
        MutableLiveData<PostResponse> post = new MutableLiveData<>();
        postService.storePost(postRequest).enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if (response.isSuccessful()) {
                    post.setValue(response.body());
                } else {
                    post.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                post.setValue(null);
            }
        });
        return post;
    }


    public LiveData<PostResponse> destroyPost(int postId) {
        MutableLiveData<PostResponse> post = new MutableLiveData<>();
        postService.destroyPost(postId).enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if (response.isSuccessful()) {
                    post.setValue(response.body());
                } else {
                    post.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                post.setValue(null);
            }
        });
        return post;
    }

    public LiveData<PostResponse> updatePost(int id, PostRequest postRequest) {
        MutableLiveData<PostResponse> post = new MutableLiveData<>();
        postService.updatePost(id, postRequest).enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if (response.isSuccessful()) {
                    post.setValue(response.body());
                } else {
                    post.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                post.setValue(null);
            }
        });
        return post;
    }
}
