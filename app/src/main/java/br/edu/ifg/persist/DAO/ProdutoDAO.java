package br.edu.ifg.persist.DAO;

import android.database.Cursor;

import java.util.List;

import br.edu.ifg.model.Produto;

public interface ProdutoDAO {
    long    salvar(Produto p);
    void    criar(Produto p);
    Produto buscar(int id);
    void    alterar(Produto p);
    void    excluir(Produto p);

    List<Produto> listarTodos();

    //Cursor listarProdutos();

}//fim da interface
