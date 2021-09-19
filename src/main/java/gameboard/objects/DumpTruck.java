package gameboard.objects;

import gameboard.GameValue;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.Silo;

/**
 * This class implements the properties and functionalities of a DumpTruck.
 * @author Luisaibele
 *
 */
public class DumpTruck extends WorkingDevice {
	
	private int grainTankCapacity;
	private int grainFillLevel;
	private Silo silo = new Silo();
	private GameValue gv = new GameValue();
	
	/**
	 * Default constructor.
	 */
	public DumpTruck() {

	}
	
	/**
	 * This constructor will be used for starting a new game.
	 */
	public DumpTruck(int lod) {
		super(18, 7, false);
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
			silo.setFillLevel(silo.getFillLevel() + grainFillLevel);
			grainFillLevel = 0;
		} else {
			grainFillLevel = grainFillLevel - grainToFill;
			silo.setFillLevel(silo.getFillLevel() + grainToFill);
		}
	}

	public void loadFromSilo(Silo silo) {
		int grainToFill = grainTankCapacity - grainFillLevel;
		if (silo.getFillLevel() >= grainToFill) {
			grainFillLevel = grainFillLevel + grainToFill;
			silo.setFillLevel(silo.getFillLevel() - grainToFill);
		} else {
			grainFillLevel = grainFillLevel + silo.getFillLevel();
			silo.setFillLevel(0);
		}

	}
	
	/**
	 * this method unloads the grain from the Dump Truck to the Court Trade
	 * in order to receive money
	 */
	public void sellingGrain(GameValue gv, CourtTrade courtTrade) {
		double cash = gv.getCash() + (grainFillLevel * courtTrade.getSellingPrice());
		int cash2 = (int) cash;
		gv.setCash(cash2);
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

	public int getGrainTankCapacity() {
		return grainTankCapacity;
	}

	public void setGrainTankCapacity(int grainTankCapacity) {
		this.grainTankCapacity = grainTankCapacity;
	}
}
