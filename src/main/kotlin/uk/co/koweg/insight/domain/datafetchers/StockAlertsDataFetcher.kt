package uk.co.koweg.insight.domain.datafetchers

import uk.co.koweg.insight.domain.api.generated.types.StockAlert
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery

@DgsComponent
class StockAlertsDataFetcher {
    private val stockAlertRepository= listOf<StockAlert>(
        StockAlert("1", "BNGO", 100, 5.23, 7.15),
        StockAlert("2", "BNGO", 5000, 10.00, 15.00),
        StockAlert("3", "SRNG", 100, 9.00, 9.75))

    @DgsQuery
    fun getAllStockAlerts(): List<StockAlert>{
        return stockAlertRepository
    }

}