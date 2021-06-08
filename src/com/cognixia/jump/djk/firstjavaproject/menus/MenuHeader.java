package com.cognixia.jump.djk.firstjavaproject.menus;

public class MenuHeader {
	
	private static final int HEADER_WIDTH = 42;
	private static String headerDivider = "";
	
	private String name = "Menu";
	private String prompt =
			"Please choose an option by entering the number of the action that you wish to select.";
	
	{
		addDividerRow('-');
		addDividerRow('_');
	}

	public MenuHeader() {}
	
	public MenuHeader(String menuName) {
		this.name = menuName;
	}
	
	public MenuHeader(String menuName, String prompt) {
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
		System.out.println(headerDivider + name.toUpperCase() + ":\n\n" + prompt + "\n");
	}
	
}
