package com.example.btlptudd_nhm11.core.models;

import com.google.firebase.Timestamp;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String userId;                 // documentId = uid từ FirebaseAuth
    public String fullName;
    public String phone;
    public String email;
    public String cccd;
    public String address;
    public String role;                   // "ADMIN" | "EMP"
    public String status;                 // "ACTIVE" | "LOCKED"
    public List<String> assignedBuildingIds = new ArrayList<>(); // Employee được phân công
    public List<String> assignedRoomIds = new ArrayList<>();     // (tùy chọn) phân công phòng chi tiết
    public Timestamp createdAt;
    public Timestamp updatedAt;
    public String createdBy;              // adminId

    public User() {}
}
