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
  - keycloak (pendente)

## Responsabilidades dos microservices

### Product service
- cadastrar produtos financieiros
- vincular conta a um produto financeiro
- inserir no cache as regras do produto, para uso no serviço de operações
- atualizar uso do produto financeiro e controle de reset.

## Subindo no ambiente local (seguir as etapas abaixo)
- instale o minikube com o driver docker
- instale o istioctl
- suba o docker-compose up -d
- execute:
   - script build
   - script install-cert-manager.sh (vamos usar um certificado para efetuar requisições https)
   - script install-istio.sh
   - script deploy-services
- Execute o comando minikube tunnel (simular um gateway a frente do cluster, pois o gateway istio é do tipo loadbalance).
- pegue o ip do gateway (kubectl get service istio-ingressgateway -o jsonpath='{.status.loadBalancer.ingress[0].ip}' --namespace=istio-system) e atualiza o host com os dns, conforme exemplo abaixo:

```
10.102.41.168  microservices.me grafana.microservices.me kiali.microservices.me prometheus.microservices.me tracing.microservices.me kibana.microservices.me elasticsearch.microservices.me mail.microservices.me health.microservices.mie
```

## Subindo efk
- Execute os scripts abaixo:
  -  build-fluentd.sh
  -  deploy-efk.sh


- Exemplo de requisição: https://microservices.me/api/v1/extract/965dae41-c79c-423f-b34a-2c481857123a?size=2&page=0
