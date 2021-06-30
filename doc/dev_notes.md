# Dev Documentation

## Create and switch branch

```bash
 git checkout -b azure-functions
```


## Configuring Application for Deployment to Azure Cloud Functions

### Updating Gradle Build

https://github.com/microsoft/azure-gradle-plugins/blob/master/azure-functions-gradle-plugin/README.md


## Docker runtime function

Further reading:

https://github.com/microsoft/azure-gradle-plugins/wiki/Configuration#supported-pricing-tiers
https://github.com/microsoft/azure-gradle-plugins/wiki/Quickstart
https://docs.microsoft.com/en-us/samples/azure-samples/hello-spring-function-azure/hello-spring-function-azure/


```json
  runtime {
    os = 'docker'
    image = '<your image name>'
    registryUrl = 'http://localhost:5000/v2'
    authentication {
      username = '<username>'
      password = System.getenv("PRIVATE_DOCKER_CREDENTIAL")
   }
 }

```


### Azure price planning

https://azure.microsoft.com/en-us/pricing/details/app-service/linux/






## Implementing a Spring Azure Cloud Function

https://docs.spring.io/spring-cloud-function/docs/current/reference/html/azure.html





## Links

https://start.spring.io/#!type=gradle-project&language=kotlin&platformVersion=2.5.0.RELEASE&packaging=jar&jvmVersion=11&groupId=com.koweg.insight&artifactId=insight&name=insight&description=Securities%20analysis%20tool&packageName=com.koweg.insight&dependencies=web,webflux,actuator,cache,data-redis,flapdoodle-mongo,data-mongodb-reactive,cloud-stream

https://spring.io/blog/2019/04/12/going-reactive-with-spring-coroutines-and-kotlin-flow

https://www.nobledesktop.com/learn/git/git-branches

https://www.altexsoft.com/blog/engineering/graphql-core-features-architecture-pros-and-cons/

https://nordicapis.com/5-potential-benefits-integrating-graphql/

https://shopify.dev/concepts/graphql/benefits

https://javascript.plainenglish.io/what-is-http-3-and-why-does-it-matter-cb7d7b4b600f

https://levelup.gitconnected.com/creating-and-filling-a-postgres-db-with-docker-compose-e1607f6f882f

