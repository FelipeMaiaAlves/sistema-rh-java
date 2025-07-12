=======
# sistema-rh-java 💼🧑‍💻
📋 Descrição
Este projeto é um sistema básico de RH que permite gerenciar departamentos e funcionários, armazenando os dados em um banco MySQL. O sistema oferece funcionalidades para:

🏢 Cadastrar departamentos e funcionários

📄 Listar departamentos e funcionários cadastrados

💾 Exportar a lista de funcionários para arquivo CSV

📊 Gerar gráfico de salários dos funcionários em formato PNG

O sistema utiliza JDBC para conexão com o banco de dados e a biblioteca JFreeChart para gerar gráficos.

🚀 Funcionalidades
Cadastro de Departamentos: 🏢 Adiciona novos departamentos à base.

Listagem de Departamentos: 📋 Exibe todos os departamentos cadastrados.

Cadastro de Funcionários: 👩‍💼 Insere funcionários associados a departamentos, com salário.

Listagem de Funcionários: 📃 Exibe todos os funcionários com seus departamentos e salários.

Exportação CSV: 💾 Gera um arquivo funcionarios.csv com dados dos funcionários.

Gráfico de Salários: 📈 Cria um gráfico de barras grafico_salarios.png mostrando os salários por funcionário.

📁 Estrutura do Projeto
src/ — código fonte Java:

Conexao.java — classe para conexão com banco MySQL via JDBC 🔗

Departamento.java — modelo do departamento 🏢

DepartamentoDAO.java — operações CRUD para departamentos 🛠️

Funcionario.java — modelo do funcionário 👤

FuncionarioDAO.java — operações CRUD para funcionários e exportação CSV 📄

Grafico.java — geração de gráficos usando JFreeChart 📊

Main.java — interface de linha de comando para interagir com o sistema 🖥️

lib/ — dependências (ex: driver JDBC, JFreeChart) 📦

bin/ — arquivos compilados .class 💾

funcionarios.csv — arquivo CSV gerado 💿

grafico_salarios.png — imagem gerada com gráfico dos salários 🖼️

🛠️ Tecnologias usadas
Java 8+ ☕

MySQL 🐬

JDBC 🔗

JFreeChart 📊

⚙️ Como usar
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
No arquivo Conexao.java, configure usuário e senha MySQL:

java
Copiar
Editar
private static final String USUARIO = "root";
private static final String SENHA = "password";
Compilar e executar
Compile o projeto e rode a classe Main para abrir o menu de comandos. ▶️

Funcionalidades
Utilize o menu para cadastrar, listar, exportar e gerar gráficos.

