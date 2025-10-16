# API de acesso ao PostgreSQL do Purpura 💜
![GitHub Actions](https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white)
![Render](https://img.shields.io/badge/Render-%46E3B7.svg?style=for-the-badge&logo=render&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/spring%20boot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/postgresql-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%232496ED.svg?style=for-the-badge&logo=docker&logoColor=white)
![Redis](https://img.shields.io/badge/redis-%23DC382D.svg?style=for-the-badge&logo=redis&logoColor=white)
![Maven](https://img.shields.io/badge/maven-%23C71A36.svg?style=for-the-badge&logo=apachemaven&logoColor=white)
![Bruno – API Client](https://img.shields.io/badge/bruno-apiclient-007396?style=for-the-badge&logo=bruno&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

## Overview 🌠
O objetivo dessa api é gerenciar do domínio de pedidos, pagamentos e consumir notícias.

Consumindo não só tabelas do banco mas também acionando functions customizadas definidas pela equipe de dados.

## Tecnologias 🪼 
Utilizou-se java 17, spring boot 3.5.2, postgresql 15, docker e docker-compose.

Utiliza-se aqui o redis para cache de algumas requisições.

## Testes do Bruno ✅
Foram feitos os testes da API usando o Bruno.

Acesse a coleção aqui: [bruno-api-pg](bruno-api-pg)

## Uso do Redis 📩

## Swagger e documentação 🧪

---

## Padrões de Projeto Utilizados

Abaixo está um levantamento dos principais padrões de projeto (creacionais, comportamentais e estruturais) utilizados neste projeto, com referência exata aos arquivos onde aparecem:

### Padrões Criacionais

#### Builder
- **model/noticia/NoticiaModel.java**
- **model/noticia/NoticiaFuncModel.java**
- **model/pedido/PedidoResiduoModel.java**
- **model/pedido/PedidoModel.java**
- **model/pedido/relatorio/RelatorioModel.java**
    - Todos utilizam a anotação `@Builder` do Lombok, implementando o padrão Builder para criação de objetos.

#### Factory/Factory Method
- **model/pedido/meta/PedidoStatus.java**
    - O método `toState()` do record `Adapter` atua como uma fábrica, instanciando a subclasse correta de `PedidoState` conforme o status.

---

### 2. Padrões Comportamentais

#### State

##### Pedido
- **model/pedido/meta/state/PedidoState.java**
- **model/pedido/meta/state/AbertoState.java**
- **model/pedido/meta/state/AprovadoState.java**
- **model/pedido/meta/state/CanceladoState.java**
- **model/pedido/meta/state/ConcluidoState.java**
- **model/pedido/PedidoModel.java**
    - Implementação do padrão State, permitindo que o `PedidoModel` altere seu comportamento conforme o estado atual.

##### Pagamento
- **model/pedido/pagamento/state/PagamentoState.java**
- **model/pedido/pagamento/state/PendenteState.java**
- **model/pedido/pagamento/state/ConcluidoState.java**
- **model/pedido/pagamento/state/CanceladoState.java**
- **model/pedido/pagamento/PagamentoStatus.java**
    - Implementação do padrão State para o ciclo de vida do pagamento, permitindo que o pagamento altere seu comportamento conforme o estado atual.


#### Strategy (Validação)
- **util/validation/UniqueVendedorCompradorValidator.java**
- **util/validation/UniqueVendedorComprador.java**
    - O validador é injetado via anotação e pode ser trocado, caracterizando o padrão Strategy.

#### Chain of Responsibility (Tratamento de Exceções)
- **exception/GlobalExceptionHandler.java**
    - Manipula exceções de forma encadeada, associando tipos de exceção a handlers específicos.
---

### 3. Padrões Estruturais

#### Adapter

##### Pedido
- **model/pedido/meta/PedidoStatus.java**
    - O record `Adapter` adapta um `PedidoStatus` para um `PedidoState`.
##### Pagamento
- **model/pedido/pagamento/PagamentoStatus.java**
    - O record `Adapter` adapta um `PagamentoStatus` para um `PagamentoState`, permitindo a conversão entre o status do pagamento e seu estado comportamental.

#### Decorator (Spring/Jackson)
- **config/jackson/JacksonConfig.java**
- **config/jackson/BlankToNullStringDeserializer.java**
    - O desserializador customizado é registrado como decorator no processo de desserialização do Jackson.


#### 4. Injeção de Dependência (Padrão Estrutural do Framework)
- **Todas as classes anotadas com `@Service`, `@Repository`, `@Configuration`, `@RestControllerAdvice`**
    - O Spring utiliza o padrão de Injeção de Dependência para gerenciar os componentes do projeto.

---

## Autores 
Feito com 💜 por:
- [Felipe Fernandes dos Santos Oliveira](http://www.github.com/rkhue) - Back-end, testes, documentação
- [Emílio Stuart Palumbo](http://www.github.com/EmilioStuart) - Deploy
