package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        try{
            this.deleteDatabase("DBQuizApp.db");
            Toast.makeText(SupportActivity.this,"Success",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(SupportActivity.this,"Fail",Toast.LENGTH_LONG).show();
        }

        //context.deleteDatabase();
    }
}