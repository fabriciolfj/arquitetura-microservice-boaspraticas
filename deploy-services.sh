kubectl apply -f ./kubernetes/namespace.yml

kubectl config set-context $(kubectl config current-context) --namespace=microservices

helm repo add bitnami https://charts.bitnami.com/bitnami
helm install my-release bitnami/kafka

for f in kubernetes/helm/components/*; do helm dep up $f; done
for f in kubernetes/helm/environments/*; do helm dep up $f; done
helm dep ls kubernetes/helm/environments/dev-env/


helm install microservices-on-dev kubernetes/helm/environments/dev-env -n microservices
