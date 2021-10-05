package com.koweg.insight.domain.datafetchers

import com.koweg.insight.domain.exception.InvalidPortfolioException
import com.koweg.insight.domain.generated.DgsConstants
import com.koweg.insight.domain.services.PortfolioService
import com.koweg.insight.domain.generated.types.Portfolio
import com.koweg.insight.domain.generated.types.PortfolioInput
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument

@DgsComponent
class PortfolioDataFetcher (val portfolioService: PortfolioService){

    @DgsData(parentType = DgsConstants.QUERY.TYPE_NAME,  field = DgsConstants.QUERY.Portfolios)
    fun retrievePortfolioById(@InputArgument portfolioId: PortfolioInput): List<Portfolio> {
        return if(portfolioId.portfolioId!=null){
            portfolioService.portfolios().filter { it.portfolioName.contains(portfolioId.portfolioId.trim())}
            }else{
            throw  InvalidPortfolioException()
        }
        }
    }
