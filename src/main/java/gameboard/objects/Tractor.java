package gameboard.objects;


/**
 * this class represents one of the two main machines in our game, the tractor.
 * @author Luisaibele
 *
 */
public class Tractor extends Machine {
	private boolean attachement; //stands for the value if a device is attached or not

	/**
	 * empty constructor of the Tractor for starting the game 
	 */
	public Tractor() {
		super();
		this.attachement = false;
	}

	/**
	 * Constructor of Tractor for reloading / continuing the game
	 * @param x
	 * @param y
	 * @param petrolTankFillLevel
	 */
	public Tractor(int x, int y, boolean selected, int petrolTankFillLevel, boolean attachement){
		super(x, y, selected, petrolTankFillLevel);
		this.attachement = attachement;
	}

	/**
	 * Getter for the attachment.
	 * @return the attachment
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
