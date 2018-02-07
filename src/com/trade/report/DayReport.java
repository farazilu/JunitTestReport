package com.trade.report;

public class DayReport {
	private Double incomming;
	private Double outgoing;
	private String date;

	public DayReport(String date) {
		this.date = date;
		incomming = 0.00;
		outgoing = 0.00;
	}

	public void addInstruction(Instruction instruction) {
		Double trade = instruction.getTrade();
		if (instruction.getInstructionType() == 'S') {
			incomming += trade;
		} else {
			outgoing += trade;
		}
	}

	public String print() {
		return "Date: " + date + " | Incomming: " + incomming + " USD | Outgoing: " + outgoing + " USD";
	}

}
