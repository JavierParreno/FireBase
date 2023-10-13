package com.example.firebase.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.firebase.R;
import com.example.firebase.usuario.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Logeado extends AppCompatActivity {

    private EditText etUserLog;
    private TextView tvTitulo;
    private String userLog;
    private Usuario user;
    private  String usu;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private FirebaseUser fbUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logeado_ok);

        tvTitulo = findViewById(R.id.tvTituloo);
        etUserLog = findViewById(R.id.etUserLogg);

        mAuth = FirebaseAuth.getInstance();
        fbUser = mAuth.getCurrentUser();
        String uid = fbUser.getUid();

        mRef = FirebaseDatabase.getInstance().getReference().child("Usuarios").child(uid);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user = snapshot.getValue(Usuario.class);
                userLog = user.getUsuarioNombre();
                tvTitulo.setText("Contactos de: " + userLog);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}