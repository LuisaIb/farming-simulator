package gameboard.objects;

/**
 * this class represents the basic structure of all the working devices,
 * which aren't able to move on their own.
 * @author Luisaibele
 *
 */
public class WorkingDevice extends MovingObject{
   
	/**
     * empty constructor of WorkingDevice for starting a new game
     */
    public WorkingDevice(){
        super(18, 7, false);
    }

    /**
     * Constructor of WorkingDevice for reloading / continuing the game
     * @param x
     * @param y
     * @param select
     */
    public WorkingDevice(int x, int y, boolean select){
        super(x, y, select);
    }

}
