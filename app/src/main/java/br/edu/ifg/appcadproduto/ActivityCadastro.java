package br.edu.ifg.appcadproduto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifg.model.Produto;
import br.edu.ifg.persist.DAO.FabricaDAO;
import br.edu.ifg.persist.DAO.ProdutoDAO;
import br.edu.ifg.persist.DatabaseHelper;

public class ActivityCadastro extends AppCompatActivity {

    //Instâncias
    //private DatabaseHelper db;
    private ProdutoDAO produtoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        //Botao gravar
        Button btnGravar = (Button) findViewById(R.id.btnGravar);
        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //textViews
                EditText edtNome =findViewById(R.id.edtNome);
                EditText edtVlUniatio = findViewById(R.id.edtVlUnitario);
                EditText edtEstoque = findViewById(R.id.edtEstoque);

                produtoDAO = FabricaDAO.criarProdutoDAO();
                Produto produto = new Produto();
                produto.setNome(edtNome.getText().toString());
                produto.setVlUnitario(Double.parseDouble(edtVlUniatio.getText().toString()));
                produto.setEstoque(Integer.parseInt(edtEstoque.getText().toString()));
                long id = produtoDAO.salvar(produto);


                //Exibe uma notificação na  tela
                if(id!=-1){
                    Toast.makeText(getApplicationContext(),"Produto " + id + " salvo com sucesso",Toast.LENGTH_LONG).show();
                    //finaliza a activity
                    finish();

                }else{

                    Toast.makeText(getApplicationContext(),"Erro ao grava pessoa",Toast.LENGTH_LONG).show();

                }
            }
        });



    }//fim don onCreate
}//fim da classe
