package gameboard.objects;

/**
 * This class represents the basic structure of all the working devices,
 * which aren't able to move on their own.
 * @author Luisaibele
 *
 */
public class WorkingDevice extends MovingObject{
   
	/**
     * Constructor of WorkingDevice for starting a new game.
     */
    public WorkingDevice(){
        super(18, 7, false);
    }

    /**
     * Constructor of WorkingDevice for reloading / continuing the game.
     * @param x the x-value to which the object is set on the matchfield
     * @param y the y-value to which the object is set on the matchfield
     * @param selected sets whether the object is selected or not
     */
    public WorkingDevice(int x, int y, boolean selected){
        super(x, y, selected);
    }

}
