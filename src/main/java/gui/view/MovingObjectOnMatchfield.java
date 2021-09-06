package gui.view;

import gui.model.ImageManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import static gui.view.Matchfield.TILE_HEIGHT;
import static gui.view.Matchfield.TILE_WIDTH;

/**
 * This class implements the moving object on the matchfield. It offers methods to change the image view, depending
 * on the selected object and to set the object to another tile.
 */

public class MovingObjectOnMatchfield {
    private Image movingObjectImage;
    private ImageView movingObjectImageView;
    Matchfield matchfield = new Matchfield();
    GridPane matchfieldGrid = matchfield.getMatchfield();

    private static final String PATH_TO_FARMER = "src/main/java/gui/view/resources/movingObjects/farmer.png";
    private static final String PATH_TO_TRACTOR = "src/main/java/gui/view/resources/movingObjects/tractor.png";
    private static final String PATH_TO_HARVESTER = "src/main/java/gui/view/resources/movingObjects/harvester.png";
    private static final String PATH_TO_CULTIVATOR = "src/main/java/gui/view/resources/movingObjects/cultivator.png";
    private static final String PATH_TO_DUMP_TRUCK_EMPTY = "src/main/java/gui/view/resources/movingObjects/dumpTruckEmpty.png";
    private static final String PATH_TO_DUMP_TRUCK_Full = "src/main/java/gui/view/resources/movingObjects/dumpTruckFull.png";
    private static final String PATH_TO_SEED_DRILL = "src/main/java/gui/view/resources/movingObjects/seedDrill.png";

    /**
     * Constructs an object of the class MovingObjectOnMatchfield.
     */
    public MovingObjectOnMatchfield(){

    }

    /**
     * This method initializes the moving object on the field. It uses the methods setImageView() and setTileOfObject().
     *
     * @param selectedObject - integer of the selected moving object that is shown on the matchfield, handed to the
     *      *                       method getTheRightImageView()
     * @param column - index of the column to which the image view is set, handed to the method setTileOfObject()
     * @param row - index of the column to which the image view is set, handed to the method setTileOfObject()
     */
    protected void initializeMovingObject(int selectedObject, int column, int row){
        setImageView(selectedObject);
        setTileOfObject(column, row);
    }

    /**
     * This method sets the image view to the one of the selected object with the help of the method
     * getTheRightImageView().
     *
     * @param selectedObject - integer of the selected moving object that is shown on the matchfield, handed to the
     *                       method getTheRightImageView()
     */
    protected void setImageView(int selectedObject){
        movingObjectImageView = getTheRightImageView(selectedObject);
    }

    /**
     * This method sets the image view to another tile on the matchfield.
     *
     * @param column - sets the image view onto this column on the grid pane of the matchfield
     * @param row - sets the image view onto this row on the grid pane of the matchfield
     */
    protected void setTileOfObject(int column, int row){
        matchfieldGrid.setColumnIndex(movingObjectImageView, column);
        matchfieldGrid.setRowIndex(movingObjectImageView, row);
        matchfieldGrid.getChildren().add(movingObjectImageView);
    }

    /**
     * Method that helps to get the image of the moving object.
     *
     * @param path - path to the image
     * @return - the requested image
     */
    private Image getImage(String path){
        movingObjectImage = new ImageManager().getImage(path, TILE_WIDTH, TILE_HEIGHT, false, false);
        return movingObjectImage;
    }

    /**
     * This method helps to get the right image view for the moving object depending on the selected object.
     *
     * @param selectedObject - integer of the selected moving object that is shown on the matchfield
     * @return the requestedd image view
     */
    private ImageView getTheRightImageView(int selectedObject){
        movingObjectImageView = null;
        switch(selectedObject){
            case 1:
                movingObjectImageView = new ImageView(getImage(PATH_TO_FARMER));
                break;
            case 2:
                movingObjectImageView = new ImageView(getImage(PATH_TO_TRACTOR));
                break;
            case 3:
                movingObjectImageView = new ImageView(getImage(PATH_TO_HARVESTER));
                break;
            case 4:
                movingObjectImageView = new ImageView(getImage(PATH_TO_CULTIVATOR));
                break;
            case 5:
                movingObjectImageView = new ImageView(getImage(PATH_TO_DUMP_TRUCK_EMPTY));
                break;
            case 6:
                movingObjectImageView = new ImageView(getImage(PATH_TO_DUMP_TRUCK_Full));
                break;
            case 7:
                movingObjectImageView = new ImageView(getImage(PATH_TO_SEED_DRILL));
                break;
        }
        return movingObjectImageView;
    }

}
