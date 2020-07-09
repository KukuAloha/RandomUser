package com.example.randomuser;

import com.example.randomuser.data.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {
    @GET("/api")
    Call<User> getResult();
}
