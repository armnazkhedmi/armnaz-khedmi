package com.armnaz.khedmi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ServiceActivity extends AppCompatActivity {

    private LinearLayout serviceActions;
    private TextView serviceStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_service);

        Button back = findViewById(R.id.btnBack);
        TextView title = findViewById(R.id.serviceTitle);
        TextView description = findViewById(R.id.serviceDescription);

        serviceActions = findViewById(R.id.serviceActions);
        serviceStatus = findViewById(R.id.serviceStatus);

        String serviceId =
                getIntent().getStringExtra("service_id");

        if (serviceId == null) {
            serviceId = "services";
        }

        switch (serviceId) {

            case "emergency":
                title.setText("🚨 الطوارئ العامة");
                description.setText(
                        "أهم جهات الطوارئ التي قد تحتاج إليها بسرعة."
                );
                buildEmergency();
                break;

            case "electricity":
                title.setText("⚡ طوارئ الكهرباء");
                description.setText(
                        "التواصل مع جهة طوارئ الكهرباء ومتابعة أخبار الشركة."
                );
                buildElectricity();
                break;

            case "hospitals":
                title.setText("🏥 المشافي");
                description.setText(
                        "دليل المشافي ووسائل التواصل المتاحة."
                );
                buildHospitals();
                break;

            case "pharmacy":
                title.setText("💊 الصيدليات");
                description.setText(
                        "دليل الصيدليات ووسائل التواصل عند توفرها."
                );
                buildPharmacy();
                break;

            case "water":
                title.setText("🚰 دور المياه");
                description.setText(
                        "معرفة مكان الضخ اليوم وترتيب الدور بين الحارات."
                );
                buildWater();
                break;

            case "exchange":
                title.setText("💱 أسعار الصرف");
                description.setText(
                        "أسعار العملات وآخر تحديث للبيانات."
                );
                buildExchange();
                break;

            case "deaths":
                title.setText("🕊️ الوفيات والعزاء");
                description.setText(
                        "آخر إعلانات الوفيات ومعلومات العزاء."
                );
                buildDeaths();
                break;

            case "alerts":
                title.setText("📢 التنبيهات");
                description.setText(
                        "آخر الأخبار والتنبيهات المهمة."
                );
                buildAlerts();
                break;

            default:
                title.setText("🧰 الخدمات");
                description.setText(
                        "الخدمات المتوفرة في تطبيق أرمناز الخدمي."
                );
                buildGeneral();
                break;
        }

        back.setOnClickListener(v -> finish());
    }


    private void buildEmergency() {

        addAction("🚑", "الإسعاف", "التواصل عبر واتساب", null);
        addAction("🚒", "الإطفاء", "التواصل عبر واتساب", null);
        addAction("👮", "الشرطة", "التواصل عبر واتساب", null);
        addAction("🧑‍🚒", "الدفاع المدني", "التواصل عبر واتساب", null);

        serviceStatus.setText("الأرقام وروابط التواصل تضاف من مصدر موثوق.");
    }


    private void buildElectricity() {

        addAction(
                "⚡",
                "رقم طوارئ الكهرباء",
                "التواصل عبر واتساب",
                null
        );

        addAction(
                "💡",
                "انقطاع الكهرباء",
                "معلومات الانقطاع الحالية",
                null
        );

        addAction(
                "📢",
                "أخبار من الشركة",
                "آخر الإعلانات والتنبيهات",
                null
        );

        serviceStatus.setText("المعلومات قابلة للتحديث من مصدر مركزي.");
    }


    private void buildHospitals() {

        addAction(
                "🏥",
                "المشافي",
                "قائمة المشافي وبيانات التواصل",
                null
        );

        addAction(
                "📞",
                "الاتصال بالمشفى",
                "اتصال مباشر عند توفر الرقم",
                null
        );

        addAction(
                "✈️",
                "تلغرام",
                "فتح قناة أو حساب المشفى عند توفره",
                null
        );

        serviceStatus.setText("بيانات المشافي تضاف عند اعتماد مصادرها.");
    }


    private void buildPharmacy() {

        addAction(
                "💊",
                "الصيدليات",
                "قائمة الصيدليات",
                null
        );

        addAction(
                "📞",
                "التواصل",
                "رقم الصيدلية عند توفره",
                null
        );

        serviceStatus.setText("بيانات الصيدليات قابلة للتحديث.");
    }


    private void buildWater() {

        addAction(
                "🚰",
                "مكان الضخ اليوم",
                "سيظهر اسم مكان الضخ لهذا اليوم",
                null
        );

        addAction(
                "➡️",
                "الحارة التالية",
                "ستظهر الحارة التالية في الدور",
                null
        );

        addAction(
                "📋",
                "الدور للكل بالترتيب",
                "قائمة الحارات حسب ترتيب الضخ",
                null
        );

        serviceStatus.setText("يتم تحديث الدور حسب جدول المياه.");
    }


    private void buildExchange() {

        addAction(
                "💵",
                "الدولار",
                "سعر الشراء والمبيع",
                null
        );

        addAction(
                "🇹🇷",
                "الليرة التركية",
                "سعر الصرف الحالي",
                null
        );

        addAction(
                "🔄",
                "تحديث الأسعار",
                "جلب آخر البيانات",
                null
        );

        serviceStatus.setText("آخر تحديث: سيتم عرضه عند توفر مصدر البيانات.");
    }


    private void buildDeaths() {

        addAction(
                "🕊️",
                "آخر الإعلانات",
                "أحدث إعلانات الوفيات والعزاء",
                null
        );

        addAction(
                "🔎",
                "البحث",
                "البحث ضمن الإعلانات",
                null
        );

        serviceStatus.setText("الإعلانات تظهر عند توفر البيانات.");
    }


    private void buildAlerts() {

        addAction(
                "📢",
                "آخر التنبيهات",
                "أحدث الإعلانات المهمة",
                null
        );

        addAction(
                "🔄",
                "تحديث",
                "جلب آخر التنبيهات",
                null
        );

        serviceStatus.setText("التنبيهات قابلة للتحديث.");
    }


    private void buildGeneral() {

        addAction(
                "🧰",
                "جميع الخدمات",
                "الوصول إلى الخدمات المتوفرة",
                null
        );

        serviceStatus.setText("التطبيق جاهز للتطوير والربط بالبيانات.");
    }


    private void addAction(
            String icon,
            String title,
            String subtitle,
            String url
    ) {

        LinearLayout card = new LinearLayout(this);

        card.setOrientation(LinearLayout.HORIZONTAL);
        card.setGravity(Gravity.CENTER_VERTICAL);
        card.setPadding(20, 18, 20, 18);
        card.setBackgroundColor(0xFFFFFFFF);

        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        cardParams.setMargins(0, 0, 0, 12);

        card.setLayoutParams(cardParams);

        TextView iconView = new TextView(this);
        iconView.setText(icon);
        iconView.setTextSize(25);
        iconView.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams iconParams =
                new LinearLayout.LayoutParams(55, 55);

        card.addView(iconView, iconParams);

        LinearLayout textBox = new LinearLayout(this);
        textBox.setOrientation(LinearLayout.VERTICAL);
        textBox.setPadding(14, 0, 0, 0);

        TextView titleView = new TextView(this);
        titleView.setText(title);
        titleView.setTextSize(16);
        titleView.setTextColor(0xFF17232B);
        titleView.setTypeface(null, 1);

        TextView subtitleView = new TextView(this);
        subtitleView.setText(subtitle);
        subtitleView.setTextSize(13);
        subtitleView.setTextColor(0xFF71808A);

        textBox.addView(titleView);

        LinearLayout.LayoutParams subParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        subParams.topMargin = 4;

        textBox.addView(subtitleView, subParams);

        card.addView(
                textBox,
                new LinearLayout.LayoutParams(
                        0,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        1
                )
        );

        if (url != null) {

            card.setOnClickListener(v -> {

                Intent intent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                startActivity(intent);
            });
        }

        serviceActions.addView(card);
    }
}
