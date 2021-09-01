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
    private static final int TALE_HEIGHT = HEIGHT_PANE / NUMBER_ROWS;
    private static final int TALE_WIDTH = WIDTH_PANE / NUMBER_COLUMNS;
    private static final String PATH_TO_GRASSLANDS = "../view/resources/ground/grasslands.png";
    private static final String PATH_TO_FOREST = "../view/resources/ground/forest.png";
    private static final String PATH_TO_GROWTH_STAGE_1 = "../view/resources/ground/growthStage1.png";
    private static final String PATH_TO_GROWTH_STAGE_2 = "../view/resources/ground/growthStage2.png";
    private static final String PATH_TO_GROWTH_STAGE_3 = "../view/resources/ground/growthStage3.png";
    private static final String PATH_TO_HARVESTED = "../view/resources/ground/harvested.png";
    private static final String PATH_TO_PATH = "../view/resources/ground/path.png";
    private static final String PATH_TO_READY_FOR_SOWING = "../view/resources/ground/readyForSowing.png";
    private static final String PATH_TO_READY_TO_HARVEST = "../view/resources/ground/readyToHarvest.png";
    private static final String PATH_TO_BARN = "../view/resources/buildings/barn.png";
    private static final String PATH_TO_GAS_STATION = "../view/resources/buildings/gasStation.png";
    private static final String PATH_TO_LAND_TRADE = "../view/resources/buildings/landTrade.png";
    private static final String PATH_TO_SILO = "../view/resources/buildings/silo.png";


    protected Matchfield(){

    }

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

    private void fillWithGrassland(){
        for (int i = 0; i < NUMBER_COLUMNS; i++){
            for (int j = 0; j < NUMBER_ROWS; j++) {
                ImageView imageViewGrassland = new ImageView(getImage(PATH_TO_GRASSLANDS, false));
                addToGridPane(imageViewGrassland, i, j);
            }
        }
    }

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

    private void setField1(int stageOfGrowth){
        for (int i = 20; i < NUMBER_COLUMNS; i++){
            for (int j = 14; j < NUMBER_ROWS; j++) {
                ImageView imageViewField = getImageView(stageOfGrowth);
                addToGridPane(imageViewField, i, j);
            }
        }
    }

    private void setField2(int stageOfGrowth){
        for (int i = 9; i < 19; i++){
            for (int j = 14; j < NUMBER_ROWS; j++) {
                ImageView imageViewField = getImageView(stageOfGrowth);
                addToGridPane(imageViewField, i, j);
            }
        }
    }

    private void setField3(int stageOfGrowth){
        for (int i = 20; i < NUMBER_COLUMNS; i++){
            for (int j = 6; j < 13; j++) {
                ImageView imageViewField = getImageView(stageOfGrowth);
                addToGridPane(imageViewField, i, j);
            }
        }
    }

    private void addToGridPane(ImageView imageView, int column, int row){
        matchfield.setColumnIndex(imageView, column);
        matchfield.setRowIndex(imageView, row);
        matchfield.getChildren().add(imageView);
    }

    private void addToGridPane(ImageView imageView, int column, int column_span, int row, int row_span){
        matchfield.setColumnIndex(imageView, column);
        matchfield.setColumnSpan(imageView, column_span);
        matchfield.setRowIndex(imageView, row);
        matchfield.setRowSpan(imageView, row_span);
        matchfield.getChildren().add(imageView);
    }

    private Image getImage(String path, boolean preserveRatio){
        Image image = new ImageManager().getImage(path, TALE_WIDTH, TALE_HEIGHT, preserveRatio, false);
        return image;
    }

    private ImageView getImageView(int stageOfGrowth){
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
}
