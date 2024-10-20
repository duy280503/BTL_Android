package com.example.demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterAlbum extends RecyclerView.Adapter<AdapterAlbum.AlbumViewHolder> {

    private List<Album> albumList; // Danh sách album

    // Constructor
    public AdapterAlbum(List<Album> albumList) {
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Tạo View cho từng item trong RecyclerView
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_favorite_album, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumList.get(position); // Lấy album tại vị trí hiện tại
        holder.tenAlbum.setText(album.getName()); // Thiết lập tên album
        holder.hinhAnh.setImageResource(album.getImageResId()); // Thiết lập hình ảnh
    }

    @Override
    public int getItemCount() {
        return albumList.size(); // Trả về số lượng album
    }

    // Lớp ViewHolder để giữ các view của một item
    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        TextView tenAlbum;
        ImageView hinhAnh;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            tenAlbum = itemView.findViewById(R.id.combined_text_view);
            hinhAnh = itemView.findViewById(R.id.contact_image);
        }
    }
}
