package com.example.btlptudd_nhm11.core.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

//hiển thị giá phòng, hóa đơn điện nước (VD: 3.500.000 đ) và chuyển đổi kiểu Timestamp của Firebase sang dạng ngày/tháng quen thuộc
public class FormatUtils {

    // Format tiền tệ VNĐ (ví dụ: 3500000 -> 3.500.000 đ)
    public static String formatCurrency(double amount) {
        try {
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            return formatter.format(amount).replace(",", ".") + " đ";
        } catch (Exception e) {
            return "0 đ";
        }
    }

    // Format ngày tháng từ Unix timestamp (milliseconds) sang dd/MM/yyyy theo múi giờ Việt Nam
    public static String formatDate(long timestamp) {
        try {
            if (timestamp <= 0) return "";
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("vi", "VN"));
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
            return sdf.format(new Date(timestamp));
        } catch (Exception e) {
            return "";
        }
    }

    // Lấy kỳ hóa đơn hiện tại theo định dạng MM/yyyy (múi giờ Việt Nam)
    public static String getCurrentMonthYear() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy", new Locale("vi", "VN"));
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
            return sdf.format(new Date());
        } catch (Exception e) {
            return "";
        }
    }
}