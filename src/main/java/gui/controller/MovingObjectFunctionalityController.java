package gui.controller;

import gameboard.GameValue;
import gameboard.objects.*;
import gameboard.tiles.FieldTile;
import gui.model.LSButton;
import gui.view.GameScene;
import gui.view.Matchfield;
import gui.view.SideControlPane;

public class MovingObjectFunctionalityController {
    private GameScene gameScene;
    private MovingObject movingObject;
    private GameValue gameValue;
    private Farmer farmer;
    private Tractor tractor;
    private Harvester harvester;
    private Cultivator cultivator;
    private DumpTruck dumpTruck;
    private SeedDrill seedDrill;
    private FieldTile fieldTile;
    private Matchfield matchfield;
    private SideControlPane sideControlPane;
    private LSButton buttonAction;
    private LSButton farmerButton;
    private LSButton tractorButton;
    private LSButton harvesterButton;
    private LSButton cultivatorButton;
    private LSButton dumpTruckButton;
    private LSButton seedDrillButton;



    private int columnExited;
    private int rowExited;
    private boolean tractorExited = false;
    private int exitedVehicleX;
    private int exitedVehicleY;
    private double rotation;
    private int exitedObject;

    public MovingObjectFunctionalityController(GameScene gameScene, MovingObject movingObject, GameValue gameValue,
                                               Farmer farmer, Tractor tractor, Harvester harvester,
                                               Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill,
                                               FieldTile fieldTile){
        this.gameScene = gameScene;
        this.movingObject = movingObject;
        this.gameValue = gameValue;
        this.farmer = farmer;
        this.tractor = tractor;
        this.harvester = harvester;
        this.cultivator = cultivator;
        this.dumpTruck = dumpTruck;
        this.seedDrill = seedDrill;
        this.fieldTile = fieldTile;
        matchfield = gameScene.getMatchfield();
        sideControlPane = gameScene.getSideControlPane();
        buttonAction = gameScene.getSideControlPane().getButtonAction();
        farmerButton = gameScene.getSideControlPane().getFarmerButton();
        tractorButton = gameScene.getSideControlPane().getTractorButton();
        harvesterButton = gameScene.getSideControlPane().getHarvesterButton();
        cultivatorButton = gameScene.getSideControlPane().getCultivatorButton();
        dumpTruckButton = gameScene.getSideControlPane().getDumpTruckButton();
        seedDrillButton = gameScene.getSideControlPane().getSeedDrillButton();
    }

    public void proofActionButtonFunctionality(int column, int row) {
        if (column == 27 && row == 5) {
            sellGrain();
        } else if (column == 27 && row == 5) {
            buyField();
        } else if ((column == 14 || column == 15) && row == 5) {
            fillTank();
        } else if ((column == 16 || column == 17) && row == 13) {
            selectVehicle();
            selectWorkingDevice();
        } else if (tractor.isSelected()){
            exitVehicle();
        } else if(farmer.isSelected() && tractorExited && farmer.getX() == columnExited &&
                farmer.getY() == rowExited){
            enterVehicle();
        }
    }


    protected void selectVehicle(){
        buttonAction.setOnMouseClicked(MouseEvent -> {
            farmerButton.setDisable(false);
            if (!tractorExited) {
                tractorButton.setDisable(false);
            }
            harvesterButton.setDisable(false);
        });


        farmerButton.setOnMouseClicked(mouseEvent -> {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(1));
            setMovingObjectToFarmer();
            sideControlPane.setButtonsDisabled(true, false, false, false, false, false);
            setMovingObjectsSelected(true, false, false, false, false, false);
            tractor.setAttachement(false);
        });

        harvesterButton.setOnMouseClicked(mouseEvent -> {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(3));
            setMovingObjectToHarvester();
            sideControlPane.setButtonsDisabled(false, false, true, false, false, false);
            setMovingObjectsSelected(false, false, true, false, false, false);
            tractor.setAttachement(false);
        });
    }

    private void setMovingObjectsSelected(boolean farmerSelected, boolean tractorSelected, boolean harvesterSelected,
                                          boolean cultivatorSelected, boolean dumpTruckSelected, boolean seedDrillSelected) {
        farmer.setSelected(farmerSelected);
        tractor.setSelected(tractorSelected);
        harvester.setSelected(harvesterSelected);
        cultivator.setSelected(cultivatorSelected);
        dumpTruck.setSelected(dumpTruckSelected);
        seedDrill.setSelected(seedDrillSelected);
    }

    protected void selectWorkingDevice(){
        tractorButton.setOnMouseClicked(MouseEvent -> {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(2));
            setMovingObjectToTractor();
            sideControlPane.setButtonsDisabled(false, true, false, true, true, true);
            setMovingObjectsSelected(false, true, false, false, false, false);
            tractor.setAttachement(false);
        });

        cultivatorButton.setOnMouseClicked(mouseEvent -> {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(4));
            sideControlPane.setButtonsDisabled(false, true, false, true, false, false);
            setMovingObjectsSelected(false, true, false, true, false, false);
            tractor.setAttachement(true);
        });

        dumpTruckButton.setOnMouseClicked(mouseEvent -> {
            if (dumpTruck.getGrainFillLevel() == 0) {
                matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(5));
            } else{
                matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(6));
            }
            sideControlPane.setButtonsDisabled(false, true, false, false, true, false);
            setMovingObjectsSelected(false, true, false, false, true, false);
            tractor.setAttachement(true);
        });

        seedDrillButton.setOnMouseClicked(mouseEvent -> {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(7));
            sideControlPane.setButtonsDisabled(false, true, false, false, false, true);
            setMovingObjectsSelected(false, true, false, false, false, true);
            tractor.setAttachement(true);
        });
    }

    protected void sellGrain() {
        buttonAction.setOnMouseClicked(mouseEvent -> {
            dumpTruck.unloadToCourtTrade(gameValue, dumpTruck.getGrainFillLevel());
        });
    }

    protected void buyField(){
        //Methode, um nächstes Feld zu kaufen
    }

    protected void fillTank() {
        buttonAction.setOnMouseClicked(mouseEvent -> {
            if (tractor.isSelected()) {
                // Methode zum Tanken
            }
            if (harvester.isSelected()) {
                // Methode zum Tanken
            }
        });
    }

    private int getObjectExited(){
        int selectedObject;
        if (cultivator.isSelected()) {
            selectedObject = 4;
            cultivatorButton.setDisable(true);
            cultivator.setSelected(false);
            exitedObject = 4;
        } else if (dumpTruck.isSelected()) {
            if (dumpTruck.getGrainFillLevel() == 0) {
                selectedObject = 5;
                exitedObject = 5;
            } else {
                selectedObject = 6;
                exitedObject = 6;
            }
            dumpTruckButton.setDisable(true);
            dumpTruck.setSelected(false);
        } else if (seedDrill.isSelected()) {
            selectedObject = 7;
            exitedObject = 7;
            seedDrillButton.setDisable(true);
            seedDrill.setSelected(false);
        } else {
            selectedObject = 2;
            exitedObject = 2;
        }
        return selectedObject;
    }

    private void setExitedIntegers(double rotation){
        if (rotation == 0) {
            columnExited = movingObject.getX()+1;
            rowExited = movingObject.getY();
        } else if (rotation == 90) {
            columnExited = movingObject.getX();
            rowExited = movingObject.getY()+1;
        } else if (rotation == 180) {
            columnExited = movingObject.getX()-1;
            rowExited = movingObject.getY();
        } else if (rotation == 270) {
            columnExited = movingObject.getX();
            rowExited = movingObject.getY()-1;
        }
        exitedVehicleX = movingObject.getX();
        exitedVehicleY = movingObject.getY();
    }

    protected void exitVehicle(){
        buttonAction.setOnMouseClicked(mouseEvent -> {
            int exitedObject = getObjectExited();
            rotation = matchfield.getMovingObjectImageView().getRotate();
            setExitedIntegers(rotation);
            initializeSecondMovingObject();
            changeToFarmerAfterExited();
        });
    }

    private void initializeSecondMovingObject(){
        matchfield.initializeSecondMovingObject(exitedObject, exitedVehicleX, exitedVehicleY);
        matchfield.getSecondMovingObjectImageView().setRotate(rotation);
        tractor.setSelected(false);
        tractorButton.setDisable(true);
        tractorExited = true;
        movingObject.getPlaces().add(0, exitedVehicleY*30+exitedVehicleX);
    }

    private void changeToFarmerAfterExited(){
        matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(1));
        matchfield.getMovingObjectImageView().setRotate(rotation);
        matchfield.setTileOfObject(columnExited, rowExited);
        farmer.setSelected(true);
        farmerButton.setDisable(false);
        movingObject.setX(columnExited);
        movingObject.setY(rowExited);
        setMovingObjectToFarmer();
    }

    protected void enterVehicle(){
        buttonAction.setOnMouseClicked(mouseEvent -> {
            removeSecondMovingObject();
            changeBackToExitedVehicle();
        });
    }

    private void removeSecondMovingObject(){
        movingObject.getPlaces().remove(0);
        matchfield.deleteSecondImageView();
        farmer.setSelected(false);
        farmerButton.setDisable(true);
    }

    private void changeBackToExitedVehicle(){
        matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(exitedObject));
        matchfield.setTileOfObject(exitedVehicleX, exitedVehicleY);
        matchfield.getMovingObjectImageView().setRotate(rotation);
        tractor.setSelected(true);
        tractorButton.setDisable(false);
        tractorExited = false;
        movingObject.setX(exitedVehicleX);
        movingObject.setY(exitedVehicleY);
        setMovingObjectToTractor();
    }

    private void setMovingObjectToFarmer(){
        int column = movingObject.getX();
        int row = movingObject.getY();
        movingObject = farmer;
        //farmer.setX(column);
        //farmer.setX(row);
    }

    private void setMovingObjectToTractor() {
        int column = movingObject.getX();
        int row = movingObject.getY();
        movingObject = tractor;
        tractor.setX(column);
        tractor.setY(row);
    }

    private void setMovingObjectToHarvester(){
        int column = movingObject.getX();
        int row = movingObject.getY();
        movingObject = harvester;
        harvester.setX(column);
        harvester.setY(row);
    }

    protected boolean isTractorExited(){
        return tractorExited;
    }

    protected int getColumnExited() {
        return columnExited;
    }

    protected int getRowExited() {
        return rowExited;
    }
}
