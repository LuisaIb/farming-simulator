package gameboard.objects;

import exceptions.MovingExcpetion;
import gameboard.tiles.Tile;
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
	private boolean selected = false; //check whether object is selected atm
	Tile tile = new Tile();


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
		for (Integer i: tile.getPlaces()) {
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
