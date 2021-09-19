package com.emad.posts_app.network;

import com.emad.posts_app.models.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface PostInterface {
	
	@GET("posts")
	public Call<List<PostModel>> getPosts();
}
