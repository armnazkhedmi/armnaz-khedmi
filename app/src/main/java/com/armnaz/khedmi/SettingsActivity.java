package com.armnaz.khedmi;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        preferences = getSharedPreferences(
                "armnaz_settings",
                MODE_PRIVATE
        );

        setupBackButton();
        setupSettings();
    }

    private void setupBackButton() {

        Button back = findViewById(R.id.btnBack);

        if (back != null) {
            back.setOnClickListener(v -> finish());
        }
    }

    private void setupSettings() {

        Switch notifications =
                findViewById(R.id.switchNotifications);

        Switch saveData =
                findViewById(R.id.switchSaveData);

        TextView clearData =
                findViewById(R.id.btnClearData);

        if (notifications != null) {

            notifications.setChecked(
                    preferences.getBoolean(
                            "notifications",
                            true
                    )
            );

            notifications.setOnCheckedChangeListener(
                    (buttonView, isChecked) -> {

                        preferences.edit()
                                .putBoolean(
                                        "notifications",
                                        isChecked
                                )
                                .apply();

                        showMessage(
                                isChecked
                                        ? "تم تفعيل التنبيهات"
                                        : "تم إيقاف التنبيهات"
                        );
                    }
            );
        }

        if (saveData != null) {

            saveData.setChecked(
                    preferences.getBoolean(
                            "save_data",
                            true
                    )
            );

            saveData.setOnCheckedChangeListener(
                    (buttonView, isChecked) -> {

                        preferences.edit()
                                .putBoolean(
                                        "save_data",
                                        isChecked
                                )
                                .apply();

                        showMessage(
                                isChecked
                                        ? "سيتم حفظ آخر البيانات"
                                        : "لن يتم حفظ البيانات محليًا"
                        );
                    }
            );
        }

        if (clearData != null) {

            clearData.setOnClickListener(v -> {

                preferences.edit()
                        .clear()
                        .apply();

                if (notifications != null) {
                    notifications.setChecked(true);
                }

                if (saveData != null) {
                    saveData.setChecked(true);
                }

                showMessage("تمت إعادة الإعدادات للوضع الافتراضي");
            });
        }
    }

    private void showMessage(String message) {

        Toast.makeText(
                this,
                message,
                Toast.LENGTH_SHORT
        ).show();
    }
}
