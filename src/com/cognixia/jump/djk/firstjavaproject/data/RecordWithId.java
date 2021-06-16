package com.cognixia.jump.djk.firstjavaproject.data;

import java.util.Collection;

public class RecordWithId {
	
	protected int id;
	
	public boolean hasId(int id) {
		return id == this.id;
	}
	
	protected RecordWithId genericize() {
		return (RecordWithId) this;
	}
	
}
