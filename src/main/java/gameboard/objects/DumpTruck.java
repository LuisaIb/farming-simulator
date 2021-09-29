package gameboard.objects;

import gameboard.GameValue;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.Silo;
import gui.view.InformationBox;

/**
 * This class implements the properties and functionalities of a DumpTruck.
 * @author Luisaibele
 */
public class DumpTruck extends WorkingDevice {
	/**
	 * the maximum of grain that can be filled into the dump truck
	 */
	private int grainTankCapacity;
	/**
	 * the actual amount of grain that is in the dump truck
	 */
	private int grainFillLevel;
	
	/**
	 * Default constructor.
	 */
	public DumpTruck() {

	}
	
	/**
	 * This constructor will be used for starting a new game. The capacity of the grain tank is set depending on the
	 * level of difficulty the player has chosen.
	 * @param lod the level of difficulty the player has chosen
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
	 * This method represents the functionality to unload grain from
	 * the Dump Truck into the Silo.
	 * @param silo the silo object of the actual game
	 * @param informationBox the informationBox of the actual game
	 */
	public void unloadToSilo(Silo silo, InformationBox informationBox) {
		int siloFillLevel = silo.getFillLevel();
		// the maximum amount of grain that can be filled into the silo until it's full
		int grainToFill = silo.getCapacity() - siloFillLevel;
		// the fill level of the dump truck is less or equal to the amount of grain that can be pu into the silo
		if (grainFillLevel <= grainToFill) {
			// the silo is filled with the grain from the dump truck
			silo.setFillLevel(silo.getFillLevel() + grainFillLevel);
			grainFillLevel = 0;
		} else { // more grain on the dump truck than place for grain in the silo
			// the new amount of grain on the dump truck is the amount minus the grain that fits into the silo
			grainFillLevel = grainFillLevel - grainToFill;
			silo.setFillLevel(silo.getFillLevel() + grainToFill);
			informationBox.getNewsField().setText("The Silo is full!");
		}
	}

	/**
	 * This method represents the functionality to load grain from the silo
	 * to the dumpTruck
	 * @param silo the Silo object of the actual game
	 */
	public void loadFromSilo(Silo silo) {
		// calculating the amount of grain that fits onto the dump truck at this moment
		int grainToFill = grainTankCapacity - grainFillLevel;
		// the amount of grain in the silo is bigger or equal to the amount of grain that fits into the dump truck
		if (silo.getFillLevel() >= grainToFill) {
			// the dump truck can only load grain until its completely full
			grainFillLevel = grainFillLevel + grainToFill;
			silo.setFillLevel(silo.getFillLevel() - grainToFill);
		} else { // the amount of grain in the silo is less than the amount of grain that fits into the dump truck
			// the dump truck is filled with the amount of grain that is in the silo
			grainFillLevel = grainFillLevel + silo.getFillLevel();
			silo.setFillLevel(0);
		}

	}
	
	/**
	 * This method unloads the grain from the Dump Truck to the Court Trade
	 * in order to receive money.
	 * @param gv the gameValue object of the actual game
	 * @param courtTrade the courtTrade object of the actual game
	 */
	public void sellingGrain(GameValue gv, CourtTrade courtTrade) {
		double cash = gv.getCash() + (grainFillLevel * courtTrade.getSellingPrice());
		int cash2 = (int) cash;
		gv.setCash(cash2);
		grainFillLevel = 0;
	}

	/**
	 * Getter for the grain fill level of the dump truck.
	 *
	 * @return the requested grain fill level
	 */
	public int getGrainFillLevel() {
		return grainFillLevel;
	}

	/**
	 * Setter for the grain fill level of the dump truck.
	 *
	 * @param grainFillLevel value that is set as grain fill level
	 */
	public void setGrainFillLevel(int grainFillLevel) {
		this.grainFillLevel = grainFillLevel;
	}

	/**
	 * Getter for grainTankCapacity
	 *
	 * @return the requested grainTankCapacity
	 */
	public int getGrainTankCapacity() {
		return grainTankCapacity;
	}

	/**
	 * Setter for grainTankCapacity
	 * @param grainTankCapacity value that is set as grain tank capacity
	 */
	public void setGrainTankCapacity(int grainTankCapacity) {
		this.grainTankCapacity = grainTankCapacity;
	}
}
