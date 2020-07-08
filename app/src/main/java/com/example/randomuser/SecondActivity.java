package com.example.randomuser;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        //return back to main menu but it reload activity and api
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
