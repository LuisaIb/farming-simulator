package gui.view;

import gui.model.ImageManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import java.util.HashMap;

import static gui.view.ViewManager.HEIGHT;

/**
 * This class implements the grid pane with the matchfield and offers methods to fill the pane with image views of the
 * ground, the buildings and the moving objects.
 *
 * @author Judith
 */
public class Matchfield {
    /**
     * grid pane for the matchfield with a size of 20 x 30 tiles
     */
    private GridPane matchfield = new GridPane();
    /**
     * height of the matchfield
     */
    private static final int HEIGHT_PANE = 860;
    /**
     * width of the matchfield
     */
    private static final int WIDTH_PANE = 1120;
    /**
     * number of columns of the grid pane
     */
    private static final int NUMBER_COLUMNS = 30;
    /**
     * number of rows of the grid pane
     */
    private static final int NUMBER_ROWS = 20;
    /**
     * height of the image of one tile
     */
    protected static double TILE_HEIGHT = (HEIGHT_PANE / NUMBER_ROWS)+0.5;
    /**
     * width of the image of one tile
     */
    protected static double TILE_WIDTH = (WIDTH_PANE / NUMBER_COLUMNS)+0.5;
    /**
     * String with the path to the image of the grasslands
     */
    private static final String PATH_TO_GRASSLANDS = "src/main/java/gui/view/resources/ground/grasslands.png";
    /**
     * String with the path to the image of the forest
     */
    private static final String PATH_TO_FOREST = "src/main/java/gui/view/resources/ground/forest.png";
    /**
     * String with the path to the image of the first state of growth of the fields
     */
    private static final String PATH_TO_GROWTH_STATE_1 = "src/main/java/gui/view/resources/ground/growthState1.png";
    /**
     * String with the path to the image of the second state of growth of the fields
     */
    private static final String PATH_TO_GROWTH_STATE_2 = "src/main/java/gui/view/resources/ground/growthState2.png";
    /**
     * String with the path to the image of the third state of growth of the fields
     */
    private static final String PATH_TO_GROWTH_STATE_3 = "src/main/java/gui/view/resources/ground/growthState3.png";
    /**
     * String with the path to the image of the harvested field
     */
    private static final String PATH_TO_HARVESTED = "src/main/java/gui/view/resources/ground/harvested.png";
    /**
     * String with the path to the image of the path
     */
    private static final String PATH_TO_PATH = "src/main/java/gui/view/resources/ground/path.png";
    /**
     * String with the path to the image of the field that is ready for sowing
     */
    private static final String PATH_TO_READY_FOR_SOWING = "src/main/java/gui/view/resources/ground/readyForSowing.png";
    /**
     * String with the path to the image of the field that is ready to harvest
     */
    private static final String PATH_TO_READY_TO_HARVEST = "src/main/java/gui/view/resources/ground/readyToHarvest.png";
    /**
     * String with the path to the image of the barn
     */
    private static final String PATH_TO_BARN = "src/main/java/gui/view/resources/buildings/barn.png";
    /**
     * String with the path to the image of the gas station
     */
    private static final String PATH_TO_GAS_STATION = "src/main/java/gui/view/resources/buildings/gasStation.png";
    /**
     * String with the path to the image of the land trade / court trade
     */
    private static final String PATH_TO_LAND_TRADE = "src/main/java/gui/view/resources/buildings/landTrade.png";
    /**
     * String with the path to the image of the silo
     */
    private static final String PATH_TO_SILO = "src/main/java/gui/view/resources/buildings/silo.png";
    /**
     * String with the path to the image of the farmer
     */
    private static final String PATH_TO_FARMER = "src/main/java/gui/view/resources/movingObjects/farmer.png";
    /**
     * String with the path to the image of the tractor
     */
    private static final String PATH_TO_TRACTOR = "src/main/java/gui/view/resources/movingObjects/tractor.png";
    /**
     * String with the path to the image of the harvester
     */
    private static final String PATH_TO_HARVESTER = "src/main/java/gui/view/resources/movingObjects/harvester.png";
    /**
     * String with the path to the image of the cultivator
     */
    private static final String PATH_TO_CULTIVATOR = "src/main/java/gui/view/resources/movingObjects/cultivator.png";
    /**
     * String with the path to the image of the empty dump truck
     */
    private static final String PATH_TO_DUMP_TRUCK_EMPTY = "src/main/java/gui/view/resources/movingObjects/dumpTruckEmpty.png";
    /**
     * String with the path to the image of the full dump truck
     */
    private static final String PATH_TO_DUMP_TRUCK_Full = "src/main/java/gui/view/resources/movingObjects/dumpTruckFull.png";
    /**
     * String with the path to the image of the seed drill
     */
    private static final String PATH_TO_SEED_DRILL = "src/main/java/gui/view/resources/movingObjects/seedDrill.png";
    /**
     *  image view of the moving object
     */
    private ImageView movingObjectImageView;
    /**
     * image view of the second moving object - the exited tractor
     */
    private ImageView secondMovingObjectImageView;
    /**
     * image view of the first field
     */
    private ImageView imageViewField1;
    /**
     * image view of the second field
     */
    private ImageView imageViewField2;
    /**
     * image view of the thrid field
     */
    private ImageView imageViewField3;

    /**
     * Constructor without parameters.
     */
    public Matchfield(){

    }

    /**
     * Constructor with parameters that initializes the pane and all image views.
     *
     * @param stateOfGrowthField1 hands the integer to the method setField1()
     * @param stateOfGrowthField2 hands the integer to the method setField2()
     * @param stateOfGrowthField3 hands the integer to the method setField3()
     */
    protected Matchfield(int stateOfGrowthField1, int stateOfGrowthField2, int stateOfGrowthField3){
        initializeMatchfield();
        fillWithGrassland();
        fillWithForest();
        fillWithBuildings();
        fillWithPath();
        setField1(stateOfGrowthField1);
        setField2(stateOfGrowthField2);
        setField3(stateOfGrowthField3);
    }

    /**
     * Sets the size and style of the matchfield grid pane and adds columns and rows.
     */
    private void initializeMatchfield(){
        matchfield.setPrefWidth(WIDTH_PANE);
        matchfield.setPrefHeight(HEIGHT_PANE);
        matchfield.setLayoutX(0);
        matchfield.setLayoutY(HEIGHT-HEIGHT_PANE);
        matchfield.setHgap(0);
        matchfield.setVgap(0);
        matchfield.setGridLinesVisible(false);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        for (int i = 0; i < NUMBER_COLUMNS; i++){
            columnConstraints.setPercentWidth(100 / NUMBER_ROWS);
            matchfield.getColumnConstraints().add(columnConstraints);
        }
        RowConstraints rowConstraints = new RowConstraints();
        for (int i = 0; i < NUMBER_ROWS; i++) {
            rowConstraints.setPercentHeight(100 / NUMBER_ROWS);
            matchfield.getRowConstraints().add(rowConstraints);
        }
    }

    /**
     * Adds the image views of grassland to the matchfield.
     */
    private void fillWithGrassland(){
        Image imageGrasslands = getImage(PATH_TO_GRASSLANDS);
        for (int i = 0; i < NUMBER_COLUMNS; i++){
            for (int j = 0; j < NUMBER_ROWS; j++) {
                ImageView imageViewGrassland = new ImageView(imageGrasslands);
                addToGridPane(imageViewGrassland, i, j);
            }
        }
    }

    /**
     * Adds the image views of forest to the matchfield.
     */
    private void fillWithForest(){
        Image imageForest = getImage(PATH_TO_FOREST);
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < NUMBER_ROWS; j++) {
                ImageView imageViewForest = new ImageView(imageForest);
                addToGridPane(imageViewForest, i, j);
            }
        }
    }

    /**
     * Adds the image views of the buildings to the matchfield.
     */
    private void fillWithBuildings(){
        ImageView imageViewBarn = new ImageView(getImage(PATH_TO_BARN, TILE_WIDTH*4, TILE_HEIGHT*7));
        addToGridPane(imageViewBarn, 15, 4, 6, 7);

        ImageView imageViewSilo = new ImageView(getImage(PATH_TO_SILO, TILE_WIDTH*5, TILE_HEIGHT*5));
        addToGridPane(imageViewSilo, 11, 5, 8, 5);

        ImageView imageViewGasStation = new ImageView(getImage(PATH_TO_GAS_STATION, TILE_WIDTH*6, TILE_HEIGHT*6));
        addToGridPane(imageViewGasStation, 13, 6, 0, 6);

        ImageView imageViewLandTrade = new ImageView(getImage(PATH_TO_LAND_TRADE, TILE_WIDTH*5, TILE_HEIGHT*5));
        addToGridPane(imageViewLandTrade, 25, 5, 0, 5);
    }

    /**
     * Adds the image views of path to the matchfield.
     */
    private void fillWithPath(){
        Image imagePath = getImage(PATH_TO_PATH);

        for (int i = 0; i < NUMBER_ROWS; i++) {
            ImageView imageViewPath = new ImageView(imagePath);
            addToGridPane(imageViewPath, 8, i);
        }

        for (int i = 9; i < NUMBER_COLUMNS; i++) {
            ImageView imageViewPath = new ImageView(imagePath);
            addToGridPane(imageViewPath, i, 13);
        }

        for (int i = 5; i < NUMBER_ROWS; i++) {
            ImageView imageViewPath = new ImageView(imagePath);
            addToGridPane(imageViewPath, 19, i);
        }

        for (int i = 0; i < NUMBER_COLUMNS; i++) {
            ImageView imageViewPath = new ImageView(imagePath);
            addToGridPane(imageViewPath, i, 5);
        }

        for (int i = 0; i < 5; i++) {
            ImageView imageViewPath = new ImageView(imagePath);
            addToGridPane(imageViewPath, 24, i);
        }
    }

    /**
     * Adds the image views of the first field to the matchfield.
     *
     * @param stateOfGrowth the value that is set as state of growth of field 1
     */
    protected void setField1(int stateOfGrowth){
        for (int j = 14; j < NUMBER_ROWS; j++) {
            for (int i = 20; i < NUMBER_COLUMNS; i++){
            imageViewField1 = getImageViewField(stateOfGrowth);
            addToGridPane(imageViewField1, i, j);
            }
        }
    }

    /**
     * This method is used when reloading the game. If parts of field 1 have been processed before saving it sets the
     * correct image views to the grid pane.
     *
     * @param indexes HashMap of the class FieldTile that holds the matching indexes of the moving object on the
     *                matchfield and the index of the node on the grid pane
     * @param completed HashMap of the class FieldTile that holds the indexes of each tile of the field and if it is
     *                  already processed
     * @param stateOfGrowth state of growth of field 1
     */
    public void fillWithField1(HashMap<Integer, Integer> indexes, HashMap<Integer, Boolean> completed, int stateOfGrowth){
        int newStateOfGrowth = stateOfGrowth+1;
        if (newStateOfGrowth > 6) {
            newStateOfGrowth = 1;
        }

        for (Integer index : completed.keySet()) {
            if (completed.get(index)) {
                getImageViewField1(indexes.get(index)).setImage(getCorrectImageField(newStateOfGrowth));
            }
        }
    }

    /**
     * Getter for the imageViewField1.
     *
     * @param index index of the image view in the list of children
     * @return the requested imageViewField1
     */
    public ImageView getImageViewField1(int index){
        imageViewField1 = (ImageView) matchfield.getChildren().get(index);
        return imageViewField1;
    }

    /**
     * Adds the image views of the second field to the matchfield.
     *
     * @param stateOfGrowth the value that is set as state of growth of field 2
     */
    protected void setField2(int stateOfGrowth){
        for (int j = 14; j < NUMBER_ROWS; j++) {
            for (int i = 9; i < 19; i++){
            imageViewField2 = getImageViewField(stateOfGrowth);
            addToGridPane(imageViewField2, i, j);
            }
        }
    }

    /**
     * This method is used when reloading the game. If parts of field 2 have been processed before saving it sets the
     * correct image views to the grid pane.
     *
     * @param indexes HashMap of the class FieldTile that holds the matching indexes of the moving object on the
     *                matchfield and the index of the node on the grid pane
     * @param completed HashMap of the class FieldTile that holds the indexes of each tile of the field and if it is
     *                  already processed
     * @param stateOfGrowth state of growth of field 2
     */
    public void fillWithField2(HashMap<Integer, Integer> indexes, HashMap<Integer, Boolean> completed, int stateOfGrowth){
        int newStateOfGrowth = stateOfGrowth+1;
        if (newStateOfGrowth > 6) {
            newStateOfGrowth = 1;
        }

        for (Integer index : completed.keySet()) {
            if (completed.get(index)) {
                getImageViewField2(indexes.get(index)).setImage(getCorrectImageField(newStateOfGrowth));
            }
        }
    }

    /**
     * Getter for the imageViewField2.
     *
     * @param index index of the image view in the list of children
     * @return the requested imageViewField2
     */
     public ImageView getImageViewField2(int index){
         imageViewField2 = (ImageView) matchfield.getChildren().get(index);
         return imageViewField2;
     }

    /**
     * Adds the image views of the third field to the matchfield.
     * @param stateOfGrowth the value that is set as state of growth of field 3
     */
    protected void setField3(int stateOfGrowth){
        for (int j = 6; j < 13; j++) {
            for (int i = 20; i < NUMBER_COLUMNS; i++){
            imageViewField3 = getImageViewField(stateOfGrowth);
            addToGridPane(imageViewField3, i, j);
            }
        }
    }

    /**
     * This method is used when reloading the game. If parts of field 3 have been processed before saving it sets the
     * correct image views to the grid pane.
     *
     * @param indexes HashMap of the class FieldTile that holds the matching indexes of the moving object on the
     *                matchfield and the index of the node on the grid pane
     * @param completed HashMap of the class FieldTile that holds the indexes of each tile of the field and if it is
     *                  already processed
     * @param stateOfGrowth state of growth of field 3
     */
    public void fillWithField3(HashMap<Integer, Integer> indexes, HashMap<Integer, Boolean> completed, int stateOfGrowth){
        int newStateOfGrowth = stateOfGrowth+1;
        if (newStateOfGrowth > 6) {
            newStateOfGrowth = 1;
        }

        for (Integer index : completed.keySet()) {
            if (completed.get(index)) {
                getImageViewField3(indexes.get(index)).setImage(getCorrectImageField(newStateOfGrowth));
            }
        }
    }

    /**
     * Getter for the imageViewField3.
     *
     * @param index index of the image view in the list of children
     * @return the requested imageViewField3
     */
    public ImageView getImageViewField3(int index){
        imageViewField3 = (ImageView) matchfield.getChildren().get(index);
        return imageViewField3;
    }

    /***
     * This method helps to add an image view to the grid pane that only needs the space of one tile.
     *
     * @param imageView node that is added to the grid pane
     * @param column index of the column to which the image view is added
     * @param row index of the row to which the image view is added
     */
    private void addToGridPane(ImageView imageView, int column, int row){
        matchfield.setColumnIndex(imageView, column);
        matchfield.setRowIndex(imageView, row);
        matchfield.getChildren().add(imageView);
    }

    /**
     * This method helps to add an image view to the grid pane that needs more than one tile.
     *
     * @param imageView node that is added to the grid pane
     * @param column index of the column to which the image view is added
     * @param column_span number of columns the image view spans
     * @param row index of the row to which the image view is added
     * @param row_span number of rows the image view spans
     */
    private void addToGridPane(ImageView imageView, int column, int column_span, int row, int row_span){
        matchfield.setColumnIndex(imageView, column);
        matchfield.setColumnSpan(imageView, column_span);
        matchfield.setRowIndex(imageView, row);
        matchfield.setRowSpan(imageView, row_span);
        matchfield.getChildren().add(imageView);
    }

    /**
     * Method that helps to get the image for the tile.
     *
     * @param path path to the image
     * @return the requested image
     */
    private Image getImage(String path){
        Image image = new ImageManager().getImage(path, TILE_WIDTH, TILE_HEIGHT, false, false);
        return image;
    }

    /**
     * Method that helps to get the images for the buildings.
     *
     * @param path path to the image
     * @param width of the image
     * @param height of the image
     * @return the requested image
     */
    private Image getImage(String path, double width, double height){
        Image image = new ImageManager().getImage(path, width, height, true, false);
        return image;
    }

    /**
     * Method that helps to get the image view of the fields depending on the state of growth.
     *
     * @param stateOfGrowth state of growth of the field
     * @return the requested image view
     */
    private ImageView getImageViewField(int stateOfGrowth){
        ImageView imageViewField = new ImageView(getCorrectImageField(stateOfGrowth));
        return imageViewField;
    }

    /**
     * This method helps to get the right image for the field depending on the state of growth.
     *
     * @param stateOfGrowth integer that is used for the switch case to get the right image
     * @return the requested image
     */
    public Image getCorrectImageField(int stateOfGrowth){
        Image imageField = null;
        switch(stateOfGrowth){
            case 0:
                imageField = getImage(PATH_TO_GRASSLANDS);
                break;
            case 1:
                imageField = getImage(PATH_TO_READY_FOR_SOWING);
                break;
            case 2:
                imageField = getImage(PATH_TO_GROWTH_STATE_1);
                break;
            case 3:
                imageField = getImage(PATH_TO_GROWTH_STATE_2);
                break;
            case 4:
                imageField = getImage(PATH_TO_GROWTH_STATE_3);
                break;
            case 5:
                imageField = getImage(PATH_TO_READY_TO_HARVEST);
                break;
            case 6:
                imageField = getImage(PATH_TO_HARVESTED);
                break;
        }
        return imageField;
    }

    /**
     * Getter for the matchfield.
     *
     * @return the requested matchfield
     */
    public GridPane getMatchfield(){
        return matchfield;
    }


    /**
     * This method initializes the moving object on the field. It uses the methods setImageView() and setTileOfObject().
     *
     * @param selectedObject integer of the selected moving object that is shown on the matchfield, handed to the
     *                             method getTheRightImageView()
     * @param column index of the column to which the image view is set, handed to the method setTileOfObject()
     * @param row index of the column to which the image view is set, handed to the method setTileOfObject()
     */
    protected void initializeMovingObject(int selectedObject, int column, int row){
        setImageView(selectedObject);
        setTileOfObject(column, row);
        matchfield.getChildren().add(movingObjectImageView);
    }

    /**
     * This method initializes a second object on the field. It uses the methods setImageView() and setTileOfObject().
     * Actually this image view isn't meant to move around.
     *
     * @param selectedObject integer of the selected moving object that is shown on the matchfield, handed to the
     *                             method getTheRightImageView()
     * @param column index of the column to which the image view is set, handed to the method setTileOfObject()
     * @param row index of the column to which the image view is set, handed to the method setTileOfObject()
     */
    public void initializeSecondMovingObject(int selectedObject, int column, int row){
        setSecondImageView(selectedObject);
        setTileOfSecondObject(column, row);
        matchfield.getChildren().add(secondMovingObjectImageView);
    }

    /**
     * This method deletes the image view of the secondMovingObject.
     */
    public void deleteSecondImageView(){
        matchfield.getChildren().remove(matchfield.getChildren().size()-1);
    }

    /**
     * This method sets the image view of the moving object to the one of the selected object with the help of the
     * method getTheRightImageView().
     *
     * @param selectedObject integer of the selected moving object that is shown on the matchfield, handed to the
     *                       method getTheRightImageView()
     */
    public void setImageView(int selectedObject){
        movingObjectImageView = getTheRightImageView(selectedObject);
    }

    /**
     * This method sets the image view of the second moving object to the one of the selected object with the help of
     * the method getTheRightImageView().
     *
     * @param selectedObject integer of the selected moving object that is shown on the matchfield, handed to the
     *                       method getTheRightImageView()
     */
    public void setSecondImageView(int selectedObject){
        secondMovingObjectImageView = getTheRightImageView(selectedObject);
    }

    /**
     * Getter for the movingObjectImageView.
     *
     * @return the requested movingObjectImageView
     */
    public ImageView getMovingObjectImageView(){
        return movingObjectImageView;
    }

    /**
     * Getter for the secondMovingObjectImageView.
     *
     * @return the requested secondMovingObjectImageView
     */
    public ImageView getSecondMovingObjectImageView(){
        return secondMovingObjectImageView;
    }

    /**
     * This method sets the image view of the moving object to a specific tile on the matchfield.
     *
     * @param column index of the column onto which the image view is put on the grid pane of the matchfield
     * @param row index of the row onto which the image view is put on the grid pane of the matchfield
     */
    public void setTileOfObject(int column, int row){
        matchfield.setColumnIndex(movingObjectImageView, column);
        matchfield.setRowIndex(movingObjectImageView, row);
    }

    /**
     * This method sets the image view of the second moving object to specific tile on the matchfield.
     *
     * @param column index of the column onto which the image view is put on the grid pane of the matchfield
     * @param row index of the row onto which the image view is put on the grid pane of the matchfield
     */
    public void setTileOfSecondObject(int column, int row){
        matchfield.setColumnIndex(secondMovingObjectImageView, column);
        matchfield.setRowIndex(secondMovingObjectImageView, row);
    }

    /**
     * Method that returns the index of the column on which the image view of the moving object is at the moment.
     *
     * @return the requested index of the column
     */
    public int getColumnOfMovingObject(){
        return matchfield.getColumnIndex(movingObjectImageView);
    }

    /**
     * Method that returns the index of the row on which the image view of the moving object is at the moment.
     *
     * @return the requested index of the row
     */
    public  int getRowOfMovingObject(){
        return matchfield.getRowIndex(movingObjectImageView);
    }


    /**
     * This method helps to get the right image view for the moving objects depending on the selected object.
     *
     * @param selectedObject integer of the selected moving object that is shown on the matchfield
     * @return the requested image view
     */
    private ImageView getTheRightImageView(int selectedObject){
        ImageView movingObjectImageView = null;
        switch(selectedObject){
            case 1:
                movingObjectImageView = new ImageView(getImage(PATH_TO_FARMER, TILE_WIDTH/2, TILE_HEIGHT/2));
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

    /**
     * This method helps to get the right image for the moving objects depending on the selected object.
     *
     * @param selectedObject integer of the selected moving object that is shown on the matchfield
     * @return the requested image
     */
    public Image getTheRightImage(int selectedObject){
        Image movingObjectImage = null;
        switch(selectedObject){
            case 1:
                movingObjectImage = getImage(PATH_TO_FARMER, TILE_WIDTH/2, TILE_HEIGHT/2);
                break;
            case 2:
                movingObjectImage = getImage(PATH_TO_TRACTOR);
                break;
            case 3:
                movingObjectImage = getImage(PATH_TO_HARVESTER);
                break;
            case 4:
                movingObjectImage = getImage(PATH_TO_CULTIVATOR);
                break;
            case 5:
                movingObjectImage = getImage(PATH_TO_DUMP_TRUCK_EMPTY);
                break;
            case 6:
                movingObjectImage = getImage(PATH_TO_DUMP_TRUCK_Full);
                break;
            case 7:
                movingObjectImage = getImage(PATH_TO_SEED_DRILL);
                break;
        }
        return movingObjectImage;
    }
}
