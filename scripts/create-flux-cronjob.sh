#!/bin/sh

kubectl create job --from=cronjob/gitops-consul-sync gitops-consul-sync-manual -n flux-system