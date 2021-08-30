package simulator;
/**
 * 
 * @author 
 *
 */
public class Game {
	private int cash;
	private double filling;
	
	public Game(int cash, double filling) {
		cash = 0; 
		filling = 100; 
	}
	
	public Game() {
		
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

	public void setFilling(double filling) {
		this.filling = filling;
	}

	@Override
	public String toString() {
		return "Game [cash=" + cash + ", filling=" + filling + "]";
	}
	
	
}
