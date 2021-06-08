package com.cognixia.jump.djk.firstjavaproject.data;

import java.text.NumberFormat;
import java.util.Locale;

public class DollarAmount {
	
	private int amount;
	
	public DollarAmount() {
		this(0); // source: https://stackoverflow.com/questions/285177/how-do-i-call-one-constructor-from-another-in-java#answer-15348070
	}
	
	public DollarAmount(int amount) {
		try {
			setAmount(amount);
		} catch(InvalidDollarAmountException e) {
			System.out.println("Invalid dollar amount. Dollar amount was not set.");
		} catch(Exception e) {
			System.out.println("Unexpected error occured while saving dollar amount.");
		}
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) throws InvalidDollarAmountException {
		if (amount < 0) throw new InvalidDollarAmountException();
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		// source: https://www.baeldung.com/java-number-formatting
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		return nf.format(amount);
	}
	
}
