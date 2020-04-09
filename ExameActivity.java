package com.example.appamd;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ExameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exame);
    }

    public void unimed(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.unimedsjc.com.br/site/pagina/detalhe/17649")));
    }

    public void plani(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://resultados.plani.com.br/login")));
    }

    public void sabin(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://laudos.sabin.com.br/shift/lis/sabin/elis/resultados/sabin.Login.csp?")));
    }

    public void vivalle(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.rededorsaoluiz.com.br/hospital/vivalle/paciente/resultado-exames")));
    }

    public void osvaldo(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.oswaldocruz.com/site/resultados-online")));
    }
}
