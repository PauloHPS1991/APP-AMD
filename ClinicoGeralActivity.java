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

public class ClinicoGeralActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_clinico_geral);

        edtnome = (EditText) findViewById(R.id.edtnome);
        listviewMedicos = (ListView) findViewById(R.id.listviewMedicos);

        lista = new ArrayList<Medico>();
        medicosAdapter = new MedicosAdapter(ClinicoGeralActivity.this, lista);

        listviewMedicos.setAdapter(medicosAdapter);

        listaMedicos();
    }

    public void seleciona(View view) {
            if (edtnome.getText().toString().isEmpty()){
                Toast.makeText(ClinicoGeralActivity.this, "Precisa selecionar um medico",Toast.LENGTH_SHORT).show();

            }else {
                Intent intent1 = new Intent(getApplicationContext(),InformacaoActivity.class);

                Medico m = new Medico();

                intent1.putExtra("nome", m.getNome());
                intent1.putExtra("telefone", m.getTelefone());
                intent1.putExtra("email", m.getEmail());
                intent1.putExtra("endereco", m.getEndereco());
                intent1.putExtra("especialidade", m.getEspecialidade());
                startActivity(intent1);
            }}

    private void listaMedicos(){
        String url  = HOST + "/readClinicoGeral.php";
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
                            m.setTelefone(obj.get("telefone").getAsString());
                            m.setEmail(obj.get("email").getAsString());
                            m.setEndereco(obj.get("endereco").getAsString());
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
