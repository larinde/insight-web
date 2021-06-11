package com.koweg.insight

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import yahoofinance.YahooFinance
import yahoofinance.quotes.fx.FxSymbols
import java.time.LocalDateTime

@SpringBootTest
class InsightWebApplicationTests {

	/**
	@Test()
	fun contextLoads() {
	}
	*/

	@Test
	fun `should retrieve requested stock data`() {
		getStockData()
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
