package uk.co.koweg.insight.azure

import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.FunctionName
import com.microsoft.azure.functions.annotation.AuthorizationLevel
import com.microsoft.azure.functions.annotation.HttpTrigger
import org.slf4j.MDC
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

import org.springframework.cloud.function.adapter.azure.FunctionInvoker

class QueryHandler : FunctionInvoker<RequestWrapper?,  Any>() {
    @FunctionName("graphql")
    fun insightsRoute(@HttpTrigger(name = "request",
        methods = [HttpMethod.POST],
        authLevel = AuthorizationLevel.ANONYMOUS)
                      request: HttpRequestMessage<RequestWrapper?>, context: ExecutionContext
    ): HttpResponseMessage {
        val data = request.body
        context.logger.info("\n\n>>> INBOUND: $data\n\n")
        MDC.put("requestId", context.invocationId)
        return  request
            .createResponseBuilder(HttpStatus.OK)
            .body(handleRequest(data, context))
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()
    }

}
