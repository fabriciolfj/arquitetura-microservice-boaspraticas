# Boas práticas desenvolvimento de microservices
Nesse repositório possuem 3 microservices, atendendo contextos diferentes, tais como:
- product-service: produtos financeiros (limites de saques, quantidade de saques, isensão de taxas)
- account-service: cadastro de contas, registro de extratos
- operation-service: efetuação de saques, debitos providos de compra, debito de taxas, debito de juros, credito de juros para conta poupança.

## Arquitetura empregada
- Todos microservices usufruem da arquitetura limpa

![alt text](https://github.com/fabriciolfj/arquitetura-microservice-boaspraticas/blob/main/dependencies.png)

## Tecnologias empregadas
- kubernetes
- observabilidade
- rastreamento
- spring boot
  - banco de dados relacional 
  - spring data | specification
  - spring sleuth
  - service discovery consul
  - lombok
  - prometheus
  - grafana
  - redis
  - kafka
  - cloud stream
  - flyway
  - oauth2
  - openfeign
  - keycloak

## Responsabilidades dos microservices

### Product service
- cadastrar produtos financieiros
- vincular conta a um produto financeiro
- inserir no cache as regras do produto, para uso no serviço de operações
- atualizar uso do produto financeiro e controle de reset.
