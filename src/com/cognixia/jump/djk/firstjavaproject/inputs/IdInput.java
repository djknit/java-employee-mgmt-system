package com.cognixia.jump.djk.firstjavaproject.inputs;

import com.cognixia.jump.djk.firstjavaproject.data.InvalidDollarAmountException;
import com.cognixia.jump.djk.firstjavaproject.data.RecordWithId;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.DataRecordInHandler;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.Executor;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.IntInputHandler;

import java.util.Collection;
import java.util.Optional;

import com.cognixia.jump.djk.firstjavaproject.InputScanner;

public class IdInput {

	private String prompt;
	private Executor canceler = null;
	private DataRecordInHandler inputHandler;
	private final static String RETRY_PROMPT = 
			"Unable to process input. Please enter a valid id (or \"0\" or \"b\").";
	private Collection<RecordWithId> entities;
	
	public IdInput(String prompt, DataRecordInHandler inputHandler) {
		this.prompt = prompt;
		this.inputHandler = inputHandler;
	}
	
	public IdInput(String prompt, DataRecordInHandler inputHandler, Executor canceler) {
		this(prompt, inputHandler);
		this.canceler = canceler;
	}
	
	public void run(Collection<RecordWithId> entities) {
		this.entities = entities;
		run("\n" + prompt);
	}
	
	private void run(String fullPrompt) {
		if (canceler != null) fullPrompt += "\n(Or enter \"0\" or \"b\" to go back.):";
		System.out.println(fullPrompt);
		System.out.print(InputScanner.getLinePreface());
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
		} catch(InvalidDollarAmountException e) {
			tryAgain();
			return;
		} catch(Exception e) {
			boolean isB = InputScanner.getInput().trim().toLowerCase().equals("b");
			if (isB && (canceler != null)) canceler.execute();
			else tryAgain();
		}
	}
	
	private Optional<RecordWithId> findByIdInCollection(Collection<RecordWithId> entities, int id) {
		// source: https://stackoverflow.com/questions/17526608/how-to-find-an-object-in-an-arraylist-by-property#answer-48839294
		return entities.stream().filter(entity -> entity.hasId(id)).findFirst();
	}
	
	private void tryAgain() {
		run(RETRY_PROMPT);
	}
	
}
