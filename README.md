# Projeto de CRUD de Pessoa / Endereço :computer:

Este é um projeto desenvolvido como parte de um teste para uma vaga de desenvolvedor. Trata-se de um CRUD simples de pessoa, com relacionamento de uma pessoa podendo ter vários endereços.


## 1. Tecnologias Utilizadas

### Backend:
  - Java EE;
  - EJB;
  - JPA;
  - Hibernate;
  - Lombok;
  - Maven;
  - JUnit;
  - PostgreSQL;
  - Payara Server.

### Frontend:
  - JSF;
  - PrimeFaces 12;


## 2. Arquitetura do Projeto (Backend)

  - Camada de Controle: Gerencia os ManagedBeans;
  - Camada de Serviço: Contém a lógica de negócios;
  - Camada Facade: Responsável pela persistência e comunicação com o banco de dados;
  - Camada de Entidade: Define as entidades JPA.


## 3. Frontend

O frontend foi desenvolvido com um template simples utilizando JSF e componentes do PrimeFaces versão 12.


## 4. Para subir a aplicação, siga os passos abaixo:

### Criar Banco de Dados:
  - Crie um banco de dados PostgreSQL vazio com o nome desafio. As tabelas serão criadas automaticamente durante o deploy da aplicação.

### Gerar o .war:
  - Gere um arquivo .war da aplicação utilizando comandos Maven ou uma IDE de sua preferência para fazer o build do projeto.

### Fazer o Deploy:
  - Faça o deploy do arquivo .war no Payara Server. A versão utilizada foi a 4.1.


## 5. Melhorias Futuras :chart:

### Frontend:
  - [ ] Aplicar mais práticas de clean code.
  - [ ] Reduzir a utilização de estilos diretamente nos componentes, utilizando classes CSS em arquivos separados.

### Validações:
  - [ ] Melhorar as validações de campos, tanto no frontend quanto no backend.
  - [ ] Implementar Bean Validation, por exemplo.

### Testes:
  - [ ] Implementar mais testes unitários.

### Relatórios:
  - [ ] Criar relatórios utilizando Jasper Reports.


## 6. Capturas de tela :camera:
  - Tela Inicial:
![image](https://github.com/user-attachments/assets/1c71222a-2781-49ed-b09e-955dd2abc4e3)

  - Listagem de pessoas:
![image](https://github.com/user-attachments/assets/6d2b0bb8-b20f-4d0a-93ad-3fd60f34f67a)

  - Formulário de Pessoa:
![image](https://github.com/user-attachments/assets/60647563-6d7a-411d-8fc8-c325fa281581)

  - Dialog para cadastro de endereço:
![image](https://github.com/user-attachments/assets/c025a876-b094-45dc-a87c-c462aa981bfc)




