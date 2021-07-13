package uk.co.koweg.insight.domain.datafetchers

import uk.co.koweg.insight.domain.services.PositionService
import uk.co.koweg.insight.domain.dataloaders.PositionsDataLoader
import uk.co.koweg.insight.domain.api.generated.DgsConstants
import uk.co.koweg.insight.domain.api.generated.types.Portfolio
import uk.co.koweg.insight.domain.api.generated.types.Position
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