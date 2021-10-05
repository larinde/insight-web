# Dev Documentation

## Create and switch branch

```bash
 git checkout -b azure-appsvc
```

## Enabling Application Insights

```shell
#Enable the Applications Insights extension
az extension add -n application-insights

az group create --location northeurope --name rgInsight --tags env=dev platform=java

az monitor app-insights component create --app apinInsight \
    -g rgInsight  \
    --location northeurope \
    --kind web \
    --application-type web
    
az webapp config appsettings set -n <webapp-name> -g <resource-group> --settings "APPINSIGHTS_INSTRUMENTATIONKEY=<instrumentationKey>" "APPLICATIONINSIGHTS_CONNECTION_STRING=<connectionString>" "ApplicationInsightsAgent_EXTENSION_VERSION=~3" "XDT_MicrosoftApplicationInsights_Mode=default"    

```
```json
{
  "id": "/subscriptions/f2b3ce42-63af-41f3-932b-e1b2bf83ad6f/resourceGroups/rgInsight",
  "location": "northeurope",
  "managedBy": null,
  "name": "rgInsight",
  "properties": {
    "provisioningState": "Succeeded"
  },
  "tags": {
    "env": "dev",
    "platform": "java"
  },
  "type": "Microsoft.Resources/resourceGroups"
}

```

```json
{
  "appId": "6df3f070-4c39-41d3-96de-b780909d9d32",
  "applicationId": "apinInsight",
  "applicationType": "web",
  "connectionString": "InstrumentationKey=b534d9c4-bbec-41f5-a634-c36377c11813;IngestionEndpoint=https://northeurope-0.in.applicationinsights.azure.com/",
  "creationDate": "2021-09-22T23:10:30.101960+00:00",
  "disableIpMasking": null,
  "etag": "\"01000b3c-0000-0200-0000-614bb7e70000\"",
  "flowType": "Bluefield",
  "hockeyAppId": null,
  "hockeyAppToken": null,
  "id": "/subscriptions/f2b3ce42-63af-41f3-932b-e1b2bf83ad6f/resourceGroups/rgInsight/providers/microsoft.insights/components/apinInsight",
  "immediatePurgeDataOn30Days": null,
  "ingestionMode": "ApplicationInsights",
  "instrumentationKey": "b534d9c4-bbec-41f5-a634-c36377c11813",
  "kind": "web",
  "location": "northeurope",
  "name": "apinInsight",
  "privateLinkScopedResources": null,
  "provisioningState": "Succeeded",
  "publicNetworkAccessForIngestion": "Enabled",
  "publicNetworkAccessForQuery": "Enabled",
  "requestSource": "rest",
  "resourceGroup": "rgInsight",
  "retentionInDays": 90,
  "samplingPercentage": null,
  "tags": {},
  "tenantId": "f2b3ce42-63af-41f3-932b-e1b2bf83ad6f",
  "type": "microsoft.insights/components"
}

```
https://github.com/lenisha/spring-demo-monitor



## Links

https://start.spring.io/#!type=gradle-project&language=kotlin&platformVersion=2.5.0.RELEASE&packaging=jar&jvmVersion=11&groupId=com.koweg.insight&artifactId=insight&name=insight&description=Securities%20analysis%20tool&packageName=com.koweg.insight&dependencies=web,webflux,actuator,cache,data-redis,flapdoodle-mongo,data-mongodb-reactive,cloud-stream

https://spring.io/blog/2019/04/12/going-reactive-with-spring-coroutines-and-kotlin-flow

https://www.nobledesktop.com/learn/git/git-branches

https://www.altexsoft.com/blog/engineering/graphql-core-features-architecture-pros-and-cons/

https://nordicapis.com/5-potential-benefits-integrating-graphql/

https://shopify.dev/concepts/graphql/benefits

https://javascript.plainenglish.io/what-is-http-3-and-why-does-it-matter-cb7d7b4b600f

https://levelup.gitconnected.com/creating-and-filling-a-postgres-db-with-docker-compose-e1607f6f882f

