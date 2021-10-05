package com.koweg.insight.domain.datafetchers

import com.koweg.insight.domain.exception.UnexpectedErrorException
import com.koweg.insight.domain.generated.DgsConstants
import com.koweg.insight.domain.generated.types.StockAlert
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import java.util.concurrent.atomic.AtomicInteger

@DgsComponent
class StockAlertsDataFetcher {
    companion object {
        val idGenerator = AtomicInteger(1)
    }

    private val stockAlertRepository= listOf<StockAlert>(
        StockAlert(idGenerator.getAndIncrement().toString(), "CRBU", 20.00, 25.00),
        StockAlert(idGenerator.getAndIncrement().toString(), "NSTB", 9.5, 10.00),
        StockAlert(idGenerator.getAndIncrement().toString(), "WFC", 45.0, 50.00),
        StockAlert(idGenerator.getAndIncrement().toString(), "SOFI", 15.00, 18.00),
        StockAlert(idGenerator.getAndIncrement().toString(), "DNA", 9.00, 14.75))

    @DgsData(parentType = DgsConstants.QUERY.TYPE_NAME, field = DgsConstants.QUERY.GetAllStockAlerts)
    fun retrieveStockAlerts(): List<StockAlert>{
        return stockAlertRepository
    }

}