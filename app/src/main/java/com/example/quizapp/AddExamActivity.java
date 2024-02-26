package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quizapp.model.Exam;
import com.example.quizapp.model.User;

public class AddExamActivity extends AppCompatActivity {
    User user;
    SQLiteDatabase db;
    Intent intent;
    EditText edtExamCode, edtExamTitle, edtExamTopic;
    Button btnAddExam,btnAddExamBack;
    Exam exam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam);
        Init();
        Events();
    }

    private void Events() {
        btnAddExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String made = edtExamCode.getText().toString();
                String tit = edtExamTitle.getText().toString();
                String topic = edtExamTopic.getText().toString();
                String cre = user.getId();
                ContentValues cv = new ContentValues();
                cv.put("code",made);
                cv.put("title",tit);
                cv.put("topic",topic);
                cv.put("creator",cre);
                exam = new Exam(made,tit, topic, cre);
                if(db.insert("tbExam",null,cv)!=-1){
                    setResult(12,intent);
                    finish();
                }
                else {
                    Toast.makeText(AddExamActivity.this,"Add that bai",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnAddExamBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(13, intent);
                finish();
            }
        });
    }

    private void Init() {
        edtExamCode= findViewById(R.id.edtExamCode);
        edtExamTitle= findViewById(R.id.edtExamTitle);
        edtExamTopic= findViewById(R.id.edtExamTopic);
        btnAddExam= findViewById(R.id.btnAddExam);
        btnAddExamBack= findViewById(R.id.btnAddExamBack);
        intent = getIntent();
        db = openOrCreateDatabase("DBQuizApp.db",MODE_PRIVATE,null);
        user = (User)intent.getSerializableExtra("user");
    }
}