

# Insight

https://start.spring.io/#!type=gradle-project&language=kotlin&platformVersion=2.5.0.RELEASE&packaging=jar&jvmVersion=11&groupId=com.koweg.insight&artifactId=insight&name=insight&description=Securities%20analysis%20tool&packageName=com.koweg.insight&dependencies=web,webflux,actuator,cache,data-redis,flapdoodle-mongo,data-mongodb-reactive,cloud-stream

https://spring.io/blog/2019/04/12/going-reactive-with-spring-coroutines-and-kotlin-flow

https://www.nobledesktop.com/learn/git/git-branches

https://www.altexsoft.com/blog/engineering/graphql-core-features-architecture-pros-and-cons/

https://nordicapis.com/5-potential-benefits-integrating-graphql/

https://shopify.dev/concepts/graphql/benefits

https://javascript.plainenglish.io/what-is-http-3-and-why-does-it-matter-cb7d7b4b600f

https://levelup.gitconnected.com/creating-and-filling-a-postgres-db-with-docker-compose-e1607f6f882f


```json
{
  getAllStockAlerts{
    id
    isin
    quantity
    lowerLimit
    upperLimit
  }
}
```

```json 
{
  "data": {
    "getAllStockAlerts": [
      {
        "id": "1",
        "isin": "BNGO",
        "quantity": 100,
        "lowerLimit": 5.23,
        "upperLimit": 7.15
      },
      {
        "id": "2",
        "isin": "BNGO",
        "quantity": 5000,
        "lowerLimit": 10,
        "upperLimit": 15
      },
      {
        "id": "3",
        "isin": "SRNG",
        "quantity": 100,
        "lowerLimit": 9,
        "upperLimit": 9.75
      }
    ]
  }
}
```






```json
{
  portfolios(portfolioId: "II_TRADE") {
    portfolioName
    positions {
      isin
      symbol
      stockName
      marketRate
      quantitiy
      currency
    }
    currency
    lastUpdated
  }
}
```


```json
{
  "data": {
    "portfolios": [
      {
        "portfolioName": "II_TRADE",
        "positions": [
          {
            "isin": "US09075F1075",
            "symbol": "BNGO",
            "stockName": "Bionano Genomics",
            "marketRate": 7.73,
            "quantitiy": 3685,
            "currency": "USD"
          },
          {
            "isin": "US62914V1061",
            "symbol": "TSM",
            "stockName": "Taiwan Semiconductor Manufacturing Co., Ltd. ",
            "marketRate": 119.61,
            "quantitiy": 200,
            "currency": "USD"
          },
          {
            "isin": "US69404D1081",
            "symbol": "PACB",
            "stockName": "Pacific Biosciences of California, Inc",
            "marketRate": 35.34,
            "quantitiy": 180,
            "currency": "USD"
          }
        "lastUpdated": "2021-06-28T20:47:36.700574+01:00"
        ],
        "currency": "GBP",
      }
    ]
  }
}

```








## Wiremock

http://localhost:8080/mock-service/mapping/__admin/

java -jar wiremock-standalone-2.14.0.jar --port 9000 --proxyall http://localhost/accounting/v1/invoices



curl -X GET "http://localhost/accounting/v1/invoices?fromDate=2001-01-31&toDate=2018-03-13&invoiceType=SALE" -H  "accept: application/json" -H  "Authorization: Bearer lwvfefvf" -H  "invoice-api-version: 1"


