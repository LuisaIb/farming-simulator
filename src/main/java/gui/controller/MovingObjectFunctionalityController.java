package gui.controller;

import gameboard.GameValue;
import gameboard.objects.*;
import gameboard.tiles.FieldTile;
import gameboard.tiles.Silo;
import gui.model.LSButton;
import gui.view.GameScene;
import gui.view.Matchfield;
import gui.view.SideControlPane;

public class MovingObjectFunctionalityController {
    private GameScene gameScene;
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

    public MovingObjectFunctionalityController(GameScene gameScene){
        this.gameScene = gameScene;
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
                                               Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill, FieldTile fieldTile,
                                               Silo silo) {
        if (column == 27 && row == 5 && farmer.isSelected() && !fieldTile.isOwningField3()) {
            buyField(gameValue, gameScene, fieldTile);
        } else if (column == 27 && row == 5) {
            sellGrain(dumpTruck, gameValue);
        } else if ((column == 14 || column == 15) && row == 5) {
            fillTank(gameValue, tractor, harvester);
        } else if ((column == 16 || column == 17) && row == 13) {
            selectVehicle(movingObject, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill);
            selectWorkingDevice(movingObject, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill);
        } else if (tractor.isSelected()){
            exitVehicle(movingObject, farmer, tractor, cultivator, dumpTruck, seedDrill);
        } else if(farmer.isSelected() && tractorExited && farmer.getX() == columnExited &&
                farmer.getY() == rowExited){
            enterVehicle(movingObject, farmer, tractor, cultivator, dumpTruck, seedDrill);
        } else if (harvester.isSelected() && column == columnToFillFromHarvester && row == rowToFillFromHarvester) {
            unloadToDumpTruck(harvester, dumpTruck);
        } else if ((column == 12 || column == 13) && row == 13 && dumpTruck.isSelected() && dumpTruck.getGrainFillLevel() != 0) {
            unloadToSilo(dumpTruck, silo);
        }
    }


    protected void selectVehicle(MovingObject movingObject, Farmer farmer, Tractor tractor, Harvester harvester,
                                 Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill){
        buttonAction.setOnMouseClicked(MouseEvent -> {
            farmerButton.setDisable(false);
            if (!tractorExited) {
                tractorButton.setDisable(false);
            }
            harvesterButton.setDisable(false);
        });


        farmerButton.setOnMouseClicked(mouseEvent -> {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(1));
            setMovingObjectToFarmer(movingObject, farmer);
            sideControlPane.setButtonsDisabled(true, false, false, false, false,
                    false);
            setMovingObjectsSelected(true, false, false, false,
                    false, false, farmer, tractor, harvester, cultivator, dumpTruck,
                    seedDrill);
            tractor.setAttachement(false);
        });

        harvesterButton.setOnMouseClicked(mouseEvent -> {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(3));
            setMovingObjectToHarvester(movingObject, harvester);
            sideControlPane.setButtonsDisabled(false, false, true, false, false, false);
            setMovingObjectsSelected(false, false, true, false,
                    false, false, farmer, tractor, harvester, cultivator, dumpTruck,
                    seedDrill);
            tractor.setAttachement(false);
        });
    }

    private void setMovingObjectsSelected(boolean farmerSelected, boolean tractorSelected, boolean harvesterSelected,
                                          boolean cultivatorSelected, boolean dumpTruckSelected, boolean seedDrillSelected,
                                          Farmer farmer, Tractor tractor, Harvester harvester, Cultivator cultivator,
                                          DumpTruck dumpTruck, SeedDrill seedDrill) {
        farmer.setSelected(farmerSelected);
        tractor.setSelected(tractorSelected);
        harvester.setSelected(harvesterSelected);
        cultivator.setSelected(cultivatorSelected);
        dumpTruck.setSelected(dumpTruckSelected);
        seedDrill.setSelected(seedDrillSelected);
    }

    protected void selectWorkingDevice(MovingObject movingObject, Farmer farmer, Tractor tractor, Harvester harvester,
                                       Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill){
        tractorButton.setOnMouseClicked(MouseEvent -> {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(2));
            setMovingObjectToTractor(movingObject, tractor);
            sideControlPane.setButtonsDisabled(false, true, false, true, true,
                    true);
            setMovingObjectsSelected(false, true, false, false,
                    false, false, farmer, tractor, harvester, cultivator, dumpTruck,
                    seedDrill);
            tractor.setAttachement(false);
        });

        cultivatorButton.setOnMouseClicked(mouseEvent -> {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(4));
            sideControlPane.setButtonsDisabled(false, true, false, true, false,
                    false);
            setMovingObjectsSelected(false, true, false, true,
                    false, false, farmer, tractor, harvester, cultivator, dumpTruck,
                    seedDrill);
            tractor.setAttachement(true);
        });

        dumpTruckButton.setOnMouseClicked(mouseEvent -> {
            if (dumpTruck.getGrainFillLevel() == 0) {
                matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(5));
            } else{
                matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(6));
            }
            sideControlPane.setButtonsDisabled(false, true, false, false, true,
                    false);
            setMovingObjectsSelected(false, true, false, false,
                    true, false, farmer, tractor, harvester, cultivator, dumpTruck,
                    seedDrill);
            tractor.setAttachement(true);
        });

        seedDrillButton.setOnMouseClicked(mouseEvent -> {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(7));
            sideControlPane.setButtonsDisabled(false, true, false, false, false,
                    true);
            setMovingObjectsSelected(false, true, false, false,
                    false, true, farmer, tractor, harvester, cultivator, dumpTruck,
                    seedDrill);
            tractor.setAttachement(true);
        });
    }

    protected void sellGrain(DumpTruck dumpTruck, GameValue gameValue) {
        buttonAction.setOnMouseClicked(mouseEvent -> {
            dumpTruck.sellingGrain(gameValue);
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(5));
        });
    }

    protected void buyField(GameValue gameValue, GameScene gameScene, FieldTile fieldTile){
        buttonAction.setOnMouseClicked(mouseEvent -> {
            fieldTile.buyField(gameValue, gameScene);
        });
    }

    protected void fillTank(GameValue gameValue, Tractor tractor, Harvester harvester) {
        buttonAction.setOnMouseClicked(mouseEvent -> {
            if (tractor.isSelected()) {
                tractor.fillTank(gameValue);
            }
            if (harvester.isSelected()) {
                harvester.fillTank(gameValue);
            }
        });
    }

    private void unloadToDumpTruck(Harvester harvester, DumpTruck dumpTruck){
        buttonAction.setOnMouseClicked(mouseEvent -> {
            harvester.unloadToDumpTruck(dumpTruck);
            exitedObject = 6;
            matchfield.getSecondMovingObjectImageView().setImage(matchfield.getTheRightImage(6));
        });
    }

    protected int getObjectExited(Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill){
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
        System.out.println(exitedVehicleX);
        exitedVehicleY = movingObject.getY();
        System.out.println(exitedVehicleY);
    }

    protected void exitVehicle(MovingObject movingObject, Farmer farmer, Tractor tractor, Cultivator cultivator, DumpTruck dumpTruck,
                               SeedDrill seedDrill){
        buttonAction.setOnMouseClicked(mouseEvent -> {
            int exitedObject = getObjectExited(cultivator, dumpTruck, seedDrill);
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
        setMovingObjectToFarmer(movingObject, farmer);
    }

    protected void enterVehicle(MovingObject movingObject, Farmer farmer, Tractor tractor, Cultivator cultivator,
                                DumpTruck dumpTruck, SeedDrill seedDrill){
        buttonAction.setOnMouseClicked(mouseEvent -> {
            removeSecondMovingObject(movingObject, farmer);
            changeBackToExitedVehicle(movingObject, tractor, cultivator, dumpTruck, seedDrill);
        });
    }

    private void removeSecondMovingObject(MovingObject movingObject, Farmer farmer){
        movingObject.getPlaces().remove(0);
        matchfield.deleteSecondImageView();
        farmer.setSelected(false);
        farmerButton.setDisable(true);
    }

    private void changeBackToExitedVehicle(MovingObject movingObject, Tractor tractor, Cultivator cultivator,
                                           DumpTruck dumpTruck, SeedDrill seedDrill){
        matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(exitedObject));
        matchfield.setTileOfObject(exitedVehicleX, exitedVehicleY);
        matchfield.getMovingObjectImageView().setRotate(rotation);
        tractor.setSelected(true);
        tractorButton.setDisable(false);
        tractorExited = false;
        if (exitedObject == 4){
            cultivator.setSelected(true);
            cultivatorButton.setDisable(false);
        } else if (exitedObject == 5 || exitedObject == 6){
            dumpTruck.setSelected(true);
            dumpTruckButton.setDisable(false);
        } else if (exitedObject == 7){
            seedDrill.setSelected(true);
            seedDrillButton.setDisable(false);
        }
        movingObject.setX(exitedVehicleX);
        movingObject.setY(exitedVehicleY);
        setMovingObjectToTractor(movingObject, tractor);
    }

    private void unloadToSilo(DumpTruck dumpTruck, Silo silo){
        dumpTruck.unloadToSilo(silo);
        if (dumpTruck.getGrainFillLevel() == 0) {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(5));
        }
    }

    private void setMovingObjectToFarmer(MovingObject movingObject, Farmer farmer){
        movingObject = farmer;
    }

    private void setMovingObjectToTractor(MovingObject movingObject, Tractor tractor) {
        movingObject = tractor;
    }

    private void setMovingObjectToHarvester(MovingObject movingObject, Harvester harvester){
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
