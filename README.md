<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Litera-Alura</title>
</head>
<body>

<h1>Litera-Alura 
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Boot">
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL">
</h1>

<p>Projeto desenvolvido como <strong>challenge da Formação One</strong> da <strong>Alura + Oracle</strong>.</p>

<p>O <strong>Litera-Alura</strong> é um sistema em Java para gerenciamento de livros e autores, integrando <strong>API externa</strong> e <strong>banco de dados</strong> via <strong>Spring Boot + JPA</strong>.</p>

<hr>

<h2>Funcionalidades</h2>
<pre>
-----------Litera-Alura----------
1 - Buscar livro por título
2 - Listar livros registrados
3 - Listar autores registrados
4 - Listar autores vivos em um determinado ano
5 - Listar livros em um determinado idioma
0 - Sair
</pre>

<ul>
  <li><strong>Buscar livro por título (API Gudendex):</strong> Consulta livros na API e salva automaticamente no banco.</li>
  <li><strong>Listar livros registrados:</strong> Consulta todos os livros salvos no banco.</li>
  <li><strong>Listar autores registrados:</strong> Consulta todos os autores salvos no banco.</li>
  <li><strong>Listar autores vivos em um determinado ano:</strong> Filtra autores por ano de nascimento/morte.</li>
  <li><strong>Listar livros em um determinado idioma:</strong> Filtra livros pelo idioma.</li>
</ul>

<p><em>💡 Todas as opções, exceto a busca por título, usam <strong>JPA</strong> para consultar o banco.</em></p>

<hr>

<h2>Tecnologias Utilizadas</h2>
<ul>
  <li>Java - Linguagem principal</li>
  <li>Spring Boot - Framework principal</li>
  <li>IntelliJ IDEA - IDE utilizada</li>
  <li>PostgreSQL - Banco de dados relacional</li>
  <li>JPA (Jakarta Persistence API) - ORM para persistência</li>
  <li>API Gudendex - Fonte externa de livros</li>
</ul>

<hr>

<h2>Configuração do Banco de Dados (Spring Boot)</h2>

<p>Exemplo de <code>application.properties</code> usando variáveis de ambiente:</p>

<pre>
spring.datasource.url=jdbc:postgresql://${DB_HOST}/literalura_db
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver
hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.format-sql=true
</pre>

<h3>Explicação dos parâmetros</h3>
<ul>
  <li><code>${DB_HOST}</code> → Host e porta do PostgreSQL (ex.: localhost:5432)</li>
  <li><code>${DB_USER}</code> → Usuário do banco</li>
  <li><code>${DB_PASSWORD}</code> → Senha do banco</li>
  <li><code>hibernate.dialect</code> → Dialeto do Hibernate para PostgreSQL</li>
  <li><code>spring.jpa.hibernate.ddl-auto=update</code> → Atualiza automaticamente o esquema do banco</li>
  <li><code>spring.jpa.show-sql=true</code> → Exibe os comandos SQL no console</li>
  <li><code>spring.jpa.format-sql=true</code> → Formata os comandos SQL para melhor leitura</li>
</ul>

<p><strong>💡 Dica:</strong> Crie o banco manualmente antes de rodar o projeto:</p>
<pre>
CREATE DATABASE literalura_db;
</pre>

<hr>

<h2>Estrutura do Projeto</h2>
<ul>
  <li><code>model</code> → Entidades JPA (<code>Livro</code>, <code>Autor</code>)</li>
  <li><code>repository</code> → Repositórios JPA</li>
  <li><code>service</code> → Lógica de negócio e integração com API Gudendex</li>
  <li><code>main</code> → Menu principal e execução do programa</li>
</ul>

<hr>

<h2>Como Rodar</h2>
<ol>
  <li>Clone o repositório:
    <pre>git clone &lt;URL_DO_REPOSITORIO&gt;</pre>
  </li>
  <li>Configure o PostgreSQL e crie o banco:
    <pre>CREATE DATABASE literalura_db;</pre>
  </li>
  <li>Configure as variáveis de ambiente:
    <pre>
export DB_HOST=localhost:5432
export DB_USER=seu_usuario
export DB_PASSWORD=sua_senha
    </pre>
  </li>
  <li>Abra o projeto no IntelliJ IDEA.</li>
  <li>Execute a classe principal (<code>Main</code> ou equivalente) para iniciar o menu interativo.</li>
</ol>

<hr>

<h2>Observações</h2>
<ul>
  <li>A opção de busca por título integra a <strong>API Gudendex</strong> e salva livros e autores automaticamente no banco.</li>
  <li>As demais funcionalidades usam <strong>JPA</strong> para consultas no banco.</li>
  <li>Projeto serve como prática de integração de APIs externas, persistência com JPA e configuração de Spring Boot + PostgreSQL.</li>
</ul>

</body>
</html>
