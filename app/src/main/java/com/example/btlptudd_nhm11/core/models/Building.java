package com.example.btlptudd_nhm11.core.models;

import com.google.firebase.Timestamp;

import java.util.List;

public class Building {
    public String buildingId;
    public String buildingName;
    public String address;
    public String description;

    public int totalFloors;
    public int totalRooms;

    public List<String> employeeIds;

    public Timestamp createdAt;
    public Timestamp updatedAt;
    public String createdBy;

    public Building() {}

}
