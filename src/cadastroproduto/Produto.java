/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroproduto;

/**
 * Classe que representa a entidade Produto.
 * 
 * Contém os atributos básicos de um produto:
 * - id: identificador único
 * - descricao: nome ou descrição do produto
 * - preco: valor unitário do produto
 * 
 * Utilizada para transporte de dados entre o sistema e o banco de dados.
 * 
 * @author Pedro Carmo
 */
public class Produto {
    
    // Atributos da classe
    private int id; // Identificador único do produto
    private String descricao; // Descrição do produto
    private double preco; // Preço do produto

    
    //Construtor vazio sem parâmetros
    public Produto(){
    }
    
    // Construtor com parâmetros para inicialização completa do objeto
    public Produto(int id, String descricao, double preco){
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }
    
    
    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
