package com.example.smarthouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CreateCodeActivity extends AppCompatActivity {

    private final View[] pinDots = new View[4]; // Для точек PIN-кода
    private StringBuilder pinBuilder; // Для хранения введенного PIN-кода
    private static final int PIN_LENGTH = 4; // Длина PIN-кода
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_code);

        pinDots[0] = findViewById(R.id.dot1);
        pinDots[1] = findViewById(R.id.dot2);
        pinDots[2] = findViewById(R.id.dot3);
        pinDots[3] = findViewById(R.id.dot4);

        pinBuilder = new StringBuilder();
        sharedPreferences = getSharedPreferences("MyAppPreferences", MODE_PRIVATE); // Инициализация SharedPreferences

        // Привязка кнопок от 1 до 9
        for (int i = 1; i <= 9; i++) {
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            Button button = findViewById(resID);
            button.setOnClickListener(new NumberButtonClickListener(i));
        }
    }

    private class NumberButtonClickListener implements View.OnClickListener {
        private final int number;

        NumberButtonClickListener(int number) {
            this.number = number;
        }

        @Override
        public void onClick(View v) {
            if (pinBuilder.length() < PIN_LENGTH) {
                pinBuilder.append(number);
                updatePinIndicator();

                // Проверка, если введен полный PIN-код
                if (pinBuilder.length() == PIN_LENGTH) {
                    savePin(); // Автоматическое сохранение PIN-кода
                }
            }
        }
    }

    private void updatePinIndicator() {
        for (int i = 0; i < PIN_LENGTH; i++) {
            if (i < pinBuilder.length()) {
                pinDots[i].setBackgroundResource(R.drawable.ellipse_4); // Устанавливаем стиль для заполненной точки
            } else {
                pinDots[i].setBackgroundResource(R.drawable.ellipse_5); // Устанавливаем стиль для пустой точки
            }
        }
    }

    private void savePin() {
        // Сохранение PIN-кода в SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("pin_code", pinBuilder.toString());
        editor.apply(); // Применение изменений
        Toast.makeText(this, "PIN-код сохранен", Toast.LENGTH_SHORT).show();

        // Очистка введенного PIN-кода после сохранения
        pinBuilder.setLength(0);
        updatePinIndicator();
    }
}

