/**
 * 
 */
package datastorage;

import datastorage.information.ConvertingToJsonb;
import datastorage.information.fromjsonb.ConvertingFromJsonb;
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
public class SavingProperties {

	private int levelInput;
	/**
	 * This method deals with starting a new game, all necessary information of the game will be set in this method.
	 */
	public void createNewGame() {
		Farmer f = new Farmer();// leerer Konstruktor mit allen gesetzten Eigenschaften:         Position, in Benutzung
		Tractor t = new Tractor();// leerer Konstruktor mit allen gesetzten Eigenschaften:       Position, in Benutzung, Bezintank
		Harvester h = new Harvester();// leerer Konstruktor mit allen gesetzten Eigenschaften:   Position, in Benutzung, Bezintank, Getreidetank
		Cultivator c = new Cultivator();// leerer Konstruktor mit allen gesetzten Eigenschaften: Position, in Benutzung
		DumpTruck dt = new DumpTruck();// leerer Konstruktor mit allen gesetzten Eigenschaften:    Position, in Benutzung, Getreidetank
		SeedDrill sd = new SeedDrill();// leerer Konstruktor mit allen gesetzten Eigenschaften:    Position, in Benutzung
		
		LevelOfDifficulty lod = new LevelOfDifficulty(levelInput);// Eingabe der Auswahlkästchen muss übergeben werden
		
		GameValue gv = new GameValue();// leerer Konstruktor mit allen gesetzten Eigenschaften: cash = 100, day = 1
		
		FieldTile ft = new FieldTile();// leerer Konstruktor mit allen gesetzten Eigenschaften: Alle Felder auf Wachstumsstufe 0, growthstate = 0 -> Wiese, ein Feld auf 1
		
		Silo s = new Silo();// leerer Konstruktor mit allen gesetzten Eigenschaften: Getreidefüllmege =
		
		CourtTrade ct = new CourtTrade();// leerer Konstruktor mit allen gesetzten Eigenschaften: Getreidefüllmege =
	}
	
	/**
	 * This method deals with saving the Game status.
	 */
	public void savingGame() {
		ConvertingToJsonb ctj = new ConvertingToJsonb();
		ctj.SetSavingInformation();
	}
	
	/**
	 * This method deals with reloading the Game status.
	 */
	public void reloadGame() {
		ConvertingFromJsonb cfj = new ConvertingFromJsonb();
		cfj.GetSavingInformation();
	}
}
