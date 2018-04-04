package com.kokomusoft.panticul.listAdapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kokomusoft.panticul.model.Post;

import java.util.List;

/**
 * Created by Gabriel on 25/04/2015.
 */
public class PostAdapter extends BaseAdapter {
    protected Activity activity;
    private List<Post> posts;

    public PostAdapter(Activity activity, List<Post> posts) {
        this.activity = activity;
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return posts.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    private static class PostViewHolder {
        public ImageView newsThumbnail;
        public TextView newsTitle;
        public TextView numberOfComments;
        public TextView newsDate;
        public TextView newsPreview;

    }
}
