package com.cognixia.jump.djk.firstjavaproject.display;

//import java.util.Collection;
import java.util.Set;

public class CollectionPrinter {

	// `print` parameter set element type is "wildcard"
		// see source: https://stackoverflow.com/questions/10477570/list-is-a-raw-type-references-to-generic-type-liste-should-be-parameterized/10489762
	public static void print(Set<?> entities) {
		for (Object entity : entities) {
			System.out.println(entity);
		}
	}
	
}
