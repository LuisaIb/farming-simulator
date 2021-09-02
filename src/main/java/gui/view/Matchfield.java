package gui.view;

import gui.model.ImageManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import static gui.view.ViewManager.HEIGHT;
import static gui.view.ViewManager.WIDTH;

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
    private static final int TILE_HEIGHT = HEIGHT_PANE / NUMBER_ROWS;
    private static final int TILE_WIDTH = WIDTH_PANE / NUMBER_COLUMNS;
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

    /**
     * Constructor without parameters.
     */
    protected Matchfield(){

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
        matchfield.setGridLinesVisible(true);

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
        Image imageGrasslands = getImage(PATH_TO_GRASSLANDS, false);
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
        Image imageForest = getImage(PATH_TO_FOREST, false);
        for (int i = 0; i < 7; i+=2){
            for (int j = 0; j < NUMBER_ROWS; j+=2) {
                ImageView imageViewForest = new ImageView(imageForest);
                addToGridPane(imageViewForest, i, 2, j, 2);
            }
        }
    }

    /**
     * Adds the image views of the buildings to the matchfield.
     */
    private void fillWithBuildings(){
        ImageView imageViewBarn = new ImageView(getImage(PATH_TO_BARN, true));
        addToGridPane(imageViewBarn, 15, 4, 6, 7);

        ImageView imageViewSilo = new ImageView(getImage(PATH_TO_SILO, true));
        addToGridPane(imageViewSilo, 11, 5, 8, 5);

        ImageView imageViewGasStation = new ImageView(getImage(PATH_TO_GAS_STATION, true));
        addToGridPane(imageViewGasStation, 13, 4, 0, 4);

        ImageView imageViewLandTrade = new ImageView(getImage(PATH_TO_LAND_TRADE, true));
        addToGridPane(imageViewLandTrade, 25, 5, 0, 5);
    }

    /**
     * Adds the image views of path to the matchfield.
     */
    private void fillWithPath(){
        Image imagePath = getImage(PATH_TO_PATH, false);

        for (int i = 0; i < NUMBER_ROWS; i++) {
            ImageView imageViewPath = new ImageView(imagePath);
            addToGridPane(imageViewPath, 8, i);
        }

        for (int i = 9; i < NUMBER_ROWS; i++) {
            ImageView imageViewPath = new ImageView(imagePath);
            addToGridPane(imageViewPath, i, 13);
        }

        for (int i = 5; i < NUMBER_ROWS; i++) {
            ImageView imageViewPath = new ImageView(imagePath);
            addToGridPane(imageViewPath, 19, i);
        }

        for (int i = 0; i < NUMBER_ROWS; i++) {
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
    private void setField1(int stageOfGrowth){
        for (int i = 20; i < NUMBER_COLUMNS; i++){
            for (int j = 14; j < NUMBER_ROWS; j++) {
                ImageView imageViewField = getImageViewField(stageOfGrowth);
                addToGridPane(imageViewField, i, j);
            }
        }
    }

    /**
     * Adds the image views of the second field to the matchfield.
     */
    private void setField2(int stageOfGrowth){
        for (int i = 9; i < 19; i++){
            for (int j = 14; j < NUMBER_ROWS; j++) {
                ImageView imageViewField = getImageViewField(stageOfGrowth);
                addToGridPane(imageViewField, i, j);
            }
        }
    }

    /**
     * Adds the image views of the third field to the matchfield.
     */
    private void setField3(int stageOfGrowth){
        for (int i = 20; i < NUMBER_COLUMNS; i++){
            for (int j = 6; j < 13; j++) {
                ImageView imageViewField = getImageViewField(stageOfGrowth);
                addToGridPane(imageViewField, i, j);
            }
        }
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
     * @param preserveRatio - boolean that is handed to the method getImage() of the class ImageManager
     * @return - the requested image
     */
    private Image getImage(String path, boolean preserveRatio){
        Image image = new ImageManager().getImage(path, TILE_WIDTH, TILE_HEIGHT, preserveRatio, false);
        return image;
    }

    /**
     * This method helps to get the right image view for the field depending on the stage of growth.
     *
     * @param stageOfGrowth - integer that is used for the switch case to get the right image view
     * @return - the requested image view
     */
    private ImageView getImageViewField(int stageOfGrowth){
        ImageView imageViewField = null;
        switch(stageOfGrowth){
            case 1:
                imageViewField = new ImageView(getImage(PATH_TO_READY_FOR_SOWING, false));
                break;
            case 2:
                imageViewField = new ImageView(getImage(PATH_TO_GROWTH_STAGE_1, false));
                break;
            case 3:
                imageViewField = new ImageView(getImage(PATH_TO_GROWTH_STAGE_2, false));
                break;
            case 4:
                imageViewField = new ImageView(getImage(PATH_TO_GROWTH_STAGE_3, false));
                break;
            case 5:
                imageViewField = new ImageView(getImage(PATH_TO_READY_TO_HARVEST, false));
                break;
            case 6:
                imageViewField = new ImageView(getImage(PATH_TO_HARVESTED, false));
                break;
        }
        return imageViewField;
    }

    /**
     * Getter for the matchfield.
     *
     * @return - the requested matchfield
     */
    protected GridPane getMatchfield(){
        return matchfield;
    }
}
