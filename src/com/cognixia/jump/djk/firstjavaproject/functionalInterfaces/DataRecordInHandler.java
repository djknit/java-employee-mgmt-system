package com.cognixia.jump.djk.firstjavaproject.functionalInterfaces;

import com.cognixia.jump.djk.firstjavaproject.data.RecordWithId;

@FunctionalInterface
public interface DataRecordInHandler {
	
	public void handleInput(RecordWithId input);
	
}
