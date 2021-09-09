package gameboard.objects;

import exceptions.WrongMachineException;

/**
 * this class represents the harvester with its properties to harvest a field
 * @author Hanna, Luisaibele
 *
 */
public class Harvester extends Machine {
	private final int GRAIN_TANK_CAPACITY = 60; //grain capacity of 1 field
	private int grainTankFillLevel;
	
	/**
	 * the constructor of the harvester represents...
	 */
	public Harvester() {
		grainTankFillLevel = 0;
	}

	public Harvester(int x, int y, boolean selected, int petrolTankFillLevel, int grainTankFillLevel){
		super(x, y, selected, petrolTankFillLevel);
		this.grainTankFillLevel = grainTankFillLevel;
	}
	
	/**
	 * this method stands for the operation of filling the tank 
	 * of the harvester with grain
	 */
	public void fillTankWithGrain() { //if animation worked 1 time then full?
			grainTankFillLevel++;
			
		if(grainTankFillLevel == GRAIN_TANK_CAPACITY) {
			System.out.println("The harvester needs to be unloaded");
		}
	}

	public void unload(){
		grainTankFillLevel = 0;
	}

	public int getGrainTankFillLevel() {
		return grainTankFillLevel;
	}

	/**
	 * this method represents the functionality to harvest a field 
	 * when it's ready to do so
	 * @param growthState
	 */
	public int harvest(int growthState) throws WrongMachineException{
		//checking if harvester is at the right place for this action
		if(growthState == 5) {
			growthState++;
		} else {
			throw new WrongMachineException("You can not use the harvester yet!");
		}
		return growthState;
	}
	
}

//Entl�dt der M�hdrescher w�hrend der Animation?
//wenn ja brauchen wir dann fillTankWithGrain Methode? 
//ist der M�hdrescher nach einer Animation entladen und Kipper voll?
//oder M�hdrescher f�hrt bei Animation ohne Kipper und ist nach einem Feld voll?