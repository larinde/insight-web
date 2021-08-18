package uk.co.koweg.insight.domain.services

import uk.co.koweg.insight.domain.api.generated.types.Position
import org.springframework.stereotype.Service

interface PositionService {
    fun positionsForPortfolio(portfolioNames: List<String>): Map<String, List<Position>>
}


private val positionRepository = mapOf<String, MutableList<Position>>(
    "ING" to mutableListOf<Position>(
        Position("US0382221051","AMAT","Appliend Materials",114.06,200, "EUR"),
        Position("US62914V1061","NIO","NIO Inc",41.40,500, "EUR"),
        Position("US5949181045","MSFT","Microsoft",225.35,120, "EUR")
    ),
    "II_TRADE" to mutableListOf<Position>(
        Position("US09075F1075","BNGO","Bionano Genomics",7.73,3685, "USD"),
        Position("US62914V1061","TSM","Taiwan Semiconductor Manufacturing Co., Ltd. ",119.61,200, "USD"),
        Position("US69404D1081","PACB","Pacific Biosciences of California, Inc",35.34,180, "USD")
    )
)

@Service
class PositionServiceImpl : PositionService {
    override fun positionsForPortfolio(portfolioNames: List<String>): Map<String, List<Position>> {
        return positionRepository.filter { portfolioNames.contains(it.key) }
    }

}