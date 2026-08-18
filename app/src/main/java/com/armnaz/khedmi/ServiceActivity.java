package com.armnaz.khedmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ServiceActivity extends AppCompatActivity {

    private LinearLayout serviceContent;
    private TextView serviceTitle;
    private TextView serviceDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_service);

        Button back = findViewById(R.id.btnBack);

        serviceTitle = findViewById(R.id.serviceTitle);
        serviceDescription = findViewById(R.id.serviceDescription);
        serviceContent = findViewById(R.id.serviceContent);

        back.setOnClickListener(v -> finish());

        String serviceId =
                getIntent().getStringExtra("service_id");

        if (serviceId == null) {
            serviceId = "services";
        }

        loadService(serviceId);
    }

    private void loadService(String id) {

        serviceContent.removeAllViews();

        switch (id) {

            case "emergency":
                showEmergency();
                break;

            case "exchange":
                showExchange();
                break;

            case "pharmacy":
                showPharmacy();
                break;

            case "water":
                showWater();
                break;

            case "deaths":
                showDeaths();
                break;

            case "alerts":
                showAlerts();
                break;

            default:
                showGeneralServices();
                break;
        }
    }

    private void setHeader(
            String title,
            String description) {

        serviceTitle.setText(title);
        serviceDescription.setText(description);
    }

    private void showEmergency() {

        setHeader(
                "🚨 الطوارئ",
                "الوصول السريع إلى خدمات الطوارئ المهمة في أرمناز."
        );

        addSection(
                "🚑 الإسعاف",
                "خدمة الإسعاف والطوارئ الطبية."
        );

        addSection(
                "🚓 الشرطة",
                "الوصول السريع إلى الجهات الأمنية."
        );

        addSection(
                "🚒 الإطفاء",
                "خدمات الإطفاء والاستجابة للحوادث."
        );

        addSection(
                "📍 أقرب خدمة",
                "سيتم لاحقًا ربطها بالموقع الجغرافي."
        );
    }

    private void showExchange() {

        setHeader(
                "💱 أسعار الصرف",
                "أسعار العملات سيتم تحديثها من مصدر بيانات مباشر."
        );

        addSection(
                "🇺🇸 الدولار الأمريكي",
                "USD — البيانات قيد الربط."
        );

        addSection(
                "🇹🇷 الليرة التركية",
                "TRY — البيانات قيد الربط."
        );

        addSection(
                "🇪🇺 اليورو",
                "EUR — البيانات قيد الربط."
        );

        addSection(
                "🔄 تحديث الأسعار",
                "سيتم تفعيل التحديث المباشر عند ربط مصدر البيانات."
        );
    }

    private void showPharmacy() {

        setHeader(
                "💊 الصيدليات",
                "دليل الصيدليات والخدمات الدوائية في أرمناز."
        );

        addSection(
                "🏥 الصيدليات",
                "سيتم عرض الصيدليات المسجلة في النظام."
        );

        addSection(
                "📍 الأقرب إليك",
                "سيتم استخدام الموقع لإظهار الأقرب."
        );

        addSection(
                "🕐 المناوبة",
                "سيتم عرض الصيدليات المناوبة عند توفر البيانات."
        );
    }

    private void showWater() {

        setHeader(
                "🚰 دور المياه",
                "معلومات نقاط توزيع المياه والخدمات المرتبطة بها."
        );

        addSection(
                "💧 نقاط المياه",
                "سيتم عرض نقاط توزيع المياه."
        );

        addSection(
                "📍 المواقع",
                "سيتم ربط المواقع بالخريطة."
        );

        addSection(
                "📢 آخر تحديث",
                "ستظهر هنا آخر معلومات التوزيع."
        );
    }

    private void showDeaths() {

        setHeader(
                "🕊️ الوفيات والعزاء",
                "الإعلانات المتعلقة بالوفيات ومواعيد العزاء."
        );

        addSection(
                "📋 آخر الإعلانات",
                "ستظهر هنا الإعلانات الجديدة."
        );

        addSection(
                "🕯️ مواعيد العزاء",
                "ستظهر هنا تفاصيل مواعيد وأماكن العزاء."
        );
    }

    private void showAlerts() {

        setHeader(
                "📢 التنبيهات",
                "آخر التنبيهات والإعلانات المهمة."
        );

        addSection(
                "🔔 التنبيهات الجديدة",
                "ستظهر هنا التنبيهات المهمة."
        );

        addSection(
                "📰 الأخبار",
                "سيتم عرض الأخبار المحلية المهمة."
        );

        addSection(
                "⚡ عاجل",
                "التنبيهات العاجلة ستظهر في مقدمة الصفحة."
        );
    }

    private void showGeneralServices() {

        setHeader(
                "🧰 الخدمات",
                "جميع الخدمات التي يقدمها تطبيق أرمناز الخدمي."
        );

        addSection(
                "✨ الخدمات",
                "اختر الخدمة التي تريد الوصول إليها."
        );
    }

    private void addSection(
            String title,
            String description) {

        LinearLayout box =
                new LinearLayout(this);

        box.setOrientation(
                LinearLayout.VERTICAL
        );

        box.setPadding(
                20,
                18,
                20,
                18
        );

        box.setBackgroundResource(
                android.R.drawable.dialog_holo_light_frame
        );

        TextView titleView =
                new TextView(this);

        titleView.setText(title);
        titleView.setTextSize(18);
        titleView.setTextColor(
                android.graphics.Color.rgb(
                        23, 35, 43
                )
        );
        titleView.setTypeface(
                null,
                android.graphics.Typeface.BOLD
        );

        TextView descriptionView =
                new TextView(this);

        descriptionView.setText(description);
        descriptionView.setTextSize(14);
        descriptionView.setTextColor(
                android.graphics.Color.rgb(
                        99, 113, 122
                )
        );

        LinearLayout.LayoutParams titleParams =
                new LinearLayout.LayoutParams(
                        -1,
                        -2
                );

        descriptionView.setPadding(
                0,
                7,
                0,
                0
        );

        box.addView(
                titleView,
                titleParams
        );

        box.addView(
                descriptionView
        );

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        -1,
                        -2
                );

        params.setMargins(
                0,
                0,
                0,
                14
        );

        serviceContent.addView(
                box,
                params
        );
    }
}
