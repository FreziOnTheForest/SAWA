package com.example.smarthouse;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class SignInActivity extends AppCompatActivity {

    public Button signInBut,signUpBut;
    public EditText emailSU,passwordRU;
    private TextInputLayout emailSUInputLayout, passwordSUInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signInBut = findViewById(R.id.signInBut);
        signUpBut = findViewById(R.id.signUpBut);

        emailSU = findViewById(R.id.emailSU);
        passwordRU = findViewById(R.id.passwordRU);

        emailSUInputLayout = findViewById(R.id.emailSUInputLayout);
        passwordSUInputLayout = findViewById(R.id.passwordSUInputLayout);

        signInBut.setOnClickListener(v -> {
            Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        signUpBut.setOnClickListener(v -> {
            String email = emailSU.getText().toString().trim();
            String password = passwordRU.getText().toString().trim();


            // Проверяем поля ввода на пустоту
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                // Если одно из полей пустое, показываем ошибку
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

            Intent intent = new Intent(SignInActivity.this,CreateCodeActivity.class );
            startActivity(intent);
        });
    }
}