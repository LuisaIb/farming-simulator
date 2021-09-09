package gameboard.objects;


/**
 * this class represents the device Cultivator, 
 * which is supposed to wrap a field when it's read to do so
 * @author Luisaibele, Hanna
 *
 */
public class Cultivator extends WorkingDevice {
	//private int id = 3; -> id for hashmap for attachement
	
	/**
	 * @param growthState
	 */
	public int wrapField(int growthState) {
		if(growthState == 5) {
			growthState++; 
			} 
		return growthState;
	}




	
}
