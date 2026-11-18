package com.example.btlptudd_nhm11.core.models;

import com.google.firebase.Timestamp;
public class UtilityReading {
    public String readingId;
    public String roomId;
    public String buildingId;
    public int month;
    public int year;

    // Chỉ số điện
    public double oldElectricIndex;
    public double newElectricIndex;
    public double electricityPrice;

    // Chỉ số nước
    public double oldWaterIndex;
    public double newWaterIndex;
    public double waterPrice;
    public Timestamp readingDate;
    public String recordedBy;
    public UtilityReading() {
    }
}
