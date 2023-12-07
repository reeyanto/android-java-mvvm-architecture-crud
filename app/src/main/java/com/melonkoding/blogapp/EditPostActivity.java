package com.melonkoding.blogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.melonkoding.blogapp.models.requests.PostRequest;
import com.melonkoding.blogapp.models.responses.PostResponse;
import com.melonkoding.blogapp.viewmodels.PostViewModel;

public class EditPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);

        EditText etTitle = findViewById(R.id.et_title);
        EditText etDescription = findViewById(R.id.et_description);
        Button btnUpdate = findViewById(R.id.btn_update);
        Button btnCancel = findViewById(R.id.btn_cancel);

        PostViewModel postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

        PostResponse post = getIntent().getParcelableExtra("POST");
        if (post != null) {
            etTitle.setText(post.getTitle());
            etDescription.setText(post.getDescription());
        }

        btnUpdate.setOnClickListener(view -> {
            PostRequest postRequest = new PostRequest(etTitle.getText().toString(), etDescription.getText().toString());
            postViewModel.updatePost(post.getId(), postRequest).observe(this, postResponse -> {
                if (postResponse != null) {
                    Toast.makeText(EditPostActivity.this, "Data updated!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                }
            });
        });

        btnCancel.setOnClickListener(view -> {
            getOnBackPressedDispatcher().onBackPressed();
        });
    }
}