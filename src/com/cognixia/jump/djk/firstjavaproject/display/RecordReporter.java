package com.cognixia.jump.djk.firstjavaproject.display;

import java.util.Collection;

import com.cognixia.jump.djk.firstjavaproject.data.RecordWithId;

public class RecordReporter {
	
	public static final RecordReporter departments = new RecordReporter("department");
	public static final RecordReporter employees = new RecordReporter("employee");
	private String entityTypeName;
	
	private RecordReporter(String entityTypeName) {
		this.entityTypeName = entityTypeName;	
	}
	
	public final void printEntity(RecordWithId entity) {
		printEntity(entity, "Selected " + entityTypeName);
	}
	
	public final void announceCreationOf(RecordWithId entity) {
		printEntity(entity, "New " + entityTypeName + " created");
	}
	
	// `printEntities` parameter element type is "wildcard"
			// source: https://stackoverflow.com/questions/10477570/list-is-a-raw-type-references-to-generic-type-liste-should-be-parameterized/10489762
		// now actually an "upper bounded wildcard"
			// source: https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html
	public final void printEntities(Collection<? extends RecordWithId> entities) {
		printEntities(entities, getCapName() + "s");
	}
	
	public final void printEntities(Collection<? extends RecordWithId> entities, String label) {
		printHeadDividers();
		System.out.println(label.toUpperCase() + ":\n");
		if (entities.isEmpty()) {
			System.out.println(" No " + entityTypeName + "s found.");
		}
		for (RecordWithId entity : entities) {
			System.out.println(" " + entity);
		}
	}
	
	private final void printEntity(RecordWithId entity, String labelText) {
		printHeadDividers();
		System.out.println(labelText.toUpperCase() + ":\n\n " + entity);
	}
	
	private static void printHeadDividers() {
		Divider.printLow();
		Divider.printLow();
		Divider.print();
	}
	
	private final String getCapName() {
		return entityTypeName.substring(0, 1).toUpperCase() + entityTypeName.substring(1);
	}
	
}
