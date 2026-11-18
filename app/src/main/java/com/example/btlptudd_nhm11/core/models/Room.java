package com.example.btlptudd_nhm11.core.models;

import com.google.firebase.Timestamp;

import java.util.List;

public class Room {

    public String roomId;
    public String buildingId;

    public String roomName;
    public int floor;
    public double area;

    public double roomPrice;
    public double deposit;

    public List<String> equipment;

    public String status;
    // VACANT / OCCUPIED

    public String currentContractId;

    public String description;

    public Timestamp createdAt;
    public Timestamp updatedAt;
    public String createdBy;

    public Room() {}
}
