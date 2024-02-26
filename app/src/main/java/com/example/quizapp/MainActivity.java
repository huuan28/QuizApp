package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quizapp.fragment.AccountFragment;
import com.example.quizapp.fragment.ExamFragment;
import com.example.quizapp.fragment.HistoryFragment;
import com.example.quizapp.fragment.HomeFragment;
import com.example.quizapp.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    User user;
    Intent intent;
    BottomNavigationView mainMenu;
    SQLiteDatabase db;

    public SQLiteDatabase getDb() {
        return db;
    }

    public User getUser() {
        return user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        fakeData();
        Events();
    }
    private void fakeData() {
        Cursor c = db.query("tbUser", null, null, null, null, null, null);
        if(c.getCount()>0) {
            c.moveToNext();
            String id = c.getString(0);
            String pw = c.getString(2);
            String name = c.getString(1);
            String gender = c.getString(3);
            String birth = c.getString(4);
            String email = c.getString(5);
            int avt = c.getInt(6);
            user = new User(id, name, pw, gender, birth, email, avt);
        }
        c.close();
    }

    private void Events() {
        mainMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fm;
                if(item.getItemId() == R.id.main_home){
                    fm =new HomeFragment();
                    LoadFragment(fm);
                    return true;
                }
                if(item.getItemId() == R.id.main_exam){
                    fm =new ExamFragment();
                    LoadFragment(fm);
                    return true;
                }
                if(item.getItemId() == R.id.main_history){
                    fm =new HistoryFragment();
                    LoadFragment(fm);
                    return true;
                }
                if(item.getItemId() == R.id.main_account){
                    fm =new AccountFragment();
                    LoadFragment(fm);
                    return true;
                }
                return false;
            }
        });
    }

    private void LoadFragment(Fragment fm) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainFrame, fm);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void Init() {
        //intent = getIntent();
        //user = (User) intent.getSerializableExtra("user");
        db = openOrCreateDatabase("DBQuizApp.db",MODE_PRIVATE,null);
        mainMenu =findViewById(R.id.main_menu);
    }

}