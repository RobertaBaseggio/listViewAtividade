package br.com.senai.myshoplist;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListagemCadastro  extends ListActivity {

    private EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(this::onClick);

    }

    public void onClick(View v){

        nome = (EditText) findViewById(R.id.nome);

        List<String> produtos = new ArrayList<String>();

        produtos.add(nome.toString());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, produtos);
        setListAdapter(arrayAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String produto = (String) this.getListAdapter().getItem(position);
        Toast.makeText(this, "Você selecionou: " + produto, Toast.LENGTH_SHORT).show();
    }

}
