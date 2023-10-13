package com.example.firebase.registro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firebase.R;
import com.example.firebase.usuario.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registro extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private FirebaseUser fbUser;
    private EditText etRegisUser, etRegisCorreo, etRegisPss;
    private Button btnRegistro;

    private String usuarii, correo, pss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference().child("Usuarios");

        etRegisUser = findViewById(R.id.etRegisUser);
        etRegisCorreo = findViewById(R.id.etRegisCorreo);
        etRegisPss = findViewById(R.id.etRegisPss);

        btnRegistro = findViewById(R.id.btnRegistro);

////////////////////////////// Botón Registro \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuarii = etRegisUser.getText().toString().trim();
                correo = etRegisCorreo.getText().toString().trim();
                pss = etRegisPss.getText().toString().trim();
                Usuario user = new Usuario(usuarii, correo);

                mAuth.createUserWithEmailAndPassword(correo, pss).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            fbUser = mAuth.getCurrentUser();
                            String uid = fbUser.getUid();
                            mRef.child(uid).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {

                                        Intent i = new Intent(Registro.this, RegistroOK.class);
                                        startActivity(i);
                                    } else {
                                        Toast.makeText(Registro.this, "argggggg", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(Registro.this, "Algo ha ido mal", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}