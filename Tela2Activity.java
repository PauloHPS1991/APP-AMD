package com.example.appamd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Tela2Activity extends AppCompatActivity {

    private String HOSTT = "http://192.168.0.17/login/";
    private String HOST = "https://paulohps1991.000webhostapp.com";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
    }

    public void pediatra(View view) {

        Toast.makeText(Tela2Activity.this,"Pediatra" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),PediatraActivity.class);
        startActivity(intent1);
    }

    public void clinicoGeral(View view) {
        Toast.makeText(Tela2Activity.this,"Clinico Geral" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),ClinicoGeralActivity.class);
        startActivity(intent1);

    }

    public void psiquiatra(View view) {

        Toast.makeText(Tela2Activity.this,"Psiquiatra" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),PsiquiatraActivity.class);
        startActivity(intent1);

    }

    public void psicologa(View view) {
        Toast.makeText(Tela2Activity.this,"Psicologa" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),PsicologaActivity.class);
        startActivity(intent1);
    }

    public void dentista(View view) {
        Toast.makeText(Tela2Activity.this,"Dentista" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),DentistaActivity.class);
        startActivity(intent1);
    }

    public void Anestesista(View view) {
        Toast.makeText(Tela2Activity.this,"Anestesistas" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),AnestesistaActivity.class);
        startActivity(intent1);

    }

    public void oftalmo(View view) {
        Toast.makeText(Tela2Activity.this,"Oftalmologista" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),OftalmoActivity.class);
        startActivity(intent1);
    }

    public void Ortopedista(View view) {
        Toast.makeText(Tela2Activity.this,"Ortopedistas" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),OrtopedistaActivity.class);
        startActivity(intent1);
    }

    public void Neuro(View view) {
        Toast.makeText(Tela2Activity.this,"NeuroLogistas" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),NeuroActivity.class);
        startActivity(intent1);
    }

    public void Cardio(View view) {
        Toast.makeText(Tela2Activity.this,"Cardiologista" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),CardioActivity.class);
        startActivity(intent1);
    }

    public void endo(View view) {
        Toast.makeText(Tela2Activity.this,"Endocrinologista" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),EndocriActivity.class);
        startActivity(intent1);
    }

    public void hema(View view) {
        Toast.makeText(Tela2Activity.this,"Hemaopata" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),HematoActivity.class);
        startActivity(intent1);
    }

    public void Oncologista(View view) {
        Toast.makeText(Tela2Activity.this,"Oncologista" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),OncoloActivity.class);
        startActivity(intent1);
    }

    public void Urologista(View view) {
        Toast.makeText(Tela2Activity.this,"Urologistaa" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),UrologistaActivity.class);
        startActivity(intent1);
    }

    public void Dermato(View view) {
        Toast.makeText(Tela2Activity.this,"Dermatologistas" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),DermatoActivity.class);
        startActivity(intent1);
    }

    public void Homeopatia(View view) {
        Toast.makeText(Tela2Activity.this,"Homeopatias" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent1);
    }

    public void Reumatologista(View view) {
        Toast.makeText(Tela2Activity.this,"Reumatologista" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),ReumaActivity.class);
        startActivity(intent1);

    }

    public void Geriatria(View view) {
        Toast.makeText(Tela2Activity.this,"Geriatria" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),GeriatriaActivity.class);
        startActivity(intent1);
    }

    public void CP(View view) {
        Toast.makeText(Tela2Activity.this,"Cirurgião Plástico" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),CPActivity.class);
        startActivity(intent1);
    }

    public void Nutricionista(View view) {
        Toast.makeText(Tela2Activity.this,"Nutricionista" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),NutriActivity.class);
        startActivity(intent1);
    }

    public void exame(View view) {
        Toast.makeText(Tela2Activity.this,"Consulta de Exames" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),ExameActivity.class);
        startActivity(intent1);
    }
}
