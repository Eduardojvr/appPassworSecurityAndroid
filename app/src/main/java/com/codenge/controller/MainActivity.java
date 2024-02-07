package com.codenge.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import com.codenge.services.EncriptacaoAES;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase mDatabase;
    public static final String PREFS_NAME = "preferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = openOrCreateDatabase("minhaBase.db", Context.MODE_PRIVATE, null);

        final EditText editTextPassword = findViewById(R.id.editTextPassword);
        final EditText nomePass = findViewById(R.id.editText);
        Button buttonSave = findViewById(R.id.botaoSalvar);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = editTextPassword.getText().toString();
                String nome = nomePass.getText().toString();


            }
        });
    }


    public void encrypt(View view){
        try {
            String textoOriginal = "Olá, mundo!";
            System.out.println("Texto original: " + textoOriginal);

            String textoEncriptado = EncriptacaoAES.encriptar(textoOriginal);
            System.out.println("Texto encriptado: " + textoEncriptado);

            String textoDesencriptado = EncriptacaoAES.desencriptar(textoEncriptado);
            System.out.println("Texto desencriptado: " + textoDesencriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}