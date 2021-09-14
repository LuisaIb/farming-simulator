package gui.view;

import gui.model.ImageManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import static gui.view.ViewManager.HEIGHT;

/**
 * This class implements the grid pane with the matchfield and offers methods to fill the pane with image views of the
 * ground and the buildings.
 */
public class Matchfield {
    private GridPane matchfield = new GridPane();
    private static final int HEIGHT_PANE = 860;
    private static final int WIDTH_PANE = 1120;
    private static final int NUMBER_COLUMNS = 30;
    private static final int NUMBER_ROWS = 20;
    protected static double TILE_HEIGHT = (HEIGHT_PANE / NUMBER_ROWS)+0.5;
    protected static double TILE_WIDTH = (WIDTH_PANE / NUMBER_COLUMNS)+0.5;
    private static final String PATH_TO_GRASSLANDS = "src/main/java/gui/view/resources/ground/grasslands.png";
    private static final String PATH_TO_FOREST = "src/main/java/gui/view/resources/ground/forest.png";
    private static final String PATH_TO_GROWTH_STAGE_1 = "src/main/java/gui/view/resources/ground/growthStage1.png";
    private static final String PATH_TO_GROWTH_STAGE_2 = "src/main/java/gui/view/resources/ground/growthStage2.png";
    private static final String PATH_TO_GROWTH_STAGE_3 = "src/main/java/gui/view/resources/ground/growthStage3.png";
    private static final String PATH_TO_HARVESTED = "src/main/java/gui/view/resources/ground/harvested.png";
    private static final String PATH_TO_PATH = "src/main/java/gui/view/resources/ground/path.png";
    private static final String PATH_TO_READY_FOR_SOWING = "src/main/java/gui/view/resources/ground/readyForSowing.png";
    private static final String PATH_TO_READY_TO_HARVEST = "src/main/java/gui/view/resources/ground/readyToHarvest.png";
    private static final String PATH_TO_BARN = "src/main/java/gui/view/resources/buildings/barn.png";
    private static final String PATH_TO_GAS_STATION = "src/main/java/gui/view/resources/buildings/gasStation.png";
    private static final String PATH_TO_LAND_TRADE = "src/main/java/gui/view/resources/buildings/landTrade.png";
    private static final String PATH_TO_SILO = "src/main/java/gui/view/resources/buildings/silo.png";
    private ImageView movingObjectImageView;
    private ImageView imageViewField1;
    private ImageView imageViewField2;
    private ImageView imageViewField3;
    private Image imageField1;
    private Image imageField2;
    private Image imageField3;
    private static final String PATH_TO_FARMER = "src/main/java/gui/view/resources/movingObjects/farmer.png";
    private static final String PATH_TO_TRACTOR = "src/main/java/gui/view/resources/movingObjects/tractor.png";
    private static final String PATH_TO_HARVESTER = "src/main/java/gui/view/resources/movingObjects/harvester.png";
    private static final String PATH_TO_CULTIVATOR = "src/main/java/gui/view/resources/movingObjects/cultivator.png";
    private static final String PATH_TO_DUMP_TRUCK_EMPTY = "src/main/java/gui/view/resources/movingObjects/dumpTruckEmpty.png";
    private static final String PATH_TO_DUMP_TRUCK_Full = "src/main/java/gui/view/resources/movingObjects/dumpTruckFull.png";
    private static final String PATH_TO_SEED_DRILL = "src/main/java/gui/view/resources/movingObjects/seedDrill.png";
    private int x;
    private int y;

    /**
     * Constructor without parameters.
     */
    public Matchfield(){

    }

    /**
     * Constructor with parameters.
     *
     * @param stageOfGrowthField1 - hands the integer to the method setField1()
     * @param stageOfGrowthField2 - hands the integer to the method setField2()
     * @param stageOfGrowthField3 - hands the integer to the method setField3()
     */
    protected Matchfield(int stageOfGrowthField1, int stageOfGrowthField2, int stageOfGrowthField3){
        initializeMatchfield();
        fillWithGrassland();
        fillWithForest();
        fillWithBuildings();
        fillWithPath();
        setField1(stageOfGrowthField1);
        setField2(stageOfGrowthField2);
        setField3(stageOfGrowthField3);
    }

    /**
     * Sets the size and style of the grid pane matchfield and adds columns and rows.
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
     * Adds the image views of the fist field to the matchfield.
     */
    protected void setField1(int stageOfGrowth){
        for (int i = 20; i < NUMBER_COLUMNS; i++){
            for (int j = 14; j < NUMBER_ROWS; j++) {
                imageViewField1 = getImageViewField(stageOfGrowth);
                addToGridPane(imageViewField1, i, j);
            }
        }
    }

    public void setImageOfField1(int stageOfGrowth) {
        imageField1 = getCorrectImageField(stageOfGrowth);
    }

    public ImageView getImageViewField1(int index){
        ImageView imageViewField1 = (ImageView) matchfield.getChildren().get(index);
        return imageViewField1;
    }

    /**
     * Adds the image views of the second field to the matchfield.
     */
    protected void setField2(int stageOfGrowth){
        for (int i = 9; i < 19; i++){
            for (int j = 14; j < NUMBER_ROWS; j++) {
                imageViewField2 = getImageViewField(stageOfGrowth);
                addToGridPane(imageViewField2, i, j);
            }
        }
    }

    public void setImageOfField2(int stageOfGrowth) {
        imageField2 = getCorrectImageField(stageOfGrowth);
    }

    /**
     * Adds the image views of the third field to the matchfield.
     */
    protected void setField3(int stageOfGrowth){
        for (int i = 20; i < NUMBER_COLUMNS; i++){
            for (int j = 6; j < 13; j++) {
                imageViewField3 = getImageViewField(stageOfGrowth);
                addToGridPane(imageViewField3, i, j);
            }
        }
    }

    public void setImageOfField3(int stageOfGrowth) {
        imageField3 = getCorrectImageField(stageOfGrowth);
    }

    /***
     * This method helps to add an image view to the grid pane that only needs the space of one tile.
     *
     * @param imageView - node that is added to the grid pane
     * @param column - index of the column to which the image view is added
     * @param row - index of the row to which the image view is added
     */
    private void addToGridPane(ImageView imageView, int column, int row){
        matchfield.setColumnIndex(imageView, column);
        matchfield.setRowIndex(imageView, row);
        matchfield.getChildren().add(imageView);
    }

    /**
     * This method helps to add an image view to the grid pane that needs more than one tile.
     *
     * @param imageView - node that is added to the grid pane
     * @param column - index of the column to which the image view is added
     * @param column_span - number of columns the image view spans
     * @param row - index of the row to which the image view is added
     * @param row_span - number of rows the image view spans
     */
    private void addToGridPane(ImageView imageView, int column, int column_span, int row, int row_span){
        matchfield.setColumnIndex(imageView, column);
        matchfield.setColumnSpan(imageView, column_span);
        matchfield.setRowIndex(imageView, row);
        matchfield.setRowSpan(imageView, row_span);
        matchfield.getChildren().add(imageView);
    }

    /**
     * Method that helps to get the image of the tile.
     * @param path - path to the image
     * @return - the requested image
     */
    private Image getImage(String path){
        Image image = new ImageManager().getImage(path, TILE_WIDTH, TILE_HEIGHT, false, false);
        return image;
    }

    /**
     * Method that helps to get the images of the buildings
     * @param path - path to the image
     * @param width - of the image
     * @param height - of the image
     * @return - the requested image
     */
    private Image getImage(String path, double width, double height){
        Image image = new ImageManager().getImage(path, width, height, true, false);
        return image;
    }

    private ImageView getImageViewField(int stageOfGrowth){
        ImageView imageViewField = new ImageView(getCorrectImageField(stageOfGrowth));
        return imageViewField;
    }


    /**
     * This method helps to get the right image view for the field depending on the stage of growth.
     *
     * @param stageOfGrowth - integer that is used for the switch case to get the right image view
     * @return - the requested image view
     */
    public Image getCorrectImageField(int stageOfGrowth){
        Image imageField = null;
        switch(stageOfGrowth){
            case 0:
                imageField = getImage(PATH_TO_GRASSLANDS);
                break;
            case 1:
                imageField = getImage(PATH_TO_READY_FOR_SOWING);
                break;
            case 2:
                imageField = getImage(PATH_TO_GROWTH_STAGE_1);
                break;
            case 3:
                imageField = getImage(PATH_TO_GROWTH_STAGE_2);
                break;
            case 4:
                imageField = getImage(PATH_TO_GROWTH_STAGE_3);
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
     * @return - the requested matchfield
     */
    public GridPane getMatchfield(){
        return matchfield;
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
        matchfield.getChildren().add(movingObjectImageView);
    }

    /**
     * This method sets the image view to the one of the selected object with the help of the method
     * getTheRightImageView().
     *
     * @param selectedObject - integer of the selected moving object that is shown on the matchfield, handed to the
     *                       method getTheRightImageView()
     */
    public void setImageView(int selectedObject){
        movingObjectImageView = getTheRightImageView(selectedObject);
    }

    public ImageView getMovingObjectImageView(){
        return movingObjectImageView;
    }

    /**
     * This method sets the image view to another tile on the matchfield.
     *
     * @param column - sets the image view onto this column on the grid pane of the matchfield
     * @param row - sets the image view onto this row on the grid pane of the matchfield
     */
    public void setTileOfObject(int column, int row){
        matchfield.setColumnIndex(movingObjectImageView, column);
        matchfield.setRowIndex(movingObjectImageView, row);
    }

    public int getColumnOfMovingObject(){
        return matchfield.getColumnIndex(movingObjectImageView);
    }

    public  int getRowOfMovingObject(){
        return matchfield.getRowIndex(movingObjectImageView);
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

    public Image getTheRightImage(int selectedObject){
        Image movingObjectImage = null;
        switch(selectedObject){
            case 1:
                movingObjectImage = getImage(PATH_TO_FARMER);
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
