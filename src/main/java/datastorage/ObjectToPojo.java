/**
 * 
 */
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
	StringBuilder sb = new StringBuilder();
	String[] game;
	
	/**
	 * @return the StringBuilder sb, with all the game information
	 */
	public StringBuilder getSb() {
		return sb;
	}

	/**
	 * This method deals with a part of the deserializing process.
	 * The textfile information are written in a new StringBuilder.
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
						
		} else {
			System.out.println("There is no existing textfile that can be read.");
			}
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
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