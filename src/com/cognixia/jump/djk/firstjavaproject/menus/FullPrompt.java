package com.cognixia.jump.djk.firstjavaproject.menus;

class FullPrompt {
	
	private static final int HEADER_WIDTH = 42;
	private static String headerDivider = "";
	
	private MenuOption[] options;
	private String name = "Menu";
	private String prompt =
			"Enter the corresponding number to select an option:";
	
	static {
		addDividerRow('_');
		addDividerRow('-');
		addDividerRow('_');
	}

	FullPrompt(MenuOption[] options) {
		this.options = options;
	}
	
	FullPrompt(MenuOption[] options, String menuName) {
		this.options = options;
		this.name = menuName;
	}
	
	FullPrompt(MenuOption[] options, String menuName, String prompt) {
		this.options = options;
		this.name = menuName;
		this.prompt = prompt;
	}
	
	private static void addDividerRow(char character) {
		for (int i = 0; i < HEADER_WIDTH; i++) {
			headerDivider += character;
		}
		headerDivider += "\n";
	}
	
	public final void print() {
		System.out.println(headerDivider + name.toUpperCase() + ":\n");
		for (int i = 0; i < options.length; i++) {
			System.out.println("  " + (i + 1) + ".) " + options[i].getDescription());
		}
		System.out.println("\n" + prompt);
	}
	
}
