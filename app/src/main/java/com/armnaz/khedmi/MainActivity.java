package com.armnaz.khedmi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setupNavigation();
    }

    private void setupNavigation() {

        findViewById(R.id.navHome).setOnClickListener(v -> {
            Toast.makeText(this, "الرئيسية", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.navEmergency).setOnClickListener(v -> {
            openService("emergency");
        });

        findViewById(R.id.navServices).setOnClickListener(v -> {
            openService("services");
        });

        findViewById(R.id.navExchange).setOnClickListener(v -> {
            openService("exchange");
        });

        findViewById(R.id.navSettings).setOnClickListener(v -> {
            openSettings();
        });

        findViewById(R.id.btnEmergency).setOnClickListener(v -> {
            openService("emergency");
        });

        findViewById(R.id.btnExchange).setOnClickListener(v -> {
            openService("exchange");
        });

        findViewById(R.id.btnPharmacy).setOnClickListener(v -> {
            openService("pharmacy");
        });

        findViewById(R.id.btnWater).setOnClickListener(v -> {
            openService("water");
        });

        findViewById(R.id.btnDeaths).setOnClickListener(v -> {
            openService("deaths");
        });

        findViewById(R.id.btnAlerts).setOnClickListener(v -> {
            openService("alerts");
        });
    }

    private void openService(String serviceId) {

        Intent intent =
                new Intent(this, ServiceActivity.class);

        intent.putExtra("service_id", serviceId);

        startActivity(intent);

        overridePendingTransition(
                android.R.anim.fade_in,
                android.R.anim.fade_out
        );
    }

    private void openSettings() {

        Intent intent =
                new Intent(this, SettingsActivity.class);

        startActivity(intent);

        overridePendingTransition(
                android.R.anim.fade_in,
                android.R.anim.fade_out
        );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
