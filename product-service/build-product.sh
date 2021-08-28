path=$(pwd)/product-service
echo $path
cd $path
mvn clean install
cd infrastructure
mvn spring-boot:build-image
docker push fabricio211/product-finance-tax

minikube cache add fabricio211/product-finance-tax:latest