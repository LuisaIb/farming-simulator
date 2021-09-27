package gameboard;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * This class implements some basic values like the time (as day) and the money.
 * @author Isabel, Judith
 *
 */
public class GameValue {
	/**
	 * IntegerProperty for the amount of money to make a binding for automatic change possible
	 */
	private IntegerProperty cash = new SimpleIntegerProperty();
	/**
	 * IntegerProperty for the day to make a binding for automatic change possible
	 */
	private IntegerProperty day = new SimpleIntegerProperty();
	
	/**
	 * This constructor will be used for reloading the game.
	 * @param cash
	 * @param day
	 */
	//public GameValue(int cash, int day) {
	//	this.cash.set(cash);
	//	this.day.set(day);
	//}
	
	/**
	 * This constructor will be used for starting a new game.
	 */
	public GameValue() {
		cash.set(100);
		day.set(1);
	}

	/**
	 * This constructor will be used for starting a new game according to the level of difficulty.
	 * @param level the level of difficulty the player has chosen
	 */
	public GameValue(int level) {//1-3
		day.set(1);
		if(level == 1) {
			cash.set(200);
		}else if(level == 2) {
			cash.set(100);
		}else if(level == 3) {
			cash.set(50);
		}
	}
	
	/**
	 * Getter for the day.
	 *
	 * @return the requested value of day
	 */
	public int getDay() {
		return day.get();
	}

	/**
	 * Setter for the day.
	 *
	 * @param day the vale set to day
	 */
	public void setDay(int day) {
		this.day.set(day);
	}

	/**
	 * Getter for the cash.
	 *
	 * @return the requested amount of cash
	 */
	public int getCash() {		
		return cash.get();
	}

	/**
	 * Setter for the cash.
	 *
	 * @param cash the value set to cash
	 */
	public void setCash(int cash) {
		this.cash.set(cash);
	}

	/**
	 * Method to get the IntegerProperty cash.
	 *
	 * @return the requested IntegerProperty cash
	 */
	public IntegerProperty cash(){
		return cash;
	}

	/**
	 * Method to get the IntegerProperty day.
	 *
	 * @return the requested IntegerProperty day
	 */
	public IntegerProperty day(){ return day; }

	/**
	 * This method is needed for the text field of the informationBox as the value of the cash is needed in a String.
	 *
	 * @return a String with the value of cash
	 */
	public String getCashAsString() {
		return "" + cash.get();
	}

	/**
	 * This method is needed for the text field of the informationBox as the value of the day is needed in a String.
	 *
	 * @return a String with the value of day
	 */
	public String getDayAsString() {
		return "" + day.get();
	}
}
