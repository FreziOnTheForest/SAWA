package com.example.smarthouse;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button signInBut = findViewById(R.id.signInBut);
        Button singUpBut = findViewById(R.id.signUpBut); // Исправлено имя переменной

        EditText nameSU = findViewById(R.id.nameSU);
        EditText emailSU = findViewById(R.id.emailSU);
        EditText passwordSU = findViewById(R.id.passwordSU);

        // Объявляем TextInputLayout для полей ввода
        TextInputLayout nameSUInputLayout = findViewById(R.id.nameSUInputLayout);
        TextInputLayout emailSUInputLayout = findViewById(R.id.emailSUInputLayout);
        TextInputLayout passwordSUInputLayout = findViewById(R.id.passwordSUInputLayout);

        singUpBut.setOnClickListener(v -> {
            String name = nameSU.getText().toString().trim();
            String email = emailSU.getText().toString().trim();
            String password = passwordSU.getText().toString().trim();

            // Проверяем поля ввода на пустоту
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                // Если одно из полей пустое, показываем ошибку
                if (TextUtils.isEmpty(name)) {
                    nameSUInputLayout.setError("Введите имя");
                }
                if (TextUtils.isEmpty(email)) {
                    emailSUInputLayout.setError("Введите почту");
                }
                if (TextUtils.isEmpty(password)) {
                    passwordSUInputLayout.setError("Введите пароль");
                }
                return;
            }

            // Проверяем почту на корректность
            String emailPattern = "^[a-z0-9]+@[a-z0-9]+\\.ru$";
            if (!email.matches(emailPattern)) {
                // Если почта не соответствует паттерну, показываем ошибку
                emailSUInputLayout.setError("Некорректная почта");
                return;
            }

            // Здесь можно добавить логику для успешной регистрации
            // Например, сохранение данных пользователя или переход на другой экран
            Toast.makeText(this, "Регистрация успешна!", Toast.LENGTH_SHORT).show();

            // Переход на следующий экран после успешной регистрации
            Intent intent = new Intent(SignUpActivity.this, CreateCodeActivity.class); // Замените на нужный экран
            startActivity(intent);
        });

        // Установим слушатель на кнопку входа
        signInBut.setOnClickListener(v -> {
            // Переходим на экран входа
            Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
            startActivity(intent);
        });
    }
}