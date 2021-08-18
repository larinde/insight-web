# Dev Documentation

## Create and switch branch

```bash
 git checkout -b azure-functions
```


## Configuring Application for Deployment to Azure Cloud Functions

### Updating Gradle Build

https://github.com/microsoft/azure-gradle-plugins/blob/master/azure-functions-gradle-plugin/README.md

./gradlew azureFunctionsPackage
./gradlew azureFunctionsRun
./gradlew azureFunctionsDeploy

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

## deleting branches

remote

``` bash
 git push origin --delete remote-branch-name
```

local

``` bash
 git branch -d local-branch-name
```

## Test containers for Azure functions

https://hub.docker.com/_/microsoft-azure-functions-java
https://hub.docker.com/_/microsoft-azure-functions-base

https://cloud.spring.io/spring-cloud-static/spring-cloud-function/2.0.0.RELEASE/multi/multi__functional_bean_definitions.html

## TODO - 03-07-2021

1. create a resource for running Java Azure Functions
   1. Follow doc guide
   2. Understand Azure Cli commands
   3. ``` https://blog.nebrass.fr/playing-with-spring-cloud-in-azure-functions/ ```
2. Deploy Insight app to Azure
3. Read and understand Spring Cloud Functions documentation
4. Find a way to inspect spring runtime beans.






8.3 Limitations of Functional Bean Declaration

Most Spring Cloud Function apps have a relatively small scope compared to the whole of Spring Boot, so we are able to adapt it to these functional bean definitions easily. If you step outside that limited scope, you can extend your Spring Cloud Function app by switching back to @Bean style configuration, or by using a hybrid approach. If you want to take advantage of Spring Boot autoconfiguration for integrations with external datastores, for example, you will need to use @EnableAutoConfiguration. Your functions can still be defined using the functional declarations if you want (i.e. the "hybrid" style), but in that case you will need to explicitly switch off the "full functional mode" using spring.functional.enabled=false so that Spring Boot can take back control.
Prev 	


https://docs.gradle.org/current/userguide/jacoco_plugin.html#sec:configuring_the_jacoco_plugin

https://www.youtube.com/watch?v=AI0dqP2OkGk

https://blogs.oracle.com/javamagazine/understanding-java-method-invocation-with-invokedynamic
https://www.infoworld.com/article/2860079/invokedynamic-101.html


## Installing NuGet

https://docs.microsoft.com/en-us/nuget/install-nuget-client-tools

## Azure Application Insights

An Application Performance Monitoring (APM) service provided by Azure

Key metrics monitored:

- dependency rates
- exceptions
- request rates
- Page views
- Load performance
- HTTP calls
- User and session counts
- performance counters

### Adding Application Insights instrumentation to Java projects

- updates to pom.xml/build.gradle.kts
- updadtes to **_host.json_** file
- adding **trackers** at critical points in code execution
