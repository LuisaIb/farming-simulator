package gameboard;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * 
 * @author Isabel
 * @param cash
 * @param day
 *
 */
public class GameValue {
	private IntegerProperty cashProperty = new SimpleIntegerProperty();
	private IntegerProperty day = new SimpleIntegerProperty();
	
	/**
	 * This constructor will be used for reloading the game.
	 * @param cash
	 * @param day
	 */
	public GameValue(int cash, int day) {
		this.cashProperty.set(cash);
		this.day.set(day);
	}
	
	/**
	 * This constructor will be used for starting a new game.
	 * @param cash
	 * @param day
	 */
	public GameValue() {
		cashProperty.set(100);
		day.set(1);
	}
	
	/**
	 * This constructor will be used for starting a new game according to the level of difficulty.
	 * @param cash
	 * @param day
	 */
	public GameValue(int level) {//1-3
		day.set(1);
		if(level == 1) {
			cashProperty.set(100); //Bezin, Getreidetank voll, Hofladen voll
		}else if(level == 2) {
			cashProperty.set(50); //Bezin voll, Getreidetank halb leer, Hofladen halb leer
		}else if(level ==2) {
			cashProperty.set(50); // Bezin voll, Getreidetank leer, Hofladen leer
		}
	}
	
	/**
	 * This method gets the day's value.
	 * @return the day
	 */
	public int getDay() {
		return day.get();
	}

	/**
	 * This method sets the day's value.
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day.set(day);
	}

	/**
	 * This method gets the cash value.
	 * @return
	 */
	public int getCash() {		
		return cashProperty.get();
	}

	/**
	 * This method sets the cash value.
	 * @param cash
	 */
	public void setCash(int cash) {
		this.cashProperty.set(cash);
	}

	/**
	 *This method is needed for serializing this class into JSONB.
	 */
	@Override
	public String toString() {
		return "Game [cash=" + cashProperty + " +  day=" + day + "]";
	}

	/**
	 * @return
	 */
	public IntegerProperty cashProperty(){
		return cashProperty;
	}

	/**
	 * @return
	 */
	public IntegerProperty day(){ return day; }

	/**
	 * @return
	 */
	public String getCashAsString() {
		return "" + cashProperty.get();
	}

	/**
	 * @return
	 */
	public String getDayAsString(){
		return "" + day.get();
	}
}
