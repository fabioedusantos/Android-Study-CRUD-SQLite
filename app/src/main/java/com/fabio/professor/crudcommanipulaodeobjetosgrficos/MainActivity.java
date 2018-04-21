package com.fabio.professor.crudcommanipulaodeobjetosgrficos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.fabio.professor.crudcommanipulaodeobjetosgrficos.dao.DaoAdapter;
import com.fabio.professor.crudcommanipulaodeobjetosgrficos.dao.DaoUsuarios;
import com.fabio.professor.crudcommanipulaodeobjetosgrficos.domain.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TextView lblTitulo;
    private EditText txtNome;
    private EditText txtSenha;
    private EditText txtConfirme;
    private Usuario usuario;
    private DaoUsuarios daoUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        lblTitulo = findViewById(R.id.lblTitulo);
        txtNome = findViewById(R.id.txtNome);
        txtSenha = findViewById(R.id.txtSenha);
        txtConfirme = findViewById(R.id.txtConfirme);

        usuario = new Usuario();

        DaoAdapter daoAdapter = new DaoAdapter(this);
        daoAdapter.onCreate(daoAdapter.getWritableDatabase());
        daoUsuarios = new DaoUsuarios(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<String> lista = new ArrayList<>();
        final List<Usuario> usuarios = daoUsuarios.get();

        if (usuarios.size() > 0) setTitle("Usuários Cadastrados");
        else setTitle("Não há usuários cadastrados");

        for (Usuario u : usuarios) lista.add(u.getNome());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                lista);
        listView.setAdapter(adapter);
    }

    public void salvar(View v) {
    }

    public void limpar(View v) {
        limpar();
    }

    private void limpar() {
        usuario = new Usuario();
        txtNome.setText("");
        txtSenha.setText("");
        txtConfirme.setText("");
        lblTitulo.setText("Novo Usuário");
    }
}
