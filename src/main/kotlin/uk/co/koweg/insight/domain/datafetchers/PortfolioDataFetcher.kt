package uk.co.koweg.insight.domain.datafetchers

import uk.co.koweg.insight.domain.services.PortfolioService
import uk.co.koweg.insight.domain.api.generated.types.Portfolio
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import org.slf4j.LoggerFactory
import uk.co.koweg.insight.domain.exception.InvalidPortfolioException

@DgsComponent
class PortfolioDataFetcher(val portfolioService: PortfolioService) {
    companion object{
        private val LOG = LoggerFactory.getLogger(PortfolioDataFetcher::class.java)
    }

    @DgsQuery
    fun portfolios(@InputArgument portfolioId: String): List<Portfolio> {
        return if (!portfolioId.isNullOrEmpty()) {
            LOG.info("loading portfolio $portfolioId")
            portfolioService.portfolios().filter { it.portfolioName.contains(portfolioId.trim()) }
        } else {
            throw InvalidPortfolioException("Invalid or unknown portfolio $portfolioId")
        }
    }

}
