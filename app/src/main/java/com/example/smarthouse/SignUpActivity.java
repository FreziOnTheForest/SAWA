package com.example.smarthouse;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {
    public Button signInBut,singUpBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signInBut = findViewById(R.id.signInBut);
        singUpBut = findViewById(R.id.singUpBut);

        EditText nameSU = findViewById(R.id.nameSU);
        EditText emailSU = findViewById(R.id.emailSU);
        EditText passwordSU = findViewById(R.id.passwordSU);

        // Объявляем TextInputLayout для полей ввода
        TextInputLayout nameSUInputLayout = findViewById(R.id.nameSUInputLayout);
        TextInputLayout emailSUInputLayout = findViewById(R.id.emailSUInputLayout);
        TextInputLayout passwordSUInputLayout = findViewById(R.id.passwordSUInputLayout);

        singUpBut.setOnClickListener(v -> {
        });
        signInBut.setOnClickListener(v -> {
            String name = nameSU.getText().toString();
            String email = emailSU.getText().toString();
            String password = passwordSU.getText().toString();


            // Проверяем поля ввода на пустоту
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                // Если одно из полей пустое, показываем ошибку
                if (name.isEmpty()) {
                    nameSUInputLayout.setError("Введите имя");
                }
                if (email.isEmpty()) {
                    emailSUInputLayout.setError("Введите почту");
                }
                if (password.isEmpty()) {
                    passwordSUInputLayout.setError("Введите пароль");
                }
                return;
            }
            // Проверяем почту на корректность
            String emailPattern = "^[a-z0-9]+@[a-z0-9]+\\.ru$";
            if (!email.matches(emailPattern)) {
                // Если почта не соответствует паттерну showc ошибку
                emailSUInputLayout.setError("Некорректная почта");
                return;
            }

            Intent intent = new Intent(SignUpActivity.this,SignInActivity.class);
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