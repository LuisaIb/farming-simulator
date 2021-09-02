package simulator;
/**
 * 
 * @author 
 *
 */
public class Game {
	private int cash;
	private double filling;
	private int day;
	
	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @param cash
	 * @param filling
	 */
	public Game(int cash, double filling, int day) {
		this.cash = cash;
		this.filling = filling; 
		this.day = day;
	}
	
	/**
	 * 
	 */
	public Game() {
		cash = 100;
		filling = 100.0;
		day = 1;
	}

	/**
	 * @return
	 */
	public int getCash() {		
		return cash;
	}

	/**
	 * @param cash
	 */
	public void setCash(int cash) {
		this.cash = cash;
	}

	/**
	 * @return
	 */
	public double getFilling() {
		return filling;
	}

	/**
	 * @param filling
	 */
	public void setFilling(double filling) {
		this.filling = filling;
	}

	@Override
	public String toString() {
		return "Game [cash=" + cash + ", filling=" + filling + ", day=" + day + "]";
	}
	
	
}
