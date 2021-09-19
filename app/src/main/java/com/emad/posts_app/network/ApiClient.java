package com.emad.posts_app.network;

import android.util.Log;

import com.emad.posts_app.models.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
	private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
	
	private PostInterface postInterface ;
	
	private static ApiClient INSTANCE ;
	
	public ApiClient() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		postInterface = retrofit.create(PostInterface.class);
	}
	
	public static ApiClient getINSTANCE() {
		
		if (null == INSTANCE){
			INSTANCE = new ApiClient();
		}
		return INSTANCE;
	}
	
	public Call<List<PostModel>> getPosts(){
		Log.d("RR"  ,  "KAK");
		return postInterface.getPosts();
	}
}
