package com.example.btlptudd_nhm11.core.models;

import com.google.firebase.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PriceConfig {
    public String priceConfigId;
    public String buildingId;

    // Giá mặc định
    public double defaultRoomPrice;
    public double defaultDeposit;

    // Giá điện nước
    public double electricityPrice;
    public double waterPrice;

    // Danh sách dịch vụ
    public List<ServiceItem> services = new ArrayList<>();

    // Thời hạn hợp đồng mặc định (tính theo tháng)
    public int defaultContractMonths;

    // Thông tin thanh toán QR (Hứng link ảnh QR từ CloudinaryHelper)
    public String qrImageUrl;
    public String bankName;
    public String bankAccountNumber;
    public String bankAccountHolder;
    public String invoiceNote;

    // Thời gian quản lý
    public Timestamp createdAt;
    public Timestamp updatedAt;
    public String createdBy;

    // Constructor rỗng bắt buộc cho Firestore
    public PriceConfig() {}
}