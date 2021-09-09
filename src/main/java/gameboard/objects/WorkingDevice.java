package gameboard.objects;

/**
 * this class represents the basic structure of all the working devices,
 * which aren't able to move on their own.
 * @author Luisaibele
 *
 */
public class WorkingDevice extends MovingObject{

    public WorkingDevice(){
        super(18, 7, false);
    }

    public WorkingDevice(int x, int y, boolean select){
        super(x, y, select);
    }

}
