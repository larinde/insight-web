package com.koweg.insight

import java.time.LocalDate

data class TradeStock(val symbol: String, val deadline: LocalDate, val catalyst: TradeCatalyst, val description: String) {
}

enum class TradeCatalyst {
    FDA_APPROVAL,
    DIVIDEND_PAYOUT,
    STOCK_SPLIT
}
