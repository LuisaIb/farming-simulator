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
 *
 * @author Judith
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
    private static final String PATH_TO_FARMER = "src/main/java/gui/view/resources/movingObjects/farmer.png";
    private static final String PATH_TO_TRACTOR = "src/main/java/gui/view/resources/movingObjects/tractor.png";
    private static final String PATH_TO_HARVESTER = "src/main/java/gui/view/resources/movingObjects/harvester.png";
    private static final String PATH_TO_CULTIVATOR = "src/main/java/gui/view/resources/movingObjects/cultivator.png";
    private static final String PATH_TO_DUMP_TRUCK_EMPTY = "src/main/java/gui/view/resources/movingObjects/dumpTruckEmpty.png";
    private static final String PATH_TO_DUMP_TRUCK_Full = "src/main/java/gui/view/resources/movingObjects/dumpTruckFull.png";
    private static final String PATH_TO_SEED_DRILL = "src/main/java/gui/view/resources/movingObjects/seedDrill.png";
    private ImageView movingObjectImageView;
    private ImageView secondMovingObjectImageView;
    private ImageView imageViewField1;
    private ImageView imageViewField2;
    private ImageView imageViewField3;

    /**
     * Constructor without parameters.
     */
    public Matchfield(){

    }

    /**
     * Constructor with parameters that initializes the pane and all image views.
     *
     * @param stageOfGrowthField1 hands the integer to the method setField1()
     * @param stageOfGrowthField2 hands the integer to the method setField2()
     * @param stageOfGrowthField3 hands the integer to the method setField3()
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
     * Adds the image views of the first field to the matchfield.
     */
    protected void setField1(int stageOfGrowth){
        for (int j = 14; j < NUMBER_ROWS; j++) {
            for (int i = 20; i < NUMBER_COLUMNS; i++){
            imageViewField1 = getImageViewField(stageOfGrowth);
            addToGridPane(imageViewField1, i, j);
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
     */
    protected void setField2(int stageOfGrowth){
        for (int j = 14; j < NUMBER_ROWS; j++) {
            for (int i = 9; i < 19; i++){
            imageViewField2 = getImageViewField(stageOfGrowth);
            addToGridPane(imageViewField2, i, j);
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
     */
    protected void setField3(int stageOfGrowth){
        for (int j = 6; j < 13; j++) {
            for (int i = 20; i < NUMBER_COLUMNS; i++){
            imageViewField3 = getImageViewField(stageOfGrowth);
            addToGridPane(imageViewField3, i, j);
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
     * Method that helps to get the image view of the fields depending on the stage of growth.
     *
     * @param stageOfGrowth stage of growth of the field
     * @return the requested image view
     */
    private ImageView getImageViewField(int stageOfGrowth){
        ImageView imageViewField = new ImageView(getCorrectImageField(stageOfGrowth));
        return imageViewField;
    }

    /**
     * This method helps to get the right image for the field depending on the stage of growth.
     *
     * @param stageOfGrowth integer that is used for the switch case to get the right image
     * @return the requested image
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
