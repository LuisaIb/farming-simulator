package gameboard.objects;

import exceptions.WrongMachineException;

/**
 * this class represents the harvester with its properties to harvest a field
 * @author Hanna, Luisaibele
 *
 */
public class Harvester implements Machine2 {

	int tankCapacity = 200;
	int grainTankCapacity = 1; //grain capacity of 1 field
	int grainTankFillLevel;
	
	public Harvester() {
		grainTankFillLevel = 0;
	}
	
	public void fillTankWithGrain() { //if animation worked 1 time then full?
			grainTankFillLevel++;
			
		if(grainTankFillLevel == grainTankCapacity) {
			System.out.println("The harvester needs to be unloaded");
		}
	}
	
	/**
	 * this method represents the functionality to harvest a field 
	 * when it's ready to do so
	 * @param growthState
	 */
	public void harvest(int growthState) throws WrongMachineException{
		//checking if harvester is at the right place for this action
		if(growthState ==4) {
			growthState++;
		} else {
			//to be implemented with exception if you can't harvest the field yet
		}
	}
	
}

//Entl�dt der M�hdrescher w�hrend der Animation?
//wenn ja brauchen wir dann fillTankWithGrain Methode? 
//ist der M�hdrescher nach einer Animation entladen und Kipper voll?
//oder M�hdrescher f�hrt bei Animation ohne Kipper und ist nach einem Feld voll?