package br.edu.ifg.model;

public class Produto {

    //Atributos
    private int id;
    private String nome;
    private double vlUnitario;
    private int estoque;


    public int getId() {return id; }

    public void setId(int id) { this.id = id;  }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVlUnitario() {
        return vlUnitario;
    }

    public void setVlUnitario(double vlUnitario) {
        this.vlUnitario = vlUnitario;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }


}//fim da classe
