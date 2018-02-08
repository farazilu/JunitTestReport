package com.trade.report;

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
		instructions[1] = new Instruction("foo", 'B', 0.10, "GBP", "01 Jan 2016", "05 Jan 2016", 200, 100.25);
		instructions[2] = new Instruction("bar", 'B', 0.70, "INR", "01 Jan 2016", "01 Jan 2016", 20, 100.25);
		instructions[3] = new Instruction("too", 'B', 0.25, "AED", "01 Jan 2016", "07 Jan 2016", 20, 100.25);

		instructions[5] = new Instruction("foo", 'S', 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25);
		instructions[6] = new Instruction("foo", 'S', 0.10, "GBP", "01 Jan 2016", "05 Jan 2016", 200, 100.25);
		instructions[7] = new Instruction("bar", 'S', 0.70, "INR", "01 Jan 2016", "03 Jan 2016", 15, 100.25);
		instructions[8] = new Instruction("too", 'S', 0.35, "SAR", "01 Jan 2016", "10 Jan 2016", 20, 100.25);

		for (Instruction instruction : instructions) {
			if (instruction != null) {
				tradeReport.addInstruction(instruction);
			}
		}
		// instuction.sattle();

	}

	@Test
	void tradeReportTest() {

		// check console for report
		tradeReport.printReport();
	}

}
