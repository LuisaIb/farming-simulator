package datastorage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents a part of the deserializing process, 
 * where all the game information that are needed for the reloading process are put into a String Array.
 * @author Isabel
 *
 */
public class ObjectToPojo {
	/**
	 * a StringBuilder that is used to write in all the information of the saved objects
	 */
	StringBuilder sb = new StringBuilder();
	/**
	 * an array that is used to separate the Strings of the object
	 */
	String[] game;

	/**
	 * This method deals with a part of the deserializing process.
	 * The textfile information is written in a new StringBuilder.
	 */
	public void toDeserialize() {
		try {
			File gameFile = new File("src/main/java/datastorage/information/farmersimulator.txt");//"src/main/java/datastorage/information/farmersimulator.txt"
			gameFile.setWritable(false);
			if (gameFile.exists()) {
				Scanner fileReader = new Scanner(gameFile);
				while (fileReader.hasNextLine()) {
				sb.append(fileReader.nextLine());
				sb.append(System.getProperty("line.separator"));
				}
			fileReader.close();
			}
		} catch (IOException e) {
		}
	}
	
	/**
	 * This method deals with splitting up the StringBuilder Object and put it into a String Array.
	 * @return the String Array with all the game information
	 */
	public String[] getDeserializedGameObjects() {
		game = new String[12];
		game = sb.toString().split(System.getProperty("line.separator"));
		return game;
	}
}