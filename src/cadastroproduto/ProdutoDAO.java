/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroproduto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo acesso e manipulação dos dados da entidade Produto no banco de dados.
 * 
 * Implementa operações de:
 * - Cadastro (INSERT)
 * - Exclusão (DELETE)
 * - Atualização (UPDATE)
 * - Consulta (SELECT)
 * 
 * Utiliza JDBC para conexão com banco MySQL.
 * 
 * @author Pedro Carmo
 */
public class ProdutoDAO {
    
    // Estabelece conexão com o banco de dados MySQL
    private Connection getConexao(){
        try {
            // O método forName carrega e inicia o driver passado por parâmetro
            Class.forName("com.mysql.cj.jdbc.Driver"); // verificar em seu computador
            // Estabelecendo a conexão
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/java_scanner", "root", "sua_senha"); // Credenciais devem ser armazenadas de forma segura (ex: variáveis de ambiente)
        } catch (ClassNotFoundException | SQLException ex) { // Tratamento de Exceções
            System.out.println(ex);
            return null;
        }
    }    
    
    /**
     * Insere um novo produto no banco de dados.
     * 
     * @param p objeto Produto contendo os dados a serem persistidos
     * @throws SQLException erro ao acessar o banco de dados
     * @throws ClassNotFoundException erro ao carregar o driver JDBC
     */
    public void cadastrarProduto(Produto p) throws SQLException, ClassNotFoundException {
        String descricao = p.getDescricao();
        double preco = p.getPreco();
        
        Connection conexao = getConexao();// Criando variável de conexão com o Banco
        //linha de texto que vai para dentro do MySQL
        PreparedStatement comando = conexao.prepareStatement("insert into produtos(descricao, preco) values(?, ?)");
        comando.setString(1, descricao); //Valor que vai ser atribuído para o primeiro '?'
        comando.setDouble(2, preco); //Valor que será atribuído para o segundo '?'
        comando.execute();//Executando o texto do MySQL com os valores atribuídos para os '?'
        conexao.close(); //Fechando execução
    }
    
    
    /**
     * Remove um produto do banco de dados com base no ID informado.
     * 
     * @param id Identificador do produto
     * @throws SQLException erro ao acessar o banco de dados
     * @throws ClassNotFoundException erro ao carregar o driver JDBC
     */
    public void excluirProduto(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = getConexao();// Criando variável de conexão com o Banco
        // Inserindo linha de texto dentro do MySQL
        PreparedStatement excluir = conexao.prepareStatement("delete from produtos where id=?");
        excluir.setInt(1, id);//Valor que vai ser atribuído para o '?'
        excluir.execute();//Executando o texto do MySQL com os valores atribuídos para os '?'
        conexao.close();//Fechando execução
    }
    
    
    /**
     * Atualiza os dados de um produto existente no banco de dados.
     * 
     * @param p objeto Produto com os novos dados
     * @throws SQLException erro ao acessar o banco de dados
     * @throws ClassNotFoundException erro ao carregar o driver JDBC
     */
    public void editarProduto(Produto p) throws SQLException, ClassNotFoundException {
        //Criando variáveis para o objeto Produto e seus atributos
        String descricao = p.getDescricao();
        double preco = p.getPreco();
        int id = p.getId();
        
        Connection conexao = getConexao();// Criando variável de conexão com o Banco
        //linha de texto que vai para dentro do MySQL
        PreparedStatement atualizar = conexao.prepareStatement("update produtos set descricao = ?, preco = ? where id = ?");
        atualizar.setString(1, descricao);//Valor que vai ser atribuído para o primeiro '?'
        atualizar.setDouble(2, preco);//Valor que vai ser atribuído para o segundo '?'
        atualizar.setInt(3, id);//Valor que vai ser atribuído para o terceiro '?'
        atualizar.execute();//Executando o texto do MySQL com os valores atribuídos para os '?'
        conexao.close();//Fechando execução
    }   
    
    /**
     * Retorna uma lista com todos os produtos cadastrados.
     * 
     * @return lista de produtos
     * @throws SQLException erro ao acessar o banco de dados
     * @throws ClassNotFoundException erro ao carregar o driver JDBC
     */
    public List<Produto> listaProdutos() throws SQLException, ClassNotFoundException {
        Connection conexao = getConexao(); // Criando variável de conexão com o Banco
        //linha de texto que vai para dentro do MySQL
        PreparedStatement exibir = conexao.prepareStatement("select id as codigo, descricao as descri, preco from produtos");
        ResultSet sqlListado = exibir.executeQuery();//Executando trecho de código do MySQL
        //Criando lista
        List<Produto> listarProdutos = new ArrayList<Produto>();
        
        //Criando laço de repetição para poder executar a lista
        while (sqlListado.next()){
            Produto p = new Produto();
            p.setId(sqlListado.getInt("codigo"));
            p.setDescricao(sqlListado.getString("descri"));
            p.setPreco(sqlListado.getDouble("preco"));
            listarProdutos.add(p);
        }
        conexao.close();//Fechando conexão com o banco
        return listarProdutos;// Retornando lista com os valores
    }   
    
    
    /**
     * Verifica se existe um produto com o ID informado.
     * 
     * @param id Identificador do produto
     * @return true se existir, false caso contrário
     * @throws SQLException erro ao acessar o banco de dados
     * @throws ClassNotFoundException erro ao carregar o driver JDBC
     */
    public boolean verificarID(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = getConexao(); // Criando variável de conexão com o Banco
        //linha de texto que vai para dentro do MySQL
        PreparedStatement exibir = conexao.prepareStatement("select count(*) from produtos where id = ?");
        exibir.setInt(1, id); //Valor que vai ser atribuído para o primeiro '?'
        ResultSet idSQL = exibir.executeQuery(); // Executando o trecho de código

        boolean existe = false;
        
        //Verificando ID
        if(idSQL.next()){
            existe = idSQL.getInt(1) > 0;
        }
        conexao.close();//Fechando conexão com o Banco
        return existe;// Retorno
    }    
}
