package datastorage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import gameboard.GameValue;
import gameboard.LevelOfDifficulty;
import gameboard.objects.*;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.FieldTile;
import gameboard.tiles.Silo;

/**
 * This class represents the serializing process, 
 * where all the game information that need to be saved are converted into a JSON-B.
 * @author Isabel
 *
 */
public class ObjectToJsonb {
	/**
	 * a StringBuilder that is used to write in all the information of the objects that need to be saved
	 */
	StringBuilder sb = new StringBuilder();
	 // all numeric values, all moving object values
	/**
	 * This method gets the information of the following params.
	 * It puts the serialized JSON-B into a StringBuilder Object.
	 * This JSON-B is written into a textfile, that is located in "src/main/java/datastorage/information/farmersimulator.txt"
	 * @param gameValue
	 * saved information: cash, day
	 * @param farmer
	 * saved information: position, is selected
	 * @param tractor
	 * saved information: position, is selected, is attached, petrol tank capacity
	 * @param harvester
	 * saved information: position, is selected, is attached, petrol tank capacity, grain tank capacity
	 * @param cultivator
	 * saved information: position, is selected, is attached
	 * @param dumpTruck
	 * saved information: position, is selected, is attached
	 * @param seedDrill
	 * saved information: position, is selected, is attached
	 * @param fieldTile
	 * saved information: fieldtile conditions, bought fields
	 * @param silo
	 * saved information: capacity
	 * @param levelOfDifficulty
	 * saved information: chosen level
	 * @param courtTrade
	 * saved information: selling price
	 */
	public void toSerialize(GameValue gameValue, Farmer farmer, Tractor tractor, Harvester harvester,
							Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill, FieldTile fieldTile,
							Silo silo, LevelOfDifficulty levelOfDifficulty, CourtTrade courtTrade, MovingObject movingObject) {
		
		Jsonb jsonb = JsonbBuilder.create();
		String serializedGameValue = jsonb.toJson(gameValue);
		sb.append(serializedGameValue);
		sb.append(System.getProperty("line.separator"));
		
		String serializedsf = jsonb.toJson(farmer);
		sb.append(serializedsf);
		sb.append(System.getProperty("line.separator"));

		String serializedst = jsonb.toJson(tractor);
		sb.append(serializedst);
		sb.append(System.getProperty("line.separator"));

		String serializedsh = jsonb.toJson(harvester);
		sb.append(serializedsh);
		sb.append(System.getProperty("line.separator"));
		
		String serializedsc = jsonb.toJson(cultivator);
		sb.append(serializedsc);
		sb.append(System.getProperty("line.separator"));
		
		String serializedsdt = jsonb.toJson(dumpTruck);
		sb.append(serializedsdt);
		sb.append(System.getProperty("line.separator"));
		
		String serializedssd = jsonb.toJson(seedDrill);
		sb.append(serializedssd);
		sb.append(System.getProperty("line.separator"));
		
		String serializedsft = jsonb.toJson(fieldTile);
		sb.append(serializedsft);
		sb.append(System.getProperty("line.separator"));
		
		String serializedss = jsonb.toJson(silo);
		sb.append(serializedss);
		sb.append(System.getProperty("line.separator"));
		
		String serializedlod = jsonb.toJson(levelOfDifficulty);
		sb.append(serializedlod);
		sb.append(System.getProperty("line.separator"));

		String serializedct = jsonb.toJson(courtTrade);
		sb.append(serializedct);
		sb.append(System.getProperty("line.separator"));

		String serializedmo = jsonb.toJson(movingObject);
		sb.append(serializedmo);
		sb.append(System.getProperty("line.separator"));

		writeFile(sb);
	}
	
		/**
		 * This method deals with writing the StringBuilder Object into a textfile, that is set write-protected.
		 * It checks if a textfile already exists or not. If there is already a textfile, the information will be overwritten.
		 * @param sb the StringBuilder with all the information to write into the text file
		 */
		public void writeFile(StringBuilder sb) {
			try {
				File textFile = new File("src/main/java/datastorage/information/farmersimulator.txt");
				textFile.setWritable(true);
				textFile.createNewFile();
				try {
					FileWriter fileWriter = new FileWriter(textFile);
					fileWriter.write(sb.toString());
					fileWriter.close();
					textFile.setWritable(false);
				} catch (IOException e) {
				}
			} catch (IOException e) {
			}
		}
}
