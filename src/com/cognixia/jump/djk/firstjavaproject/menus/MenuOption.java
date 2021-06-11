package com.cognixia.jump.djk.firstjavaproject.menus;

import com.cognixia.jump.djk.firstjavaproject.Executor;

class MenuOption {
	
	private String description;
	private Executor executor;
	
	MenuOption(String description, Executor executor) {
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
