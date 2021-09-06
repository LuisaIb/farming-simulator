package machines;

/**
 * This class implements the methods, that are basic functions for every Machine.
 * 
 * @author Hanna
 */

public class Machine extends MovingObject{

	private double x;
	private double y;
	
	public Machine() {
	}
	
	/**
	 * the constructor sets the position in the coordinate system
	 * @param id
	 */
	public Machine(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
    /** 
     * hand over the x-Coordinate
     * @return x
     */
	public double getX() {
		return x;
	}
	
    /** 
     * Sets the x-Coordinate
     * @param x - Coordinate
     */
	public void setX(double x) {
		this.x = x;
	}
	
    /** 
     * hand over the y-Coordinate
     * @return y
     */
	public double getY() {
		return y;
	}
	
    /** 
     * Sets the y-Coordinate
     * @param y - Coordinate
     */
	public void setY(double y) {
		this.y = y;
	}
	
}
