package uk.co.koweg.insight.domain.exception


import com.netflix.graphql.dgs.exceptions.DefaultDataFetcherExceptionHandler
import com.netflix.graphql.types.errors.ErrorDetail
import com.netflix.graphql.types.errors.ErrorType
import com.netflix.graphql.types.errors.TypedGraphQLError
import graphql.execution.DataFetcherExceptionHandler
import graphql.execution.DataFetcherExceptionHandlerParameters
import graphql.execution.DataFetcherExceptionHandlerResult
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.stereotype.Component
import java.lang.RuntimeException
import java.time.Instant
import java.time.format.DateTimeFormatter

@Component
class InsightExceptionHandler : DataFetcherExceptionHandler {

    companion object {
        private val LOG = LoggerFactory.getLogger(InsightExceptionHandler::class.java)
    }

    private val defaultHandler = DefaultDataFetcherExceptionHandler()

    override fun onException(params: DataFetcherExceptionHandlerParameters?)
            : DataFetcherExceptionHandlerResult {

        val exception = params?.exception
        return if (exception is InvalidPortfolioException) {
            LOG.info("\n%%%%%%%%%%%%%%\nInvalidPortfolioException ERROR INTERCEPTED \n%%%%%%%%%%%%%%\n")
            DateTimeFormatter.ISO_INSTANT.format(Instant.now()).toString()
            val debugInfo = mapOf<String, String>("timestamp" to Instant.now().toString(),
                "requestId" to MDC.get("requestId")
            )
            DataFetcherExceptionHandlerResult.newResult()
                    .error(TypedGraphQLError
                            .newBadRequestBuilder()
                            .message(exception.message).debugInfo(debugInfo)
                            .build())
                    .build()
        } else {
            LOG.info("*** SOME OTHER ERROR INTERCEPTED ***")
            defaultHandler.onException(params)
        }
    }

}

class InvalidPortfolioException(message : String) : RuntimeException(message)
