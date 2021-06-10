package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.HasExecutor;
import com.cognixia.jump.djk.firstjavaproject.InputScanner;

public class TextInput {
	
	private static String divider = "\n";
	String prompt;
	HasExecutor canceler;
	
	static {
		for (int i = 0; i < 42; i++) {
			divider += "-";
		}
	}
	
	TextInput(String prompt) {
		this.prompt = prompt;
	}
	
	TextInput(String prompt, HasExecutor canceler) {
		this.prompt = prompt;
		this.canceler = canceler;
	}
	
	public String run() {
		System.out.println(divider + prompt + " (Or type \"b\" to go back.)");
		String userInput = InputScanner.getInput();
		if (userInput.toLowerCase() == "b") {
			canceler.execute();
			return "";
		}
		return userInput;
	}
	
}
