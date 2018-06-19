package br.edu.ifg.persist.SQLiteDAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
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
        return null;
    }

    @Override
    public void alterar(Produto p) {

    }

    @Override
    public void excluir(Produto p) {

    }

    @Override
    public List<String> listarTodos() {
//DatabaseHelper helper = new DatabaseHelper(MyApp.getContext());
        SQLiteDatabase db = getReadableDB();
        Cursor cursor = db.rawQuery("SELECT * from produtos", null);
        cursor.moveToFirst();

        List<String> produtos = new ArrayList<>();
        while (cursor.moveToNext()){
            produtos.add(String.valueOf(cursor.getColumnIndex("nome")));
            produtos.add(String.valueOf(cursor.getColumnIndex("vlUnitario")));
            produtos.add(String.valueOf(cursor.getColumnIndex("estoque")));


        }

        return produtos;
    }//fim da classe


}
/*
//DatabaseHelper helper = new DatabaseHelper(MyApp.getContext());
        SQLiteDatabase db = getReadableDB();
        Cursor cursor = db.rawQuery("SELECT * from produtos", null);
        cursor.moveToFirst();

        List<String> produtos = new ArrayList<>();
        while (cursor.moveToNext()){
            produtos.add(String.valueOf(cursor.getColumnIndex("nome")));
            produtos.add(String.valueOf(cursor.getColumnIndex("vlUnitario")));
            produtos.add(String.valueOf(cursor.getColumnIndex("estoque")));


        }



        return produtos;

 */

/*
 //DatabaseHelper helper = new DatabaseHelper(MyApp.getContext());
        SQLiteDatabase db = getReadableDB();
        Cursor cursor = db.rawQuery("SELECT * from produtos", null);
        cursor.moveToFirst();

        List<String> produtos = new ArrayList<>();

        while (cursor.moveToNext()){
            Produto produto = new Produto();
            produto.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            produto.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            produto.setVlUnitario(cursor.getLong(cursor.getColumnIndex("vlUnitario")));
            produto.setEstoque(cursor.getInt(cursor.getColumnIndex("estoque")));
            produtos.add(produto);
        }
 */