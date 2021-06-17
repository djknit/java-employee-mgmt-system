package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.data.DollarAmount;
import com.cognixia.jump.djk.firstjavaproject.data.InvalidDollarAmountException;
import com.cognixia.jump.djk.firstjavaproject.data.InvalidIntException;
import com.cognixia.jump.djk.firstjavaproject.display.Divider;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.DollarAmountInHandler;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.Executor;
import com.cognixia.jump.djk.firstjavaproject.InputScanner;

public class DollarsInput {

	private final static String RETRY_PROMPT = 
			"Unable to process input. Please enter a positive whole number.";
	
	private String prompt;
	private DollarAmountInHandler inputHandler;
	private Executor canceler;
	
	public DollarsInput(String prompt, DollarAmountInHandler inputHandler) {
		this(prompt, inputHandler, null);
	}
	
	public DollarsInput(String prompt, DollarAmountInHandler inputHandler, Executor canceler) {
		this.prompt = prompt;
		this.inputHandler = inputHandler;
		this.canceler = canceler;
	}
	
	public void run() {
		run(Divider.get() + "\n" + prompt);
	}
	
	private void run(String fullPrompt) {
		if (canceler != null) fullPrompt += "\n(Or enter \"b\" to go back.):";
		System.out.println(fullPrompt);
		System.out.print(InputScanner.getLinePreface() + "$ ");
		try {
			int input = InputScanner.getIntInput(false);
			if (input < 0) {
				throw new InvalidDollarAmountException();
			}
			else inputHandler.handleInput(new DollarAmount(input));
		} catch(InvalidDollarAmountException e) {
			tryAgain();
		} catch(InvalidIntException e) {
			boolean isB = InputScanner.getInput().trim().toLowerCase().equals("b");
			if (isB && (canceler != null)) canceler.execute();
			else tryAgain();
		} catch(Exception e) {
			tryAgain();
		}
	}
	
	private void tryAgain() {
		run(RETRY_PROMPT);
	}
	
}
