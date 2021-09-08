package gameboard.tiles;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This class represents a tile, which is a field with its several properties
 * @author Luisaibele
 *
 */
public class FieldTile extends Tile{
	
	private Timer timer = new Timer();
	
	private int growthState; //representing the state of growth of the first field
	private int growthState2; //representing the state of growth of the second field
	private int growthState3; //representing the state of growth of the third field
	/*
	 * growthstate = 0 -> zur Aussaat bereit
	 * growthstate = 1 -> Wachstumsstufe 1
	 * growthstate = 2 -> Wachstumsstufe 2
	 * growthstate = 3 -> Wachstumsstufe 3
	 * growthstate = 4 -> erntereif
	 * growthstate = 5 -> abgeerntet
	 * 
	 */
	
	/**
	 * this constructor stands for a field tile
	 * @param id
	 * @param growthState
	 */
	public FieldTile(int id, int growthState, int growthState2, int growthState3 ) {
		super(id);
//		this.growthState = growthState;
		this.growthState2 = growthState2;
		this.growthState3 = growthState3;
		
	}
	
	/**
	 * this empty constructor is for starting a new game
	 */
	public FieldTile() {
		growthState = 0;
		growthState2 = 0;
		growthState3 = 0;
		
	}
		
	/**
	 * this method is supposed to check whether the farmer can run over 
	 * a field tile or not
	 * @return the checked boolean value
	 */
	public boolean isSolid() {
		return true;
	}
	
	/**
	 * this method gets the growthState of the first field
	 * @return growthState
	 */
	public int getGrowthState() {
		return growthState;
	}

	/**
	 * this method sets the growthState of the first field
	 * @param growthState
	 */
	public void setGrowthState(int growthState, Timer timer) {
		this.growthState = growthState;
		// trying a timer for the growing
		if(growthState == 1) {
			System.out.println("The first field is growing now!");
		}
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if(growthState == 1 || growthState ==2 || growthState ==3) {
//					growthState = growthState+1;
					} else if(growthState == 4) {
						System.out.println("The first field is ready to harvest now!");
						timer.cancel();
					}	
			}
		}, 2*1000, 2*1000);
		
		// if else statement without timer for growing
		if(growthState == 4) {
			System.out.println("The first field is ready to harvest!");
			//timer.stop
		}else if(growthState == 5){
			System.out.println("The first field is ready to get cultivated!");
		}else if(growthState == 0){
			System.out.println("The first field is ready for sowing!");
		}else {
			System.out.println("The first field is growing now!");
		}
	}
	
	/**
	 * this method gets the growthState of the second field
	 * @return growthState2
	 */
	public int getGrowthState2() {
		return growthState2;
	}

	/**
	 * this method sets the growthState of the second field
	 * @param growthState2
	 */
	public void setGrowthState2(int growthState2) {
		this.growthState2 = growthState2;
		if(growthState2 == 4) {
			System.out.println("The second field is ready to harvest!");
			//timer.stop
		}else if(growthState2 == 5){
			System.out.println("The second field is ready to get cultivated!");
		}else if(growthState2 == 0){
			System.out.println("The second field is ready for sowing!");
		}else {
			System.out.println("The second field is growing now!");
		}
	}

	/**
	 * this method gets the growthState of the third field
	 * @return growthState3
	 */
	public int getGrowthState3() {
		return growthState3;
	}

	/**
	 * this method sets the growthState of the third field
	 * @param growthState3
	 */
	public void setGrowthState3(int growthState3) {
		this.growthState3 = growthState3;
		if(growthState3 == 4) {
			System.out.println("The third field is ready to harvest!");
			//timer.stop
		}else if(growthState3 == 5){
			System.out.println("The third field is ready to get cultivated!");
		}else if(growthState3 == 0){
			System.out.println("The third field is ready for sowing!");
		}else {
			System.out.println("The third field is growing now!");
		}
	}
	
	/**
	 * this method is there so the field is able to grow by time
	 * @param growthState
	 */
	public void growing(int growthState) {
		
	}

	/**
	 * this method is needed for serializing this class into JSONB
	 */
	@Override
	public String toString() {
		return "FieldTile [growthState=" + growthState + ", growthState2=" + growthState2 + ", growthState3="
				+ growthState3 + "]";
	}

}
