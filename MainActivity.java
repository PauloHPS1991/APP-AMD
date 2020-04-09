package com.example.appamd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    private String HOST = "https://paulohps1991.000webhostapp.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edt1);
        String url = HOST + "/cadastrar.json";

    }

    public void mudartela1(View view) {

        String cartao = editText.getText().toString();
        String url = HOST + "/logar.php";

        if (cartao.equals(cartao)){
            if (cartao.isEmpty()){
                Toast.makeText(MainActivity.this, "O Campos nao pode ser vazio" , Toast.LENGTH_LONG).show();

            }else {
                Ion.with(MainActivity.this)
                        .load(url)
                        .setBodyParameter("cartao_app", cartao)
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {

                            public void onCompleted(Exception e, JsonObject result) {
                                try {
                                    String RETORNO = result.get("LOGIN").getAsString();
                                    if (RETORNO.equals("ERRO")){
                                        Toast.makeText(MainActivity.this, "Numero de Cartão invalido", Toast.LENGTH_SHORT).show();
                                        Toast.makeText(MainActivity.this, "Entre em contato com seu convenio", Toast.LENGTH_SHORT).show();
                                    }else if (RETORNO.equals("SUCESSO")){
                                        Toast.makeText(MainActivity.this, "Cartão Valido", Toast.LENGTH_SHORT).show();
                                        Intent intent1 = new Intent(getApplicationContext(), Tela2Activity.class);
                                        startActivity(intent1);

                                    }


                                } catch (Exception error) {
                                    Toast.makeText(MainActivity.this, "ops erro" + error, Toast.LENGTH_LONG).show();
                                }

                            }
                        });
            }
        }else {

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
