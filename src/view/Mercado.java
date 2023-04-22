package view;

import helper.Utils;
import model.Produto;

import java.util.*;

public class Mercado {

    private static Scanner teclado = new Scanner(System.in);
    public static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<Produto>();
        carrinho = new HashMap<Produto, Integer>();
        Mercado.menu();

        }


    private static void menu() {
        System.out.println("========Bem-vindo(a)========");
        System.out.println("SELECIONE UMA OPÇÃO ABAIXO");

        System.out.println("1: cadastar Produto");
        System.out.println("2: Listar Produto");
        System.out.println("3: Comprar Produto");
        System.out.println("4: Visualizar Carrinho");
        System.out.println("5: Sair do Sistema");

        int opcao = 0;

        try{
            opcao = Integer.parseInt(Mercado.teclado.nextLine());
        }catch (InputMismatchException e) {
            Mercado.menu();
        }catch (NumberFormatException f) {
            Mercado.menu();
        }

        switch (opcao){
            case 1:
                Mercado.cadastrarProduto();
                break;

            case 2:
                Mercado.listarProduto();
                break;

            case 3:
                Mercado.comprarProduto();
                break;

            case 4:
                Mercado.vizualizarProduto();
                break;

            case 5:
                System.out.println("=====Volte Sempre=====");
                Utils.pausar(2);
                System.exit(0);
            default:
                System.out.println("Opção inválida");
                Utils.pausar(2);
                Mercado.menu();
                break;
        }

    }


    private static void cadastrarProduto(){
        System.out.println("Cadastro de Produto");

        System.out.println("Informe o Produto");
        String nome = Mercado.teclado.nextLine();

        System.out.println("Infoeme o preço");
        Double preco = Mercado.teclado.nextDouble();

        Produto produto = new Produto(nome, preco);

        Mercado.produtos.add(produto);
        System.out.println("O produto " + produto.getNome() +  " foi cadastrado com sucesso");

        Utils.pausar(2);
        Mercado.menu();
        }

    private static void listarProduto(){
        if(Mercado.produtos.size() > 0){
            System.out.println("Listagem de Produtos");
            System.out.println();

        for (Produto P: Mercado.produtos){
            System.out.println(P);
            System.out.println();

        }
        }else {
            System.out.println("Não há Produtos Cadastrados");
        }
        Utils.pausar(2);
        Mercado.menu();
    }

    private static void vizualizarProduto(){
        if(Mercado.carrinho.size() > 0){
            System.out.println("Produtos no Carrinho");
            System.out.println();

            for (Produto P: Mercado.carrinho.keySet()){
                System.out.println("Produto" + P + "Quatidade" + Mercado.carrinho.get(P));
                System.out.println();

            }
        }else {
            System.out.println("Não há Produtos no Carrinho");
        }
        Utils.pausar(2);
        Mercado.menu();
    }

    private static void comprarProduto(){
        if(Mercado.produtos.size() > 0){
            System.out.println("Informe o Código do produto");
            System.out.println();

            System.out.println("==========Produtos Disponíveis==========");

                for (Produto P: Mercado.produtos){
                System.out.println(P);
                System.out.println("--------------------");
            }
            int codigo = Integer.parseInt(Mercado.teclado.nextLine());
            boolean tem = false;


                for (Produto P : Mercado.produtos) {

                    if (P.getCodigo() == codigo) {
                        int quant = 0;

                        try {
                            quant = Mercado.carrinho.get(P);
                            Mercado.carrinho.put(P, quant + 1);

                        } catch (NullPointerException e) {
                            Mercado.carrinho.put(P, 1);
                        }
                        System.out.println("O produto " + P.getNome() + " foi adicionado ao carrinho");
                        tem = true;

                    }
                }
            if (tem){
                    System.out.println("Deseja adicionar outros produtos ao carrinho?");
                    System.out.println("Informe 1 para sim ou 0 para não");

                    int op = Integer.parseInt(Mercado.teclado.nextLine());
                if(op == 1){
                    Mercado.comprarProduto();
            }else {
                    System.out.println("Aguarde enquantos fechamos seu pedido");
                    Utils.pausar(2);
                    Mercado.fecharPedido();

                    }
        }else {
                    System.out.println("Não foi encontrado o produto de código " + codigo);
                    Utils.pausar(2);
                    Mercado.menu();
                 }
    }else {
                    System.out.println("Não há produtos");
                    Utils.pausar(2);
                    Mercado.menu();
            }
    }


    private static void fecharPedido(){
        Double ValorTotal = 0.0;
        System.out.println("Produtos do Carrinho");
        System.out.println("---------------------");
        for (Produto P : Mercado.carrinho.keySet()){
            int quant = Mercado.carrinho.get(P);
            ValorTotal += P.getPreco() * quant;
            System.out.println(P);
            System.out.println("Quantidade " + quant);
            System.out.println("--------------------");
        }
        System.out.println("Sua fatura é: " + Utils.doubleParaString(ValorTotal));
        Mercado.carrinho.clear();
        System.out.println("Obrigado pela preferêcia");
        Utils.pausar(5);
        Mercado.menu();

    }

}







