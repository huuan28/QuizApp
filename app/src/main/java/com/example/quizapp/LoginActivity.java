package com.example.quizapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.model.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
        //---------Components-----------
    TextView txtRegister, txtForgotPs;
    EditText edtUserID,edtPw;
    Button btnLogin;
    CheckBox cbRememberPw;
    //-----------------------------//

        //------Database define------
    String DATABASE_NAME = "DBQuizApp.db";
    String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database = null;
    //-----------------------------//
        //------data field-------
    String id, pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DatabseSetup();
        Init();
        AddEvent();
    }

    private void AddEvent() {
        // Sự kiện đăng nhập
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadInfo();
                String selection = "id = ? AND password = ?";
                Cursor c = database.query("tbUser", null, selection, new String[]{id,pw}, null, null, null);
                if(c.getCount()>0) {
                    c.moveToNext();
                    String name = c.getString(1);
                    String gender = c.getString(3);
                    String birth = c.getString(4);
                    String email = c.getString(5);
                    int avt = c.getInt(6);
                    User user = new User(id, name, pw, gender, birth, email, avt);
                    Intent it = new Intent(LoginActivity.this, MainActivity.class);
                    it.putExtra("user", user);
                    startActivity(it);
                }
                c.close();
            }
        });
        // Sự kiện đăng ký
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(it,11);
            }
        });
        txtForgotPs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Quên mật khẩu
            }
        });
    }

    private void LoadInfo() {
        id = edtUserID.getText().toString();
        pw = edtPw.getText().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==11&&resultCode==11){
            id = data.getStringExtra("id");
            pw = data.getStringExtra("pw");
            edtUserID.setText(id);
            edtPw.setText(pw);
        }
    }
    private void Init() {
        edtUserID = findViewById(R.id.edtUserID);
        edtPw = findViewById(R.id.edtPw);
        txtForgotPs = findViewById(R.id.txtForgotPw);
        txtRegister = findViewById(R.id.txtRegister);
        btnLogin = findViewById(R.id.btnLogin);
        cbRememberPw = findViewById(R.id.cbRememberPw);
        database = openOrCreateDatabase("DBQuizApp.db",MODE_PRIVATE,null);
    }

    private void DatabseSetup() {
        File dbFile = getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists()) {
            try {
                CopyDataBaseFromAsset();
                Toast.makeText(this, "Copying sucess from Assets folder",
                        Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, "Database is Exist", Toast.LENGTH_LONG).show();
        }
    }
    public void CopyDataBaseFromAsset() {
        // TODO Auto-generated method stub
        try {
            InputStream myInput;
            myInput = getAssets().open(DATABASE_NAME);
            // Path to the just created empty db
            String outFileName = getDatabasePath();
            // if the path doesn't exist first, create it
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists())
                f.mkdir();
            // Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);
            // transfer bytes from the inputfile to the outputfile
            // Truyền bytes dữ liệu từ input đến output
            int size = myInput.available();
            byte[] buffer = new byte[size];
            myInput.read(buffer);
            myOutput.write(buffer);
            // Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private String getDatabasePath() {
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
    }
}