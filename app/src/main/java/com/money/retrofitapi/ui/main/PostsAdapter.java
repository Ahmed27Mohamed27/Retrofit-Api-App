package com.money.retrofitapi.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import com.money.retrofitapi.R;
import com.money.retrofitapi.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewModel> {

    private List<PostModel> PostModel = new ArrayList<>();

    @NonNull
    @Override
    public PostViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewModel(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewModel holder, int position) {
        holder.titleTV.setText(PostModel.get(position).getTitle());
        holder.bodyTV.setText(PostModel.get(position).getBody());
        holder.userIdTV.setText(PostModel.get(position).getUserId()+"");
    }

    @Override
    public int getItemCount() {
        return PostModel.size();
    }

    public void setList(List<PostModel> PostModel) {
        this.PostModel = PostModel;
        notifyDataSetChanged();
    }

    public class PostViewModel extends RecyclerView.ViewHolder {
        TextView titleTV, bodyTV, userIdTV;
        public PostViewModel(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            userIdTV = itemView.findViewById(R.id.userIdTV);
            bodyTV = itemView.findViewById(R.id.bodyTV);
        }
    }
}