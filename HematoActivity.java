package com.example.appamd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

public class HematoActivity extends AppCompatActivity {
    EditText edtnome;
    ListView listviewMedicos;
    private String HOST = "https://paulohps1991.000webhostapp.com";
    private String HOSTT = "http://192.168.0.17/login";

    private int itemClicado;

    MedicosAdapter medicosAdapter;
    List<Medico> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hemato);
        edtnome = (EditText) findViewById(R.id.edtnome);
        listviewMedicos = (ListView) findViewById(R.id.listviewMedicos);

        lista = new ArrayList<Medico>();
        medicosAdapter = new MedicosAdapter(HematoActivity.this, lista);

        listviewMedicos.setAdapter(medicosAdapter);

        listaMedicos();
    }

    private void listaMedicos(){
        String url  = HOST + "/readHemato.php";
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

    public void seleciona(View view) {
        if (edtnome.getText().toString().isEmpty()){
            Toast.makeText(HematoActivity.this, "Precisa selecionar um medico",Toast.LENGTH_SHORT).show();

        }else {
        Toast.makeText(HematoActivity.this,"Medico Selecionado" ,Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(getApplicationContext(),InformacaoActivity.class);
        startActivity(intent1);
    }}
}
