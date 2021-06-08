package com.cognixia.jump.djk.firstjavaproject;

import com.cognixia.jump.djk.firstjavaproject.menus.Menus;

public class MainDriver {

	public static void main(String[] args) {
		Greeting.run();
		Menus.main();
		Input.close();
		Greeting.runGoodbye();
	}

}
