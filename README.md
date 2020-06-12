
https://medium.com/better-programming/server-sent-events-on-react-and-spring-webflux-5f532b04633

react-ui:
---------


npm create-react-app react-ui

npm i react-d3-speedometer

npm install

npm start


Docker:
-------

docker build -t sb-sse-service .

docker tag sb-sse-service eu.gcr.io/ssil1-258911/sb-sse-service:v1

docker push eu.gcr.io/ssil1-258911/sb-sse-service:v1


docker build -t react-ui .

docker tag react-ui eu.gcr.io/ssil1-258911/react-ui:v1

docker push eu.gcr.io/ssil1-258911/react-ui:v1


Kubernetes:
-----------

gcloud container clusters create --machine-type n1-standard-2 --num-nodes 2  --zone europe-west2-b --cluster-version latest test-cluster


kubectl apply -f k8s-service.yml

kubectl apply -f k8s-ui.yml


kubectl delete -f k8s-ui.yml

kubectl delete -f k8s-service.yml


gcloud container clusters delete test-cluster
