package gameboard.objects;

import exceptions.MovingExcpetion;

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
	List<Integer> places = Arrays.asList(7, 37, 67, 90, 120, 121, 122, 123, 124, 125, 126, 127, 180, 181, 182, 183,
			184, 185, 186, 187, 217, 247, 277, 307, 337, 367, 397, 427, 457, 487, 517, 547, 577);

	public MovingObject(){
		this.x = getX();
		this.y = getY();
		this.selected = isSelected();
	}

	public MovingObject(int x, int y, boolean selected){
		this.x = x;
		this.y = y;
		this.selected = selected;
	}

	private boolean proofPassabilty(int x, int y){
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
	 * this method is representing the functionality of each object 
	 * to move over the gameboard
	 */
	public void moveRight() throws MovingExcpetion {
		if (x < 29 && proofPassabilty(x+1, y)) {
			x++;
		} else {
			throw new MovingExcpetion("You can not walk further to the right.");
		}
	}


	public void moveLeft() throws MovingExcpetion {
		if (x > 0 && proofPassabilty(x-1, y)) {
			x--;
		} else {
			throw new MovingExcpetion("You can not walk further to the left.");
		}
	}

	public void moveUp() throws MovingExcpetion {
		if (y > 0 && proofPassabilty(x, y-1)) {
			y--;
		} else {
			throw new MovingExcpetion("You can not walk further to the top.");
		}
	}

	public void moveDown() throws MovingExcpetion {
		if (y < 19 && proofPassabilty(x, y+1)) {
			y++;
		} else {
			throw new MovingExcpetion("You can not walk further to the bottom.");
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
