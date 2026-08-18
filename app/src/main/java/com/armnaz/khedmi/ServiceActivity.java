package com.armnaz.khedmi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_service);

        Button back = findViewById(R.id.btnBack);
        TextView title = findViewById(R.id.serviceTitle);
        TextView description = findViewById(R.id.serviceDescription);

        String serviceId =
                getIntent().getStringExtra("service_id");

        if (serviceId == null) {
            serviceId = "services";
        }

        String serviceTitle;
        String serviceDescription;

        switch (serviceId) {

            case "emergency":
                serviceTitle = "🚨 الطوارئ";
                serviceDescription =
                        "الوصول السريع إلى خدمات الطوارئ المهمة.";
                break;

            case "exchange":
                serviceTitle = "💱 أسعار الصرف";
                serviceDescription =
                        "أسعار العملات سيتم ربطها بمصدر بيانات مباشر.";
                break;

            case "pharmacy":
                serviceTitle = "💊 الصيدليات";
                serviceDescription =
                        "دليل الصيدليات والخدمات الطبية في أرمناز.";
                break;

            case "water":
                serviceTitle = "🚰 دور المياه";
                serviceDescription =
                        "معلومات نقاط توزيع المياه والخدمات المرتبطة بها.";
                break;

            case "deaths":
                serviceTitle = "🕊️ الوفيات والعزاء";
                serviceDescription =
                        "الإعلانات المتعلقة بالوفيات والعزاء.";
                break;

            case "alerts":
                serviceTitle = "📢 التنبيهات";
                serviceDescription =
                        "آخر التنبيهات والإعلانات المهمة.";
                break;

            default:
                serviceTitle = "🧰 الخدمات";
                serviceDescription =
                        "جميع الخدمات التي يقدمها تطبيق أرمناز الخدمي.";
                break;
        }

        title.setText(serviceTitle);
        description.setText(serviceDescription);

        back.setOnClickListener(v -> finish());
    }
}
