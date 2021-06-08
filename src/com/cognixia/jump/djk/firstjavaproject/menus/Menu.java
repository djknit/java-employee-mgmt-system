package com.cognixia.jump.djk.firstjavaproject.menus;

public class Menu {
	
	private MenuOption[] options;
	private MenuHeader header;
	
	Menu(MenuOption[] options) {
		this.options = options;
		this.header = new MenuHeader();
	}
	
	Menu(MenuHeader header, MenuOption[] options) {
		this.options = options;
		this.header = header;
	}
	
	public final void run() {
//		header.print();
//		for (int i = 0; i < options.length; i++) {
//			System.out.println(" " + (i + 1) + ".) " + options[i].getDescription());
//		}
		run(this);
	}
	
	public static void run(Menu menu) {
		menu.header.print();
		for (int i = 0; i < menu.options.length; i++) {
			System.out.println(" " + (i + 1) + ".) " + menu.options[i].getDescription());
		}
	}
	
}
