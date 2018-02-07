package com.trade.report;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InstructionTest {

	private Instruction instuction;

	@BeforeEach
	void setUp() throws Exception {
		instuction = new Instruction("foo", "B", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25);
	}

	@Test
	void instuctionTest() {
		instuction.sattle();
		assertEquals(10025, instuction.getTrade());
	}

	@Test
	void checkWeekendTest() {

		assertEquals(true, instuction.checkWeekend("02 Jan 2016", "SGP")); // Sat weekend
		assertEquals(true, instuction.checkWeekend("03 Jan 2016", "SGP")); // Sun weekend
		assertEquals(false, instuction.checkWeekend("04 Jan 2016", "SGP")); // Monday weekday

		assertEquals(false, instuction.checkWeekend("07 Jan 2016", "AED")); // Thu weekday
		assertEquals(true, instuction.checkWeekend("08 Jan 2016", "AED")); // Fri weekend for AED
		assertEquals(true, instuction.checkWeekend("09 Jan 2016", "AED")); // Sat weekend for AED
	}

	@Test
	void getNextWorkingDayTest() {
		assertEquals("04 Jan 2016", instuction.getNextWorkingDay("02 Jan 2016", "SGP")); // Sat weekend
		assertEquals("04 Jan 2016", instuction.getNextWorkingDay("03 Jan 2016", "SGP")); // Sun weekend
		assertEquals("04 Jan 2016", instuction.getNextWorkingDay("04 Jan 2016", "SGP")); // Monday weekday

		assertEquals("07 Jan 2016", instuction.getNextWorkingDay("07 Jan 2016", "AED")); // Thu weekday
		assertEquals("10 Jan 2016", instuction.getNextWorkingDay("08 Jan 2016", "AED")); // Fri weekend for AED
		assertEquals("10 Jan 2016", instuction.getNextWorkingDay("09 Jan 2016", "AED")); // Sat weekend for AED
	}
}
