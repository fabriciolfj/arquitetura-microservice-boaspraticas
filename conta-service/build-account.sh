path=$(pwd)/conta-service
echo $path
cd $path
mvn clean install
cd infrastructure
mvn spring-boot:build-image
docker push fabricio211/account-finance

minikube cache add fabricio211/account-finance:latest