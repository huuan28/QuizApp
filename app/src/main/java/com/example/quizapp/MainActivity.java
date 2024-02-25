package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.quizapp.model.User;

public class MainActivity extends AppCompatActivity {
    User user;
    Intent intent;

    ImageView avt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }

    private void Init() {
        avt = findViewById(R.id.avt);
        Glide.with(this)
                .load(R.drawable.base_avt)
                .circleCrop()
                .into(avt);
    }

}