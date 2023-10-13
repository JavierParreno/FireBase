package com.example.firebase.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firebase.login.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firebase.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private FirebaseUser fbUser;
    private EditText etLoginUser, etLoginPss;
    private Button btnLogin;
    private String loginCorreo, loginPss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference().child("Usuarios");

        etLoginUser = findViewById(R.id.etLoginUser);
        etLoginPss = findViewById(R.id.etLoginPss);

        btnLogin = findViewById(R.id.btnLogin);

////////////////////////////// Botón Login \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginCorreo = etLoginUser.getText().toString().trim();
                loginPss = etLoginPss.getText().toString().trim();

                mAuth.signInWithEmailAndPassword(loginCorreo, loginPss).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(Login.this, Logeado.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(Login.this, "Algo ha ido mal", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}