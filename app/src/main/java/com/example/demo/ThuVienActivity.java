package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ThuVienActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterAlbum albumAdapter;
    private List<Album> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_album); // Kết nối layout

        recyclerView = findViewById(R.id.recyclerViewThuVien); // Lấy RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Thiết lập LayoutManager

        // Khởi tạo danh sách album
        albumList = new ArrayList<>();
        albumList.add(new Album("Đừng làm trái tim anh đau - Sơn Tùng MTP", R.drawable.dunglamtraitimanhdau));
        albumList.add(new Album("Ngày đẹp trời để nói chia tay - Lou Hoàng", R.drawable.ngaydeptroidenoichiatay)); // Thêm album vào danh sách
        albumList.add(new Album("Lạ lùng - Vũ", R.drawable.lalung));
        albumList.add(new Album("Mộng Yu - AMEE x MCK", R.drawable.mongyu));

        // Thiết lập adapter cho RecyclerView
        albumAdapter = new AdapterAlbum(albumList);
        recyclerView.setAdapter(albumAdapter);
        // Thiết lập Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {
                    Intent intent = new Intent(ThuVienActivity.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.nav_search) {
                    Toast.makeText(ThuVienActivity.this, "000", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId() == R.id.nav_library) {
                    Toast.makeText(ThuVienActivity.this, "000", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
}
