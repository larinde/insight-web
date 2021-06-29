package com.koweg.insight.domain.datafetchers

import com.koweg.insight.domain.services.PositionService
import com.koweg.insight.domain.dataloaders.PositionsDataLoader
import com.koweg.insight.domain.generated.DgsConstants
import com.koweg.insight.domain.generated.types.Portfolio
import com.koweg.insight.domain.generated.types.Position
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import org.dataloader.DataLoader
import java.util.concurrent.CompletableFuture

@DgsComponent
class PositionDataFetcher(val positionService : PositionService) {


    @DgsData(parentType = DgsConstants.PORTFOLIO.TYPE_NAME, field = DgsConstants.PORTFOLIO.Positions)
    fun getPositions(dfe: DgsDataFetchingEnvironment): CompletableFuture<List<Position>> {
        val positionsLoader : DataLoader<String, List<Position>> = dfe.getDataLoader(PositionsDataLoader::class.java)

        val po : Portfolio = dfe.getSource()

        println("\n***********loading  portfolio positions: " + po.portfolioName)

        return  positionsLoader.load(po.portfolioName)
    }

}