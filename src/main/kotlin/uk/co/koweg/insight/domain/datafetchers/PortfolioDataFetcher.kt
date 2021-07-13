package uk.co.koweg.insight.domain.datafetchers

import uk.co.koweg.insight.domain.services.PortfolioService
import uk.co.koweg.insight.domain.api.generated.types.Portfolio
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class PortfolioDataFetcher (val portfolioService: PortfolioService){

    @DgsQuery
    fun portfolios(@InputArgument portfolioId: String): List<Portfolio> {
        return if(portfolioId!=null){
            portfolioService.portfolios().filter { it.portfolioName.contains(portfolioId.trim())}
            }else{
                portfolioService.portfolios()
            }
        }
    }