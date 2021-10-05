package com.koweg.insight.domain.exception

import com.microsoft.applicationinsights.web.internal.ThreadContext
import com.netflix.graphql.types.errors.ErrorType
import com.netflix.graphql.types.errors.TypedGraphQLError
import graphql.execution.DataFetcherExceptionHandler
import graphql.execution.DataFetcherExceptionHandlerParameters
import graphql.execution.DataFetcherExceptionHandlerResult
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.format.DateTimeFormatter

@Component
class InsightExceptionHandler : DataFetcherExceptionHandler {

    private val REQUEST_ID_CONTEXT = "requestId"

    override fun onException(params: DataFetcherExceptionHandlerParameters?): DataFetcherExceptionHandlerResult {
        return when(params?.exception){
            is InvalidPortfolioException -> {
                buildErrorResponse(ErrorType.BAD_REQUEST, ErrorResponseMessages.MISSING_PORTFOLIO_IDENTIFIER.message)
            }
            else -> {
                buildErrorResponse(ErrorType.UNKNOWN, ErrorResponseMessages.UNKNOWN_FAILURE.message)
            }
        }
    }

    private fun buildErrorResponse(
        errorType: ErrorType,
        errorMessage: String) : DataFetcherExceptionHandlerResult{
        val opId = ThreadContext.getRequestTelemetryContext()?.httpRequestTelemetry?.context?.operation?.id?:""
        val additionalInfo = mapOf<String, String>(
            "timestamp" to DateTimeFormatter.ISO_INSTANT.format(Instant.now()).toString(),
            REQUEST_ID_CONTEXT to opId
        )

        return DataFetcherExceptionHandlerResult
            .newResult()
            .error( TypedGraphQLError
                .newBuilder()
                .message(errorMessage)
                .errorType(errorType)
                .debugInfo(additionalInfo)
                .build())
            .build()
    }
}

enum class ErrorResponseMessages(val message: String){
    UNAUTHORISED_ACCESS("Invalid or unauthorised token"),
    UNKNOWN_FAILURE("Unable to process request"),
    MISSING_PORTFOLIO_IDENTIFIER("Invalid or missing portfolio identifier")
}

class UnexpectedErrorException: RuntimeException()

class InvalidPortfolioException: RuntimeException()