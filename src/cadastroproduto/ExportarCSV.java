/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroproduto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
 * Classe responsável por exportar dados para arquivos CSV.
 * 
 * O arquivo gerado pode ser aberto em ferramentas como Microsoft Excel,
 * permitindo análise de dados, criação de gráficos e dashboards.
 * 
 * Características do arquivo:
 * - Formato: CSV (Comma Separated Values)
 * - Separador utilizado: ponto e vírgula (;)
 * - Contém cabeçalho com os campos: ID, Descrição e Preço
 * @author Pedro Carmo
 */
public class ExportarCSV {
    
     public void exportar(List<Produto> lista) {
        try {
            FileWriter writer = new FileWriter("produtos.csv");

            // Cabeçalho do arquivo
            writer.append("ID;Descricao;Preco\n");

            // Escrita dos produtos
            for (Produto p : lista) {
                writer.append(p.getId() + ";" 
                            + p.getDescricao() + ";" 
                            + p.getPreco() + "\n");
            }

            writer.flush();
            writer.close();

            System.out.println("\nArquivo exportado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao exportar: " + e.getMessage());
        }
    }
}
