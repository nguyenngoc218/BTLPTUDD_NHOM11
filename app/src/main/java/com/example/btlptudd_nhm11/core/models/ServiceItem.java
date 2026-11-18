package com.example.btlptudd_nhm11.core.models;

public class ServiceItem {
    public String id;           // UUID hoặc tên không dấu
    public String name;         // "Internet", "Gửi xe máy", "Vệ sinh"...
    public double price;
    public String unit;         // "phòng/tháng", "xe/tháng", "người/tháng"...
    public boolean active = true;
    public int sortOrder;       // Thứ tự hiển thị

    // Constructor rỗng cho Firestore
    public ServiceItem() {}

    public ServiceItem(String name, double price, String unit) {
        this.name = name;
        this.price = price;
        this.unit = unit;
    }
}