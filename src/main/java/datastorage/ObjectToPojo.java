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
		game = new String[10];
		game = sb.toString().split(System.getProperty("line.separator"));
		System.out.println(game);
		System.out.println(game[0]);
		return game;
	}
	
	public GameValue toDeserializeGameValue() {
		Jsonb jb = JsonbBuilder.create();
		GameValue deserialized = jb.fromJson(game[0], GameValue.class);
		return deserialized;	
	}

	public Farmer toDeserializeFarmer() {
		Jsonb jb = JsonbBuilder.create();
		Farmer deserialized = jb.fromJson(game[1], Farmer.class);
		return deserialized;	
	}
	
	public Tractor toDeserializeTractor() {
		Jsonb jb = JsonbBuilder.create();
		Tractor deserialized = jb.fromJson(game[2], Tractor.class);
		return deserialized;	
	}
	
	public Harvester toDeserializeHarvester() {
		Jsonb jb = JsonbBuilder.create();
		Harvester deserialized = jb.fromJson(game[3], Harvester.class);
		return deserialized;	
	}
	
	public Cultivator toDeserializeCultivator() {
		Jsonb jb = JsonbBuilder.create();
		Cultivator deserialized = jb.fromJson(game[4], Cultivator.class);
		return deserialized;	
	}
	
	public DumpTruck toDeserializeDumpTruck() {
		Jsonb jb = JsonbBuilder.create();
		DumpTruck deserialized = jb.fromJson(game[5], DumpTruck.class);
		return deserialized;	
	}
	public SeedDrill toDeserializeSeedDrill() {
		Jsonb jb = JsonbBuilder.create();
		SeedDrill deserialized = jb.fromJson(game[6], SeedDrill.class);
		return deserialized;	
	}
	
	public FieldTile toDeserializeFieldTile() {
		Jsonb jb = JsonbBuilder.create();
		FieldTile deserialized = jb.fromJson(game[7], FieldTile.class);
		return deserialized;	
	}
	
	public Silo toDeserializeSilo() {
		Jsonb jb = JsonbBuilder.create();
		Silo deserialized = jb.fromJson(game[8], Silo.class);
		return deserialized;	
	}
	
	public LevelOfDifficulty toDeserializeLevelOfDifficulty() {
		Jsonb jb = JsonbBuilder.create();
		LevelOfDifficulty deserialized = jb.fromJson(game[9], LevelOfDifficulty.class);
		return deserialized;	
	}
}