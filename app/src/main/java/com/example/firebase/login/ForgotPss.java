package com.example.firebase.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class ForgotPss extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText etCorreoRecor;
    private  String correoRecover;

    private Button btnRecovery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pss);

        mAuth = FirebaseAuth.getInstance();

        etCorreoRecor = findViewById(R.id.etCorreoRecor);
        btnRecovery = findViewById(R.id.btnRecupera);


        //////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        ////////////////////////////// Boton Recovery \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        btnRecovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correoRecover = etCorreoRecor.getText().toString().trim();


                mAuth.sendPasswordResetEmail(correoRecover).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Intent i = new Intent(ForgotPss.this, Login.class);
                            startActivity(i);
                        }

                    }
                });
            }
        });

        //////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    }
}