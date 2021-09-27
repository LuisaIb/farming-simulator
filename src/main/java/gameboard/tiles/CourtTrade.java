package gameboard.tiles;

/**
 * This class represents the Court Trade, where the farmer can sell his grain
 * to earn money.
 * @author Luisaibele, Judith
 *
 */
public class CourtTrade extends TileWithBuilding{
    /**
     * selling price of the grain is set depending on the level of difficulty
     */
    private double sellingPrice;

    /**
     * Empty Constructor of CourtTrade for reloading the game.
     */
    public CourtTrade() {
    	super();
    }
    
    /**
     * Constructor of CourtTrade.
     *
     * @param level the level of difficulty the player has chosen
     */
    public CourtTrade(int level) {
        super();
        if (level == 1) {
            sellingPrice = 4;
        } else if (level == 2) {
            sellingPrice = 3;
        } else if (level == 3) {
            sellingPrice = 2;
        }
    }

    /**
     * Getter for sellingPrice
     * @return the requested sellingPrice
     */
    public double getSellingPrice() {
        return sellingPrice;
    }

    /**
     * Setter for sellingPrice
     * @param sellingPrice the value that is set as sellingPrice
     */
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
