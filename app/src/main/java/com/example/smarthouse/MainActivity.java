package com.example.smarthouse;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    public ImageView Zagruzka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Zagruzka = findViewById(R.id.Zagruzka);

        Zagruzka.setImageResource(R.drawable.splash_screen);

        // Установите размер изображения в зависимости от размера экрана
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        Zagruzka.setLayoutParams(new LinearLayout.LayoutParams(screenWidth, screenHeight));

        // Переход на следующую страницу через 5 секунд
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        }, 5000);
    }
}