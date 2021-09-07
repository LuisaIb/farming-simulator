package machines;

/**
 * This class implements ...
 * 
 * @author Hanna
 */

public class Harvester implements Machine2 {

	int tankCapacity = 200;
	int grainTankCapacity = 1; //grain capacity of 1 field
	int grainTankFillLevel;
	
	public Harvester() {
		
	}
	
	public void fillTankWithGrain() { //if animation worked 1 time then full?
			grainTankFillLevel++;
			
		if(grainTankFillLevel == grainTankCapacity) {
			System.out.println("The harvester needs to be unloaded");
		}
	}
	
}

//Entl�dt der M�hdrescher w�hrend der Animation?
//wenn ja brauchen wir dann fillTankWithGrain Methode? 
//ist der M�hdrescher nach einer Animation entladen und Kipper voll?
//oder M�hdrescher f�hrt bei Animation ohne Kipper und ist nach einem Feld voll?