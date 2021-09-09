package gameboard.objects;

import exceptions.WrongMachineException;

/**
 * this class represents the device SeedDrill with its functionality
 * to seed a field.
 * @author Luisaibele
 *
 */
public class SeedDrill extends WorkingDevice {
	// private int id = 1; -> for attachment hashmap

	public SeedDrill(){
		super(18, 7, false);
	}

	public SeedDrill(int x, int y, boolean selected){
		super(x, y, selected);
	}

	/**
	 * this method is there to seed a field or to set it to growth stage 0
	 */
	public int seedGrain(int growthState) throws WrongMachineException{
		if(growthState == 1) {
			growthState++;
		} else {
			throw new WrongMachineException("You can not use the harvester yet!");
		}
		return growthState;
	}

}
