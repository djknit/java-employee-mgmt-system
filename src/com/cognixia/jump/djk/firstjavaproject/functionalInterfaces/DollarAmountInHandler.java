package com.cognixia.jump.djk.firstjavaproject.functionalInterfaces;

import com.cognixia.jump.djk.firstjavaproject.data.DollarAmount;

@FunctionalInterface
public interface DollarAmountInHandler {

	public void handleInput(DollarAmount input);
	
}
