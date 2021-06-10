package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.Executor;
import com.cognixia.jump.djk.firstjavaproject.InputScanner;
import com.cognixia.jump.djk.firstjavaproject.InputHandler;

public class TextInput {
	
	private static String divider = "\n";
	private String prompt;
	private Executor canceler;
	private InputHandler inputHandler;
	private boolean hasCanceler = false;
	
	static {
		for (int i = 0; i < 42; i++) {
			divider += "-";
		}
	}
	
	TextInput(String prompt, InputHandler inputHandler) {
		this.prompt = prompt;
		this.inputHandler = inputHandler;
	}
	
	TextInput(String prompt, InputHandler inputHandler, Executor canceler) {
		this(prompt, inputHandler);
		this.canceler = canceler;
		this.hasCanceler = true;
	}
	
	public void run() {
		String fullPrompt = divider + prompt;
		if (hasCanceler) fullPrompt += "\n(Or type \"0\" or \"b\" to go back.):";
		System.out.println(fullPrompt);
		String userInput = InputScanner.getInput().trim();
		if (hasCanceler && (userInput.toLowerCase() == "b" || userInput == "0")) {
			canceler.execute();
			return;
		}
		inputHandler.handleInput(userInput);
	}
	
}
