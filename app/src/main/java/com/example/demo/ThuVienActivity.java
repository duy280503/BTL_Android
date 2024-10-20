package com.example.demo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
    }
}
