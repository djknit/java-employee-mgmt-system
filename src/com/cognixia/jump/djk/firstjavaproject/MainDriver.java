package com.cognixia.jump.djk.firstjavaproject;

import com.cognixia.jump.djk.firstjavaproject.data.Company;
import com.cognixia.jump.djk.firstjavaproject.data.IO;
import com.cognixia.jump.djk.firstjavaproject.display.Greeting;
import com.cognixia.jump.djk.firstjavaproject.menus.Menus;

public class MainDriver {

	public static void main(String[] args) {
		Greeting.run();
		Menus.main();
		InputScanner.close();
		IO.writeToFile(Company.getInstance());
		Greeting.runGoodbye();
	}

}
