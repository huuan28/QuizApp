package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quizapp.model.User;

public class MainActivity extends AppCompatActivity {
    User user;
    Intent intent;

    ImageView avt;
    TextView txtName;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }

    private void Init() {
        intent = getIntent();
        user = (User) intent.getSerializableExtra("user");
        avt = findViewById(R.id.avt);
        //int y = user.getAvatar();
        int y = R.drawable.avt_default;
        avt.setImageResource(R.drawable.avt_default);
        Glide.with(this)
                .load(y)
                .circleCrop()
                .into(avt);
        txtName = findViewById(R.id.txtName);
        txtName.setText(user.getName());
    }

}