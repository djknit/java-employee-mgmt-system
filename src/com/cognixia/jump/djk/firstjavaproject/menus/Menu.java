package com.cognixia.jump.djk.firstjavaproject.menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cognixia.jump.djk.firstjavaproject.Input;

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
		System.out.print("received int: " + selectionNumber);
		menu.options[selectionNumber - 1].select();
	}
	
	private static int getInput(int numOptions) {
		int selectedNumber = 0;
		boolean isFirstTry = true;
		try {
			new Input().getIntInput();
		} catch(InputMismatchException e) {
			
		} catch(Exception e) {
			
		}
		int selectedNumber = 0;
		boolean isFirstTry = true;
		Scanner input = new Scanner(System.in);
		while (selectedNumber <= 0 || selectedNumber > numOptions) {
			if (!isFirstTry) {				
				System.out.println("Unable to process input. Please enter a number between 1 and " + numOptions + ":");
			}
			isFirstTry = false;
			input.useDelimiter(System.lineSeparator()); // source: https://www.reddit.com/r/javahelp/wiki/scanner
			if (input.hasNextInt()) {
				selectedNumber = input.nextInt();
			}
			else {
				input.next();
			}
		}
		input.close();
		return selectedNumber;
	}
	
}
