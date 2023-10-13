package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firebase.login.Login;
import com.example.firebase.registro.Registro;

public class MainActivity extends AppCompatActivity
{
    private Button btnRegistro;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistro = findViewById(R.id.btnRegistro);
        btnLogin = findViewById(R.id.btnLogin);

////////////////////////////// Botón Registro \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        btnRegistro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this, Registro.class);
                startActivity(i);
            }
        });
////////////////////////////// Botón Login \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                            Intent i= new Intent(MainActivity.this, Login.class);
                            startActivity(i);
            }
        });
    }
}

