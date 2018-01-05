1. Build the application

gradle bootRepackage

2. Create the docker container

docker build -t "jajabro/sentenceservice:0.0.1" .

3. Push the container to the repo

docker push jajabro/sentenceservice:0.0.1

4. Create the Kubernetes nounservice loadbalancer

kubectl create -f service.yml

5. Deploy the kubenetes pods

kubectl create -f deploy.yml

6. Get the service information

kubectl describe svc nounservice

note down the ip address and port and then check the service is working

http://<ip>:<port>

