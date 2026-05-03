# 🛒 Sistema de Cadastro de Produtos com Análise de Dados

Este projeto consiste em um sistema desenvolvido em Java para cadastro e gerenciamento de produtos, integrado com banco de dados MySQL e exportação de dados para análise no Excel.

## 🚀 Tecnologias utilizadas

- Java
- MySQL
- JDBC
- Excel (para análise de dados)
- Git & GitHub

## 📌 Funcionalidades

- Cadastro de produtos
- Listagem de produtos
- Atualização de dados
- Exclusão de registros
- Integração com banco de dados MySQL
- Exportação de dados para Excel
- Tratamento de dados para análise
- Criação de dashboards no Excel

## 🔗 Dependência

Este projeto utiliza o driver JDBC do MySQL:

- MySQL Connector/J

## 🗂️ Estrutura do Projeto

📁 src/
┗ 📂 cadastroproduto/
┣ 📜 CadastroProduto.java
┣ 📜 Produto.java
┣ 📜 ProdutoDAO.java
┣ 📜 ScannerInput.java
┗ 📜 ExportarCSV.java

📁 database/
┗ 📜 script.sql

📁 excel/
┗ 📜 dados.xlsx

## 🛠️ Como executar o projeto

1. Clone o repositório:
<pre> ```bash git clone https://github.com/PedroCarmo01/java-mysql-excel-product-analysis.git ``` </pre>

2. Configure o banco de dados MySQL:
- Execute o script localizado em:
/database/script.sql

3. Configure a conexão com o banco:
- Configure os dados de conexão com o banco diretamente no código (ex: `ProdutoDAO.java`)


4. Execute o projeto:
- Rode a classe `CadastroProdutos.java`

## 📊 Análise de Dados

Os dados cadastrados podem ser exportados para o Excel, permitindo:

- Criação de dashboards
- Análise estatística
- Histogramas
- Boxplots
- Tratamento de dados inconsistentes

## 📷 Demonstração
<img width="1384" height="658" alt="image" src="https://github.com/user-attachments/assets/ce450d5b-3b28-40d7-8404-976c5545b9c8" />


## 📈 Possíveis melhorias

- Expansão do banco de dados
- Adição de novas tabelas
- Interface gráfica (JavaFX ou Swing)
- Criação de API REST
- Integração com Power BI
- Validação de dados mais robusta
- Análise de dados mais aprofundada

## 🧠 Aprendizados

Durante o desenvolvimento deste projeto, foram aplicados e aprofundados conhecimentos em:

- Integração entre Java e banco de dados MySQL utilizando JDBC
- Estruturação de código com separação de responsabilidades (DAO, conexão, entidades)
- Manipulação e persistência de dados
- Exportação de dados para análise externa (Excel)
- Tratamento e organização de dados para geração de insights
- Criação de dashboards e visualizações no Excel
- Uso do Git e GitHub para versionamento de código

## 🧩 Problemas resolvidos

Alguns dos principais desafios enfrentados durante o projeto:

- Correção de erros na leitura e exportação de dados para o Excel
- Tratamento de dados inconsistentes e valores inválidos
- Estruturação correta da conexão com o banco de dados
- Organização do código para evitar acoplamento excessivo
- Ajustes na geração de arquivos para garantir compatibilidade com Excel
- Implementação de operações CRUD completas com persistência em banco

## 📄 Licença

Este projeto está sob a licença MIT.

## 👨‍💻 Autor

Pedro Henrique Silva do Carmo
