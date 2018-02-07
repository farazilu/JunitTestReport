package com.trade.report;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Instruction {
	private String entity;
	private String instruction;
	private double agreedFx;
	private String currency;
	private String instuctionDate;
	private String settlementDate;
	private int units;
	private double pricePerUnit;
	private double trade;

	Instruction(String entity, String instruction, double agreedFx, String currency, String instuctionDate,
			String settlementDate, int units, double pricePerUnit) {
		this.entity = entity;
		this.instruction = instruction;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instuctionDate = instuctionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
	}

	public void sattle() {
		if (checkWeekend(instuctionDate, currency)) {
			this.settlementDate = getNextWorkingDay(instuctionDate, currency);
		}
		trade = pricePerUnit * units * agreedFx;

	}

	public double getTrade() {
		return trade;
	}

	public boolean checkWeekend(String date, String currency) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM uuuu");
		LocalDate localDate = LocalDate.parse(date, formatter);
		DayOfWeek dayoOfWeek = localDate.getDayOfWeek();

		if (currency == "AED" || currency == "SAR") {
			return (dayoOfWeek == DayOfWeek.FRIDAY || dayoOfWeek == DayOfWeek.SATURDAY);
		} else {
			return (dayoOfWeek == DayOfWeek.SATURDAY || dayoOfWeek == DayOfWeek.SUNDAY);
		}
	}

	public String getNextWorkingDay(String date, String currency) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM uuuu");
		LocalDate localDate = LocalDate.parse(date, formatter);
		DayOfWeek dayoOfWeek = localDate.getDayOfWeek();

		if (currency == "AED" || currency == "SAR") {
			if (dayoOfWeek == DayOfWeek.FRIDAY) {
				localDate = localDate.plusDays(2);
			}
			if (dayoOfWeek == DayOfWeek.SATURDAY) {
				localDate = localDate.plusDays(1);
			}
		} else {
			if (dayoOfWeek == DayOfWeek.SATURDAY) {
				localDate = localDate.plusDays(2);
			}
			if (dayoOfWeek == DayOfWeek.SUNDAY) {
				localDate = localDate.plusDays(1);
			}
		}

		return formatter.format(localDate);
	}
}
