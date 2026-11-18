package com.example.btlptudd_nhm11.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.auth.FirebaseAuth;

public class SessionManager {
    private static final String PREF_NAME = "motel_session";

    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_ROLE = "role";
    private static final String KEY_IS_LOGGED_IN = "is_logged_in";

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void saveSession(String userId, String fullName, String role) {
        editor.putString(KEY_USER_ID, userId);
        editor.putString(KEY_FULL_NAME, fullName);
        editor.putString(KEY_ROLE, role);
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.apply();
    }

    public String getCurrentUserId() {
        return prefs.getString(KEY_USER_ID, null);
    }

    public String getCurrentUserName() {
        return prefs.getString(KEY_FULL_NAME, "");
    }

    public String getCurrentUserRole() {
        return prefs.getString(KEY_ROLE, "");
    }

    public boolean isLoggedIn() {
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public boolean isAdmin() {
        return "ADMIN".equals(getCurrentUserRole());
    }

    public boolean isEmployee() {
        return "EMP".equals(getCurrentUserRole());
    }

    public void clearSession() {
        editor.clear();
        editor.apply();
    }

    // Tiện ích đăng xuất kết hợp Firebase Auth
    public static void logout(Context context) {
        FirebaseAuth.getInstance().signOut();
        if (context != null) {
            SessionManager sessionManager = new SessionManager(context);
            sessionManager.clearSession();
        }
    }
}