package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.DollarAmountInHandler;
import com.cognixia.jump.djk.firstjavaproject.Executor;
import com.cognixia.jump.djk.firstjavaproject.data.DollarAmount;
import com.cognixia.jump.djk.firstjavaproject.data.InvalidDollarAmountException;
import com.cognixia.jump.djk.firstjavaproject.InputScanner;

public class DollarsInput {

	private static String divider = "\n";
	private String prompt;
	private Executor canceler;
	private DollarAmountInHandler inputHandler;
	private boolean hasCanceler = false;
	private final String RETRY_PROMPT = 
			"Unable to process input. Please enter a positive whole number.";
	
	static {
		for (int i = 0; i < 42; i++) divider += "-";
	}
	
	public DollarsInput(String prompt, DollarAmountInHandler inputHandler) {
		this.prompt = prompt;
		this.inputHandler = inputHandler;
	}
	
	public DollarsInput(String prompt, DollarAmountInHandler inputHandler, Executor canceler) {
		this(prompt, inputHandler);
		this.canceler = canceler;
		this.hasCanceler = true;
	}
	
	public void run() {
		run(divider + prompt);
	}
	
	private void run(String fullPrompt) {
		if (hasCanceler) fullPrompt += "\n(Or enter \"b\" to go back.):";
		System.out.println(fullPrompt);
		try {
			int input = InputScanner.getIntInput(false);
			if (hasCanceler && input == 0) canceler.execute();
			else if (input < 0) tryAgain();
			else {
				inputHandler.handleInput(new DollarAmount(input));
			}
		} catch(InvalidDollarAmountException e) {
			tryAgain();
			return;
		} catch(Exception e) {
			if (InputScanner.getInput().trim().toLowerCase() == "b" && hasCanceler) {
				canceler.execute();
				return;
			}
			tryAgain();
		}
	}
	
	private void tryAgain() {
		run(RETRY_PROMPT);
	}
	
}
