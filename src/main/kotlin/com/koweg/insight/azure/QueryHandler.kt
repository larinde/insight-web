package com.koweg.insight.azure

import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.FunctionName
import com.microsoft.azure.functions.annotation.AuthorizationLevel
import com.microsoft.azure.functions.annotation.HttpTrigger
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
//import java.util.*

import org.springframework.cloud.function.adapter.azure.FunctionInvoker
//import org.springframework.cloud.function.adapter.azure.HttpFunctionInvoker

/**
 * Azure Functions with HTTP Trigger.
 */
class QueryHandler : FunctionInvoker<RequestWrapper?, ResponseWrapper?>() {
    /**
     * This function listens at endpoint "/api/graphql". To invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/graphql
     */
    @FunctionName("graphql")
    fun run(
        @HttpTrigger(name = "request",
            methods = [HttpMethod.POST],
            authLevel = AuthorizationLevel.ANONYMOUS
        ) request: HttpRequestMessage<RequestWrapper>,
        context: ExecutionContext
    ): HttpResponseMessage {
        val requestWrapper = request.body
        context.logger.info(">>> INBOUND: " + requestWrapper.data)
        return  request.createResponseBuilder(HttpStatus.OK)
            .body(handleRequest(requestWrapper, context))
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()
        }


    @FunctionName("test")
    fun graphqlDispatcher(@HttpTrigger(name = "request",
        methods = [HttpMethod.POST],
        authLevel = AuthorizationLevel.ANONYMOUS)
                          request: HttpRequestMessage<RequestWrapper>, context: ExecutionContext
    ): HttpResponseMessage {
        val requestWrapper = request.body
        context.logger.info(">>> INBOUND: " + requestWrapper.data)
        return  request.createResponseBuilder(HttpStatus.OK)
            .body(handleRequest(requestWrapper, context))
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()
    }


}
