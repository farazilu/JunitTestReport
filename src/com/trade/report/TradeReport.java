package com.trade.report;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TradeReport {

	private Map<String, DayReport> dailyReports;

	private Map<String, Double> outgoingRanking;
	private Map<String, Double> incomingRanking;

	TradeReport() {
		dailyReports = new HashMap<String, DayReport>();
		outgoingRanking = new HashMap<String, Double>();
		incomingRanking = new HashMap<String, Double>();
	}

	void addInstruction(Instruction instruction) {
		instruction.sattle();
		if (instruction.is_sattled()) {
			// process report as instruction arrive
			String settlementDate = instruction.getSettlementDate();

			// check if we already have a day report for settlement Date
			DayReport dayReport = dailyReports.get(settlementDate);
			if (dayReport == null) {
				dayReport = new DayReport(settlementDate);

			}

			dayReport.addInstruction(instruction);
			dailyReports.put(settlementDate, dayReport);

			Double trade = instruction.getTrade();
			String entity = instruction.getEntity();
			// add instruction to ranking table
			if (instruction.getInstructionType() == 'S') {
				Double entityTotal = incomingRanking.get(entity);
				incomingRanking.put(entity, (entityTotal == null) ? trade : entityTotal + trade);
			} else {
				Double entityTotal = outgoingRanking.get(entity);
				outgoingRanking.put(entity, (entityTotal == null) ? trade : entityTotal + trade);
			}
		}
	}

	public void printReport() {
		// Map<String, Double> outgoingRankingSorted = sortRanking(outgoingRanking);
		// Map<String, Double> incomingRankingSorted = sortRanking(incomingRanking);
		dailyReports.forEach((k, v) -> System.out.println(v.print()));
		// System.out.println(outgoingRanking);
		// System.out.println(incomingRanking);
		System.out.println("Outgong Ranking :");
		outgoingRanking.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEach(System.out::println);
		// outgoingRankingSorted.forEach((k, v) -> {
		// System.out.println(k + " with USD: " + v);
		// });
		System.out.println("Incomming Ranking :");
		// incomingRankingSorted.forEach((k, v) -> {
		// System.out.println(k + " with USD: " + v);
		// });
		//
		incomingRanking.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEach(System.out::println);
	}

	private Map<String, Double> sortRanking(Map<String, Double> unsortMap) {
		return unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
	}

}
