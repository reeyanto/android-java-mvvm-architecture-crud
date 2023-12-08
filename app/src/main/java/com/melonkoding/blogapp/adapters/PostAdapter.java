package com.melonkoding.blogapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.melonkoding.blogapp.R;
import com.melonkoding.blogapp.models.responses.PostResponse;

import java.util.List;

public class PostAdapter extends BaseAdapter {

    private Context context;
    private List<PostResponse> postResponses;

    public PostAdapter(Context context, List<PostResponse> postResponses) {
        this.context = context;
        this.postResponses = postResponses;
    }

    @Override
    public int getCount() {
        return postResponses.size();
    }

    @Override
    public Object getItem(int i) {
        return postResponses.get(i);
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
        tvTitle.setText(postResponses.get(i).getTitle());
        tvDescription.setText(postResponses.get(i).getDescription());

        return postView;
    }
}
