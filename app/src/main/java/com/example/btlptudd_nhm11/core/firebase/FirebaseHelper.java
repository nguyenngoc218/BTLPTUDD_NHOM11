package com.example.btlptudd_nhm11.core.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class FirebaseHelper {
    private static FirebaseAuth authInstance;
    private static FirebaseFirestore firestoreInstance;
    private static FirebaseStorage storageInstance;

    // Lấy instance FirebaseAuth dùng chung cho phần Đăng nhập/Xác thực
    public static FirebaseAuth getAuth() {
        if (authInstance == null) {
            authInstance = FirebaseAuth.getInstance();
        }
        return authInstance;
    }

    // Lấy instance FirebaseFirestore dùng chung cho việc truy vấn dữ liệu Quản lý trọ
    public static FirebaseFirestore getFirestore() {
        if (firestoreInstance == null) {
            firestoreInstance = FirebaseFirestore.getInstance();
        }
        return firestoreInstance;
    }

    // Lấy instance FirebaseStorage dùng chung cho việc lưu trữ ảnh sửa chữa/báo cáo
    public static FirebaseStorage getStorage() {
        if (storageInstance == null) {
            storageInstance = FirebaseStorage.getInstance();
        }
        return storageInstance;
    }
}