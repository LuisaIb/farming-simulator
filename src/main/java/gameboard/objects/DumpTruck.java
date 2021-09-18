package gameboard.objects;

import gameboard.GameValue;
import gameboard.tiles.Silo;

/**
 * This class implements the properties and functionalities of a DumpTruck.
 * @author Luisaibele
 *
 */
public class DumpTruck extends WorkingDevice {
	
	private final int GRAIN_TANK_CAPACITY = 120;
	private int grainFillLevel;
	private Silo silo = new Silo();
	private GameValue gv = new GameValue();
	
	/**
	 * the constructor sets the harvest fill level of the Dump Truck
	 * @param grainFillLevel
	 */
	public DumpTruck(int x, int y, boolean selected, int grainFillLevel) {
		super(x, y, selected);
		this.grainFillLevel = grainFillLevel;
	}
	
	/**
	 * This constructor will be used for starting a new game.
	 */
	public DumpTruck() {
		super(18, 7, false);
		grainFillLevel = 0;
	}
	
	/**
	 * this method loads the Dump Truck with harvest
	 */
	public void load() {
		if(grainFillLevel < GRAIN_TANK_CAPACITY) {
			grainFillLevel++;
		} 
		else if(grainFillLevel == GRAIN_TANK_CAPACITY) {
			System.out.println("The Dump Truck must be unloaded!");
		}
	}
	
	/**
	 * this method unloads the grain from the Dump Truck into the Silo
	 */
	public void unloadToSilo(Silo silo, int grainFillLevel) {
		int capacity = silo.getCapacity() + grainFillLevel; 
		silo.setCapacity(capacity);
		grainFillLevel = 0;
	}
	
	/**
	 * this method unloads the grain from the Dump Truck to the Court Trade
	 * in order to receive money
	 */
	public void unloadToCourtTrade(GameValue gv, int grainFillLevel) {
		int cash = gv.getCash() + 50;
		gv.setCash(cash);		
		grainFillLevel = 0;
	}

	/**
	 * this method is the Setter for the grain fill level of the dump truck
	 * @return grainFillLevel
	 */
	public int getGrainFillLevel() {
		return grainFillLevel;
	}

	/**
	 * @return the silo
	 */
	public Silo getSilo() {
		return silo;
	}

	/**
	 * @param silo the silo to set
	 */
	public void setSilo(Silo silo) {
		this.silo = silo;
	}

	/**
	 * @param grainFillLevel the grainFillLevel to set
	 */
	public void setGrainFillLevel(int grainFillLevel) {
		this.grainFillLevel = grainFillLevel;
	}
}
