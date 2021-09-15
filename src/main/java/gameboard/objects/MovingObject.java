package gameboard.objects;

import exceptions.MovingExcpetion;
import gui.view.GameScene;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * this class represents any object on the gameboard,
 * that is able to move
 * @author Luisaibele
 *
 */
public class MovingObject {
	private int x;
	private int y;
	private boolean selected = false;
	private ArrayList<Integer> places = new ArrayList<>(Arrays.asList(7, 25, 37, 42, 43, 44, 45, 46, 47, 48, 55, 67, 72, 78, 85, 90, 102, 108, 115,
			120, 121, 122, 123, 124, 125, 126, 127, 133, 134, 135, 136, 137, 138, 145, 146, 147, 148, 149, 180, 181,
			182, 183, 184, 185, 186, 187, 194, 195, 196, 197, 198, 217, 224, 228, 247, 251, 252, 253, 254, 258, 277,
			280, 288, 307, 310, 318, 337, 341, 348, 367, 371, 372, 373, 374, 375, 376, 377, 378, 397, 427, 457, 487,
			517, 547, 577));

	/**
	 * the empty constructor is there for starting the game
	 */
	public MovingObject(){
		this.x = getX();
		this.y = getY();
		this.selected = isSelected();
	}

	/**
	 * constructor to set each param and to reload the game
	 * @param x
	 * @param y
	 * @param selected
	 */
	public MovingObject(int x, int y, boolean selected){
		this.x = x;
		this.y = y;
		this.selected = selected;
	}

	/**
	 * Getter for the list of not passable tiles.
	 *
	 * @return the requested list
	 */
	public ArrayList<Integer> getPlaces() {
		return places;
	}

	/** This method checks, if it's possible to move to the next tile. Therefore, it uses the List with not passable
	 * tiles that holds all the indexes, that are not passable.
	 *
	 * @param x x-value of the tile that the player wants to move to
	 * @param y y-value of the tile that the player wants to move to
	 * @return if it's possible to move to the next tile
	 */
	public boolean proofPassabilty(int x, int y){
		boolean passable = true;
		int tileIndex = (y*30) + x;
		for (Integer i: places) {
			if (i == tileIndex) {
				passable = false;
			}
		}
		return passable;
	}

	/**
	 * this method represents the functionality of each object 
	 * to move right
	 * @param gameScene
	 * @throws MovingExcpetion
	 */
	public void moveRight(GameScene gameScene) throws MovingExcpetion {
		if (x < 29 && proofPassabilty(x+1, y)) {
			x++;
		} else {
			throw new MovingExcpetion("You can not walk further to the right.", gameScene.getInformationBox());
		}
	}


	/**
	 * this method represents the functionality of each object 
	 * to move left
	 * @param gameScene
	 * @throws MovingExcpetion
	 */
	public void moveLeft(GameScene gameScene) throws MovingExcpetion {
		if (x > 0 && proofPassabilty(x-1, y)) {
			x--;
		} else {
			throw new MovingExcpetion("You can not walk further to the left.", gameScene.getInformationBox());
		}
	}

	/**
	 * this method represents the functionality of each object 
	 * to move up
	 * @param gameScene
	 * @throws MovingExcpetion
	 */
	public void moveUp(GameScene gameScene) throws MovingExcpetion {
		if (y > 0 && proofPassabilty(x, y-1)) {
			y--;
		} else {
			throw new MovingExcpetion("You can not walk further to the top.", gameScene.getInformationBox());
		}
	}

	/**
	 * this method represents the functionality of each object 
	 * to move down
	 * @param gameScene
	 * @throws MovingExcpetion
	 */
	public void moveDown(GameScene gameScene) throws MovingExcpetion {
		if (y < 19 && proofPassabilty(x, y+1)) {
			y++;
		} else {
			throw new MovingExcpetion("You can not walk further to the bottom.", gameScene.getInformationBox());
		}
	}

	/**
	 * hand over the x-Coordinate
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x-Coordinate
	 * @param x - Coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * hand over the y-Coordinate
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y-Coordinate
	 * @param y - Coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Getter for the variable selected.
	 * @return if the moving object is selected.
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Setter for the variable selected.
	 * @param selected sets, if the moving object is selected
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
