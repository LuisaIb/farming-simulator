package gameboard.tiles;

/**
 * this class represents the Court Trade, where the farmer can sell his grain
 * to earn money.
 * @author Luisaibele, Judith
 *
 */
public class CourtTrade extends TileWithBuilding{
    private double sellingPrice;


    public CourtTrade() {
    	super();
    }
    /**
     * Constructor of CourtTrade
     * @param level
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
     * Getter for SellingPrice
     * @return sellingPrice
     */
    public double getSellingPrice() {
        return sellingPrice;
    }

    /**
     * Setter for SellingPrice
     * @param sellingPrice
     */
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
