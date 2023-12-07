package com.melonkoding.blogapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.window.OnBackInvokedDispatcher;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.melonkoding.blogapp.adapters.PostAdapter;
import com.melonkoding.blogapp.models.responses.PostResponse;
import com.melonkoding.blogapp.viewmodels.PostViewModel;

public class MainActivity extends AppCompatActivity {

    PostResponse[] responses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvPosts = findViewById(R.id.lv_posts);
        ProgressBar pbProgress = findViewById(R.id.pb_progress);
        FloatingActionButton fabAdd = findViewById(R.id.fab_add);
        PostViewModel postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

        postViewModel.getAllPosts().observe(this, postResponses -> {
            if (postResponses != null) {
                responses = postResponses;
                PostAdapter postAdapter = new PostAdapter(getApplicationContext(), responses);
                postAdapter.notifyDataSetChanged();
                lvPosts.setAdapter(postAdapter);
                pbProgress.setVisibility(View.GONE);
            }
        });

        lvPosts.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(MainActivity.this, DetailPostActivity.class);
            intent.putExtra("POST", responses[i]);
            startActivity(intent);
        });

        fabAdd.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddPostActivity.class);
            startActivity(intent);
        });
    }
}