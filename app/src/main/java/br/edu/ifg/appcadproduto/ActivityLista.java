package br.edu.ifg.appcadproduto;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;
import br.edu.ifg.model.Produto;
import br.edu.ifg.persist.SQLiteDAO.ProdutoDaoSqlite;
import br.edu.ifg.util.MyApp;

public class ActivityLista extends AppCompatActivity {

    //Instancias
    ProdutoDaoSqlite produtoDaoSqlite = new ProdutoDaoSqlite();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        //ListView
        ListView listView = (ListView) findViewById(R.id.lstItens);
        List<Produto> produtos = produtoDaoSqlite.listarTodos();
        ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(MyApp.getContext(), android.R.layout.simple_list_item_1,produtos);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String codigo;
                Toast.makeText(MyApp.getContext(),"id " + i,Toast.LENGTH_LONG).show();

            }
        });

    }



}//fim da classe
