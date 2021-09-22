/**
 * 
 */
package datastorage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Isabel
 *
 */
public class ObjectToPojo {
	StringBuilder sb = new StringBuilder();
	String[] game;
	
	/**
	 * @return the sb
	 */
	public StringBuilder getSb() {
		return sb;
	}

	/**
	 * 
	 */
	public void toDeserialize() {
		try {
			File gameFile = new File("src/main/java/datastorage/SavingInformation/farmersimulator.txt");//"src/main/java/datastorage/SavingInformation/farmersimulator.txt"
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
		
		System.out.println(sb);
	}
	
	/**
	 * @return
	 */
	public String[] getDeserializedGameObjects() {
		game = new String[12];
		game = sb.toString().split(System.getProperty("line.separator"));
		return game;
	}
}