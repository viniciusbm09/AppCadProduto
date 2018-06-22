package br.edu.ifg.persist.SQLiteDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.ifg.model.Produto;
import br.edu.ifg.persist.DAO.ProdutoDAO;
import br.edu.ifg.persist.DatabaseHelper;
import br.edu.ifg.util.MyApp;


public class ProdutoDaoSqlite extends GenericDaoSqlite implements ProdutoDAO {
    @Override
    public long salvar(Produto p) {
        SQLiteDatabase db = getWritebleDB();
        ContentValues values = new ContentValues();
        values.put("nome", p.getNome());
        values.put("vlUnitario", p.getVlUnitario());
        values.put("estoque", p.getEstoque());

        long id = db.insert("produtos", null, values);

        return id;
    }

    @Override
    public void criar(Produto p) {

    }

    @Override
    public Produto buscar(int id) {
        //DatabaseHelper helper = DatabaseHelper.getInstance(MyApp.getContext());
        SQLiteDatabase db = getReadableDB();
        Cursor cursor = db.rawQuery("SELECT * from produtos where _id="+ id, null);
        Produto produto = new Produto();

        if (cursor != null){

            produto.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            produto.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            produto.setVlUnitario(cursor.getLong(cursor.getColumnIndex("vlUnitario")));
            produto.setEstoque(cursor.getInt(cursor.getColumnIndex("estoque")));

        }else{
            Toast.makeText(MyApp.getContext(),"Produto não encontrado com o ID" + id,Toast.LENGTH_LONG).show();
        }
        return produto;
    }

    @Override
    public void alterar(Produto p) {

    }

    @Override
    public void excluir(Produto p) {
        DatabaseHelper helper = DatabaseHelper.getInstance(MyApp.getContext());
        SQLiteDatabase db = getReadableDB();
        Cursor cursor = db.rawQuery("DELETE * from produtos where _id="+ p.getId(), null);

    }

    @Override
    public List<Produto> listarTodos() {

        //Instancia o helper obtendo o contexto
        DatabaseHelper helper = DatabaseHelper.getInstance(MyApp.getContext());
        SQLiteDatabase db = getReadableDB();
        //Cursor recebe o resultado da consulta via SQL
        Cursor cursor = db.rawQuery("SELECT * from produtos", null);
        //move o cursor para a primeira posição
        cursor.moveToFirst();

        List<Produto> produtos = new ArrayList<Produto>();

        //Enquanto cursor mover para o proximo item
        while (cursor.moveToNext()){
            Produto produto = new Produto();
            //Adiciona cada valor da coluna ao atribudo do objeto produto
            produto.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            produto.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            produto.setVlUnitario(cursor.getLong(cursor.getColumnIndex("vlUnitario")));
            produto.setEstoque(cursor.getInt(cursor.getColumnIndex("estoque")));
            //Adiciona o objeto ao List
            produtos.add(produto);
        }
        //fecha a consulta
        cursor.close();
        //retorna o List de objetos
        return produtos;
    }
}//fim da classe
