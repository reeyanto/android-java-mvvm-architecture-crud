package com.melonkoding.blogapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.melonkoding.blogapp.R;
import com.melonkoding.blogapp.models.responses.PostResponse;

public class PostAdapter extends BaseAdapter {

    private Context context;
    private PostResponse[] postResponses;

    public PostAdapter(Context context, PostResponse[] postResponses) {
        this.context = context;
        this.postResponses = postResponses;
    }

    @Override
    public int getCount() {
        return postResponses.length;
    }

    @Override
    public Object getItem(int i) {
        return postResponses[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View postView = inflater.inflate(R.layout.post_item, viewGroup, false);

        // init
        TextView tvTitle = postView.findViewById(R.id.tv_title);
        TextView tvDescription = postView.findViewById(R.id.tv_description);

        // set value
        tvTitle.setText(postResponses[i].getTitle());
        tvDescription.setText(postResponses[i].getDescription());

        return postView;
    }
}
