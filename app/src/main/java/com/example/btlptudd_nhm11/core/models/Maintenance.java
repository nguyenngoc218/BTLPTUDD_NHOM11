package com.example.btlptudd_nhm11.core.models;

import com.google.firebase.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Maintenance {
    public String maintenanceId;
    public String buildingId;
    public String roomId;

    // Khu vực cần sửa chữa
    // public String areaType;    // ROOM / BUILDING

    // Thông tin sự cố
    public String title;
    public String description;
    public String priority;    // LOW / MEDIUM / HIGH

    // Ảnh trước và sau sửa chữa (Hứng danh sách link ảnh từ CloudinaryHelper)
    public List<String> beforeImages = new ArrayList<>();
    public List<String> afterImages = new ArrayList<>();

    // Thông tin thợ / kỹ thuật
    public String handledBy;
    public String technicianPhone;
    public String technicianNote;

    // Thông tin xử lý
    public String solution;

    // Chi phí sửa chữa
    public double repairCost;

    // Trạng thái (PENDING / IN_PROGRESS / COMPLETED)
    public String status;

    // Người báo cáo sự cố
    public String reportedBy;

    // Thời gian
    public Timestamp createdAt;
    public Timestamp completedAt;

    // Constructor rỗng bắt buộc cho Firestore
    public Maintenance() {}
}