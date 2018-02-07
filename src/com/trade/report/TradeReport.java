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
				Double freq = incomming.get(settlementDate);
				incomming.put(settlementDate, (freq == null) ? trade : freq + trade);
			} else {
				Double freq = outgoing.get(settlementDate);
				outgoing.put(settlementDate, (freq == null) ? trade : freq + trade);
			}
			// associative array in java
			// https://stackoverflow.com/questions/5122913/java-associative-array
			// https://docs.oracle.com/javase/tutorial/collections/interfaces/map.html
		}
	}

}
