# Boas práticas desenvolvimento de microservices
Nesse repositório possuem 3 microservices, atendendo contextos diferentes, tais como:
- product-service: produtos financeiros (limites de saques, quantidade de saques, isensão de taxas)
- account-service: cadastro de contas, registro de extratos
- operation-service: efetuação de saques, debitos providos de compra, debito de taxas, debito de juros, credito de juros para conta poupança.

## Arquitetura empregada
- Todos microservices usufruem da arquitetura limpa

## Tecnologias empregadas
- kubernetes
- observabilidade
- rastreamento
- spring boot
  - banco de dados relacional 
  - spring data 
  - spring sleuth
  - service discovery consul
  - lombok
  - zipkin
  - prometheus
  - grafana
  - redis
  - kafka
  - cloud stream
  - flyway
  - oauth2
  - openfeign
  - keycloak
