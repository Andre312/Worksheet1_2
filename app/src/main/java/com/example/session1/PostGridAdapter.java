package com.example.session1;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PostGridAdapter extends ArrayAdapter<Post> {
    private List<Post> myPost;
    private Context myContext;

    public PostGridAdapter(Context context, List<Post> objects) {
        super(context, R.layout.adapter_view_layout, objects);
        myContext = context;
        myPost = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View gridView = convertView;
        List<Post> storedPosts;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.adapter_view_layout, null);
        }

        ImageView imageView = (ImageView)gridView.findViewById(R.id.iv_customGrid);
        imageView.setImageURI(Uri.parse(myPost.get(position).imageDirectory));

        TextView textView = (TextView)gridView.findViewById(R.id.tv_customText);
        textView.setText(myPost.get(position).title);

        return gridView;
    }
}
