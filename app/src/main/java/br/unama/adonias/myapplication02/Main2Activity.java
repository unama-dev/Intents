package br.unama.adonias.myapplication02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t = findViewById(R.id.texto);
        Bundle dados = getIntent().getExtras();
        t.setText(dados.getString("nome"));
    }
}
