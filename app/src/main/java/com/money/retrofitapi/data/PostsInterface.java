package com.money.retrofitapi.data;

import com.money.retrofitapi.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsInterface {
    @GET("posts")
    public Call<List<PostModel>> getPosts();
}
