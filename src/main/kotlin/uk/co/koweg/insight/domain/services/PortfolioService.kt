package uk.co.koweg.insight.domain.services

import uk.co.koweg.insight.domain.api.generated.types.Portfolio
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

interface PortfolioService {
    fun portfolios(): List<Portfolio>
}

@Service
class PortfolioServiceImpl : PortfolioService {

    override fun portfolios(): List<Portfolio> {
        return listOf<Portfolio>(
            Portfolio(portfolioName = "ING", currency =  "EUR", lastUpdated =  OffsetDateTime.now().minusDays(3)),
            Portfolio(portfolioName = "II_TRADE", currency = "GBP", lastUpdated =  OffsetDateTime.now().minusDays(1)),
            Portfolio(portfolioName ="II_ISA", currency = "GBP", lastUpdated = OffsetDateTime.now().minusDays(1)),
            Portfolio(portfolioName ="II_SIPP", currency = "GBP", lastUpdated = OffsetDateTime.now().minusDays(1))
        )
    }

}