package model;

import helper.Utils;

public class Produto {

    private static int contador = 1;


    private int codigo;
    private String nome;
    private double preco;

    public Produto(String nome, Double preco) {
        this.codigo = Produto.contador;
        this.nome = nome;
        this.preco = preco;
        Produto.contador = contador += 1;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String toString(){
        return "Codígo: " + this.codigo +
                " Nome: " + this.nome +
                " Preço: " + Utils.doubleParaString(this.getPreco());
    }


}
