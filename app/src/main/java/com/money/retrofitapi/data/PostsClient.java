package com.money.retrofitapi.data;

import com.money.retrofitapi.pojo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private PostsInterface postsInterface;
    private static PostsClient INSTANCE;

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        postsInterface = retrofit.create(PostsInterface.class);
    }

    public static PostsClient getINSTANCE() {
        if (INSTANCE == null) {
            return INSTANCE = new PostsClient();
        }
        return INSTANCE;
    }

    public Observable<List<PostModel>> getPosts() {
        return postsInterface.getPosts();
    }

}
