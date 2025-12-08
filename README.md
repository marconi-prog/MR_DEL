🛵 MR_DEL | API de Gerenciamento de Pedidos e Produtos

MR_DEL é uma API RESTFUL robusta e segura, desenvolvida para servir como backend de um sistema de delivery.
Ela é responsável pelo gerenciamento de produtos, usuários e autenticação, com foco em boas práticas, segurança e escalabilidade.

🚀 Tecnologias Utilizadas

☕ Linguagem	Java	Linguagem principal do projeto

🍃 Framework	Spring Boot	Criação da API REST

🛡️ Segurança	Spring Security & JWT	Autenticação e autorização (ADMIN / CLIENTE)

💾 Banco de Dados	PostgreSQL	Persistência de dados

🔗 Persistência	Spring Data JPA / Hibernate	Mapeamento Objeto-Relacional

🧪 Testes	Postman	Testes e validação dos endpoints

🧰 Versionamento	Git & GitHub	Controle de versão e colaboração

🔐 Funcionalidades Principais

✅ Cadastro e login de usuários

✅ Autenticação via JWT

✅ Controle de acesso por perfil (ADMIN / CLIENTE)

✅ CRUD de produtos

✅ Persistência segura em PostgreSQL

✅ API REST seguindo boas práticas

⚙️ Configuração Local
✅ Pré-requisitos

JDK 21+

Maven

PostgreSQL

🗄️ Queries SQL Utilizadas no Projeto

Estas consultas foram usadas para validação e testes diretos no banco de dados PostgreSQL:

-- Listar todos os usuários
SELECT * FROM users;

-- Listar todos os produtos
SELECT * FROM products;

-- Listar produtos ordenados por preço (do maior para o menor)
SELECT name, price FROM products ORDER BY price DESC;

-- Buscar produto específico pelo nome
SELECT name, price FROM products WHERE name = 'Pizza';

-- Buscar usuário pelo nome
SELECT name FROM users WHERE name = 'admin';

💬 Comunidade e Suporte

[![Abrir Issues](https://img.shields.io/badge/Abrir%20Issues-blue?style=for-the-badge&logo=github)](https://github.com/marconi-prog/MR_DEL/issues)

Tire suas dúvidas e participe das discussões para melhorar a MR_DEL!

Use o espaço de issues para relatar bugs, sugerir novas funcionalidades (como endpoints de Pedidos!) ou tirar dúvidas sobre a estrutura do projeto 💬

<div align="center">
  <p>Feito com ❤️ e ☕️ por <a href="https://github.com/marconi-prog">Marconi Farias</a></p>
</div>
