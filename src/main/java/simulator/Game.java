package simulator;
/**
 * 
 * @author Isabel
 *
 */
public class Game {
	private int cash;
	private int filling;
	
	public Game(int cash, int filling, int level) {
		cash = 0; 
		filling = 100; 
	}

	public int getCash() {		
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public double getFilling() {
		return filling;
	}

	public void setFilling(int filling) {
		this.filling = filling;
	}
}
