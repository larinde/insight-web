# Insight


## Function app and storage account names must be unique.

```
storageName=mystorageaccount$RANDOM
functionAppName=myserverlessfunc$RANDOM
region=westeurope
```

## Create a resource group.

az group create --name myResourceGroup --location $region

## Create an Azure storage account in the resource group.

```
az storage account create \
  --name $storageName \
  --location $region \
  --resource-group myResourceGroup \
  --sku Standard_LRS
```

## Create a serverless function app in the resource group.

```
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
mvn clean package azure-functions:run -DenableDebug
mvn clean package azure-functions:deploy  -DskipTests

```

```
https://azurefctnspring.azurewebsites.net/api/graphql

http://localhost:7071/api/graphql
```

## Creating NuGet package

```bash
 nuget spec 
 mv .nuspec insight-web.nuspec
 mvn clean  azure-functions:package
 # update manifest and run command below
 nuget pack insight-web.nuspec 
```
