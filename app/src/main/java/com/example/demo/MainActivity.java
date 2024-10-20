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
//loc ngu vl

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerKhamPha, recyclerNgheGanDay, recyclerChuDe;
    private AdapterKhamPha khamPhaAdapter;
    private AdapterNgheGanDayVaChuDe NgheGanDayAdapter, ChuDeAdapter;
    private List<Album> albumKhamPha, albumNgheGanDay, albumChuDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo RecyclerView
        recyclerKhamPha = findViewById(R.id.recycler_kham_pha);
        recyclerKhamPha.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Tạo danh sách album
        albumKhamPha = new ArrayList<>();
        albumKhamPha.add(new Album("Album 1", R.drawable.dunglamtraitimanhdau));
        albumKhamPha.add(new Album("Album 2", R.drawable.mongyu));

        // Khởi tạo adapter và thiết lập cho RecyclerView
        khamPhaAdapter = new AdapterKhamPha(this, albumKhamPha);
        recyclerKhamPha.setAdapter(khamPhaAdapter);

        //==========================================================================================

        // Khởi tạo RecyclerView
        recyclerNgheGanDay = findViewById(R.id.recycler_nghe_gan_day);
        recyclerNgheGanDay.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Tạo danh sách album
        albumNgheGanDay = new ArrayList<>();
        albumNgheGanDay.add(new Album("Mình anh nơi này - NIT", R.drawable.minhanh));
        albumNgheGanDay.add(new Album("Bạn đời - KARIK", R.drawable.bandoi));
        albumNgheGanDay.add(new Album("Lạ lùng - Vũ", R.drawable.lalung));
        albumNgheGanDay.add(new Album("Ngày đẹp trời để nói chia tay - Lou Hoàng", R.drawable.ngaydeptroidenoichiatay));

        // Khởi tạo adapter và thiết lập cho RecyclerView
        NgheGanDayAdapter = new AdapterNgheGanDayVaChuDe(this, albumNgheGanDay);
        recyclerNgheGanDay.setAdapter(NgheGanDayAdapter);

        //==========================================================================================

        // Khởi tạo RecyclerView
        recyclerChuDe = findViewById(R.id.recycler_chu_de_the_loai);
        recyclerChuDe.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Tạo danh sách album
        albumChuDe = new ArrayList<>();
        albumChuDe.add(new Album("Nhạc Việt", R.drawable.vpop));
        albumChuDe.add(new Album("Nhạc Trung", R.drawable.cpop));
        albumChuDe.add(new Album("Nhạc Âu Mĩ", R.drawable.usuk));
        albumChuDe.add(new Album("Nhạc Hàn", R.drawable.kpop));

        // Khởi tạo adapter và thiết lập cho RecyclerView
        ChuDeAdapter = new AdapterNgheGanDayVaChuDe(this, albumChuDe);
        recyclerChuDe.setAdapter(ChuDeAdapter);

        // Thiết lập Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.nav_home){
                    Toast.makeText(MainActivity.this, "000", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId()==R.id.nav_search){
                    Toast.makeText(MainActivity.this, "000", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId()==R.id.nav_library){
                    Intent intent = new Intent(MainActivity.this, ThuVienActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }
}
