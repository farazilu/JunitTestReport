package com.trade.report;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TradeReportTest {

	private TradeReport tradeReport;

	@BeforeEach
	void setUp() throws Exception {
		// setup report
		tradeReport = new TradeReport();

		// setup sample instructions
		Instruction[] instructions = new Instruction[9];
		instructions[0] = new Instruction("foo", 'B', 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25);
		instructions[1] = new Instruction("foo", 'B', 0.10, "GBP", "05 Fab 2016", "02 Jan 2016", 200, 100.25);
		
		
		instructions[5] = new Instruction("foo", 'S', 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25);
		instructions[6] = new Instruction("foo", 'S', 0.10, "GBP", "05 Fab 2016", "02 Jan 2016", 200, 100.25);
		
		
		for (Instruction instruction : instructions) {
			instruction.sattle();
			tradeReport.addInstruction(instruction);
		}
		// instuction.sattle();

	}

	@Test
	void tradeReportTest() {
		// create instructions

		fail("its suppose to fial");
	}

}
