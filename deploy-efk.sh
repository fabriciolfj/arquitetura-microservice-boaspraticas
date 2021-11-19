eval $(minikube docker-env)
docker pull docker.elastic.co/elasticsearch/elasticsearch:7.12.1
docker pull docker.elastic.co/kibana/kibana:7.12.1
eval $(minikube docker-env -u);

helm install logging-microservices kubernetes/helm/environments/logging -n logging --create-namespace --wait