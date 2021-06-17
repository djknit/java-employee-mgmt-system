package com.cognixia.jump.djk.firstjavaproject;

import com.cognixia.jump.djk.firstjavaproject.display.Greeting;
import com.cognixia.jump.djk.firstjavaproject.menus.Menus;

public class MainDriver {

	public static void main(String[] args) {
		Greeting.run();
		/* TO DO:
		 * 
		 * retrieve saved object data
		 * 
		 * */
		Menus.main();
		InputScanner.close();
		Greeting.runGoodbye();
	}

}
