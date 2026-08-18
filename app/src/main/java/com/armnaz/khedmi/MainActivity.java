package com.armnaz.khedmi;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setupNavigation();
        setupServices();
        setupRefresh();
        animateInterface();
    }

    // =========================
    // التنقل السفلي
    // =========================

    private void setupNavigation() {

        findViewById(R.id.navHome).setOnClickListener(v -> {
            animateClick(v);
            scrollToTop();
        });

        findViewById(R.id.navEmergency).setOnClickListener(v -> {
            animateClick(v);
            openService("emergency");
        });

        findViewById(R.id.navServices).setOnClickListener(v -> {
            animateClick(v);
            openService("services");
        });

        findViewById(R.id.navExchange).setOnClickListener(v -> {
            animateClick(v);
            openService("exchange");
        });

        findViewById(R.id.navSettings).setOnClickListener(v -> {
            animateClick(v);
            openSettings();
        });
    }

    // =========================
    // الخدمات
    // =========================

    private void setupServices() {

        setupService(R.id.btnEmergency, "emergency");
        setupService(R.id.btnExchange, "exchange");
        setupService(R.id.btnPharmacy, "pharmacy");
        setupService(R.id.btnWater, "water");
        setupService(R.id.btnDeaths, "deaths");
        setupService(R.id.btnAlerts, "alerts");
    }

    private void setupService(int viewId, String serviceId) {

        View view = findViewById(viewId);

        view.setOnClickListener(v -> {

            animateClick(v);

            handler.postDelayed(() -> {
                openService(serviceId);
            }, 120);

        });
    }

    // =========================
    // تحديث البيانات
    // =========================

    private void setupRefresh() {

        View refresh = findViewById(R.id.btnRefresh);

        refresh.setOnClickListener(v -> {

            animateClick(v);

            TextView lastUpdate =
                    findViewById(R.id.lastUpdate);

            lastUpdate.setText("جاري تحديث البيانات...");

            handler.postDelayed(() -> {

                lastUpdate.setText(
                        "آخر تحديث: الآن"
                );

                Toast.makeText(
                        this,
                        "تم تحديث البيانات بنجاح",
                        Toast.LENGTH_SHORT
                ).show();

            }, 700);
        });
    }

    // =========================
    // فتح الخدمة
    // =========================

    private void openService(String serviceId) {

        android.content.Intent intent =
                new android.content.Intent(
                        this,
                        ServiceActivity.class
                );

        intent.putExtra(
                "service_id",
                serviceId
        );

        startActivity(intent);

        overridePendingTransition(
                android.R.anim.fade_in,
                android.R.anim.fade_out
        );
    }

    // =========================
    // الإعدادات
    // =========================

    private void openSettings() {

        android.content.Intent intent =
                new android.content.Intent(
                        this,
                        SettingsActivity.class
                );

        startActivity(intent);

        overridePendingTransition(
                android.R.anim.fade_in,
                android.R.anim.fade_out
        );
    }

    // =========================
    // حركة الواجهة عند الدخول
    // =========================

    private void animateInterface() {

        int[] views = {

                R.id.weatherCard,
                R.id.prayerCard,
                R.id.btnRefresh,
                R.id.btnEmergency,
                R.id.btnExchange,
                R.id.btnPharmacy,
                R.id.btnWater,
                R.id.btnDeaths,
                R.id.btnAlerts

        };

        for (int i = 0; i < views.length; i++) {

            View view = findViewById(views[i]);

            if (view == null) {
                continue;
            }

            view.setAlpha(0f);
            view.setTranslationY(35f);

            final long delay = 100L + (i * 70L);

            handler.postDelayed(() -> {

                ObjectAnimator alpha =
                        ObjectAnimator.ofFloat(
                                view,
                                View.ALPHA,
                                0f,
                                1f
                        );

                ObjectAnimator translation =
                        ObjectAnimator.ofFloat(
                                view,
                                View.TRANSLATION_Y,
                                35f,
                                0f
                        );

                AnimatorSet set =
                        new AnimatorSet();

                set.playTogether(
                        alpha,
                        translation
                );

                set.setDuration(450);

                set.setInterpolator(
                        new DecelerateInterpolator()
                );

                set.start();

            }, delay);
        }
    }

    // =========================
    // حركة الضغط
    // =========================

    private void animateClick(View view) {

        view.animate()
                .scaleX(0.96f)
                .scaleY(0.96f)
                .setDuration(80)
                .withEndAction(() -> {

                    view.animate()
                            .scaleX(1f)
                            .scaleY(1f)
                            .setDuration(120)
                            .start();

                })
                .start();
    }

    // =========================
    // العودة للأعلى
    // =========================

    private void scrollToTop() {

        View scroll =
                findViewById(R.id.contentScroll);

        if (scroll instanceof android.widget.ScrollView) {

            ((android.widget.ScrollView) scroll)
                    .smoothScrollTo(0, 0);
        }
    }

    // =========================
    // تنظيف Handler
    // =========================

    @Override
    protected void onDestroy() {

        handler.removeCallbacksAndMessages(null);

        super.onDestroy();
    }
}
