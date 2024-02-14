package com.money.retrofitapi.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.money.retrofitapi.R;
import com.money.retrofitapi.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostsViewModel postsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);
        postsViewModel.getPosts();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        PostsAdapter adapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        postsViewModel.mutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });

    }
}