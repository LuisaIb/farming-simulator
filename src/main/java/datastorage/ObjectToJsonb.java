package datastorage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import gameboard.GameValue;
import gameboard.objects.Cultivator;
import gameboard.objects.DumpTruck;
import gameboard.objects.Farmer;
import gameboard.objects.Harvester;
import gameboard.objects.SeedDrill;
import gameboard.objects.Tractor;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.FieldTile;
import gameboard.tiles.Silo;
import simulator.LevelOfDifficulty;

/**
 * @author Isabel
 *
 */
public class ObjectToJsonb {
	StringBuilder sb = new StringBuilder();
	 // all numeric values
		/**
		 * This method gets the values of the cash, the filling and the gameday of the class GameValue.
		 * @return serialized as a JSONB object of the cash, filling values and the day.
		 * 	/**
		 * This method gets the value of the level of difficulty of the class LevelOfDifficulty.
		 * @return serialized as a JSONB object of the level of difficulty.
		 */
		
		/**
		 * This method gets the growth state of all three fields of the class FieldTile.
		 * @return serialized as a JSONB object of the fieldtile's conditions.
		 */
	
		
		
		/**
		 * This method gets the filling of the silo.
		 * @return serialized as a JSONB object of the Silo's conditions.
		 */
		

		
	    // all position values
	    /**
		 * This method gets the position of the farmer of the class...
		 * @return serialized as a JSONB object of the farmer's position
		 */
		
		
		/**
		 * This method gets the position of the tractor of the class...
		 * @return serialized as a JSONB object of the tractor's positions
		 */
		
		
		/**
		 * This method gets the position of the harvester of the class...
		 * @return serialized as a JSONB object of the tractor's positions
		 */
		
		
		/**
		 * This method gets the information of the Cultivator.
		 * @return serialized as a JSONB object of the tractor's positions
		 */
		
		
		/**
		 * This method gets the information of the Cultivator.
		 * @return serialized as a JSONB object of the tractor's positions
		 */
		
		
		/**
		 * This method gets the information of the Cultivator.
		 * @return serialized as a JSONB object of the tractor's positions
		 */
		 
	
	/**
	 * @param gameValue
	 * @param farmer
	 * @param tractor
	 * @param harvester
	 * @param cultivator
	 * @param dumpTruck
	 * @param seedDrill
	 * @param fieldTile
	 * @param silo
	 * @param levelOfDifficulty
	 * @param courtTrade
	 */
	public void toSerialize(GameValue gameValue, Farmer farmer, Tractor tractor, Harvester harvester,
							Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill, FieldTile fieldTile,
							Silo silo, LevelOfDifficulty levelOfDifficulty, CourtTrade courtTrade) {
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

		writeFile(sb);
	}
	
		/**
		 * @param sb
		 */
		public void writeFile(StringBuilder sb) {
		try {
			File textFile = new File("src/main/java/datastorage/SavingInformation/farmersimulator.txt");
			textFile.setWritable(true);
			if (textFile.createNewFile()) {
			System.out.println("Textdatei erstellt.");
			} else {
			System.out.println("Textdatei existiert bereits.");
			}
			
			try {
			FileWriter fileWriter = new FileWriter(textFile);
				fileWriter.write(sb.toString());
				fileWriter.close();
				textFile.setWritable(false);
			
			System.out.println("In die Textdatei wurde geschrieben.");
			} catch (IOException e) {
			System.out.println("Es konnte nicht in die Textdatei geschrieben werden.");
			}

			} catch (IOException e) {
			System.out.println("Textdatei konnte nicht erstellt werden.");
			}
		}
}
