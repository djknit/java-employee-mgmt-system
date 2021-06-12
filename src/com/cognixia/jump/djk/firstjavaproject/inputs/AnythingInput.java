package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.InputScanner;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.Executor;

public class AnythingInput {

	private Executor next;
	
	public AnythingInput(Executor next) {
		this.next = next;
	}
	
	public void run() {
		System.out.println("\nPress \"Enter\" to continue...");
		InputScanner.getInput();
		next.execute();
	}
	
}
