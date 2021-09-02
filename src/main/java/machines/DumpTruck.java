package machines;


/**
 * 
 * 
 * @author Hanna
 */

public class DumpTruck extends Machine{

	private int capacity;
	private int fillLevel;
	
	public DumpTruck(int capacity) {
		this.capacity = capacity;
		
	}
	
	public void load() {
		if(fillLevel < capacity) {
			fillLevel++;	
		} 
		else {
			unload();
		}
	}
	
	public void unload() {
		fillLevel = 0;
	}
	
	

	}
