package com.melonkoding.blogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.melonkoding.blogapp.models.responses.PostResponse;

public class DetailPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);

        TextView tvTitle = findViewById(R.id.tv_title);
        TextView tvDescription = findViewById(R.id.tv_description);
        TextView tvDate = findViewById(R.id.tv_date);

        PostResponse post = getIntent().getParcelableExtra("POST");
        if (post != null) {
            tvTitle.setText(post.getTitle());
            tvDescription.setText(post.getDescription());
            tvDate.setText("Posted at. "+ post.getCreatedAt().substring(0, 10));
        }
    }
}