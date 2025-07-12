sistema-rh-java 💼🧑‍💻
Sistema simples de Recursos Humanos (RH) desenvolvido em Java com conexão ao banco de dados MySQL.

📋 Descrição
Este projeto é um sistema básico de RH que permite gerenciar departamentos e funcionários, armazenando os dados em um banco de dados MySQL. O sistema oferece funcionalidades para:

🏢 Cadastrar departamentos e funcionários
📄 Listar departamentos e funcionários cadastrados
💾 Exportar a lista de funcionários para um arquivo CSV
📊 Gerar gráficos de salários dos funcionários em formato PNG

O sistema utiliza JDBC para conexão com o banco de dados e a biblioteca JFreeChart para geração dos gráficos.

🚀 Funcionalidades
Cadastro de Departamentos 🏢
Adicione novos departamentos ao banco de dados.

Listagem de Departamentos 📋
Exibe todos os departamentos cadastrados.

Cadastro de Funcionários 👩‍💼
Insere funcionários vinculados a departamentos, com salário.

Listagem de Funcionários 📃
Exibe todos os funcionários com seus departamentos e salários.

Exportação para CSV 💾
Gera um arquivo employees.csv com os dados dos funcionários.

Gráfico de Salários 📈
Cria um gráfico de barras salary_chart.png mostrando os salários dos funcionários.

📁 Estrutura do Projeto
src/ — Código-fonte Java:

Conexao.java — Classe de conexão com MySQL via JDBC 🔗

Departamento.java — Modelo de departamento 🏢

DepartamentoDAO.java — Operações CRUD para departamentos 🛠️

Funcionario.java — Modelo de funcionário 👤

FuncionarioDAO.java — Operações CRUD para funcionários e exportação CSV 📄

Grafico.java — Geração de gráfico usando JFreeChart 📊

Main.java — Interface de linha de comando para interação com o sistema 🖥️

lib/ — Dependências (como driver JDBC, JFreeChart) 📦
bin/ — Arquivos compilados .class 💾
employees.csv — Arquivo CSV gerado 💿
salary_chart.png — Imagem do gráfico de salários gerado 🖼️

🛠️ Tecnologias Utilizadas
Java 8+ ☕

MySQL 🐬

JDBC 🔗

JFreeChart 📊

⚙️ Como Usar
Configurar banco de dados MySQL
Crie o banco rh com as tabelas departamentos e funcionarios:

sql
Copiar
Editar
CREATE DATABASE rh;
USE rh;

CREATE TABLE departamentos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL
);

CREATE TABLE funcionarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  departamento_id INT,
  salario DOUBLE,
  FOREIGN KEY (departamento_id) REFERENCES departamentos(id)
);
Ajustar credenciais de conexão
No arquivo Conexao.java, configure o usuário e senha do MySQL:

java
Copiar
Editar
private static final String USUARIO = "root";
private static final String SENHA = "password";
Compilar e executar
Compile o projeto e execute a classe Main para abrir o menu de comandos. ▶️

Funcionalidades
Use o menu para cadastrar, listar, exportar e gerar gráficos.
