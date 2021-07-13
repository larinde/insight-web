package uk.co.koweg.insight.azure

import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.FunctionName
import com.microsoft.azure.functions.annotation.AuthorizationLevel
import com.microsoft.azure.functions.annotation.HttpTrigger
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

import org.springframework.cloud.function.adapter.azure.FunctionInvoker

class QueryHandler : FunctionInvoker<RequestWrapper?,  Any>() {
    @FunctionName("graphql")
    fun allMealsRoute(@HttpTrigger(name = "request",
        methods = [HttpMethod.POST],
        authLevel = AuthorizationLevel.ANONYMOUS)
                      request: HttpRequestMessage<RequestWrapper?>, context: ExecutionContext
    ): HttpResponseMessage {
        val data = request.body
        context.logger.info("\n\n>>> INBOUND: $data\n\n")
        return  request
            .createResponseBuilder(HttpStatus.OK)
            .body(handleRequest(data, context))
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()
    }







/*
    @FunctionName("test")
    fun run(
        @HttpTrigger(name = "request",
            methods = [HttpMethod.POST],
            authLevel = AuthorizationLevel.ANONYMOUS
        ) request: HttpRequestMessage<RequestWrapper>,
        context: ExecutionContext
    ): HttpResponseMessage {
        val data = request.body
        context.logger.info("\n\n>>> INBOUND: $data\n\n")
        return  request.createResponseBuilder(HttpStatus.OK)
            .body(handleRequest(data, context))
            .header("Content-Type", "application/json")
            //.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()
        }
*/


/*
    @FunctionName("graphql")
    fun graphqlDispatcher(@HttpTrigger(name = "request",
        methods = [HttpMethod.POST],
        authLevel = AuthorizationLevel.ANONYMOUS)
                          request: HttpRequestMessage<Any>, context: ExecutionContext
    ): HttpResponseMessage {
        //val requestWrapper = request.body
        context.logger.info(">>> INBOUND GraphQL Query ")
        return  request
            .createResponseBuilder(HttpStatus.OK)
            .body(handleRequest(Any(), context))
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()
    }
*/


}
