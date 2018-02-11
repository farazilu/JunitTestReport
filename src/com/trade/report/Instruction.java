package com.trade.report;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.sun.media.sound.InvalidDataException;

public class Instruction {
	private String entity;
	private char instruction;
	private double agreedFx;
	private String currency;
	private String instuctionDate;
	private String settlementDate;
	private int units;
	private double pricePerUnit;
	private double trade;
	private boolean sattled = false;

	Instruction(String entity, char instruction, double agreedFx, String currency, String instuctionDate,
			String settlementDate, int units, double pricePerUnit) throws InvalidDataException {
		if (instruction != 'B' && instruction != 'S') {
			throw new InvalidDataException("Wrong instruction value, expecting B or S. given: " + instruction);
		}
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

		if (sattled == false) {
			if (checkWeekend(settlementDate, currency)) {
				settlementDate = getNextWorkingDay(settlementDate, currency);
			}
			trade = pricePerUnit * units * agreedFx;
			sattled = true;
		}
	}

	public boolean is_sattled() {
		return sattled;
	}

	public double getTrade() {
		return trade;
	}

	public String getSettlementDate() {
		return settlementDate;
	}

	public char getInstructionType() {
		return instruction;
	}

	public String getEntity() {
		return entity;
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
