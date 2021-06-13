package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.InputScanner;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.Executor;

/*
ABOUT THIS CLASS:
	Created to allow the user to read output from the previous action before new information is printed to the console.
	Unlike other inputs, no user input is collected apart from the fact that something was entered.
*/
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
