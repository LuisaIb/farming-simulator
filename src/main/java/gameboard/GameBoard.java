package gameboard;

import gameboard.tiles.Tile;
/**
 * this class represents the gameboard itself
 * @author Luisaibele
 *
 */
public class GameBoard {
	
	private int width = 30, height = 20;
	private int [][] tiles;
	
	
	public GameBoard() {
		tiles = new int[width][height]; 
		
	}
	/*
	 * checking or setting each tile of the gameboard
	 */
	public Tile getTile(int x, int y) {
		// Tile t = Tile.tiles[tiles[x][y]]; -> setting each tile
		
//		if (t == null) {
//		//	return Tile.forestTile;  -> setting a default tile
//		}
//		return t;
		return null; 
	}

}
