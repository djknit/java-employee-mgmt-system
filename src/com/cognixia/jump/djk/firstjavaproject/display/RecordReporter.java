package com.cognixia.jump.djk.firstjavaproject.display;

import java.util.Collection;
//import java.util.Set;

public class RecordReporter {
	
	private String entityTypeName;
	
	RecordReporter(String entityTypeName) {
		this.entityTypeName = entityTypeName;	
	}
	
	public final void announceCreationOf(Object entity) {
		printHeadDividers();
		String text = "New " + entityTypeName + " created";
		System.out.println(text.toUpperCase() + ":\n\n " + entity);
	}
	
	public final void printEntities(Collection<?> entities) {
		printHeadDividers();
		System.out.println((entityTypeName + "s").toUpperCase() + ":\n");
		CollectionPrinter.print(entities);
	}
	
	private static void printHeadDividers() {
		Divider.printLow();
		Divider.printLow();
		Divider.print();
	}
	
}
