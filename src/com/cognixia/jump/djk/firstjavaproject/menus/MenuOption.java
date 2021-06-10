package com.cognixia.jump.djk.firstjavaproject.menus;

import com.cognixia.jump.djk.firstjavaproject.HasExecutor;

public class MenuOption {
	
	private String description;
	private HasExecutor executor;
	
	MenuOption(String description, HasExecutor executor) {
		this.description = description;
		this.executor = executor;
	}
	
	String getDescription() {
		return description;
	}
	
	void select() {
		executor.execute();
	}
}
