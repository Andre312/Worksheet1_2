package com.example.session1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.activeandroid.util.Log;

import java.util.List;


public class science extends Fragment {
    public science() {
        // Required empty public constructor
    }

    List<Post> storedPosts;
    GridView myGrid;
    PostGridAdapter adapter;
    String tabName;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_science, container, false);
        // Inflate the layout for this fragment
        myGrid = (GridView) view.findViewById(R.id.grid_view_science);
        Log.e("test4", myGrid.toString());
        Log.e("test5", tabName);
        storedPosts = Post.getPosts(tabName);
        Log.e("test6", storedPosts.toString());
        adapter = new PostGridAdapter(getContext(), storedPosts);
        myGrid.setAdapter(adapter);

        return view;
    }
}
