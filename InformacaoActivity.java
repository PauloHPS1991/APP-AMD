package com.example.appamd;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.List;

public class InformacaoActivity extends AppCompatActivity {

    EditText editNomem, editTelefonem, editEmailm, editEnd, editEspecialidade;
    private String HOST = "https://paulohps1991.000webhostapp.com";
    private String HOSTT = "http://192.168.0.17/login";
    private int itemClicado;

    MedicosAdapter medicosAdapter;
    List<Medico> lista;

    //Medico m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao);

        editNomem = (EditText) findViewById(R.id.editNomem);
        editTelefonem = (EditText) findViewById(R.id.editTelefonem);
        editEmailm = (EditText) findViewById(R.id.editEmailm);
        editEnd = (EditText) findViewById(R.id.editEnd);
        editEspecialidade = (EditText) findViewById(R.id.editEspecialidade);

        listarmedico();
        //itemClicado = position;


    }

    public void viawhats(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=5512988508446&text=Gostaria de marcar uma consulta, Meu nome é: ")));
    }

    public void emailll(View view) {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setData(Uri.parse("mailto"));
        email.setType("message/rfc822");
        email.putExtra(Intent.EXTRA_EMAIL,
                new String[]{"paulohps1991@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT,
                "Marcar Consulta: ");
        email.putExtra(Intent.EXTRA_TEXT, "Ola, Gostaria de marcar uma consulta " + "\n Nome: " + "\n Telefone: " + "\n Numero do Cartao: ");
        startActivity(Intent.createChooser(email, "ENVIAR E-MAIL"));
    }

    public void ligar(View view) {

        String telefone = "12988508446";
        Uri uri = Uri.parse("tel:" + telefone);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);

        startActivity(intent);
    }

/*
    public void listarmedico(){

        Medico m = new Medico();
        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");

        editNomem.setText(String.valueOf(m.getNome()));
        editTelefonem.setText(String.valueOf(m.getTelefone()));
        editEmailm.setText(String.valueOf(m.getEmail()));
        editEnd.setText(String.valueOf(m.getEndereco()));
        editEspecialidade.setText(String.valueOf(m.getEspecialidade()));


    }*/

    public void listarmedico() {

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String telefone = intent.getStringExtra("contato");
        String email = intent.getStringExtra("email");
        String endereco = intent.getStringExtra("endereco");
        String especialidade = intent.getStringExtra("especialidade");

        editNomem.setText(nome);
        editTelefonem.setText(telefone);
        editEmailm.setText(email);
        editEnd.setText(endereco);
        editEspecialidade.setText(especialidade);


    }
}
