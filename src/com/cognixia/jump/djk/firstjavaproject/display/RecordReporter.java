package com.cognixia.jump.djk.firstjavaproject.display;

import java.util.Collection;

public class RecordReporter {
	
	private String entityTypeName;
	public static final RecordReporter departments = new RecordReporter("department");
	public static final RecordReporter employees = new RecordReporter("employee");
	
	private RecordReporter(String entityTypeName) {
		this.entityTypeName = entityTypeName;	
	}
	
	public final void printEntity(Object entity) {
		printEntity(entity, "Selected " + entityTypeName);
	}
	
	public final void announceCreationOf(Object entity) {
		printEntity(entity, "New " + entityTypeName + " created");
	}
	
	public final void printEntities(Collection<?> entities) {
		printEntities(entities, entityTypeName + "s");
	}
	
	public final void printEntities(Collection<?> entities, String label) {
		printHeadDividers();
		System.out.println(label.toUpperCase() + ":\n");
		if (entities.isEmpty()) {
			System.out.println(" No " + entityTypeName + "s found.");
		}
		CollectionPrinter.print(entities);
	}
	
	private final void printEntity(Object entity, String labelText) {
		printHeadDividers();
		System.out.println(labelText.toUpperCase() + ":\n\n " + entity);
	}
	
	private static void printHeadDividers() {
		Divider.printLow();
		Divider.printLow();
		Divider.print();
	}
	
}
