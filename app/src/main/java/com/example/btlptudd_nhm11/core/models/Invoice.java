package com.example.btlptudd_nhm11.core.models;

import com.google.firebase.Timestamp;
import java.util.ArrayList;
import java.util.List;
public class Invoice {
    public String invoiceId;
    public String buildingId;
    public String roomId;
    public String contractId;
    public String tenantId;
    public int month;
    public int year;
    public double roomAmount;
    public double electricAmount;
    public double waterAmount;
    public List<ServiceItem> appliedServices = new ArrayList<>();
    public double serviceFee;                 // Tổng tiền dịch vụ
    public double totalAmount;
    public String status;     // UNPAID / PAID
    public Timestamp createdAt;
    public Timestamp dueDate;
    public Invoice() {
    }
}
