package com.cognixia.jump.djk.firstjavaproject.data;

class ObjIdGenerator {
	
	private int greatestId = 0;
	private boolean wasIdSetManually = false;
	
	int getNextId() {
		return ++greatestId;
	}

	void setGreatestId(int id) {
		if (wasIdSetManually) {
			System.out.println("\nUNEXPECTED: `greatestId` of existing object set multiple times.\n");
			return;
		}
		wasIdSetManually = true;
		if (id > greatestId) {
			greatestId = id;
		}
	}
	
}
