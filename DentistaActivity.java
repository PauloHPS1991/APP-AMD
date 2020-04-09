package com.example.appamd;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.loopj.android.http.*;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class DentistaActivity extends AppCompatActivity {
    EditText edtnome;
    ListView listviewMedicos;
    private String HOST = "https://paulohps1991.000webhostapp.com";
    private String HOSTT = "http://192.168.0.17/login";
    private int itemClicado;

    MedicosAdapter medicosAdapter;
    List<Medico>lista;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentista);

        edtnome = (EditText) findViewById(R.id.edtnome);
        listviewMedicos = (ListView) findViewById(R.id.listviewMedicos);

        lista = new ArrayList<Medico>();
        medicosAdapter = new MedicosAdapter(DentistaActivity.this, lista);

        listviewMedicos.setAdapter(medicosAdapter);

        listaMedicos();



    }

    public void seleciona(View view) {



        if (edtnome.getText().toString().isEmpty()){
            Toast.makeText(DentistaActivity.this, "Precisa selecionar um medico",Toast.LENGTH_SHORT).show();
        }else{
            Intent intent1 = new Intent(getApplicationContext(),InformacaoActivity.class);
            startActivity(intent1);

        }
    }

    private void listaMedicos(){
        String url  = HOST + "/readDentista.php";
        Ion.with(getBaseContext())
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (int i = 0; i < result.size();i++){
                            JsonObject obj = result.get(i).getAsJsonObject();
                            Medico m = new Medico();
                            m.setId(obj.get("id").getAsInt());
                            m.setNome(obj.get("nome").getAsString());
                            m.setEspecialidade(obj.get("especialidade").getAsString());

                            lista.add(m);
                        }
                        medicosAdapter.notifyDataSetChanged();

                    }
                });
        listviewMedicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Medico m = (Medico) adapterView.getAdapter().getItem(position);
                edtnome.setText(String.valueOf(m.getNome()));

                itemClicado = position;
            }
        });



    }

}





