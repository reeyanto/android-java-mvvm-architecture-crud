package com.melonkoding.blogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.melonkoding.blogapp.adapters.PostAdapter;
import com.melonkoding.blogapp.models.responses.PostResponse;
import com.melonkoding.blogapp.viewmodels.PostViewModel;

public class MainActivity extends AppCompatActivity {

    PostResponse[] responses;
    PostAdapter postAdapter;

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
                postAdapter = new PostAdapter(getApplicationContext(), responses);
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

        lvPosts.setOnItemLongClickListener((adapterView, view, i, l) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Data Operation")
                .setMessage("Please select data operation for \""+ responses[i].getTitle() + "\"")
                .setPositiveButton(R.string.delete, (dialogInterface, i1) -> {
                    postViewModel.destroyPost(responses[i].getId()).observe(this, postResponse -> {
                        if (postResponse != null) {
                            Toast.makeText(this, "Data deleted!", Toast.LENGTH_SHORT).show();
                        }
                    });
                })
                .setNegativeButton(R.string.update, (dialogInterface, i12) -> {
                    Intent intent = new Intent(this, EditPostActivity.class);
                    intent.putExtra("POST", responses[i]);
                    startActivity(intent);
                })
                .show();
                return true;
        });

        fabAdd.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddPostActivity.class);
            startActivity(intent);
        });
    }
}