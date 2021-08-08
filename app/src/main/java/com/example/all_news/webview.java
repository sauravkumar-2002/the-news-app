package com.example.all_news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.all_news.databinding.ActivityWebviewBinding;

public class webview extends AppCompatActivity {
ActivityWebviewBinding binding;
String weburl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWebviewBinding.inflate(getLayoutInflater());
        View v=binding.getRoot();
        setContentView(v);
        Intent intent=getIntent();
        weburl=intent.getStringExtra("url");
        binding.mywebview.loadUrl(weburl);
    }
}