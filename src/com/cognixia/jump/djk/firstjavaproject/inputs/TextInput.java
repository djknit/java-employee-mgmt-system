package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.Divider;
import com.cognixia.jump.djk.firstjavaproject.Executor;
import com.cognixia.jump.djk.firstjavaproject.InputScanner;
import com.cognixia.jump.djk.firstjavaproject.StringInHandler;

public class TextInput {
	
	private String prompt;
	private Executor canceler;
	private StringInHandler inputHandler;
	private boolean hasCanceler = false;
	
	public TextInput(String prompt, StringInHandler inputHandler) {
		this.prompt = prompt;
		this.inputHandler = inputHandler;
	}
	
	public TextInput(String prompt, StringInHandler inputHandler, Executor canceler) {
		this(prompt, inputHandler);
		this.canceler = canceler;
		this.hasCanceler = true;
	}
	
	public void run() {
		String fullPrompt = Divider.get() + "\n" + prompt;
		if (hasCanceler) fullPrompt += "\n(Or enter \"0\" or \"b\" to go back.):";
		System.out.println(fullPrompt);
		String userInput = InputScanner.getInput().trim();
		if (hasCanceler && (userInput.toLowerCase() == "b" || userInput == "0")) {
			canceler.execute();
			return;
		}
		inputHandler.handleInput(userInput);
	}
	
}
