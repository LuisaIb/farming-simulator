package gameboard.objects;


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

	
}
