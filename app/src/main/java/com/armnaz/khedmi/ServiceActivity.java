package com.armnaz.khedmi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ServiceActivity extends AppCompatActivity {

    private LinearLayout serviceContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_service);

        Button back = findViewById(R.id.btnBack);
        TextView title = findViewById(R.id.serviceTitle);
        TextView description = findViewById(R.id.serviceDescription);

        serviceContent = findViewById(R.id.serviceContent);

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
                        "متابعة أسعار العملات في أرمناز.";
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
                        "آخر التنبيهات والإعلانات المهمة في أرمناز.";
                break;

            default:
                serviceTitle = "🧰 الخدمات";
                serviceDescription =
                        "جميع الخدمات التي يقدمها تطبيق أرمناز الخدمي.";
                break;
        }

        title.setText(serviceTitle);
        description.setText(serviceDescription);

        addServiceContent(serviceId);

        back.setOnClickListener(v -> finish());
    }

    private void addServiceContent(String serviceId) {

        if (serviceContent == null) {
            return;
        }

        serviceContent.removeAllViews();

        TextView sectionTitle = new TextView(this);
        sectionTitle.setText("الوصول السريع");
        sectionTitle.setTextSize(20);
        sectionTitle.setTextColor(0xFF17232B);
        sectionTitle.setTypeface(null, 1);

        serviceContent.addView(sectionTitle);

        TextView info = new TextView(this);
        info.setText(
                "سيتم تجهيز الأدوات والبيانات الخاصة بهذه الخدمة في المرحلة التالية."
        );
        info.setTextSize(14);
        info.setTextColor(0xFF71808A);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.topMargin = 8;

        serviceContent.addView(info, params);
    }
}
