eval $(minikube docker-env);
sh ./conta-service/build-account.sh;
sh ./product-service/build-product.sh;
sh ./operation-service/build-operation.sh;
eval $(minikube docker-env -u);