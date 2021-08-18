# Insight



#!/bin/bash

# Function app and storage account names must be unique.
storageName=mystorageaccount$RANDOM
functionAppName=myserverlessfunc$RANDOM
region=westeurope

# Create a resource group.
az group create --name myResourceGroup --location $region

# Create an Azure storage account in the resource group.
az storage account create \
  --name $storageName \
  --location $region \
  --resource-group myResourceGroup \
  --sku Standard_LRS

# Create a serverless function app in the resource group.
az functionapp create \
  --name $functionAppName \
  --storage-account $storageName \
  --consumption-plan-location $region \
  --resource-group myResourceGroup \
  --functions-version 2
  
  
  
  az storage account create \
  --name insightwebstorage \
  --location westus \
  --resource-group kowegAzFctnResGrp \
  --sku Standard_LRS


./gradlew azureFunctionsPackage
./gradlew azureFunctionsRun

./gradlew clean build -x test



mvn clean package
mvn clean package -DskipTests
mvn azure-functions:run

mvn clean package azure-functions:deploy  -DskipTests

https://azurefctnspring.azurewebsites.net/api/graphql

http://localhost:7071/api/graphql



## Creating NuGet package

```bash
 nuget spec 
 mv .nuspec insight-web.nuspec
 mvn clean  azure-functions:package
 # update manifest and run command below
 nuget pack insight-web.nuspec 
```










































larinde@mars:~/tmp/fix/azure-fctn-spring$ az storage account create \
>   --name insightwebstorage \
>   --location westus \
>   --resource-group kowegAzFctnResGrp
{- Finished ..
  "accessTier": "Hot",
  "allowBlobPublicAccess": null,
  "azureFilesIdentityBasedAuthentication": null,
  "blobRestoreStatus": null,
  "creationTime": "2021-07-07T01:33:44.471701+00:00",
  "customDomain": null,
  "enableHttpsTrafficOnly": true,
  "encryption": {
    "keySource": "Microsoft.Storage",
    "keyVaultProperties": null,
    "requireInfrastructureEncryption": null,
    "services": {
      "blob": {
        "enabled": true,
        "keyType": "Account",
        "lastEnabledTime": "2021-07-07T01:33:44.549814+00:00"
      },
      "file": {
        "enabled": true,
        "keyType": "Account",
        "lastEnabledTime": "2021-07-07T01:33:44.549814+00:00"
      },
      "queue": null,
      "table": null
    }
  },
  "failoverInProgress": null,
  "geoReplicationStats": null,
  "id": "/subscriptions/f2b3ce42-63af-41f3-932b-e1b2bf83ad6f/resourceGroups/kowegAzFctnResGrp/providers/Microsoft.Storage/storageAccounts/insightwebstorage",
  "identity": null,
  "isHnsEnabled": null,
  "kind": "StorageV2",
  "largeFileSharesState": null,
  "lastGeoFailoverTime": null,
  "location": "westus",
  "minimumTlsVersion": null,
  "name": "insightwebstorage",
  "networkRuleSet": {
    "bypass": "AzureServices",
    "defaultAction": "Allow",
    "ipRules": [],
    "virtualNetworkRules": []
  },
  "primaryEndpoints": {
    "blob": "https://insightwebstorage.blob.core.windows.net/",
    "dfs": "https://insightwebstorage.dfs.core.windows.net/",
    "file": "https://insightwebstorage.file.core.windows.net/",
    "internetEndpoints": null,
    "microsoftEndpoints": null,
    "queue": "https://insightwebstorage.queue.core.windows.net/",
    "table": "https://insightwebstorage.table.core.windows.net/",
    "web": "https://insightwebstorage.z22.web.core.windows.net/"
  },
  "primaryLocation": "westus",
  "privateEndpointConnections": [],
  "provisioningState": "Succeeded",
  "resourceGroup": "kowegAzFctnResGrp",
  "routingPreference": null,
  "secondaryEndpoints": {
    "blob": "https://insightwebstorage-secondary.blob.core.windows.net/",
    "dfs": "https://insightwebstorage-secondary.dfs.core.windows.net/",
    "file": null,
    "internetEndpoints": null,
    "microsoftEndpoints": null,
    "queue": "https://insightwebstorage-secondary.queue.core.windows.net/",
    "table": "https://insightwebstorage-secondary.table.core.windows.net/",
    "web": "https://insightwebstorage-secondary.z22.web.core.windows.net/"
  },
  "secondaryLocation": "eastus",
  "sku": {
    "name": "Standard_RAGRS",
    "tier": "Standard"
  },
  "statusOfPrimary": "available",
  "statusOfSecondary": "available",
  "tags": {},
  "type": "Microsoft.Storage/storageAccounts"
}
larinde@mars:~/tmp/fix/azure-fctn-spring$ 

