package com.cognixia.jump.djk.firstjavaproject.menus;

import com.cognixia.jump.djk.firstjavaproject.InputScanner;

class Menu {
	
	private static final String DEFAULT_NAME = "Menu";
	private static final String DEFAULT_PROMPT =
			"Enter the corresponding number to select an option:";

	private MenuOption[] options;
	private FullPrompt fullPrompt = null;
	
	Menu(MenuOption[] options) {
		this(options, DEFAULT_NAME);
	}
	
	Menu(MenuOption[] options, String name) {
		this(options, name, DEFAULT_PROMPT);
	}
	
	Menu(MenuOption[] options, String name, String prompt) {
		this.options = new MenuOption[options.length + 1];
		this.options[0] = new EndProgramMenuOption();
		for (int i = 0; i < options.length; i++) {
			this.options[i + 1] = options[i];
		}
		this.fullPrompt = new FullPrompt(this.options, name, prompt);
	}
	
	private class EndProgramMenuOption extends MenuOption {
		EndProgramMenuOption() {
			super("Exit Program", () -> {});
		}
	}
	
	final void run() {
		run(this);
	}
	
	static void run(Menu menu) {
		menu.fullPrompt.print();
		int selectionNumber = getInput(menu.options.length);
		menu.options[selectionNumber].select();
	}
	
	private static int getInput(int numOptions) {
		int selectedNumber = -1;
		int numTries = 0;
		while (selectedNumber < 0 || selectedNumber >= numOptions) {
			if (numTries++ > 0) {
				System.out.println(
					"Unable to process input. Please enter a number between 0 and "
					+ (numOptions - 1) + ":"
				);
			}
			try {
				selectedNumber = InputScanner.getIntInput();
			} catch(Exception e) {
				continue;
			}
		}
		return selectedNumber;
	}
	
}
