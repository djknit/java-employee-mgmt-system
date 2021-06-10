package com.cognixia.jump.djk.firstjavaproject.menus;

import com.cognixia.jump.djk.firstjavaproject.InputScanner;

public class Menu {
	
	private MenuOption[] options;
	private FullPrompt fullPrompt = null;
	
	Menu(MenuOption[] options) {
		this.options = options;
		this.fullPrompt = new FullPrompt(options);
	}
	
	Menu(MenuOption[] options, String name) {
		this.options = options;
		this.fullPrompt = new FullPrompt(options, name);
	}
	
	Menu(MenuOption[] options, String name, String prompt) {
		this.options = options;
		this.fullPrompt = new FullPrompt(options, name, prompt);
	}
	
	public final void run() {
		run(this);
	}
	
	public static void run(Menu menu) {
		menu.fullPrompt.print();
		int selectionNumber = getInput(menu.options.length);
		menu.options[selectionNumber - 1].select();
	}
	
	private static int getInput(int numOptions) {
		int selectedNumber = 0;
		boolean isFirstTry = true;
		while (selectedNumber <= 0 || selectedNumber > numOptions) {
			if (!isFirstTry) {
				System.out.println("Unable to process input. Please enter a number between 1 and " + numOptions + ":");
			}
			isFirstTry = false;
			try {
				selectedNumber = InputScanner.getIntInput();
			} catch(Exception e) {
				continue;
			}
		}
		return selectedNumber;
	}
	
}
