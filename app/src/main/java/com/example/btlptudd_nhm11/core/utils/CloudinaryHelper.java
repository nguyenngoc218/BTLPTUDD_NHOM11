package com.example.btlptudd_nhm11.core.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import com.cloudinary.android.MediaManager;
import com.cloudinary.android.callback.ErrorInfo;
import com.cloudinary.android.callback.UploadCallback;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CloudinaryHelper {

    private static boolean isInitialized = false;

    // 1. Hàm khởi tạo cấu hình (chỉ gọi 1 lần khi ứng dụng mở lên ở MainActivity hoặc Application)
    public static void initCloudinary(Context context) {
        if (!isInitialized) {
            try {
                Map<String, String> config = new HashMap<>();
                config.put("cloud_name", "dyfrsmo2t");
                config.put("api_key", "491938523278629");
                config.put("api_secret", "S4GkloqfY6Ykrq1RKrC5RqvGEoQ");

                MediaManager.init(context, config);
                isInitialized = true;
            } catch (IllegalStateException e) {
                // Nếu đã khởi tạo rồi thì đánh dấu true để không bị lỗi trùng lặp
                isInitialized = true;
            }
        }
    }

    // Giao diện trung gian để trả kết quả về cho Activity/Fragment gọi nó
    public interface UploadCallbackListener {
        void onSuccess(String imageUrl);
        void onError(String errorMessage);
    }

    // 2. Hàm dùng chung để upload ảnh từ bất cứ màn hình nào trong app
    public static void uploadImage(String filePath, UploadCallbackListener listener) {
        if (filePath == null || filePath.isEmpty()) {
            if (listener != null) listener.onError("Đường dẫn file ảnh không hợp lệ!");
            return;
        }

        MediaManager.get().upload(filePath)
                .callback(new UploadCallback() {
                    @Override
                    public void onStart(String requestId) {
                        // Đang bắt đầu tải lên
                    }

                    @Override
                    public void onProgress(String requestId, long bytes, long totalBytes) {
                        // Tiến trình tải lên (có thể bỏ trống nếu không làm thanh % progress)
                    }

                    @Override
                    public void onSuccess(String requestId, Map resultData) {
                        // Lấy thành công đường dẫn URL của ảnh trên mây
                        String downloadUrl = (String) resultData.get("secure_url");
                        if (listener != null) {
                            listener.onSuccess(downloadUrl);
                        }
                    }

                    @Override
                    public void onError(String requestId, ErrorInfo error) {
                        if (listener != null) {
                            listener.onError(error.getDescription());
                        }
                    }

                    @Override
                    public void onReschedule(String requestId, ErrorInfo error) {
                        // Xử lý khi bị hoãn mạng
                    }
                })
                .dispatch();
    }
    // Thêm hàm hỗ trợ nén file ảnh trước khi đưa vào hàm upload
    public static File compressImage(Context context, Uri imageUri) {
        try {
            // Đọc bitmap từ Uri
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(context.getContentResolver().openInputStream(imageUri), null, options);

            // Tính toán tỷ lệ thu nhỏ (ví dụ giới hạn chiều rộng/cao tối đa 1024px)
            int scaleFactor = 1;
            int maxDimension = 1024;
            if (options.outWidth > maxDimension || options.outHeight > maxDimension) {
                final int halfHeight = options.outHeight / 2;
                final int halfWidth = options.outWidth / 2;
                while ((halfWidth / scaleFactor) >= maxDimension && (halfHeight / scaleFactor) >= maxDimension) {
                    scaleFactor *= 2;
                }
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = scaleFactor;
            Bitmap bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(imageUri), null, options);

            // Lưu ra file tạm trong bộ nhớ cache của app để upload
            File compressedFile = new File(context.getCacheDir(), "compressed_" + System.currentTimeMillis() + ".jpg");
            FileOutputStream fos = new FileOutputStream(compressedFile);
            if (bitmap != null) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fos); // Giữ lại 80% chất lượng
                fos.flush();
                fos.close();
            }
            return compressedFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}