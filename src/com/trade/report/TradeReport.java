package com.trade.report;

import java.util.HashMap;
import java.util.Map;

public class TradeReport {

	private Map<String, Double> incomming;
	private Map<String, Double> outgoing;

	TradeReport() {
		incomming = new HashMap<String, Double>();
		outgoing = new HashMap<String, Double>();
	}

	void addInstruction(Instruction instruction) {
		if (instruction.is_sattled()) {
			// process report as instruction arrive
			String settlementDate = instruction.getSettlementDate();
			Double trade = instruction.getTrade();
			if (instruction.getInstructionType() == 'S') {
				Double runningTotal = incomming.get(settlementDate);
				incomming.put(settlementDate, (runningTotal == null) ? trade : runningTotal + trade);
			} else {
				Double runningTotal = outgoing.get(settlementDate);
				outgoing.put(settlementDate, (runningTotal == null) ? trade : runningTotal + trade);
			}
			// associative array in java
			// https://stackoverflow.com/questions/5122913/java-associative-array
			// https://docs.oracle.com/javase/tutorial/collections/interfaces/map.html
		}
	}

}
