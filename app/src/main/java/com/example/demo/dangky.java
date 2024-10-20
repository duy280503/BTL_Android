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

public class dangky extends AppCompatActivity {
    EditText edt1dk, edt2dk, edt3dk; // edt1dk: tên người dùng, edt2dk: mật khẩu, edt3dk: xác nhận mật khẩu
    Button btndk;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Gson gson;
    ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky);

        // Gán các thành phần giao diện
        edt1dk = findViewById(R.id.edt1dk); // Tên người dùng
        edt2dk = findViewById(R.id.edt2dk); // Mật khẩu
        edt3dk = findViewById(R.id.edt3dk); // Xác nhận mật khẩu
        btndk = findViewById(R.id.btndk); // Nút đăng ký

        // Khởi tạo SharedPreferences, Editor và Gson
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();

        // Lấy danh sách người dùng từ SharedPreferences
        userList = getUserListFromSharedPreferences();

        // Xử lý khi nhấn nút đăng ký
        btndk.setOnClickListener(v -> {
            String username = edt1dk.getText().toString();
            String password = edt2dk.getText().toString();
            String confirmPassword = edt3dk.getText().toString(); // Lấy mật khẩu xác nhận

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(dangky.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(dangky.this, "Mật khẩu xác nhận không khớp!", Toast.LENGTH_SHORT).show();
            } else if (isUsernameTaken(username)) {
                Toast.makeText(dangky.this, "Tên người dùng đã tồn tại!", Toast.LENGTH_SHORT).show();
            } else {
                // Tạo đối tượng người dùng mới
                User newUser = new User(username, password); // Lưu cả mật khẩu xác nhận nếu cần
                userList.add(newUser);

                // Lưu danh sách người dùng vào SharedPreferences
                String json = gson.toJson(userList);
                editor.putString("userList", json);
                editor.apply();

                Toast.makeText(dangky.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        // Đặt click listener cho TextView chuyển đến trang đăng nhập
        TextView txt = findViewById(R.id.txt2dk);
        txt.setOnClickListener(view -> {
            Intent intent = new Intent(dangky.this, dangnhap.class);
            startActivity(intent);
        });
    }

    // Phương thức kiểm tra tên người dùng đã tồn tại chưa
    private boolean isUsernameTaken(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true; // Tên người dùng đã tồn tại
            }
        }
        return false; // Tên người dùng chưa tồn tại
    }

    // Phương thức lấy danh sách người dùng từ SharedPreferences
    private ArrayList<User> getUserListFromSharedPreferences() {
        String json = sharedPreferences.getString("userList", null);
        Type type = new TypeToken<ArrayList<User>>() {}.getType(); // Dùng TypeToken ở đây
        ArrayList<User> savedUserList = gson.fromJson(json, type);

        if (savedUserList == null) {
            savedUserList = new ArrayList<>();
        }

        return savedUserList;
    }
}
