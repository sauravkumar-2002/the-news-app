package com.example.all_news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.all_news.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding1=ActivityMainBinding.inflate(getLayoutInflater());
        View v=binding1.getRoot();
        setContentView(v);
        binding1.tv.setText("bhbhbhbhbhbhbhb");
        binding1.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,dashboard.class);
                startActivity(intent);
            }
        });
    }
}