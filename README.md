🛵 MR_DEL | API de Gerenciamento de Pedidos e Produtos

MR_DEL é uma API RESTful robusta e segura, desenvolvida para ser o backend de um sistema de pedidos de delivery. Ela gerencia o catálogo de produtos e lida com a autenticação de usuários e administradores.

🚀 Tecnologias Utilizadas

O projeto MR_DEL foi construído usando o ecossistema Java/Spring, garantindo alta performance e um desenvolvimento estruturado.
Categoria	Tecnologia	Função Principal

☕ Linguagem	Java	Linguagem principal do projeto.

🍃 Framework	Spring Boot	Estrutura moderna para criação da API.

🛡️ Segurança	Spring Security & JWT	Autenticação (Login/Registro) e Autorização por papéis (ADMIN/CLIENTE).

💾 Banco de Dados	PostgreSQL	Persistência de dados (Produtos, Usuários).

🔗 Persistência	Spring Data JPA/Hibernate	Mapeamento Objeto-Relacional.

🧪 Testes	Postman	Testes e validação de todos os endpoints.

🧰 Versionamento	Git e GitHub	Versionamento e colaboração do código.

🔒 Endpoints da API

A API diferencia o acesso entre rotas públicas e rotas de gerenciamento (ADMIN), que exigem um token JWT válido.
Categoria	URL Base	Exemplos de Rotas
Público	/api/products	GET /api/products (Catálogo de produtos)
Autenticação	/api/auth	POST /api/auth/login, POST /api/auth/register
Gerenciamento	/api/products/management	POST /api/products/management (Cria produto, exige ADMIN)

⚙️ Configuração Local

Para rodar a API MR_DEL em sua máquina:

    Pré-requisitos: Instale JDK 21+, Maven e PostgreSQL.

    Configuração do BD: Crie um banco de dados e configure o arquivo application.properties (veja a seção de Código).

    Variáveis de Ambiente: Defina JWT_KEY e JWT_EXP na sua IDE ou terminal.

    Execução: mvn spring-boot:run

Um usuário ADMIN padrão é criado automaticamente com as credenciais: admin@deli.com / 123mudar.

💬 Comunidade e Suporte

Tire suas dúvidas e participe das discussões para melhorar a MR_DEL!

Use o espaço de issues para relatar bugs, sugerir novas funcionalidades (como endpoints de Pedidos!) ou tirar dúvidas sobre a estrutura do projeto 💬

<div align="center">
  <p>Feito com ❤️ e ☕️ por <a href="https://github.com/marconi-prog">Marconi Farias</a></p>
</div>
