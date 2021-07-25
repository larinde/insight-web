package uk.co.koweg.insight.azure

import com.fasterxml.jackson.databind.ObjectMapper
//import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.netflix.graphql.dgs.DgsQueryExecutor
import org.springframework.stereotype.Component
import uk.co.koweg.insight.domain.datafetchers.StockAlertsDataFetcher
import java.util.function.Function

@Component
class QueryDelegate(private val dgsQueryExecutor: DgsQueryExecutor) : Function<RequestWrapper?, Any> {

    val mapper = ObjectMapper()

    override fun apply(requestWrapper: RequestWrapper?): Any {
        val result = dgsQueryExecutor.execute(requestWrapper?.query)
        println("\n###########\n $result \n###########\n")
        return result.getData()
    }
}