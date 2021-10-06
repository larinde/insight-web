package uk.co.koweg.insight.domain.datafetchers

import com.netflix.graphql.dgs.DgsQueryExecutor
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import uk.co.koweg.insight.domain.datafetchers.PositionDataFetcher
import uk.co.koweg.insight.domain.services.PositionService
import org.mockito.Mockito.`when`
import uk.co.koweg.insight.domain.api.generated.types.Position
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import uk.co.koweg.insight.domain.api.generated.types.Portfolio
import uk.co.koweg.insight.domain.dataloaders.PositionsDataLoader
import uk.co.koweg.insight.domain.scalars.DateTimeScalarRegistration
import uk.co.koweg.insight.domain.services.PortfolioService
import java.time.OffsetDateTime

//@Disabled
@SpringBootTest(classes = [DateTimeScalarRegistration::class, DgsAutoConfiguration::class])
class PortfolioDataFetcherTest {

    @Autowired
    lateinit var dgsQueryExecutor: DgsQueryExecutor

    @MockBean
    lateinit var portfolioService: PortfolioService

    @MockBean
    lateinit var positionService: PositionService

    @BeforeEach
    fun before() {
        `when`(portfolioService.portfolios()).thenAnswer {
            listOf(
                Portfolio(portfolioName = "ING", currency =  "EUR", lastUpdated =  OffsetDateTime.now().minusDays(1))
            )
        }
        `when`(positionService.positionsForPortfolio(listOf("ING"))).thenAnswer {
            mapOf(
                Pair(
                    "demo", listOf(
                        Position("US000", "MEGA", "MEGA Corp", 25.10, 2000, "USD")
                    )
                )
            )
        }
    }

    @Test
    fun `should return a list of portfolio positions`() {
        val result = dgsQueryExecutor.execute(
            """
                {
                  portfolios(portfolioId: "ING") {
                    portfolioName
                    positions {
                      isin
                      symbol
                      stockName
                      marketRate
                      quantitiy
                      currency
                    }
                    currency
                    lastUpdated
                  }
                }                
            """.trimIndent()
        )
        assertThat(result).isNotNull

    }

}