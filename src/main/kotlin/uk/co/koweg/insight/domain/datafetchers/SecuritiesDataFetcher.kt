package uk.co.koweg.insight.domain.datafetchers

import com.netflix.graphql.dgs.*
import org.slf4j.LoggerFactory
import uk.co.koweg.insight.domain.api.generated.DgsConstants
import uk.co.koweg.insight.domain.api.generated.types.Portfolio
import uk.co.koweg.insight.domain.api.generated.types.Position
import uk.co.koweg.insight.domain.api.generated.types.StockAlert

@DgsComponent
class SecuritiesDataFetcher {
    companion object{
        private val LOG = LoggerFactory.getLogger(SecuritiesDataFetcher::class.java)
    }

    @DgsQuery
    fun securities(dfe: DgsDataFetchingEnvironment): List<StockAlert> {
        return dfe.getSource<List<StockAlert>>()
    }

    @DgsData(parentType = DgsConstants.SECURITIES.TYPE_NAME, field = DgsConstants.SECURITIES.Portfolios)
    fun portfolios(dfe: DgsDataFetchingEnvironment, @InputArgument portfolioId: String?): List<Portfolio> {
        LOG.info("########### retrieving securities/portfolios #########################\n\n")
        return dfe.getSource<List<Portfolio>>()
    }

    @DgsData(parentType = DgsConstants.SECURITIES.TYPE_NAME, field = DgsConstants.SECURITIES.StockAlerts)
    fun stockAlerts(dfe: DgsDataFetchingEnvironment): List<StockAlert> {
        LOG.info("########### retrieving securities/stockAlerts #########################\n\n")
        return dfe.getSource<List<StockAlert>>()
    }

}