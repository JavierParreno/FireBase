package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private EditText etRegisUser, etRegisCorreo, etRegisPss;
    private Button btnRegistro;
    private String usuarii, correo, pss;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRegisUser = findViewById(R.id.etRegisUser);
        etRegisCorreo = findViewById(R.id.etRegisCorreo);
        etRegisPss = findViewById(R.id.etRegisPss);

        btnRegistro = findViewById(R.id.btnRegistro);

        btnRegistro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                usuarii = etRegisUser.getText().toString().trim();
                correo = etRegisCorreo.getText().toString().trim();
                pss = etRegisPss.getText().toString().trim();

            }
        });
    }




    


}

