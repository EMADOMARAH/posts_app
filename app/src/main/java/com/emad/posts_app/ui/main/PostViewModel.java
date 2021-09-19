package com.emad.posts_app.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.emad.posts_app.models.PostModel;
import com.emad.posts_app.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
	
	MutableLiveData<List<PostModel>> postMutableLiveData = new MutableLiveData<>();
	
	public void getPosts(){
		ApiClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostModel>>() {
			@Override
			public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
				postMutableLiveData.setValue(response.body());
			}
			
			@Override
			public void onFailure(Call<List<PostModel>> call, Throwable t) {
				Log.d("error" , t.toString());
			}
		});
	}




}
