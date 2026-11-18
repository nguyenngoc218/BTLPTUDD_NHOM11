package com.example.btlptudd_nhm11.core.models;

import com.google.firebase.Timestamp;
public class Tenant {
    public String tenantId;
    public String fullName;
    public String phone;
    public String email;
    public String dateOfBirth;
    public String cccd;
    public String address;
    public String licensePlate;  // biển số xe
    public String status;     // ACTIVE / INACTIVE
    public Timestamp createdAt;
    public Timestamp updatedAt;
    public String createdBy;
    public Tenant() {
    }
}
