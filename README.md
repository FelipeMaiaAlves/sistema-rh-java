
sistema-rh-java 💼🧑‍💻
Simple Human Resources (HR) system developed in Java with MySQL database connection.

📋 Description
This project is a basic HR system that allows managing departments and employees, storing data in a MySQL database. The system provides functionalities to:

🏢 Register departments and employees

📄 List registered departments and employees

💾 Export the employee list to a CSV file

📊 Generate salary charts for employees in PNG format

The system uses JDBC for database connection and the JFreeChart library to generate charts.

🚀 Features
Department Registration: 🏢 Add new departments to the database.

Department Listing: 📋 Display all registered departments.

Employee Registration: 👩‍💼 Insert employees linked to departments, with salary.

Employee Listing: 📃 Display all employees with their departments and salaries.

CSV Export: 💾 Generate a employees.csv file with employee data.

Salary Chart: 📈 Create a bar chart salary_chart.png showing employees' salaries.

📁 Project Structure
src/ — Java source code:

Conexao.java — class for MySQL connection via JDBC 🔗

Departamento.java — department model 🏢

DepartamentoDAO.java — CRUD operations for departments 🛠️

Funcionario.java — employee model 👤

FuncionarioDAO.java — CRUD operations for employees and CSV export 📄

Grafico.java — chart generation using JFreeChart 📊

Main.java — command line interface to interact with the system 🖥️

lib/ — dependencies (e.g. JDBC driver, JFreeChart) 📦

bin/ — compiled .class files 💾

employees.csv — generated CSV file 💿

salary_chart.png — generated salary chart image 🖼️

🛠️ Technologies Used
>>>>>>> fc7d36e (Primeiro commit)
Java 8+ ☕

MySQL 🐬

JDBC 🔗

JFreeChart 📊

<<<<<<< HEAD
⚙️ Como usar
Configurar banco de dados MySQL
Crie o banco rh com as tabelas departamentos e funcionarios:
=======
⚙️ How to Use
Set up MySQL database
Create the rh database with the tables departamentos and funcionarios:
>>>>>>> fc7d36e (Primeiro commit)

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
<<<<<<< HEAD
Ajustar credenciais de conexão
No arquivo Conexao.java, configure usuário e senha MySQL:
=======
Adjust connection credentials
In Conexao.java, configure MySQL username and password:
>>>>>>> fc7d36e (Primeiro commit)

java
Copiar
Editar
private static final String USUARIO = "root";
private static final String SENHA = "password";
<<<<<<< HEAD
Compilar e executar
Compile o projeto e rode a classe Main para abrir o menu de comandos. ▶️

Funcionalidades
Utilize o menu para cadastrar, listar, exportar e gerar gráficos.

=======
Compile and run
Compile the project and run the Main class to open the command menu. ▶️

Features
Use the menu to register, list, export, and generate charts.
>>>>>>> fc7d36e (Primeiro commit)
