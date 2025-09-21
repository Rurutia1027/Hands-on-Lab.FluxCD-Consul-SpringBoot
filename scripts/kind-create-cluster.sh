#!/bin/sh 

# Create Kind cluster by referring config yaml file
kind create cluster --name k8s-cluster --config ../config/kind-config.yaml

# Get k8s cluster nodes info & check whether k8s cluster setup successfuly & cluster in health status 
kubectl get nodes

# Check Pod's network gets ready, default ns: kube-system namespace
kubectl get pods -n kube-system