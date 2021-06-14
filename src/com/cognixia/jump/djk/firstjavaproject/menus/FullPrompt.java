package com.cognixia.jump.djk.firstjavaproject.menus;

import com.cognixia.jump.djk.firstjavaproject.display.Divider;

class FullPrompt {
	
	private MenuOption[] options;
	private String name;
	private String prompt;

	FullPrompt(MenuOption[] options, String menuName, String prompt) {
		this.options = options;
		this.name = menuName.toUpperCase();
		this.prompt = prompt;
	}

	FullPrompt(MenuOption[] options, String menuName, String prompt, boolean leaveCase) {
		this.options = options;
		this.name = leaveCase ? menuName : menuName.toUpperCase();
		this.prompt = prompt;
	}
	
	public final void print() {
		Divider.printLow();
		Divider.print();
		Divider.printLow();
		System.out.println(name + ":\n");
		for (int i = 0; i < options.length; i++) {
			System.out.println("  " + i + ".) " + options[i].getDescription());
		}
		System.out.println("\n" + prompt);
	}
	
}
