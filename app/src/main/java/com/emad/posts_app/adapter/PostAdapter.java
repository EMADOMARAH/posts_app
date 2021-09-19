package com.emad.posts_app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emad.posts_app.R;
import com.emad.posts_app.models.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
	private ArrayList<PostModel> postList = new ArrayList<>();
	
	
	@NonNull
	@Override
	public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
	}
	
	@Override
	public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
		
		holder.titleTV.setText(postList.get(position).getTitle());
		holder.bodyTV.setText(postList.get(position).getBody());
		holder.userTV.setText(postList.get(position).getUserId()  +" ");
	}
	
	public void setPostList(ArrayList<PostModel> postList) {
		this.postList = postList;
		notifyDataSetChanged();
	}
	
	@Override
	public int getItemCount() {
		return postList.size();
	}
	
	public class PostViewHolder extends RecyclerView.ViewHolder {
		TextView titleTV , userTV , bodyTV ;
		
		public PostViewHolder(@NonNull View itemView) {
			super(itemView);
			
			titleTV = itemView.findViewById(R.id.titleTV);
			userTV = itemView.findViewById(R.id.userIDTV);
			bodyTV = itemView.findViewById(R.id.bodyTV);
			
			
		}
	}
}

