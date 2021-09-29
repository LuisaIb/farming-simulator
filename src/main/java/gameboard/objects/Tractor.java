package gameboard.objects;


/**
 * This class represents one of the two main machines in our game, the tractor.
 * @author Luisaibele
 */
public class Tractor extends Machine {
	/**
	 * shows whether a working device is attached or not
	 */
	private boolean attachement; //stands for the value if a device is attached or not

	/**
	 * Constructor of the Tractor for starting the game.
	 */
	public Tractor() {
		super();
		this.attachement = false;
	}

	/**
	 *Constructor of Tractor for reloading / continuing the game
	 * @param x the x-value to which the object is set on the matchfield
	 * @param y the y-value to which the object is set on the matchfield
	 * @param selected sets whether the object is selected or not
	 * @param petrolTankFillLevel the value that is set as the fill level of the petrol tank
	 * @param attachement sets whether a working device it attached or nor
	 */
	public Tractor(int x, int y, boolean selected, int petrolTankFillLevel, boolean attachement){
		super(x, y, selected, petrolTankFillLevel);
		this.attachement = attachement;
	}

	/**
	 * Getter for the attachment.
	 * @return the requested boolean attachment
	 */
	public boolean isAttachement() {
		return attachement;
	}

	/**
	 * Setter for the attachment.
	 * @param attachement to set if something is attached
	 */
	public void setAttachement(boolean attachement) {
		this.attachement = attachement;
	}
}
