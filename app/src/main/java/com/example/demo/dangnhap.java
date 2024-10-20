package com.example.demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class dangnhap extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin;

    SharedPreferences sharedPreferences;
    Gson gson;
    ArrayList<User> userList; // Danh sách người dùng

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);

        edtUsername = findViewById(R.id.edt1dn);
        edtPassword = findViewById(R.id.edt2dn);
        btnLogin = findViewById(R.id.btndn);

        // Khởi tạo SharedPreferences và Gson
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        gson = new Gson();

        // Lấy danh sách người dùng từ SharedPreferences
        userList = getUserListFromSharedPreferences();

        btnLogin.setOnClickListener(v -> {
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();

            // Kiểm tra thông tin đăng nhập
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(dangnhap.this, "Vui lòng nhập tên đăng nhập và mật khẩu!", Toast.LENGTH_SHORT).show();
            } else if (checkLogin(username, password)) {
                Toast.makeText(dangnhap.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                // Chuyển đến trang chính hoặc làm gì đó sau khi đăng nhập thành công
            } else {
                Toast.makeText(dangnhap.this, "Tên đăng nhập hoặc mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
            }
        });
        // Đặt click listener cho TextView chuyển đến trang đăng nhập
        TextView txt = findViewById(R.id.txt2dn);
        txt.setOnClickListener(view -> {
            Intent intent = new Intent(dangnhap.this, dangky.class);
            startActivity(intent);
        });
    }

    // Phương thức kiểm tra thông tin đăng nhập
    private boolean checkLogin(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Thông tin đăng nhập đúng
            }
        }
        return false; // Không tìm thấy thông tin đăng nhập đúng
    }

    // Phương thức lấy danh sách người dùng từ SharedPreferences
    private ArrayList<User> getUserListFromSharedPreferences() {
        String json = sharedPreferences.getString("userList", null);
        Type type = new TypeToken<ArrayList<User>>() {}.getType();
        ArrayList<User> savedUserList = gson.fromJson(json, type);

        if (savedUserList == null) {
            savedUserList = new ArrayList<>();
        }

        return savedUserList;
    }
}
