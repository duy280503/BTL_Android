package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterNgheGanDayVaChuDe extends RecyclerView.Adapter<AdapterNgheGanDayVaChuDe.MyViewHolder> {

    private Context context;
    private List<Album> albumList;

    public AdapterNgheGanDayVaChuDe(Context context, List<Album> albumList) {
        this.context = context;
        this.albumList = albumList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.album_name);
            image = view.findViewById(R.id.album_image);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_album_ngheganday, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.name.setText(album.getName());
        holder.image.setImageResource(album.getImageResId()); // Hiển thị hình ảnh
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

}


