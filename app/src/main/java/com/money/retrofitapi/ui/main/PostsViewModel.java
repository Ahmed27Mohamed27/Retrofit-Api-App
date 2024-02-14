package com.money.retrofitapi.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.money.retrofitapi.data.PostsClient;
import com.money.retrofitapi.data.PostsInterface;
import com.money.retrofitapi.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsViewModel extends ViewModel {
    MutableLiveData<List<PostModel>> mutableLiveData = new MutableLiveData<>();

    public void getPosts() {
        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });
    }

}
