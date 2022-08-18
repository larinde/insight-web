package com.koweg.insight

import org.assertj.core.api.Assertions.assertThat
//import org.junit.Ignore
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import yahoofinance.YahooFinance
import yahoofinance.quotes.fx.FxSymbols
import java.time.LocalDateTime

@SpringBootTest
@Disabled("Descoping testing for the time being")
class InsightWebApplicationTests {

	/**
	@Test()
	fun contextLoads() {
	}
	*/

	@Test
	fun `should retrieve requested stock data`() {
//		##################################################
//		2021-06-13 20:48:56.596  INFO 400550 --- [    Test worker] y.quotes.query1v7.QuotesRequest          : Sending request: https://query1.finance.yahoo.com/v7/finance/quote?symbols=CLNE
//		10.8
//		CLNE
//		--------------------------------
//		log: Logger[yahoofinance.Stock]
//		symbol: CLNE
//		name: Clean Energy Fuels Corp.
//		currency: USD
//		stockExchange: NasdaqGS
//		quote: Ask: 10.7, Bid: 10.67, Price: 10.8, Prev close: 10.99
//		stats: EPS: -0.101, PE: null, Earnings announcement: Thu May 06 17:05:00 BST 2021
//		dividend: Pay date: /, Ex date: /, Annual yield: /
//		history: null
//		dividendHistory: null
//		splitHistory: null
//		$jacocoData: [Z@6fd4d272
//		--------------------------------
//		kotlin.Unit
//		---------------------------------------------------
//		2021-06-13 20:48:57.521  INFO 400550 --- [    Test worker] y.quotes.query1v7.QuotesRequest          : Sending request: https://query1.finance.yahoo.com/v7/finance/quote?symbols=USDGBP%3DX
//		2021-06-13T20:48:57.558188
//		USDGBP=X: 0.70839
//		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		//getStockData()
		assertThat(findFdaReport("Cassava")).isNotBlank()
	}


	private fun findFdaReport(company : String): String{
		return "done"
	}


	fun getStockData()  {
		println("##################################################")
		val stock = YahooFinance.get("CLNE")
		assertThat(stock).isNotNull()
		println(stock.getQuote().getPrice())
		println(stock.print())
		println("---------------------------------------------------")
		val currencies = listOf<String>(FxSymbols.USDGBP,
			FxSymbols.USDGBP,
			FxSymbols.USDHKD,
			FxSymbols.USDCAD)
		val usdToGbp = YahooFinance.getFx(FxSymbols.USDGBP)
		println(LocalDateTime.now().toString())
		println(usdToGbp.toString())
		println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")

	}

	fun `fda search for catalyst`() {
		//https://api.fda.gov/drug/drugsfda.json?search=openfda.manufacturer_name:"ETON"&limit=5
	}
			
	

}
