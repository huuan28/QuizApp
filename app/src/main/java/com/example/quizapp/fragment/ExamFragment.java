package com.example.quizapp.fragment;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.quizapp.AddExamActivity;
import com.example.quizapp.MainActivity;
import com.example.quizapp.R;
import com.example.quizapp.model.User;

public class ExamFragment extends Fragment {
    User user;
    View view;
    SQLiteDatabase db;
    MainActivity activity;
    Button btnLetAddExam;
    public ExamFragment() {
        // Required empty public constructor
    }

    public static ExamFragment newInstance(String param1, String param2) {
        ExamFragment fragment = new ExamFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_exam, container, false);
        Init();
        Events();
        return view;
    }

    private void Events() {
        btnLetAddExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(activity, AddExamActivity.class);
                it.putExtra("user",user);
                startActivityForResult(it,12);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==12&&resultCode==12){
            Toast.makeText(activity, "Ban vua tao thanh cong",Toast.LENGTH_LONG).show();
        }
        else {

        }
    }

    private void Init() {
        activity = (MainActivity) getActivity();
        user = activity.getUser();
        db = activity.getDb();
        btnLetAddExam = view.findViewById(R.id.btnLetAddExam);
    }
}