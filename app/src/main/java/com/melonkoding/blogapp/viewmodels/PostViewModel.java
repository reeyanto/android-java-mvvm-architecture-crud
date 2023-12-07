package com.melonkoding.blogapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.melonkoding.blogapp.models.requests.PostRequest;
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

    public LiveData<PostResponse> storePost(PostRequest postRequest) {
        return postRepository.storePost(postRequest);
    }

    public LiveData<PostResponse> destroyPost(int postId) {
        return postRepository.destroyPost(postId);
    }

    public LiveData<PostResponse> updatePost(int postId, PostRequest postRequest) {
        return postRepository.updatePost(postId, postRequest);
    }
}
