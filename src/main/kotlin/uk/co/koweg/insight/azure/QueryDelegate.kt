package uk.co.koweg.insight.azure

import com.netflix.graphql.dgs.DgsQueryExecutor
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class QueryDelegate(private val dgsQueryExecutor: DgsQueryExecutor) : Function<RequestWrapper?, Any> {

    override fun apply(requestWrapper: RequestWrapper?): Any {
        val result = dgsQueryExecutor.execute(requestWrapper?.query)
        if(result.isDataPresent && result.errors.isNullOrEmpty()){
            return result.getData()
        }
        println("\n>>>>>>>>>>>\n ${result.errors} \n>>>>>>>>>>>\n")

        return result.errors
    }
}