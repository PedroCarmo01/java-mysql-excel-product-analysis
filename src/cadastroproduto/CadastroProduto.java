/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastroproduto;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal do sistema cadastro de produtos.
 * 
 * Responsável por:
 * - Exibir o menu principal
 * - Capturar interações do usuário
 * - Direcionar operações (CRUD)
 * 
 * @author Pedro Carmo
 */
public class CadastroProduto {

    /**
     * Método principal que executa o sistema
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Scanner para verificar dados de entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Classe responsável pela validação de entrada do usuário
        ScannerInput input = new ScannerInput();
        
        // Classe responsável pelo acesso ao banco de dados
        ProdutoDAO pDao = new ProdutoDAO();
        
        int opcao;
        
        // Criando loop principal do sistema
        do{
            System.out.println("\n========= MENU PRINCIPAL =========\n");
            System.out.println("1 - CADASTRAR PRODUTOS");
            System.out.println("2 - EXCLUIR PRODUTOS");
            System.out.println("3 - EDITAR PRODUTOS");
            System.out.println("4 - LISTAR PRODUTOS");
            System.out.println("5 - EXPORTAR PARA O EXCEL");
            System.out.println("0 - SAIR");
            
            // Validando se valor da opcao está entre 0 e 5
            opcao = input.verificarOpcaoMenu(scanner, 0, 5);
            
            
            // 1 = CADASTRAR PRODUTOS
            if(opcao == 1){
                
                Produto p = new Produto();// Instanciando objeto Produto
                
                // Solicitando valores para o usuário e fazendo a validação
                p.setDescricao(input.verificarDescricaoProduto(scanner, "\nDigite a descrição do produto: "));
                p.setPreco(input.verificarValorProduto(scanner));
                
                // Pedindo confirmação do usuário para executar ação do sistema
                System.out.println("\nConfirmar cadastro do produto?");
                
                // Fazendo verificação do valor digitado pelo usuário
                if(input.confirmarProduto(scanner) == 1){
                    try{
                        pDao.cadastrarProduto(p);// Atribuindo valor para o método ser acionado
                        System.out.println("\nProduto cadastrado com sucesso!");
                    } catch (Exception ex){
                        System.out.println("Erro: " + ex.getMessage());
                    }
                }
                
                
            // 2 - EXCLUIR PRODUTOS    
            } else if(opcao == 2){
                
                // Exibindo a lista de produtos
                try{
                    List<Produto> lista = pDao.listaProdutos();
                    
                    
                    for(Produto p : lista){
                        System.out.println("ID: " + p.getId() + " | " + p.getDescricao() + " | R$" + p.getPreco());
                    }
                } catch (Exception ex){
                    System.out.println("Erro: " + ex.getMessage());
                }
                
                // Solicita para o usuário um ID válido
                int id = input.verificarIdProduto(scanner, pDao);
                
                // Confirmar exclusão
                System.out.println("\nConfirmar exclusão?");
                if(input.confirmarProduto(scanner) == 1){
                    try{
                        pDao.excluirProduto(id);
                        System.out.println("\nProduto excluído com sucesso!");
                    } catch (Exception ex){
                        System.out.println("Erro: " + ex.getMessage());
                    }
                }
                
                
            // 3 - EDITAR PRODUTOS
            } else if(opcao == 3){
                
                // Exibindo a lista de produtos
                try{
                    List<Produto> lista = pDao.listaProdutos();
                    
                    for(Produto p : lista){
                        System.out.println("ID: " + p.getId() + " | " + p.getDescricao() + " | R$" + p.getPreco());
                    }
                } catch (Exception ex){
                    System.out.println("Erro: " + ex.getMessage());
                }
                
                // Solicita para o usuário um ID válido
                int id = input.verificarIdProduto(scanner, pDao);
                
                Produto p = new Produto();
                p.setId(id);
                
                // Solicita ao usuário os novos dados para edição
                p.setDescricao(input.verificarDescricaoProduto(scanner, "\nDigite uma nova descrição para o produto: "));
                p.setPreco(input.verificarValorProduto(scanner));
                
                // Confirmar edição
                System.out.println("\nConfirmar alteração do produto?");
                if(input.confirmarProduto(scanner) == 1){
                    try{
                        pDao.editarProduto(p);
                        System.out.println("\nProduto atualizado com sucesso!");
                    } catch(Exception ex){
                        System.out.println("Erro: " + ex.getMessage());
                    }
                }
            
                
            // 4 - LISTAR PRODUTOS
            }else if(opcao == 4){
                try{
                    List<Produto> lista = pDao.listaProdutos();
                    System.out.println("\n-----PRODUTOS-----\n");
                    for(Produto p : lista){
                        System.out.println("ID: " + p.getId());
                        System.out.println("Descrição: " + p.getDescricao());
                        System.out.println("Valor unitário: R$" + p.getPreco());
                        System.out.println("-----------------------------------");
                    }
                } catch (Exception ex){
                    System.out.println("Erro: " + ex.getMessage());
                }
            }
            
            // 5 - EXPORTAR PARA O EXCEL
            else if(opcao == 5){
                try{
                    
                    ExportarCSV exp = new ExportarCSV();
                
                    List<Produto> lista = pDao.listaProdutos();
                    exp.exportar(lista);
                    
                } catch (Exception ex){
                    System.out.println("Erro: " + ex.getMessage());
                }
                          
            }
        }while (opcao != 0);
        
        // Encerrando o sistema
        System.out.println("\nSaindo do sistema...");
        scanner.close();
    }
    
}
    