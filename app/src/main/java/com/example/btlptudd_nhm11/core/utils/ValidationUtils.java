package com.example.btlptudd_nhm11.core.utils;

import android.text.TextUtils;
import android.util.Patterns;

//kiểm tra nhanh số điện thoại, CCCD, email hoặc chỉ số điện nước mới/cũ trước khi lưu lên Firestore
public class ValidationUtils {

    // Kiểm tra null hoặc chuỗi rỗng / khoảng trắng
    public static boolean isEmpty(String str) {
        return str == null || TextUtils.isEmpty(str.trim());
    }

    // Kiểm tra số điện thoại: đúng 10 chữ số, bắt đầu bằng 0, chỉ chứa số, không khoảng trắng/ký tự khác
    public static boolean isValidPhone(String phone) {
        if (isEmpty(phone)) return false;
        return phone.matches("^0\\d{9}$");
    }

    // Kiểm tra CCCD: đúng 12 chữ số, không chứa ký tự chữ hay khoảng trắng
    public static boolean isValidCCCD(String cccd) {
        if (isEmpty(cccd)) return false;
        return cccd.matches("^\\d{12}$");
    }

    // Kiểm tra định dạng Email cơ bản
    public static boolean isValidEmail(String email) {
        if (isEmpty(email)) return false;
        return Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches();
    }

    // Kiểm tra chỉ số điện mới ≥ chỉ số cũ (đồng thời kiểm tra NaN và Infinite)
    public static boolean isValidElectricReading(double oldReading, double newReading) {
        if (Double.isNaN(oldReading) || Double.isInfinite(oldReading) ||
                Double.isNaN(newReading) || Double.isInfinite(newReading)) {
            return false;
        }
        return newReading >= oldReading;
    }

    // Kiểm tra chỉ số nước mới ≥ chỉ số cũ (đồng thời kiểm tra NaN và Infinite)
    public static boolean isValidWaterReading(double oldReading, double newReading) {
        if (Double.isNaN(oldReading) || Double.isInfinite(oldReading) ||
                Double.isNaN(newReading) || Double.isInfinite(newReading)) {
            return false;
        }
        return newReading >= oldReading;
    }
}