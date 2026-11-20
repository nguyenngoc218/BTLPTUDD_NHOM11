package com.example.btlptudd_nhm11;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.btlptudd_nhm11.core.utils.CloudinaryHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private boolean isAdmin = true; // Tạm thời để true/false test 2 quyền, sau lấy từ Session/Intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Khởi tạo Cloudinary dùng chung cho toàn bộ app
        CloudinaryHelper.initCloudinary(this);

        // 1. Lấy trạng thái phân quyền (ví dụ từ Intent hoặc SharedPreferences)
        if (getIntent() != null && getIntent().hasExtra("is_admin")) {
            isAdmin = getIntent().getBooleanExtra("is_admin", false);
        }

        // 2. Ánh xạ BottomNavigationView và nạp menu theo quyền
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        setupBottomNavigation();

        // 3. Mở tab mặc định khi khởi tạo lần đầu
        if (savedInstanceState == null) {
            int defaultTabId = isAdmin ? R.id.nav_overview : R.id.nav_tasks;
            bottomNavigationView.setSelectedItemId(defaultTabId);
        }
    }

    private void setupBottomNavigation() {
        bottomNavigationView.getMenu().clear();
        bottomNavigationView.inflateMenu(isAdmin ? R.menu.menu_bottom_admin : R.menu.menu_bottom_staff);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment targetFragment = isAdmin
                    ? getAdminFragment(item.getItemId())
                    : getStaffFragment(item.getItemId());

            if (targetFragment != null) {
                openRootFragment(targetFragment);
                return true;
            }
            return false;
        });
    }

    private Fragment getAdminFragment(int itemId) {
        if (itemId == R.id.nav_overview) {
            return new Fragment(); // Thay bằng AdminOverviewFragment()
        } else if (itemId == R.id.nav_rooms) {
            return new Fragment(); // Thay bằng BuildingsFragment.newInstance(true)
        } else if (itemId == R.id.nav_invoices) {
            return new Fragment(); // Thay bằng AdminInvoicesFragment()
        } else if (itemId == R.id.nav_statistics) {
            return new Fragment(); // Thay bằng AdminStatisticsFragment()
        } else if (itemId == R.id.nav_settings) {
            return new Fragment(); // Thay bằng AdminSettingsFragment()
        }
        return null;
    }

    private Fragment getStaffFragment(int itemId) {
        if (itemId == R.id.nav_tasks) {
            return new Fragment(); // Thay bằng StaffTasksFragment()
        } else if (itemId == R.id.nav_rooms) {
            return new Fragment(); // Thay bằng BuildingsFragment.newInstance(false)
        } else if (itemId == R.id.nav_invoices) {
            return new Fragment(); // Thay bằng StaffInvoicesFragment()
        } else if (itemId == R.id.nav_account) {
            return new Fragment(); // Thay bằng StaffAccountFragment()
        }
        return null;
    }

    private void openRootFragment(@NonNull Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit();
    }
}