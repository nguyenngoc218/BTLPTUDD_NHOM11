package com.example.btlptudd_nhm11.core.models;

import com.google.firebase.Timestamp;
public class Payment {
    public String paymentId;
    public String invoiceId;
    public double amount;
    public String paymentMethod;
    // CASH / BANK_TRANSFER
    public Timestamp paymentDate;
    public String receivedBy;
    public String note;
    public Payment() {
    }
}

