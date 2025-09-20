#!/bin/sh 

# Create Kind cluster by referring config yaml file
kind create cluster --name flux-cluster --config ../config/kind-config.yml

# Get k8s cluster nodes info & check whether k8s cluster setup successfuly & cluster in health status 
kubectl get nodes

# Check Pod's network gets ready, default ns: kube-system namespace
kubectl get pods -n kube-system

# Check whether setup spring app instances can be get acces to successfully
# Spring Boot app instances (instance defined in kind-config.yaml)
curl http://localhost:8080
curl http://localhost:8081
curl http://localhost:8082
curl http://localhost:8083

# Check Consul works ok
curl http://localhost:8500/v1/status/leader