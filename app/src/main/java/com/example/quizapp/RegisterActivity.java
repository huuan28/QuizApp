package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {
    Intent intent;
    EditText edtUserID_reg, edtPw_reg, edtName, edtConfirmPw;
    TextView txtRules;
    Button btnRegister;
    RadioGroup rgGender;
    SQLiteDatabase db;
    String id, pw, name, confirmPw;
    int gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Init();
        AddEvent();
    }

    private void AddEvent() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetInfo();
                if(CheckFormat()){
                    if(ComparePw()){
                        ContentValues ct = new ContentValues();
                        ct.put("id", id);
                        ct.put("name", name);
                        ct.put("password", pw);
                        ct.put("gender", gender);
                        if (db.insert("tbUser", null, ct) != -1) {
                            Toast.makeText(RegisterActivity.this, "Tạo thành công", Toast.LENGTH_SHORT).show();
                            intent.putExtra("id", id);
                            intent.putExtra("pw", pw);
                            setResult(11, intent);
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "Tạo thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(RegisterActivity.this,"Xác nhận mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean CheckFormat() {
        if(id.isEmpty()){
            Toast.makeText(RegisterActivity.this,"Chưa nhập số điện thoại", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(CheckID()==false){
            Toast.makeText(RegisterActivity.this,"Số điện thoại đã được đăng ký", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(name.isEmpty()){
            Toast.makeText(RegisterActivity.this,"Chưa nhập họ và tên", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(pw.isEmpty()){
            Toast.makeText(RegisterActivity.this,"Chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(confirmPw.isEmpty()){
            Toast.makeText(RegisterActivity.this,"Chưa xác nhận mật khẩu", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(confirmPw.isEmpty()){
            Toast.makeText(RegisterActivity.this,"Chưa xác nhận mật khẩu", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(gender==-1){
            Toast.makeText(RegisterActivity.this,"Chưa chọn giới tính", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean CheckID() {
        ArrayList<String> arr = new ArrayList<>();
        Cursor c = db.query("tbUser", null, null, null, null, null, null);
        c.moveToNext();
        String data = "";
        while (c.isAfterLast() == false) {
            arr.add(c.getString(0));
            c.moveToNext();
        }
        c.close();
        for (String i : arr) {
            if(i.equals(id))
                return false;
        }
        return true;
    }

    boolean ComparePw(){
        return pw.equals(confirmPw);
    }
    private void GetInfo() {
        id = edtUserID_reg.getText().toString();
        pw = edtPw_reg.getText().toString();
        confirmPw = edtConfirmPw.getText().toString();
        name = edtName.getText().toString();
        gender = -1;
        int select = rgGender.getCheckedRadioButtonId();
        String kq = "";
        if (select != -1) {
            RadioButton rb = findViewById(select);
            kq = rb.getText().toString();
            if (kq.equals("Nam")) {
                gender = 1;
            }
            else gender = 0;
        }
    }

    private void Init() {
        edtUserID_reg = findViewById(R.id.edtUserID_reg);
        edtName = findViewById(R.id.edtName);
        edtPw_reg = findViewById(R.id.edtPw_reg);
        edtConfirmPw = findViewById(R.id.edtConfirmPw);
        txtRules = findViewById(R.id.txtRules);
        btnRegister = findViewById(R.id.btnRegister);
        rgGender = findViewById(R.id.rgGender);
        intent = getIntent();
        db = openOrCreateDatabase("DBQuizApp.db", MODE_PRIVATE, null);
    }
}