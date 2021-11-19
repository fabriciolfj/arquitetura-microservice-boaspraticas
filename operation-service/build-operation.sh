path=$(pwd)/operation-service
echo $path
cd $path
mvn clean install
cd infrastructure
mvn spring-boot:build-image
docker push fabricio211/operation-finance

minikube cache add fabricio211/operation-finance:latest