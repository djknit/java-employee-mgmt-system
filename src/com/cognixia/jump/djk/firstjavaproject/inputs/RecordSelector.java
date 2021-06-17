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
	private Executor handleEmptyCollection;
	private String emptyCollectionStatement;
	
	public RecordSelector(
		String entityTypeName,
		Executor cancel,
		DataRecordInHandler handleSelection,
		String title,
		String prompt
	) {
		this(entityTypeName, cancel, handleSelection, title, prompt, cancel, null);
	}
	
	public RecordSelector(
		String entityTypeName,
		Executor cancel,
		DataRecordInHandler handleSelection,
		String title,
		String prompt,
		Executor handleEmpty,
		String emptyStatement
	) {
		reporter = entityTypeName == "department" ?
				RecordReporter.departments :
				RecordReporter.employees; 
		this.cancel = cancel;
		this.handleEmptyCollection = handleEmpty;
		this.handleSelection = handleSelection;
		this.title = title;
		this.prompt = prompt;
		this.emptyCollectionStatement = emptyStatement;
	}
	
	public void selectFrom(
		Collection<? extends RecordWithId> wildCardCollection
	) {
		@SuppressWarnings("unchecked") // hopefully I know what I'm doing here. This shouldn't have any unexpected types.
		Collection<RecordWithId> entities = (Collection<RecordWithId>) wildCardCollection;
		reporter.printEntities(entities, title);
		if (entities.isEmpty()) {
			if (emptyCollectionStatement != null) {
				System.out.println("\n" + emptyCollectionStatement);
			}
			new AnythingInput(handleEmptyCollection).run();
			return;
		}
		new IdInput(prompt, handleSelection, cancel).run(entities);
	}
	
//	private static final String getCapName(String entityTypeName) {
//		return entityTypeName.substring(0, 1).toUpperCase() + entityTypeName.substring(1);
//	}
//	
//	private static final String getDefaultPrompt(String entityTypeName) {
//		return "Enter the id of the " + entityTypeName + " to select.";
//	}
	
}
