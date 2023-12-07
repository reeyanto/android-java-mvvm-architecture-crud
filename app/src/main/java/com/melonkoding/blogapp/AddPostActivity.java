package com.melonkoding.blogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.melonkoding.blogapp.models.requests.PostRequest;
import com.melonkoding.blogapp.models.responses.PostResponse;
import com.melonkoding.blogapp.viewmodels.PostViewModel;

public class AddPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        EditText etTitle = findViewById(R.id.et_title);
        EditText etDescription = findViewById(R.id.et_description);
        Button btnSave = findViewById(R.id.btn_save);
        Button btnCancel = findViewById(R.id.btn_cancel);

        PostViewModel postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

        btnSave.setOnClickListener(view -> {
            if (etTitle.getText().toString().trim().length() == 0) {
                Toast.makeText(this, "Please fill title fields!", Toast.LENGTH_SHORT).show();
                etTitle.requestFocus();
            } else if (etDescription.getText().toString().trim().length() == 0){
                Toast.makeText(this, "Please fill description fields!", Toast.LENGTH_SHORT).show();
                etDescription.requestFocus();
            } else {
                PostRequest postRequest = new PostRequest(etTitle.getText().toString(), etDescription.getText().toString());
                postViewModel.storePost(postRequest).observe(this, postResponse -> {
                    if (postResponse != null) {
                        Toast.makeText(this, "New post added!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddPostActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(this, "Error while adding new post!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btnCancel.setOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());
    }
}