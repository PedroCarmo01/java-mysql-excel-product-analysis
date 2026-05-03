-- Criando banco de dados.
create database java_scanner;
-- Usando o banco de dados.
use java_scanner; 


-- Criando tabela produto.
create table produtos(
	id int auto_increment primary key,
    descricao varchar(70) not null unique,
    preco decimal(10,2) not null check (preco >= 0)
);

-- Listando toda a tabela produtos.
select * from produtos;

-- Listando produtos com alias para exibição
select id as codigo, descricao as descri, preco
from produtos;

-- Alterando descrição de um produto com base no seu ID
update produtos
set descricao = 'Mouse'
where id = 1;

-- ==== ANÁLISE DOS DADOS =====

-- Exibindo média de preço dos produtos
select avg(preco) as preco_medio
from produtos;

-- Exibindo o produto mais caro
select *
from produtos
order by preco desc limit 1;

-- Exibindo o produto mais barato
select *
from produtos
order by preco asc limit 1;

-- Listando quantidade de produtos cadastrados
select count(*) as quantidade_produtos
from produtos;

-- Classificação de produtos por faixa de preço
select 
	case 
		when preco < 700 then 'Barato'
		when preco between 700 and 1500 then 'Médio'
		else 'Caro'
	end as classificacao,
	count(*) as quantidade
from produtos
group by classificacao;
    