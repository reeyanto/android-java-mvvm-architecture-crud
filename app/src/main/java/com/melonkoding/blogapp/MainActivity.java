package com.melonkoding.blogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.melonkoding.blogapp.adapters.PostAdapter;
import com.melonkoding.blogapp.viewmodels.PostViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvPosts = findViewById(R.id.lv_posts);
        ProgressBar pbProgress = findViewById(R.id.pb_progress);
        PostViewModel postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

        postViewModel.getAllPosts().observe(this, postResponses -> {
            if (postResponses != null) {
                PostAdapter postAdapter = new PostAdapter(getApplicationContext(), postResponses);
                postAdapter.notifyDataSetChanged();
                lvPosts.setAdapter(postAdapter);
                pbProgress.setVisibility(View.GONE);
            }
        });
    }
}