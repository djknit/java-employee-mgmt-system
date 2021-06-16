package com.cognixia.jump.djk.firstjavaproject.inputs;

import java.util.Collection;

import com.cognixia.jump.djk.firstjavaproject.data.RecordWithId;
import com.cognixia.jump.djk.firstjavaproject.display.RecordReporter;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.DataRecordInHandler;
import com.cognixia.jump.djk.firstjavaproject.functionalInterfaces.Executor;

public class RecordSelector {
	
	private Executor cancel;
	private String title;
	private String prompt;
	private RecordReporter reporter;
	private DataRecordInHandler handleSelection;
	
	public RecordSelector(
		String entityTypeName,
		Executor cancel,
		DataRecordInHandler handleInput
	) {
		this(
			entityTypeName,
			cancel,
			handleInput,
			getDefaultPrompt(entityTypeName)
		);
	}
	
	public RecordSelector(
		String entityTypeName,
		Executor cancel,
		DataRecordInHandler handleInput,
		String prompt
	) {
		this(
			entityTypeName,
			cancel,
			handleInput,
			"Select " + getCapName(entityTypeName),
			getDefaultPrompt(entityTypeName)
		);
	}
	
	public RecordSelector(
		String entityTypeName,
		Executor cancel,
		DataRecordInHandler handleSelection,
		String title,
		String prompt
	) {
		reporter = entityTypeName == "department" ?
				RecordReporter.departments :
				RecordReporter.employees; 
		this.cancel = cancel;
		this.handleSelection = handleSelection;
		this.title = title;
		this.prompt = prompt;
	}
	
	public void selectFrom(
		Collection<? extends RecordWithId> wildCardCollection
	) {
		@SuppressWarnings("unchecked") // hopefully I know what I'm doing here. This shouldn't have any unexpected types.
		Collection<RecordWithId> entities = (Collection<RecordWithId>) wildCardCollection;
		reporter.printEntities(entities, title);
		if (entities.isEmpty()) {
			new AnythingInput(cancel).run();
			return;
		}
		new IdInput(prompt, handleSelection, cancel).run(entities);
	}
	
	private static final String getCapName(String entityTypeName) {
		return entityTypeName.substring(0, 1).toUpperCase() + entityTypeName.substring(1);
	}
	
	private static final String getDefaultPrompt(String entityTypeName) {
		return "Enter the id of the " + entityTypeName + " to select.";
	}
	
}
