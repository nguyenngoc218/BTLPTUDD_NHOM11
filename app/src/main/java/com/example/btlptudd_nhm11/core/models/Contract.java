package com.example.btlptudd_nhm11.core.models;

import com.google.firebase.Timestamp;
public class Contract {
    public String contractId;
    public String roomId;
    public String buildingId;
    public String tenantId;
    public Timestamp startDate;
    public Timestamp endDate;
    public Timestamp actualEndDate;
    public double roomPrice;
    public double deposit;
    public String status;     // ACTIVE / EXPIRED / TERMINATED
    public String terminationReason;
    public Timestamp createdAt;
    public Contract() {
    }
}
