package machines;

public class Tank{

    private int petrolLevel;
    private int y;
    private int x;
 
    public Tank(int petrolLevel, int x, int y) {  
    	this.petrolLevel = petrolLevel;
    	this.x = x;
    	this.y = y;
    }
    
    public int move(int petrolLevel, int x, int y) {
    	if(x == +-1 || y == +-1) {
    		petrolLevel--;
    	} return petrolLevel;
    }
    
    public void lowPetrolLevel(int petrolLevel) {
    	if(petrolLevel <= 50) {
    		System.out.println("The petrol level is only " + petrolLevel + "l.");
    		System.out.println("Please refuel your vehicle!");
    } 	else if (petrolLevel == 0) {
    		System.out.println("The tank is empty!");
    		System.out.println("Game Over!");
    }
    }
}


