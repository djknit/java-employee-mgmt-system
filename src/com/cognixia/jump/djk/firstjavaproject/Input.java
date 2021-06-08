package com.cognixia.jump.djk.firstjavaproject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	
	private static Scanner inputScanner = new Scanner(System.in);
	
	public int getIntInput() throws InputMismatchException, Exception {
//		if (inputScanner.hasNextInt()) {
			return inputScanner.nextInt();
//		}
//		else {
//		}
	}
	
	public String getInput() {
		return inputScanner.next();
	}
	
}
