package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.data.RecordWithId;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.DataRecordInHandler;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.Executor;

import java.util.Collection;
import java.util.Optional;

import com.cognixia.jump.djk.firstjavaproject.InputScanner;

class IdInput {

	private String prompt;
	private Executor canceler = null;
	private DataRecordInHandler inputHandler;
	private final static String RETRY_PROMPT = 
			"Unable to process input. Please enter a valid id (or \"0\" or \"b\").";
	private Collection<RecordWithId> entities;
	
	IdInput(String prompt, DataRecordInHandler inputHandler, Executor canceler) {
		this.prompt = prompt;
		this.inputHandler = inputHandler;
		this.canceler = canceler;
	}
	
	void run(Collection<RecordWithId> entities) {
		this.entities = entities;
		run("\n" + prompt);
	}
	
	private void run(String fullPrompt) {
		printFullPrompt(fullPrompt);
		try {
			int input = InputScanner.getIntInput(false);
			if (input < 0) tryAgain();
			else if (input == 0 && canceler != null) {
				canceler.execute();
			}
			else {
				Optional<RecordWithId> entity = findByIdInCollection(entities, input);
				if (entity.isPresent()) inputHandler.handleInput(entity.get());
				else tryAgain();
			}
		} catch(Exception e) {
			boolean isB = InputScanner.getInput().trim().toLowerCase().equals("b");
			if (isB && (canceler != null)) canceler.execute();
			else tryAgain();
		}
	}
	
	private void tryAgain() {
		run(RETRY_PROMPT);
	}
	
	private Optional<RecordWithId> findByIdInCollection(Collection<RecordWithId> entities, int id) {
		// source: https://stackoverflow.com/questions/17526608/how-to-find-an-object-in-an-arraylist-by-property#answer-48839294
		return entities.stream().filter(entity -> entity.hasId(id)).findFirst();
	}
	
	private void printFullPrompt(String fullPrompt) {
		if (canceler != null) {
			fullPrompt += "\n(Or enter \"0\" or \"b\" to go back.):";
		}
		System.out.println(fullPrompt);
		System.out.print(InputScanner.getLinePreface());
	}
	
}
