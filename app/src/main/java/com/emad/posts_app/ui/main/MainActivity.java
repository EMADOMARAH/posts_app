package com.emad.posts_app.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.emad.posts_app.R;
import com.emad.posts_app.adapter.PostAdapter;
import com.emad.posts_app.models.PostModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	
	PostViewModel postViewModel ;
	RecyclerView recyclerView ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
		
		
		recyclerView = findViewById(R.id.recycler);
		PostAdapter postAdapter = new PostAdapter();
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(postAdapter);
		postViewModel.getPosts();
		//listen to viewModel
		postViewModel.postMutableLiveData.observe(this, new Observer<List<PostModel>>() {
			@Override
			public void onChanged(List<PostModel> postModels) {
				postAdapter.setPostList((ArrayList<PostModel>) postModels);
				Log.d("WE" ,postModels.get(0).getBody().toString());
			}
		});
		
	}
}