package uk.co.koweg.insight.azure

import org.springframework.stereotype.Component
import uk.co.koweg.insight.domain.datafetchers.StockAlertsDataFetcher
import java.util.function.Function

@Component
class QueryDelegate(val stockAlertsDataFetcher: StockAlertsDataFetcher) : Function<RequestWrapper?, Any> {
    override fun apply(requestWrapper: RequestWrapper?): Any {
        return stockAlertsDataFetcher.getAllStockAlerts()
    }
}