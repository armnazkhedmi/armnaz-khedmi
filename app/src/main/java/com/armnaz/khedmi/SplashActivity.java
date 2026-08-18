package com.armnaz.khedmi;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DURATION = 1800;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        View logo = findViewById(R.id.splashLogo);
        TextView title = findViewById(R.id.splashTitle);
        TextView subtitle = findViewById(R.id.splashSubtitle);
        View glow = findViewById(R.id.splashGlow);

        logo.setAlpha(0f);
        logo.setScaleX(0.65f);
        logo.setScaleY(0.65f);

        title.setAlpha(0f);
        subtitle.setAlpha(0f);
        glow.setAlpha(0f);

        ObjectAnimator logoAlpha =
                ObjectAnimator.ofFloat(logo, View.ALPHA, 0f, 1f);

        ObjectAnimator logoScaleX =
                ObjectAnimator.ofFloat(logo, View.SCALE_X, 0.65f, 1f);

        ObjectAnimator logoScaleY =
                ObjectAnimator.ofFloat(logo, View.SCALE_Y, 0.65f, 1f);

        AnimatorSet logoAnimation = new AnimatorSet();
        logoAnimation.playTogether(
                logoAlpha,
                logoScaleX,
                logoScaleY
        );
        logoAnimation.setDuration(700);
        logoAnimation.setInterpolator(
                new AccelerateDecelerateInterpolator()
        );

        ObjectAnimator glowAnimation =
                ObjectAnimator.ofFloat(glow, View.ALPHA, 0f, 1f);

        glowAnimation.setDuration(900);

        ObjectAnimator titleAnimation =
                ObjectAnimator.ofFloat(title, View.ALPHA, 0f, 1f);

        titleAnimation.setDuration(500);

        ObjectAnimator subtitleAnimation =
                ObjectAnimator.ofFloat(subtitle, View.ALPHA, 0f, 1f);

        subtitleAnimation.setDuration(500);

        logoAnimation.start();

        new Handler().postDelayed(
                glowAnimation::start,
                250
        );

        new Handler().postDelayed(
                titleAnimation::start,
                500
        );

        new Handler().postDelayed(
                subtitleAnimation::start,
                850
        );

        new Handler().postDelayed(() -> {

            Intent intent =
                    new Intent(
                            SplashActivity.this,
                            MainActivity.class
                    );

            startActivity(intent);

            overridePendingTransition(
                    android.R.anim.fade_in,
                    android.R.anim.fade_out
            );

            finish();

        }, SPLASH_DURATION);
    }
}
