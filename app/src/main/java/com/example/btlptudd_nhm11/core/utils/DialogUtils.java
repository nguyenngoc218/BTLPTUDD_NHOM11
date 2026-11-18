package com.example.btlptudd_nhm11.core.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.LinearLayout;

public class DialogUtils {

    private static AlertDialog loadingDialogInstance;

    public interface OnConfirmListener {
        void onConfirm();
    }

    // A. LoadingDialog
    public static void showLoadingDialog(Context context, String message) {
        if (context == null) return;
        dismissLoadingDialog();

        // Tạo một ProgressBar xoay tròn đơn giản cùng thông báo
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setPadding(50, 40, 50, 40);

        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 40, 0);
        layout.addView(progressBar, params);

        android.widget.TextView textView = new android.widget.TextView(context);
        textView.setText(message != null && !message.isEmpty() ? message : "Đang xử lý...");
        textView.setTextSize(16);
        textView.setTextColor(context.getResources().getColor(android.R.color.black));
        layout.addView(textView, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(layout);
        builder.setCancelable(false); // Không cho phép người dùng đóng trong quá trình xử lý

        loadingDialogInstance = builder.create();
        loadingDialogInstance.show();
    }

    public static void dismissLoadingDialog() {
        if (loadingDialogInstance != null && loadingDialogInstance.isShowing()) {
            try {
                loadingDialogInstance.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                loadingDialogInstance = null;
            }
        }
    }

    // B. ConfirmDialog
    public static void showConfirmDialog(Context context, String title, String message, OnConfirmListener listener) {
        if (context == null) return;

        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false) // Không thực hiện hành động khi nhấn Back
                .setPositiveButton("Xác nhận", (dialog, which) -> {
                    if (listener != null) {
                        listener.onConfirm();
                    }
                })
                .setNegativeButton("Hủy", (dialog, which) -> {
                    dialog.dismiss();
                })
                .show();
    }
}