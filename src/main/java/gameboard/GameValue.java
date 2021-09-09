package gameboard;
/**
 * 
 * @author Isabel
 * @param cash
 * @param day
 *
 */
public class GameValue {
	private int cash;
	private int day;
	
	/**
	 * This constructor will be used for reloading the game.
	 * @param cash
	 * @param day
	 */
	public GameValue(int cash, int day) {
		this.cash = cash;
		this.day = day;
	}
	
	/**
	 * This constructor will be used for starting a new game.
	 * @param cash
	 * @param day
	 */
	public GameValue() {
//		cash = 100;
//		day = 1;
	}
	
	/**
	 * This constructor will be used for starting a new game according to the level of difficulty.
	 * @param cash
	 * @param day
	 */
	public GameValue(int level) {//1-3
		day = 1;
		if(level == 1) {
			cash = 100; //Bezin, Getreidetank voll, Hofladen voll
		}else if(level == 2) {
			cash = 50;//Bezin voll, Getreidetank halb leer, Hofladen halb leer
		}else if(level ==2) {
			cash = 50;// Bezin voll, Getreidetank leer, Hofladen leer
		}
	}
	
	/**
	 * This method gets the day's value.
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * This method sets the day's value.
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * This method gets the cash value.
	 * @return
	 */
	public int getCash() {		
		return cash;
	}

	/**
	 * This method sets the cash value.
	 * @param cash
	 */
	public void setCash(int cash) {
		this.cash = cash;
	}

	/**
	 *This method is needed for serializing this class into JSONB.
	 */
	@Override
	public String toString() {
		return "Game [cash=" + cash + " +  day=" + day + "]";
	}
	
	
}
