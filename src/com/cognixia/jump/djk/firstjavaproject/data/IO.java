package com.cognixia.jump.djk.firstjavaproject.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

abstract public class IO {
	
	private static File file;
	
	static {
		try {
			file = new File("resources/emsCompanyData");
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch(Exception e) {
			System.out.println("\nERROR: STORED DATA COULD NOT BE LOADED. YOUR DATA IS NOT BEING SAVED!\n");
		}
	}
	
	public static void writeToFile(Object objDataToWrite) {
		
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {

			writer.writeObject(objDataToWrite);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Object getObjectDataFromFile() {
		Object savedData = null;
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
			
			savedData = reader.readObject();
			
		} catch (Exception e) {}
		return savedData;
	}
}
