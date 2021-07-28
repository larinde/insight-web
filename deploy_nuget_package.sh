#!/bin/bash

# https://docs.microsoft.com/en-us/cli/azure/functionapp?view=azure-cli-latest
location=northeurope
rg=kowegAzFctnGrp
appName=insight-web-fctn
packageFile=insight-web.1.0.0.nupkg
storageAcc=insightwebstorage

az group create --name $rg --location $location

az storage account create \
  --name $storageAcc \
  --location $location \
  --resource-group $rg \
  --sku Standard_LRS

#az functionapp create -n $appName --storage-account $storageAcc --consumption-plan-location $location --runtime dotnet -g $rg
az functionapp create \
  --name $appName \
  --storage-account $storageAcc \
  --consumption-plan-location $location \
  --resource-group $rg \
  --functions-version 2

az functionapp deployment source config-zip -n $appName -g $rg --src $packageFile
