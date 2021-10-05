# GraphQL Documentation

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




```graphql
{
    getAllStockAlerts {
        id
        isin
        quantity
        lowerLimit
        upperLimit
    }
    portfolios(portfolioId: "ING") {
        portfolioName
        positions {
            symbol
            stockName
            currency
            isin
            marketRate
            quantitiy
        }
        currency
        lastUpdated
    }
}

```

## Query stock alerts

```graphql
query {
  getAllStockAlerts {
    id
    isin
    quantity
    lowerLimit
    upperLimit
  }
  
}

```


## Query stock alerts and portfolio in 1 call

Request: 

```graphql
query {
  getAllStockAlerts {
    id
    isin
    lowerLimit
    upperLimit
  }
  
  portfolios(portfolioId: {
    portfolioId : "ING"
    }){
    portfolioName
    currency
    positions{
      symbol
      stockName
      isin
      marketRate
      quantity
      currency
    }
    lastUpdated
  }
  
}

```

Response:

```graphql
{
  "data": {
    "getAllStockAlerts": [
      {
        "id": "1",
        "isin": "CRBU",
        "lowerLimit": 20,
        "upperLimit": 25
      },
      {
        "id": "2",
        "isin": "NSTB",
        "lowerLimit": 9.5,
        "upperLimit": 10
      },
      {
        "id": "3",
        "isin": "WFC",
        "lowerLimit": 45,
        "upperLimit": 50
      },
      {
        "id": "4",
        "isin": "SOFI",
        "lowerLimit": 15,
        "upperLimit": 18
      },
      {
        "id": "5",
        "isin": "DNA",
        "lowerLimit": 9,
        "upperLimit": 14.75
      }
    ],
    "portfolios": [
      {
        "portfolioName": "ING",
        "currency": "EUR",
        "positions": [
          {
            "symbol": "AMAT",
            "stockName": "Appliend Materials",
            "isin": "US0382221051",
            "marketRate": 114.06,
            "quantity": 200,
            "currency": "EUR"
          },
          {
            "symbol": "NIO",
            "stockName": "NIO Inc",
            "isin": "US62914V1061",
            "marketRate": 41.4,
            "quantity": 500,
            "currency": "EUR"
          },
          {
            "symbol": "MSFT",
            "stockName": "Microsoft",
            "isin": "US5949181045",
            "marketRate": 225.35,
            "quantity": 120,
            "currency": "EUR"
          }
        ],
        "lastUpdated": "2021-09-28T01:18:57.397323+01:00"
      }
    ]
  }
}
```



## Wiremock

http://localhost:8080/mock-service/mapping/__admin/

java -jar wiremock-standalone-2.14.0.jar --port 9000 --proxyall http://localhost/accounting/v1/invoices



curl -X GET "http://localhost/accounting/v1/invoices?fromDate=2001-01-31&toDate=2018-03-13&invoiceType=SALE" -H  "accept: application/json" -H  "Authorization: Bearer lwvfefvf" -H  "invoice-api-version: 1"

```
traces
| where operation_Id == "5bc5c420a8b64a257892ed9f5a0115ee"
```

```shell
 ./gradlew azureWebAppDeploy

```

```shell
#show all containers
docker ps -aq 
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:community

./gradlew -Dsonar.host.url=http://localhost:9000 -Dsonar.verbose=true sonarqube 
```

