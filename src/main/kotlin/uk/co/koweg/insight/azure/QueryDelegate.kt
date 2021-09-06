package uk.co.koweg.insight.azure

import com.netflix.graphql.dgs.DgsQueryExecutor
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class QueryDelegate(private val dgsQueryExecutor: DgsQueryExecutor) : Function<RequestWrapper?, Any> {

    companion object{
        private val LOG = LoggerFactory.getLogger(QueryDelegate::class.java)
    }
    override fun apply(requestWrapper: RequestWrapper?): Any {
        val result = dgsQueryExecutor.execute(requestWrapper?.query)
        if(result.isDataPresent && result.errors.isNullOrEmpty()){
            return result.getData()
        }
        LOG.error("error executing query ${result.errors}")

        return result.errors
    }
}