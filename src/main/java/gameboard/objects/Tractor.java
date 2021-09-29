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
