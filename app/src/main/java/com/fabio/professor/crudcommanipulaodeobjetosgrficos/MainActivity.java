package com.fabio.professor.crudcommanipulaodeobjetosgrficos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TextView lblTitulo;
    private EditText txtNome;
    private EditText txtSenha;
    private EditText txtConfirme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        lblTitulo = findViewById(R.id.lblTitulo);
        txtNome = findViewById(R.id.txtNome);
        txtSenha = findViewById(R.id.txtSenha);
        txtConfirme = findViewById(R.id.txtConfirme);
    }

    public void salvar(View v) {
    }

    public void limpar(View v) {
        txtNome.setText("");
        txtSenha.setText("");
        txtConfirme.setText("");
        lblTitulo.setText("Novo Usuário");
    }
}
