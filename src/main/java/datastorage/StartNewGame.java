/**
 * 
 */
package datastorage;

import gameboard.objects.Cultivator;
import gameboard.objects.DumpTruck;
import gameboard.objects.Farmer;
import gameboard.objects.Harvester;
import gameboard.objects.SeedDrill;
import gameboard.objects.Tractor;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.FieldTile;
import gameboard.tiles.Silo;
import simulator.GameValue;
import simulator.LevelOfDifficulty;

/**
 * @author Isabel
 *
 */
public class StartNewGame {

	private int levelInput;
	/**
	 * 
	 */
	public void getGameInformation() {
		Farmer f = new Farmer();// leerer Konstruktor mit allen gesetzten Eigenschaften:         Position
		Tractor t = new Tractor();// leerer Konstruktor mit allen gesetzten Eigenschaften:       Position, Bezintank
		Harvester h = new Harvester();// leerer Konstruktor mit allen gesetzten Eigenschaften:   Position, Bezintank, Getreidetank
		Cultivator c = new Cultivator();// leerer Konstruktor mit allen gesetzten Eigenschaften: Position
		//DumpTruck dt = DumpTruck();// leerer Konstruktor mit allen gesetzten Eigenschaften:    Position, Getreidetank
		//SeedDrill sd = SeedDrill();// leerer Konstruktor mit allen gesetzten Eigenschaften:    Position
		
		LevelOfDifficulty lod = new LevelOfDifficulty(levelInput);// Eingabe der Auswahlkästchen muss übergeben werden
		
		GameValue gv = new GameValue();// leerer Konstruktor mit allen gesetzten Eigenschaften: cash = 100, day = 1
		
		FieldTile ft = new FieldTile();// leerer Konstruktor mit allen gesetzten Eigenschaften: Alle Felder auf Wachstumsstufe 0, growthstate = 0 -> zur Aussaat bereit
		
		Silo s = new Silo();// leerer Konstruktor mit allen gesetzten Eigenschaften: Getreidefüllmege =
		
		CourtTrade ct = new CourtTrade();// leerer Konstruktor mit allen gesetzten Eigenschaften: Getreidefüllmege =
	}
}
