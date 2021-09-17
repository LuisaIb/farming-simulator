/**
 * 
 */
package datastorage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import gameboard.GameValue;
import gameboard.objects.Cultivator;
import gameboard.objects.DumpTruck;
import gameboard.objects.Farmer;
import gameboard.objects.Harvester;
import gameboard.objects.SeedDrill;
import gameboard.objects.Tractor;
import gameboard.tiles.FieldTile;
import gameboard.tiles.Silo;
import simulator.LevelOfDifficulty;

/**
 * @author Isabel
 *
 */
public class ObjectToPojo {
	//"src/main/java/datastorage/SavingInformation/farmersimulator.txt"
	StringBuilder sb = new StringBuilder();
	String[] game;
	
	/**
	 * @return the sb
	 */
	public StringBuilder getSb() {
		return sb;
	}

	public void toDeserialize() {
		try {
			File gameFile = new File("src/main/java/datastorage/SavingInformation/farmersimulator.txt");
			gameFile.setWritable(false);
			if (gameFile.exists()) {
			Scanner fileReader = new Scanner(gameFile);
			
			while (fileReader.hasNextLine()) {
			sb.append(fileReader.nextLine()); 
			sb.append(System.getProperty("line.separator"));
			}
			fileReader.close();
						
			} else {
			System.out.println("Es gibt keine Textdatei, aus der gelesen werden kann.");
			}
			} catch (IOException e) {
			System.out.println("Fehler: " + e.getMessage());
			}
		
		System.out.println(sb);
	}
	
	public String[] getDeserializedGameObjects() {
		game = new String[11];
		game = sb.toString().split(System.getProperty("line.separator"));
		return game;
	}
}