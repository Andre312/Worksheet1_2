package com.example.session1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.activeandroid.query.Select;
import com.activeandroid.util.Log;

import java.util.List;

public class sports extends Fragment {
    public sports() {
        // Required empty public constructor
    }

    List<Post> storedPosts;
    GridView myGrid;
    PostGridAdapter adapter;
    String tabName;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//            GridView myGrid = (GridView) findViewById(R.id.grid_view);
//            List<Post> storedPosts = Post.getPosts("Sports");
//            PostGridAdapter adapter = new PostGridAdapter(this, R.layout.adapter_view_layout, storedPosts);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sports, container, false);
        // Inflate the layout for this fragment
//        myGrid = (GridView) view.findViewById(R.id.grid_view);
//        Log.e("test4", myGrid.toString());
//        Log.e("test5", tabName);
//        storedPosts = Post.getPosts(tabName);
//        Log.e("test6", storedPosts.toString());
//        adapter = new PostGridAdapter(getContext(), storedPosts);
//        myGrid.setAdapter(adapter);

        return view;
    }
}
