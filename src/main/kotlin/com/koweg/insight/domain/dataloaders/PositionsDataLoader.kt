package com.koweg.insight.domain.dataloaders

import com.koweg.insight.domain.services.PositionService
import com.koweg.insight.domain.generated.types.Position
import com.netflix.graphql.dgs.DgsDataLoader
import org.dataloader.MappedBatchLoader
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
import kotlin.streams.toList

@DgsDataLoader(name = "portfolioItems")
class PositionsDataLoader(val positionService: PositionService) : MappedBatchLoader<String, List<Position>> {

    override fun load(keys: MutableSet<String>): CompletionStage<Map<String, List<Position>>>? {
        return CompletableFuture.supplyAsync{positionService.positionsForPortfolio(keys.stream().toList())}
    }

}