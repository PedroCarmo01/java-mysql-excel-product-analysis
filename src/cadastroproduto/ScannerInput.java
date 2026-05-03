/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroproduto;
import java.util.Scanner;

/**
 * Classe responsável pela validação e tratamento das entradas do usuário via Scanner.
 * 
 * Centraliza regras de validação para:
 * - Opções de menu
 * - Descrição de produtos
 * - Valores monetários
 * - Identificadores (ID)
 * - Confirmações de operações
 * 
 * Evita repetição de código e melhora organização do sistema.
 * 
 * @author Pedro Carmo
 */
public class ScannerInput {
    
    /**
     * Valida a opção digitada pelo usuário no menu
     * 
     * @param scanner objeto Scanner para a leitura de dados
     * @param opcao_min valor mínimo permitido
     * @param opcao_max valor máximo permitido
     * @return opção válida dentro do intervalo informado
     */
    public int verificarOpcaoMenu(Scanner scanner, int opcao_min , int opcao_max){
        int opcao;
        while(true){
            System.out.println("\nEscolha uma opção: ");
            
            if(scanner.hasNextInt()){
                opcao = scanner.nextInt();
                scanner.nextLine();
                
                if(opcao >= opcao_min && opcao <= opcao_max){
                    return opcao;
                } else {
                    System.out.println("\nOpção inválida!");
                }
            } else {
                System.out.println("\nOpção inválida!");
                scanner.next();
            }
        }
    }
    
    /**
     * Valida a descrição do produto informada pelo usuário
     * 
     * Garante que a descrição do produto não esteja vazia
     * 
     * @param scanner objeto Scanner para leitura de dados
     * @param mensagem exibida ao usuário
     * @return descrição válida (não vazia)
     */
    public String verificarDescricaoProduto(Scanner scanner, String mensagem){
        String descricao;
        
        do{
            System.out.println(mensagem);
            descricao = scanner.nextLine().trim();
            
            if(descricao.isEmpty()){
                System.out.println("\nA descrição não pode estar vazia!");
            }
            
        } while (descricao.isEmpty());
        return descricao;
    }   
    
    /**
     * Valida o valor do produto informado pelo usuário.
     * 
     * Garante que o valor seja numérico e maior que zero.
     * 
     * @param scanner objeto Scanner para leitura de dados
     * @return valor válido do produto
     */
    public double verificarValorProduto(Scanner scanner){
        double preco;
        while(true){
            System.out.println("\nDigite o valor unitário do Produto: R$");
            
            if(scanner.hasNextDouble()){
                preco = scanner.nextDouble();
                scanner.nextLine();
                
                if(preco > 0){
                    return preco;
                } else{
                    System.out.println("\nO valor deve ser maior que ZERO!");
                }
            } else{
                System.out.println("\nValor inválido!");
                scanner.next();
            }
        }
    }
    
    /**
     * Valida o ID do produto informado pelo usuário.
     * 
     * Garante que:
     * - O valor seja numérico
     * - Seja maior que zero
     * - O valor exista no banco de dados
     * 
     * @param scanner objeto Scanner para leitura de dados
     * @param pDao objeto ProdutoDAO para verificação no banco
     * @return ID válido existente no banco de dados
     */
    public int verificarIdProduto(Scanner scanner, ProdutoDAO pDao){
        int id;
        
        while(true){
            System.out.println("\nDigite o ID do produto: ");
            
            if(scanner.hasNextInt()){
                    id = scanner.nextInt();
                    scanner.nextLine();

                    if(id <= 0){
                        System.out.println("\nID inválido!");
                        continue;
                    }
                 try{
                        if(pDao.verificarID(id)){
                            return id;
                        } else{
                        System.out.println("\nID não localizado!");
                        }
                } catch (Exception ex){
                    System.out.println("Erro: " + ex.getMessage());           
                } 
            } else{
                System.out.println("\nID inválido!");
                scanner.next();
            }   
        }
    } 
    
    /**
     * Solicita confirmação do usuário para execução de uma ação.
     * 
     * @param scanner objeto Scanner para leitura de dados
     * @return 1 para confirmar (SIM) ou 2 para cancelar (NÃO)
     */
    public int confirmarProduto(Scanner scanner){
        int confirmacao;
        
        do{
            System.out.println("\n1 - SIM\n2 - NÃO");
            confirmacao = scanner.nextInt();
            scanner.nextLine();
            
            if(confirmacao != 1 && confirmacao != 2){
                System.out.println("\nOpção inválida!");
            } 
        } while(confirmacao != 1 && confirmacao != 2);
            
        return confirmacao;
    }
    
    
    
    
}

