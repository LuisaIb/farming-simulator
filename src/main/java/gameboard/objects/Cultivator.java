package gameboard.objects;


/**
 * this class represents the device Cultivator, 
 * which is supposed to wrap a field when it's read to do so
 * @author Luisaibele, Hanna
 *
 */
public class Cultivator extends WorkingDevice {
	//private int id = 3; -> id for hashmap for attachement

	public Cultivator(){
		super(18, 7, false);
	}

	public Cultivator(int x, int y, boolean selected){
		super(x, y, selected);
	}

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
