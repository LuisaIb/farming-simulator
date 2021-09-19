package gameboard.objects;

import gameboard.GameValue;
import gameboard.tiles.Silo;
import simulator.LevelOfDifficulty;

/**
 * This class represents the properties and functionalities of a DumpTruck.
 * @author Luisaibele
 *
 */
public class DumpTruck extends WorkingDevice {
	
	private int grainTankCapacity; //how much grain can be in the dumpTruck?
	private int grainFillLevel; //how much grain is in the dumpTruck?
	private Silo silo = new Silo();
	private GameValue gv = new GameValue();
	LevelOfDifficulty lofd = new LevelOfDifficulty();

	
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
		int lod = lofd.getLevel();
		grainFillLevel = 0;
		if (lod == 1) {
			grainTankCapacity = 180;
		} else if (lod == 2) {
			grainTankCapacity = 120;
		} else if (lod == 3) {
			grainTankCapacity = 60;
		}
	}
	
	/**
	 * this method loads the Dump Truck with harvest
	 */
	public void load() {
		if(grainFillLevel < grainTankCapacity) {
			grainFillLevel++;
		} 
		else if(grainFillLevel == grainTankCapacity) {
			System.out.println("The Dump Truck must be unloaded!");
		}
	}
	
	/**
	 * this method unloads the grain from the Dump Truck into the Silo
	 */
	public void unloadToSilo(Silo silo) {
		int siloFillLevel = silo.getFillLevel();
		int grainToFill = silo.getCapacity() - siloFillLevel;
		if (grainFillLevel <= grainToFill) {
			grainFillLevel = 0;
			silo.setFillLevel(silo.getFillLevel() + grainToFill);
		} else {
			grainFillLevel = grainFillLevel - grainToFill;
			silo.setFillLevel(silo.getFillLevel() + grainToFill);
		}


		int capacity = silo.getFillLevel() + grainFillLevel;
		silo.setFillLevel(capacity);
		grainFillLevel = 0;
	}
	
	/**
	 * this method unloads the grain from the Dump Truck to the Court Trade
	 * in order to receive money
	 */
	public void sellingGrain(GameValue gv) {
		int cash = gv.getCash() + (grainFillLevel * 2);
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
	 * Getter for silo object
	 * @return silo object
	 */
	public Silo getSilo() {
		return silo;
	}

	/**
	 * Setter for silo object
	 * @param silo object
	 */
	public void setSilo(Silo silo) {
		this.silo = silo;
	}

	/**
	 * Setter for grainFillLevel
	 * @param grainFillLevel the grainFillLevel to set
	 */
	public void setGrainFillLevel(int grainFillLevel) {
		this.grainFillLevel = grainFillLevel;
	}

	/**
	 * Getter for grainTankCapacity
	 * @return grainTankCapacity
	 */
	public int getGrainTankCapacity() {
		return grainTankCapacity;
	}

	/**
	 * Setter for grainTankCapacity
	 * @param grainTankCapacity
	 */
	public void setGrainTankCapacity(int grainTankCapacity) {
		this.grainTankCapacity = grainTankCapacity;
	}
}
