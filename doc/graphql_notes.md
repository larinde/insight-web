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








## Wiremock

http://localhost:8080/mock-service/mapping/__admin/

```

java -jar wiremock-standalone-2.14.0.jar --port 9000 --proxyall http://localhost/accounting/v1/invoices

```

```
curl -X GET "http://localhost/accounting/v1/invoices?fromDate=2001-01-31&toDate=2018-03-13&invoiceType=SALE" -H  "accept: application/json" -H  "Authorization: Bearer lwvfefvf" -H  "invoice-api-version: 1"
```
## GraphQL Authz & Authn

Authorisation Patterns

1. Proxy pattern
   - redirect incoming request - without token - to Authorisation Server
   - forward incoming request with token to downstream service
   - aggregate and transform downstream responses

2. www

#### Goals

1. Avoid duplication of authZ logic across BFF microservices
2. Delegate PEP to an API Manager or IdP so that changes/updates can be centrally and dynamically managed.
3. GraphQL should not know anything about authz &authn. it should be delegated
4. Avoid managing audit trail in GraphQL layer
5. Decouple access layer of Graph from permission layer
6. Authorisation error and behaviour - driven from the __product perspective vs driven from a technology perspective__
   - privacy leak consideration

7. GraphQL resolver delegation
8. Avoid privacy rules in GraphQl layer.
9. GraphQL directives??
10. Categories of authorisation errors
    1. invalid auth
    2. insufficient auth
    3. missing auth
11. Caching and memoization

## GraphQL Security Considerations

1. Avoid exposing intrspection in order to reduce attack surface
2. GraphqQL queries bind to resolvers
   1. Prevent DoS and resource exhaustion by estimating and limiting query complexity & depth

3. Layering and chaining of Authz & Authn 
   1. Find the best strategy for enforcing authz/authn at the appropriate layer
      - API layer - authZ & coarse-grained AuthN 
      - Data layer - fine-grained field-level AuthZ 
4. Error handling is challenging due to nested queries and the possibility of conflicting error codes thrown by different queries 
5. GraphQL  Voyager



## Security testing resources

```
https://github.com/hysnsec/DevSecOps-Studio
https://github.com/swisskyrepo
https://github.com/swisskyrepo/PayloadsAllTheThings
```