package com.example.randomuser;

import android.util.Log;
import android.widget.Toast;

import com.example.randomuser.data.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModule {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://randomuser.me";

    public static Retrofit getUserResponse() {
        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
