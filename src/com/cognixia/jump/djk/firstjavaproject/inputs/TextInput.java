package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.InputScanner;
import com.cognixia.jump.djk.firstjavaproject.display.Divider;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.Executor;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.StringInHandler;

public class TextInput {
	
	private String prompt;
	private StringInHandler inputHandler;
	private Executor canceler;
	
	public TextInput(String prompt, StringInHandler inputHandler) {
		this(prompt, inputHandler, null);
	}
	
	public TextInput(String prompt, StringInHandler inputHandler, Executor canceler) {
		this.prompt = prompt;
		this.inputHandler = inputHandler;
		this.canceler = canceler;
	}
	
	public void run() {
		String fullPrompt = Divider.get() + "\n" + prompt;
		if (canceler != null) fullPrompt += "\n(Or enter \"0\" or \"b\" to go back.):";
		System.out.println(fullPrompt);
		System.out.print(InputScanner.getLinePreface());
		String userInput = InputScanner.getInput().trim();
		if ((canceler != null) && (userInput.toLowerCase().equals("b") || userInput.equals("0"))) {
			canceler.execute();
			return;
		}
		inputHandler.handleInput(userInput);
	}
	
}
