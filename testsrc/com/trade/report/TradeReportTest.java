package com.trade.report;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
class TradeReportTest {

	private TradeReport tradeReport;

	@BeforeEach
	void setUp() throws Exception {
		tradeReport = new TradeReport();
	}

	@Parameters
	public static Collection<Object[]> testData() {
		Object[][] data = new Object[][] { { 1, 2, 3 } };
		return Arrays.asList(data);
	}

	@Test
	void tradeReportTest() {
		fail("its suppose to fial");
	}

	@Test
	void checkWeekendTest() {

//		assertEquals(true, tradeReport.checkWeekend("02 Jan 2016", "SGP")); // Sat weekend
//		assertEquals(true, tradeReport.checkWeekend("03 Jan 2016", "SGP")); // Sun weekend
//		assertEquals(false, tradeReport.checkWeekend("04 Jan 2016", "SGP")); // Monday weekday
//
//		assertEquals(false, tradeReport.checkWeekend("07 Jan 2016", "AED")); // Thu weekday
//		assertEquals(true, tradeReport.checkWeekend("08 Jan 2016", "AED")); // Fri weekend for AED
//		assertEquals(true, tradeReport.checkWeekend("09 Jan 2016", "AED")); // Sat weekend for AED
	}

	@Test
	void getNextWorkingDayTest() {
//		assertEquals("04 Jan 2016", tradeReport.getNextWorkingDay("02 Jan 2016", "SGP")); // Sat weekend
//		assertEquals("04 Jan 2016", tradeReport.getNextWorkingDay("03 Jan 2016", "SGP")); // Sun weekend
//		assertEquals("04 Jan 2016", tradeReport.getNextWorkingDay("04 Jan 2016", "SGP")); // Monday weekday
//
//		assertEquals("07 Jan 2016", tradeReport.getNextWorkingDay("07 Jan 2016", "AED")); // Thu weekday
//		assertEquals("10 Jan 2016", tradeReport.getNextWorkingDay("08 Jan 2016", "AED")); // Fri weekend for AED
//		assertEquals("10 Jan 2016", tradeReport.getNextWorkingDay("09 Jan 2016", "AED")); // Sat weekend for AED
	}
}
