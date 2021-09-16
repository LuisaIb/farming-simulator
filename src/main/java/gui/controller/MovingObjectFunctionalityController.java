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
    //private MovingObject movingObject;
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
    private int columnToFillFromHarvester;
    private int rowToFillFromHarvester;

    public MovingObjectFunctionalityController(GameScene gameScene, MovingObject movingObject, GameValue gameValue,
                                               Farmer farmer, Tractor tractor, Harvester harvester,
                                               Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill,
                                               FieldTile fieldTile){
        this.gameScene = gameScene;
        //this.movingObject = movingObject;
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

    public void proofActionButtonFunctionality(int column, int row, MovingObject movingObject, GameValue gameValue,
                                               Farmer farmer, Tractor tractor, Harvester harvester,
                                               Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill) {
        if (column == 27 && row == 5) {
            sellGrain(dumpTruck, gameValue);
        } else if (column == 27 && row == 5) {
            buyField();
        } else if ((column == 14 || column == 15) && row == 5) {
            fillTank();
        } else if ((column == 16 || column == 17) && row == 13) {
            selectVehicle(movingObject);
            selectWorkingDevice(movingObject);
        } else if (tractor.isSelected()){
            exitVehicle(movingObject, tractor, cultivator, dumpTruck, seedDrill);
        } else if(farmer.isSelected() && tractorExited && farmer.getX() == columnExited &&
                farmer.getY() == rowExited){
            enterVehicle(movingObject);
        } else if (harvester.isSelected() && column == columnToFillFromHarvester && row == rowToFillFromHarvester) {
            unloadToDumpTruck();
        }
    }


    protected void selectVehicle(MovingObject movingObject){
        buttonAction.setOnMouseClicked(MouseEvent -> {
            farmerButton.setDisable(false);
            if (!tractorExited) {
                tractorButton.setDisable(false);
            }
            harvesterButton.setDisable(false);
        });


        farmerButton.setOnMouseClicked(mouseEvent -> {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(1));
            setMovingObjectToFarmer(movingObject);
            sideControlPane.setButtonsDisabled(true, false, false, false, false, false);
            setMovingObjectsSelected(true, false, false, false, false, false);
            tractor.setAttachement(false);
        });

        harvesterButton.setOnMouseClicked(mouseEvent -> {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(3));
            setMovingObjectToHarvester(movingObject);
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

    protected void selectWorkingDevice(MovingObject movingObject){
        tractorButton.setOnMouseClicked(MouseEvent -> {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(2));
            setMovingObjectToTractor(movingObject);
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

    protected void sellGrain(DumpTruck dumpTruck, GameValue gameValue) {
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

    private void unloadToDumpTruck(){
        buttonAction.setOnMouseClicked(mouseEvent -> {
            //entsprechende Methode aufrufen
            System.out.println("unloaded to dump truck");
            exitedObject = 6;
            matchfield.getSecondMovingObjectImageView().setImage(matchfield.getTheRightImage(6));
        });
    }

    protected int getObjectExited(Tractor tractor, Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill){
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

    private void setExitedIntegers(double rotation, MovingObject movingObject){
        if (rotation == 0) {
            System.out.println("moving object x in setExitedIntegers" + movingObject.getX());
            System.out.println("moving object y in setExitedIntegers" + movingObject.getY());
            columnExited = movingObject.getX()+1;
            rowExited = movingObject.getY();
        } else if (rotation == 90) {
            System.out.println("moving object x in setExitedIntegers" + movingObject.getX());
            System.out.println("moving object y in setExitedIntegers" + movingObject.getY());
            columnExited = movingObject.getX();
            rowExited = movingObject.getY()+1;
        } else if (rotation == 180) {
            System.out.println("moving object x in setExitedIntegers" + movingObject.getX());
            System.out.println("moving object y in setExitedIntegers" + movingObject.getY());
            columnExited = movingObject.getX()-1;
            rowExited = movingObject.getY();
        } else if (rotation == 270) {
            System.out.println("moving object x in setExitedIntegers" + movingObject.getX());
            System.out.println("moving object y in setExitedIntegers" + movingObject.getY());
            columnExited = movingObject.getX();
            rowExited = movingObject.getY()-1;
        }
        exitedVehicleX = movingObject.getX();
        System.out.println(exitedVehicleX);
        exitedVehicleY = movingObject.getY();
        System.out.println(exitedVehicleY);
    }

    protected void exitVehicle(MovingObject movingObject, Tractor tractor, Cultivator cultivator, DumpTruck dumpTruck,
                               SeedDrill seedDrill){
        buttonAction.setOnMouseClicked(mouseEvent -> {
            int exitedObject = getObjectExited(tractor, cultivator, dumpTruck, seedDrill);
            rotation = matchfield.getMovingObjectImageView().getRotate();
            setExitedIntegers(rotation, movingObject);
            setIntegersToFillFromHarvester(rotation, movingObject);
            initializeSecondMovingObject(movingObject, tractor);
            changeToFarmerAfterExited(movingObject, farmer);
        });
    }

    private void setIntegersToFillFromHarvester(double rotation, MovingObject movingObject){
        if (rotation == 0) {
            columnToFillFromHarvester = movingObject.getX()-1;
            rowToFillFromHarvester = movingObject.getY();
        } else if (rotation == 90) {
            columnToFillFromHarvester = movingObject.getX();
            rowToFillFromHarvester = movingObject.getY()-1;
        } else if (rotation == 180) {
            columnToFillFromHarvester = movingObject.getX()+1;
            rowToFillFromHarvester = movingObject.getY();
        } else if (rotation == 270) {
            columnToFillFromHarvester = movingObject.getX();
            rowToFillFromHarvester = movingObject.getY()+1;
        }
    }

    private void initializeSecondMovingObject(MovingObject movingObject,Tractor tractor){
        matchfield.initializeSecondMovingObject(exitedObject, exitedVehicleX, exitedVehicleY);
        matchfield.getSecondMovingObjectImageView().setRotate(rotation);
        tractor.setSelected(false);
        tractorButton.setDisable(true);
        tractorExited = true;
        movingObject.getPlaces().add(0, exitedVehicleY*30+exitedVehicleX);
    }

    private void changeToFarmerAfterExited(MovingObject movingObject, Farmer farmer){
        matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(1));
        matchfield.getMovingObjectImageView().setRotate(rotation);
        matchfield.setTileOfObject(columnExited, rowExited);
        farmer.setSelected(true);
        farmerButton.setDisable(false);
        movingObject.setX(columnExited);
        movingObject.setY(rowExited);
        setMovingObjectToFarmer(movingObject);
    }

    protected void enterVehicle(MovingObject movingObject){
        buttonAction.setOnMouseClicked(mouseEvent -> {
            removeSecondMovingObject(movingObject);
            changeBackToExitedVehicle(movingObject);
        });
    }

    private void removeSecondMovingObject(MovingObject movingObject){
        movingObject.getPlaces().remove(0);
        matchfield.deleteSecondImageView();
        farmer.setSelected(false);
        farmerButton.setDisable(true);
    }

    private void changeBackToExitedVehicle(MovingObject movingObject){
        matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(exitedObject));
        matchfield.setTileOfObject(exitedVehicleX, exitedVehicleY);
        matchfield.getMovingObjectImageView().setRotate(rotation);
        tractor.setSelected(true);
        tractorButton.setDisable(false);
        tractorExited = false;
        movingObject.setX(exitedVehicleX);
        movingObject.setY(exitedVehicleY);
        setMovingObjectToTractor(movingObject);
    }

    private void setMovingObjectToFarmer(MovingObject movingObject){
        movingObject = farmer;
    }

    private void setMovingObjectToTractor(MovingObject movingObject) {
        movingObject = tractor;
    }

    private void setMovingObjectToHarvester(MovingObject movingObject){
        movingObject = harvester;
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

    protected double getRotation(){
        return rotation;
    }

    protected int getColumnToFillFromHarvester(){
        return columnToFillFromHarvester;
    }

    protected int getRowToFillFromHarvester(){
        return rowToFillFromHarvester;
    }

    protected int getExitedObject() {
        return exitedObject;
    }
}
