package com.example.demo;

public class Album {
    private String name;
    private int imageResId;  // ID của tài nguyên ảnh

    public Album(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    // Getter cho tên album
    public String getName() {
        return name;
    }

    // Getter cho ID tài nguyên ảnh
    public int getImageResId() {
        return imageResId;
    }
}
