package com.melonkoding.blogapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.melonkoding.blogapp.models.responses.PostResponse;
import com.melonkoding.blogapp.repositories.PostRepository;

public class PostViewModel extends ViewModel {

    private PostRepository postRepository;
    private LiveData<PostResponse[]> posts;

    public PostViewModel() {
        postRepository = new PostRepository();
        posts = postRepository.getAllPosts();
    }

    public LiveData<PostResponse[]> getAllPosts() {
        return posts;
    }
}
