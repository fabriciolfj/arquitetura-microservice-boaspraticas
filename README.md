# Boas práticas desenvolvimento de microservices
Nesse repositório possuem 3 microservices, atendendo contextos diferentes, tais como:
- product-service: produtos financeiros
- account-service: operações financeiras
- limit-service: controle de limites, como saques, tarifas isentas e etc.

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
