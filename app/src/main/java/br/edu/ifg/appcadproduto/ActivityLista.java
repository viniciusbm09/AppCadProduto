package br.edu.ifg.appcadproduto;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.List;

import br.edu.ifg.model.Produto;
import br.edu.ifg.persist.DAO.FabricaDAO;
import br.edu.ifg.persist.DAO.ProdutoDAO;
import br.edu.ifg.persist.DatabaseHelper;
import br.edu.ifg.persist.SQLiteDAO.ProdutoDaoSqlite;
import br.edu.ifg.util.MyApp;

public class ActivityLista extends AppCompatActivity {

    //Instancias
    private ProdutoDAO produtoDAO;
    ProdutoDaoSqlite produtoDaoSqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ListView lista = (ListView) findViewById(R.id.lstItens);

        //String[] strings = new String[] { "nome1", "nome2", "nome3", "nome4" };
        String[] strings = produtoDaoSqlite.listarTodos().toArray(new String[0]);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strings);

        lista.setAdapter(adapter);


    }
}//fim da classe

/*
ListView lista = (ListView) findViewById(R.id.lstItens);

        //String[] strings = new String[] { "nome1", "nome2", "nome3", "nome4" };
        String[] strings = produtoDaoSqlite.listarTodos();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strings);

        lista.setAdapter(adapter);
 */