package gui.controller;

import gameboard.GameValue;
import gameboard.objects.*;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.FieldTile;
import gameboard.tiles.Silo;
import gui.model.LSButton;
import gui.view.GameScene;
import gui.view.Matchfield;
import gui.view.SideControlPane;

/**
 * This class implements all the actions that are possible when moving around e. g. selecting a vehicle, exiting and
 * entering or unload grain to the silo or sell it at the court trade.
 *
 * @author Judith
 */
public class MovingObjectFunctionalityController {
    /**
     * the actual GameScene object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private GameScene gameScene;
    /**
     * the actual Matchfield object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private Matchfield matchfield;
    /**
     * the actual SideControlPane object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private SideControlPane sideControlPane;
    // buttons that are needed to implement the functionality
    /**
     * the buttonAction of the actual SideControlPane object
     */
    private LSButton buttonAction;
    /**
     * the farmerButton of the actual SideControlPane object
     */
    private LSButton farmerButton;
    /**
     * the tractorButton of the actual SideControlPane object
     */
    private LSButton tractorButton;
    /**
     * the harvesterButton of the actual SideControlPane object
     */
    private LSButton harvesterButton;
    /**
     * the cultivatorButton of the actual SideControlPane object
     */
    private LSButton cultivatorButton;
    /**
     * the dumpTruckButton of the actual SideControlPane object
     */
    private LSButton dumpTruckButton;
    /**
     * the seedDrillButton of the actual SideControlPane object
     */
    private LSButton seedDrillButton;
    // column and row on the left side of the tractor in which the farmer exits and enters the tractor
    /**
     * integer to store the index of the column to which the farmer exited the tractor
     */
    private int columnExited;
    /**
     * integer to store the index of the row to which the farmer exited the tractor
     */
    private int rowExited;
    /**
     * boolean that stores the information if the farmer exited the tractor on the matchfield
     */
    private boolean tractorExited = false;
    // column and row on which the tractor is placed
    /**
     * integer to store on which column the exited tractor is placed
     */
    private int exitedVehicleX;
    /**
     * integer to store on which row the exited tractor is placed
     */
    private int exitedVehicleY;
    // rotation of the imageView of the movingObject
    /**
     * rotation of the image view if the exited tractor
     */
    private double rotation;
    /**
     * integer that stores the number of the exited object
     */
    private int exitedObject;
    // column and row on the right side of the tractor to unload the harvester to the dumpTruck
    /**
     * integer that stores the column on the right side of the exited tractor and that is needed to proof if the
     * harvester is standing on the correct side of the tractor
     */
    private int columnToFillFromHarvester;
    /**
     * integer that stores the row on the right side of the exited tractor and that is needed to proof if the harvester
     * is standing on the correct side of the tractor
     */
    private int rowToFillFromHarvester;

    /**
     * Constructor that initializes the variables of this class.
     *
     * @param gameScene the GameScene object of the actual game
     */
    protected MovingObjectFunctionalityController(GameScene gameScene){
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

    /**
     * This method check if an action is possible and calls it.
     *
     * @param column integer of the column on which the moving object is standing
     * @param row integer of the row on which the moving object is standing
     * @param movingObject the MovingObjet object of the actual game
     * @param gameValue the GameValue object of the actual game
     * @param farmer the Farmer object of the actual game
     * @param tractor the Tractor object of the actual game
     * @param harvester the Harvester object of the actual game
     * @param cultivator the Cultivator object of the actual game
     * @param dumpTruck the DumpTruck object of the actual game
     * @param seedDrill the SeedDrill object of the actual game
     * @param fieldTile the FieldTile object of the actual game
     * @param silo the Silo object of the actual game
     * @param courtTrade the CourtTrade object of the actual game
     */
    protected void proofActionButtonFunctionality(int column, int row, MovingObject movingObject, GameValue gameValue,
                                               Farmer farmer, Tractor tractor, Harvester harvester,
                                               Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill, FieldTile fieldTile,
                                               Silo silo, CourtTrade courtTrade) {
        if (column == 27 && row == 5 && farmer.isSelected() && !fieldTile.isOwningField3()) {
            buyField(gameValue, gameScene, fieldTile);
        } else if (column == 27 && row == 5) {
            sellGrain(dumpTruck, gameValue, courtTrade);
        }  else if ((column == 12 || column == 13) && row == 13 && dumpTruck.isSelected()) {
            if (dumpTruck.getGrainFillLevel() != 0) {
                unloadToSilo(dumpTruck, silo);
            } else if (dumpTruck.getGrainFillLevel() != dumpTruck.getGrainTankCapacity()) {
                loadFromSilo(dumpTruck, silo);
            }
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
        }
    }

    /**
     * This method implements the functionality to select a vehicle or go back to the farmer at the barn. Therefore, the
     * buttons on the pane on the right side are used. This method implements the functionality to choose the farmer or
     * the harvester.
     *
     * @param movingObject the MovingObject object of the actual game
     * @param farmer the Farmer object of the actual game
     * @param tractor the Tractor object of the actual game
     * @param harvester the Harvester object of the actual game
     * @param cultivator the Cultivator object of the actual game
     * @param dumpTruck the DumpTruck object of the actual game
     * @param seedDrill the SeedDtrill object of the actual game
     */
    private void selectVehicle(MovingObject movingObject, Farmer farmer, Tractor tractor, Harvester harvester,
                                 Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill){
        buttonAction.setOnMouseClicked(MouseEvent -> {
            // if the farmer exited the tractor he can not enter another tractor at the barn
            if (tractorExited) {
                sideControlPane.setButtonsDisabled(true, false, true, false,
                        false, false);
            } else {
                sideControlPane.setButtonsDisabled(true, true, true, false,
                        false, false);
            }
        });

        // the farmer is selected by clicking the button of the farmer
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

        // the harvester is selected by clicking the button of the harvester
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

    /**
     * This method implements the functionality to select a working device if the tractor is selected at the barn.
     * Therefore, the buttons on the pane on the right side are used. This method implements the functionality to
     * choose the tractor and one of the working devices.
     *
     * @param movingObject the MovingObject object of the actual game
     * @param farmer the Farmer object of the actual game
     * @param tractor the Tractor object of the actual game
     * @param harvester the Harvester object of the actual game
     * @param cultivator the Cultivator object of the actual game
     * @param dumpTruck the DumpTruck object of the actual game
     * @param seedDrill the SeedDrill object of the actual game
     */
    private void selectWorkingDevice(MovingObject movingObject, Farmer farmer, Tractor tractor, Harvester harvester,
                                       Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill){
        // the tractor is selected by clicking the button of the tractor which makes the buttons of the
        // working devices clickable
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

        // the cultivator is selected and attached by clicking the button of the cultivator
        cultivatorButton.setOnMouseClicked(mouseEvent -> {
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(4));
            sideControlPane.setButtonsDisabled(false, true, false, true, false,
                    false);
            setMovingObjectsSelected(false, true, false, true,
                    false, false, farmer, tractor, harvester, cultivator, dumpTruck,
                    seedDrill);
            tractor.setAttachement(true);
        });

        // the dumpTruck is selected and attached by clicking the button of the dumpTruck
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

        // the seedDrill is selected and attached by clicking the button of the seedDrill
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

    /**
     * This method helps to set the different objects selected or not selected.
     *
     * @param farmerSelected boolean that is true if the farmer is selected
     * @param tractorSelected boolean that is true if the tractor is selected
     * @param harvesterSelected boolean that is true if the harvester is selected
     * @param cultivatorSelected boolean that is true if the cultivator is selected
     * @param dumpTruckSelected boolean that is true if the dumpTruck is selected
     * @param seedDrillSelected boolean that is true if the seedDrill is selected
     * @param farmer the Farmer object of the actual game
     * @param tractor the Tractor object of the actual game
     * @param harvester the Harvester object of the actual game
     * @param cultivator the Cultivator object of the actual game
     * @param dumpTruck the DumpTruck object of the actual game
     * @param seedDrill the SeedDrill object of the actual game
     */
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

    /**
     * This method implements the functionality to sell grain at the courtTrade.
     *
     * @param dumpTruck the DumpTruck object of the actual game
     * @param gameValue the gameValue object of the actual game
     * @param courtTrade the CourtTrade object of the actual game
     */
    private void sellGrain(DumpTruck dumpTruck, GameValue gameValue, CourtTrade courtTrade) {
        buttonAction.setOnMouseClicked(mouseEvent -> {
            dumpTruck.sellingGrain(gameValue, courtTrade);
            // the image of the dumpTruck has to be changed to the empty image
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(5));
        });
    }

    /**
     * This method implements the functionality to buy a field at the courtTrade.
     *
     * @param gameValue the GameValue object of the actual game
     * @param gameScene the GameScene object of the actual game
     * @param fieldTile the FieldTile object of the actual game
     */
    private void buyField(GameValue gameValue, GameScene gameScene, FieldTile fieldTile){
        buttonAction.setOnMouseClicked(mouseEvent -> {
            fieldTile.buyField(gameValue, gameScene);
        });
    }

    /**
     * This method implements the functionality to fill the petrol tank of the tractor and the harvester at the
     * gasStation.
     *
     * @param gameValue the GameValue object of the actual game
     * @param tractor the Tractor object of the actual game
     * @param harvester the Harvester object of the actual game
     */
    private void fillTank(GameValue gameValue, Tractor tractor, Harvester harvester) {
        buttonAction.setOnMouseClicked(mouseEvent -> {
            if (tractor.isSelected()) {
                tractor.fillTank(gameValue);
            }
            if (harvester.isSelected()) {
                harvester.fillTank(gameValue);
            }
        });
    }

    /**
     * This method implements the functionality to unload the grain tank of the harvester to the dumpTruck.
     *
     * @param harvester the Harvester object of the actual game
     * @param dumpTruck the DumpTruck object of the actual game
     */
    private void unloadToDumpTruck(Harvester harvester, DumpTruck dumpTruck){
        buttonAction.setOnMouseClicked(mouseEvent -> {
            harvester.unloadToDumpTruck(harvester, dumpTruck);
            // set the exited object to six because the dumpTruck isn't empty anymore
            exitedObject = 6;
            matchfield.getSecondMovingObjectImageView().setImage(matchfield.getTheRightImage(6));
        });
    }

    /**
     * This method checks if a and which of the working devices is attached when exiting the tractor. Depending on that
     * it sets and returns an integer and sets the button of the working device disbaled and the working device itself
     * not selected anymore.
     *
     * @param cultivator the Cultivator object of the actual game
     * @param dumpTruck the DumpTruck object of the actual game
     * @param seedDrill the SeedDrill object of the actual game
     * @return an integer that is set depending on the attached working device
     */
    private int getObjectExited(Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill){
        int selectedObject;
        if (cultivator.isSelected()) {
            selectedObject = 4;
            cultivatorButton.setDisable(true);
            cultivator.setSelected(false);
            exitedObject = 4;
        } else if (dumpTruck.isSelected()) {
            if (dumpTruck.getGrainFillLevel() == 0) {
                // empty dumpTruck
                selectedObject = 5;
                exitedObject = 5;
            } else {
                // filled dumpTruck
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
            // no working device attached, only the tractor exited
            selectedObject = 2;
            exitedObject = 2;
        }
        return selectedObject;
    }

    /**
     * This method sets the variable columnExited and rowExited when exiting the tractor as well as the variables
     * exitedVehicleX and exitedVehicleY. As the farmer exits the tractor on the left side the column and the row to
     * which he exits depend on the direction.
     *
     * @param rotation rotation of the tractor
     * @param movingObject the MovingObject object of the actual game
     */
    private void setExitedIntegers(double rotation, MovingObject movingObject){
        if (rotation == 0) { // down
            columnExited = movingObject.getX()+1;
            rowExited = movingObject.getY();
        } else if (rotation == 90) { // left
            columnExited = movingObject.getX();
            rowExited = movingObject.getY()+1;
        } else if (rotation == 180) { // up
            columnExited = movingObject.getX()-1;
            rowExited = movingObject.getY();
        } else if (rotation == 270) { // right
            columnExited = movingObject.getX();
            rowExited = movingObject.getY()-1;
        }
        exitedVehicleX = movingObject.getX();
        exitedVehicleY = movingObject.getY();
    }

    /**
     * This method implements the functionality to exit the tractor.
     *
     * @param movingObject the MovingObject object of the actual game
     * @param farmer the Farmer object of the actual game
     * @param tractor the Tractor object of the actual game
     * @param cultivator the Cultivator object of the actual game
     * @param dumpTruck the DumpTruck object of the actual game
     * @param seedDrill the SeedDrill object of the actual game
     */
    private void exitVehicle(MovingObject movingObject, Farmer farmer, Tractor tractor, Cultivator cultivator, DumpTruck dumpTruck,
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

    /**
     * This method sets the variables columnToFillFromHarvester and rowToFillFromHarvester. As the harvester has to be
     * on the right side of the tractor the values integers are set depending on the direction the tractor is facing to.
     *
     * @param rotation rotation of the tractor
     * @param movingObject the MovingObject object of the actual game
     */
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

    /**
     * This method implements a second image view that holds the image of the exited tractor and eventually of the
     * attached working device.
     *
     * @param movingObject the MovingObject object of the actual game
     * @param tractor the Tractor object of the actual game
     */
    private void initializeSecondMovingObject(MovingObject movingObject,Tractor tractor){
        matchfield.initializeSecondMovingObject(exitedObject, exitedVehicleX, exitedVehicleY);
        matchfield.getSecondMovingObjectImageView().setRotate(rotation);
        tractor.setSelected(false);
        tractorButton.setDisable(true);
        tractorExited = true;
        // the tile on which the tractor is standing - the moving object can't move onto it anymore
        movingObject.getPlaces().add(0, exitedVehicleY*30+exitedVehicleX);
    }

    /**
     * This method helps to exit the tractor by changing the moving object back to the farmer. The farmer has to be
     * placed on the left side of the tractor and set selected.
     *
     * @param movingObject the MovingObject object of the actual game
     * @param farmer the Farmer object of the actual game
     */
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

    /**
     * This method implements the functionality to enter the tractor after exiting it.
     *
     * @param movingObject the MovingObject object of the actual game.
     * @param farmer the Farmer object of the actual game
     * @param tractor the Tractor object of the actual game
     * @param cultivator the Cultivator object of the actual game
     * @param dumpTruck the DumpTruck object of the actual game
     * @param seedDrill the SeedDrill object of the actual game
     */
    private void enterVehicle(MovingObject movingObject, Farmer farmer, Tractor tractor, Cultivator cultivator,
                                DumpTruck dumpTruck, SeedDrill seedDrill){
        buttonAction.setOnMouseClicked(mouseEvent -> {
            removeSecondMovingObject(movingObject, farmer);
            changeBackToExitedVehicle(movingObject, tractor, cultivator, dumpTruck, seedDrill);
        });
    }

    /**
     * This method removes the image view of the exited tractor and sets the farmer not selected anymore.
     *
     * @param movingObject the MovingObject object of the actual game
     * @param farmer the Farmer object of the actual game
     */
    private void removeSecondMovingObject(MovingObject movingObject, Farmer farmer){
        // the tile on which the exited tractor is standing is now passable again
        movingObject.getPlaces().remove(0);
        matchfield.deleteSecondImageView();
        farmer.setSelected(false);
        farmerButton.setDisable(true);
    }

    /**
     * This method helps to change from the farmer back to the exited tractor.
     *
     * @param movingObject the MovingObject object of the actual game
     * @param tractor the Tractor object of the actual game
     * @param cultivator the Cultivator object of the actual game
     * @param dumpTruck the DumpTruck object of the actual game
     * @param seedDrill the SeedDrill object of the actual game
     */
    private void changeBackToExitedVehicle(MovingObject movingObject, Tractor tractor, Cultivator cultivator,
                                           DumpTruck dumpTruck, SeedDrill seedDrill){
        matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(exitedObject));
        matchfield.setTileOfObject(exitedVehicleX, exitedVehicleY);
        matchfield.getMovingObjectImageView().setRotate(rotation);
        tractor.setSelected(true);
        tractorButton.setDisable(false);
        tractorExited = false;
        if (exitedObject == 4){ // cultivator
            cultivator.setSelected(true);
            cultivatorButton.setDisable(false);
        } else if (exitedObject == 5 || exitedObject == 6){ // dumpTruck - empty or nor
            dumpTruck.setSelected(true);
            dumpTruckButton.setDisable(false);
        } else if (exitedObject == 7){ // seedDrill
            seedDrill.setSelected(true);
            seedDrillButton.setDisable(false);
        }
        movingObject.setX(exitedVehicleX);
        movingObject.setY(exitedVehicleY);
        setMovingObjectToTractor(movingObject, tractor);
    }

    /**
     * This method implements the functionality to unload the dumpTruck to the silo.
     *
     * @param dumpTruck the DumpTruck object of the actual game
     * @param silo the Silo object of the actual game
     */
    private void unloadToSilo(DumpTruck dumpTruck, Silo silo){
        buttonAction.setOnMouseClicked(mouseEvent -> {
            dumpTruck.unloadToSilo(silo);
            if (dumpTruck.getGrainFillLevel() == 0) { // if the dumpTruck is now empty the image has to be changed
                matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(5));
            }
        });
    }

    /**
     * This method implements the functionality to load the dumpTruck from the silo.
     *
     * @param dumpTruck the DumpTruck object of the actual game
     * @param silo the Silo object of the actual game
     */
    private void loadFromSilo(DumpTruck dumpTruck, Silo silo) {
        buttonAction.setOnMouseClicked(mouseEvent -> {
            dumpTruck.loadFromSilo(silo);
            matchfield.getMovingObjectImageView().setImage(matchfield.getTheRightImage(6));
        });
    }

    /**
     * This method sets the movingObject to the farmer.
     *
     * @param movingObject the MovingObject object of the actual game
     * @param farmer the Farmer object of the actual game
     */
    private void setMovingObjectToFarmer(MovingObject movingObject, Farmer farmer){
        movingObject = farmer;
    }

    /**
     * This method sets the movingObject to the tractor.
     *
     * @param movingObject the MovingObject object of the actual game
     * @param tractor the Tractor object of the actual game
     */
    private void setMovingObjectToTractor(MovingObject movingObject, Tractor tractor) {
        movingObject = tractor;
    }

    /**
     * This method sets the movingObject to the Harvester.
     *
     * @param movingObject the MovingObject object of the actual game
     * @param harvester the Harvster object of the actual game
     */
    private void setMovingObjectToHarvester(MovingObject movingObject, Harvester harvester){
        movingObject = harvester;
    }

    /**
     * Getter for the boolean tractorExited.
     *
     * @return the requested boolean tractorExited
     */
    protected boolean isTractorExited(){
        return tractorExited;
    }

    /**
     * Getter for the integer columnExited.
     *
     * @return the requested integer columnExited
     */
    protected int getColumnExited() {
        return columnExited;
    }

    /**
     * Getter for the integer rowExited.
     *
     * @return the requested integer rowExited
     */
    protected int getRowExited() {
        return rowExited;
    }

    /**
     * Getter for the rotation of the tractor
     *
     * @return the requested rotation of the tractor
     */
    protected double getRotation(){
        return rotation;
    }

    /**
     * Getter for the integer columnToFillFromHarvester.
     *
     * @return the requested integer columnToFillFromHarvester
     */
    protected int getColumnToFillFromHarvester(){
        return columnToFillFromHarvester;
    }

    /**
     * Getter for the integer rowToFillFromHarvester.
     *
     * @return the requested integer rowToFillFromHarvester
     */
    protected int getRowToFillFromHarvester(){
        return rowToFillFromHarvester;
    }

    /**
     * Getter for the integer exitedObject.
     *
     * @return the requested integer exitedObject
     */
    protected int getExitedObject() {
        return exitedObject;
    }
}
