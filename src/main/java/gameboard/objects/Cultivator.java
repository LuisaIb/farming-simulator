package gameboard.objects;

import exceptions.WrongMachineException;

/**
 * this class represents the device Cultivator, 
 * which is supposed to wrap a field when it's read to do so
 * @author Luisaibele, Hanna
 *
 */
public class Cultivator extends WorkingDevice {

	public Cultivator(){
		super(18, 7, false);
	}

	public Cultivator(int x, int y, boolean selected){
		super(x, y, selected);
	}

	/**
	 * @param growthState
	 */
	public int wrapField(int growthState) throws WrongMachineException{
		if(growthState == 6) {
			growthState++;
		} else {
			throw new WrongMachineException("You can not use the harvester yet!");
		}
		return growthState;
	}

}
