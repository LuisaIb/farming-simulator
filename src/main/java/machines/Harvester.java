package machines;

/**
 * This class implements ...
 * 
 * @author Hanna
 */

public class Harvester extends Machine {

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

//Entlädt der Mähdrescher während der Animation?
//wenn ja brauchen wir dann fillTankWithGrain Methode? 
//ist der Mähdrescher nach einer Animation entladen und Kipper voll?
//oder Mähdrescher fährt bei Animation ohne Kipper und ist nach einem Feld voll?