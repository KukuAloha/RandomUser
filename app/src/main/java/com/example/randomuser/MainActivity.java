package com.example.randomuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.randomuser.data.Result;
import com.example.randomuser.data.User;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button button;
    //private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       getAllUsers();
    }


    public void getAllUsers() {

        RetrofitApi retrofitApi = RetrofitModule.getUserResponse().create(RetrofitApi.class);
        Call<User> call = retrofitApi.getResult();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                button = findViewById(R.id.restart_button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        recreate();
                    }
                });
                generateResultData(response.body().getResults());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
            }

        });
     }

    private void generateResultData(List<Result> results) {
        RecyclerView recyclerView = findViewById(R.id.random_user_rv);
        ResultAdapter resultAdapter = new ResultAdapter(results, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this
                /*LinearLayoutManager.VERTICAL,false*/);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(resultAdapter);
    }

}