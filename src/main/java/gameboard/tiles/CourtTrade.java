package gameboard.tiles;

public class CourtTrade extends TileWithBuilding{
    private double sellingPrice;


    public CourtTrade(int level) {
        super();
        if (level == 1) {
            sellingPrice = 2;
        } else if (level == 2) {
            sellingPrice = 1.5;
        } else if (level == 3) {
            sellingPrice = 1;
        }
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
