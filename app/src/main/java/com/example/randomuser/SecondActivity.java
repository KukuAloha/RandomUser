package com.example.randomuser;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randomuser.data.Result;
import com.example.randomuser.data.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    private InfoAdapter infoAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        //return back to main menu but it reload activity and api
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getAllInfo();
    }

    public void getAllInfo(){
        RetrofitApi retrofitApi = RetrofitModule.getUserResponse().create(RetrofitApi.class);
        Call<User> call = retrofitApi.getResult();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                generateInfoData(response.body().getResults());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(SecondActivity.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

        private void generateInfoData(List<Result> results){
            recyclerView = findViewById(R.id.infoRV);
            infoAdapter = new InfoAdapter(results, this);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SecondActivity.this
                    /*LinearLayoutManager.VERTICAL,false*/);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(infoAdapter);
    }
}
