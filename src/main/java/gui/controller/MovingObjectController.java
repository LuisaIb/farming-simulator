package gui.controller;

import exceptions.MovingExcpetion;
import gameboard.GameValue;
import gameboard.objects.*;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.FieldTile;
import gameboard.tiles.Silo;
import gui.view.GameScene;
import gui.view.InformationBox;
import gui.view.Matchfield;
import gui.view.SideControlPane;

public class MovingObjectController {
    private GameScene gameScene;
    private MovingObject movingObject;
    private GameController gameController;
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
    private InformationBox informationBox;
    private Silo silo;
    private CourtTrade courtTrade;
    private MovingObjectFunctionalityController mofc;


    /**
     * @param gameScene
     * @param movingObject
     * @param gameController
     * @param gameValue
     * @param farmer
     * @param tractor
     * @param harvester
     * @param cultivator
     * @param dumpTruck
     * @param seedDrill
     * @param fieldTile
     */
    public MovingObjectController(GameScene gameScene, MovingObject movingObject, GameController gameController,
                                  GameValue gameValue, Farmer farmer, Tractor tractor, Harvester harvester,
                                  Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill, FieldTile fieldTile,
                                  Silo silo, CourtTrade courtTrade){
        this.gameScene = gameScene;
        this.movingObject = movingObject;
        this.gameController = gameController;
        this.gameValue = gameValue;
        this.farmer = farmer;
        this.tractor = tractor;
        this.harvester = harvester;
        this.cultivator = cultivator;
        this.dumpTruck = dumpTruck;
        this.seedDrill = seedDrill;
        this.fieldTile = fieldTile;
        this.silo = silo;
        this.courtTrade = courtTrade;
        this.matchfield = gameScene.getMatchfield();
        this.sideControlPane = gameScene.getSideControlPane();
        this.informationBox = gameScene.getInformationBox();
        initializeFunctionality();
    }

    /**
     * 
     */
    private void initializeFunctionality(){
        mofc = new MovingObjectFunctionalityController(gameScene);
    }


    /**
     * 
     */
    public void moveObject() {
        if (gameController.isRightPressed() && !gameController.isLeftPressed() &&
                !gameController.isUpPressed() && !gameController.isDownPressed()) {
            move('r');
        }
        if (gameController.isLeftPressed() && !gameController.isRightPressed() &&
                !gameController.isUpPressed() && !gameController.isDownPressed()) {
            move('l');
        }
        if (gameController.isUpPressed() && !gameController.isRightPressed() &&
                !gameController.isLeftPressed() && !gameController.isDownPressed()) {
           move('u');
        }
        if (gameController.isDownPressed() && !gameController.isRightPressed() &&
                !gameController.isLeftPressed() && !gameController.isUpPressed()) {
            move('d');
        }
    }

    /**
     * @param direction
     */
    private void move(char direction){
        rotate(direction);
        boolean moveSuccess = false;
        int newX = 0;
        int newY = 0;
        if (direction == 'r') {
            try {
                movingObject.moveRight(gameScene);
                moveSuccess = true;
                newX = matchfield.getColumnOfMovingObject()+1;
                newY = matchfield.getRowOfMovingObject();
            } catch (MovingExcpetion e) {

            }
        }
        if (direction == 'l') {
            try {
                movingObject.moveLeft(gameScene);
                moveSuccess = true;
                newX = matchfield.getColumnOfMovingObject()-1;
                newY = matchfield.getRowOfMovingObject();
            } catch (MovingExcpetion e) {

            }
        }
        if (direction == 'u') {
            try {
                movingObject.moveUp(gameScene);
                moveSuccess = true;
                newX = matchfield.getColumnOfMovingObject();
                newY = matchfield.getRowOfMovingObject()-1;
            } catch (MovingExcpetion e) {

            }
        }
        if (direction == 'd') {
            try {
                movingObject.moveDown(gameScene);
                moveSuccess = true;
                newX = matchfield.getColumnOfMovingObject();
                newY = matchfield.getRowOfMovingObject()+1;
            } catch (MovingExcpetion e) {

            }
        }

        if (moveSuccess) {
            movingSuccessful(newX, newY);
        }
    }

    /**
     * @param x
     * @param y
     */
    private void movingSuccessful(int x, int y){
        matchfield.setTileOfObject(x, y);
        if (tractor.isSelected()) {
            tractor.lowPetrolLevel(tractor.getPetrolTankFillLevel()-1, gameScene);
        }
        if (harvester.isSelected()) {
            harvester.lowPetrolLevel(harvester.getPetrolTankFillLevel()-1, gameScene);
        }
    }

    /**
     * @param direction
     */
    private void rotate(char direction){
        switch (direction) {
            case 'r':
                matchfield.getMovingObjectImageView().setRotate(270);
                break;
            case 'l':
                matchfield.getMovingObjectImageView().setRotate(90);
                break;
            case 'u':
                matchfield.getMovingObjectImageView().setRotate(180);
                break;
            case 'd':
                matchfield.getMovingObjectImageView().setRotate(0);
                break;
        }
    }

    /**
     * 
     */
    public void proofAction(){
        int x = movingObject.getX();
        int y = movingObject.getY();
        mofc.proofActionButtonFunctionality(x, y, movingObject, gameValue, farmer, tractor, harvester, cultivator,
                dumpTruck, seedDrill, fieldTile, silo, courtTrade);
        double rotation = gameScene.getMatchfield().getMovingObjectImageView().getRotate();

        if ((x == 16 || x == 17) && y == 13) {
            setButtonAction(false, "select vehicle");
        } else if (x == 27 && y == 5 && farmer.isSelected() && !fieldTile.isOwningField3()) {
            setButtonAction(false, "buy field");
        } else if (x == 27 && y == 5 && dumpTruck.isSelected() && dumpTruck.getGrainFillLevel() != 0) {
            setButtonAction(false, "sell grain");
        } else if((x == 14 || x == 15) && y == 5 && (tractor.isSelected() && tractor.getPetrolTankFillLevel() < 200
                || harvester.isSelected() && harvester.getPetrolTankFillLevel() < 200)) {
            setButtonAction(false, "fill tank");
        } else if ((x == 12 || x == 13) && y == 13 && dumpTruck.isSelected()) {
            if (dumpTruck.getGrainFillLevel() != 0) {
                setButtonAction(false, "unload");
            } else if (dumpTruck.getGrainFillLevel() != dumpTruck.getGrainTankCapacity()) {
                setButtonAction(false, "load");
            }
        } else if (tractor.isSelected() && ((rotation == 0 && movingObject.proofPassabilty(x+1, y)) ||
                rotation == 90 && movingObject.proofPassabilty(x, y+1) ||
                rotation == 180 && movingObject.proofPassabilty(x-1, y) ||
                rotation == 270 && movingObject.proofPassabilty(x, y-1))) {
            setButtonAction(false, "exit vehicle");
            if (tractor.isSelected() || !tractor.isAttachement()) {
                sideControlPane.getCultivatorButton().setDisable(true);
                sideControlPane.getDumpTruckButton().setDisable(true);
                sideControlPane.getSeedDrillButton().setDisable(true);
            }
        } else if (farmer.isSelected() && mofc.isTractorExited() &&
                x == mofc.getColumnExited() &&
                y == mofc.getRowExited()) {
            setButtonAction(false, "enter vehicle");
        } else if(harvester.isSelected() && harvester.getGrainTankFillLevel() != 0 &&
                (mofc.getExitedObject() == 5 || mofc.getExitedObject() == 6) &&
                mofc.getRotation() == matchfield.getMovingObjectImageView().getRotate() &&
                x == mofc.getColumnToFillFromHarvester() &&
                y == mofc.getRowToFillFromHarvester()) {
            setButtonAction(false, "unload");
        } else {
            setButtonAction(true, "");
            if (tractor.isSelected() || !tractor.isAttachement()) {
                sideControlPane.getCultivatorButton().setDisable(true);
                sideControlPane.getDumpTruckButton().setDisable(true);
                sideControlPane.getSeedDrillButton().setDisable(true);
            }
        }
    }

    /**
     * @param disabled
     * @param text
     */
    private void setButtonAction(boolean disabled, String text){
        gameScene.getSideControlPane().getButtonAction().setDisable(disabled);
        gameScene.getSideControlPane().getButtonAction().setText(text);
    }

    /**
     * 
     */
    public void proofFieldAction(){
        int x = movingObject.getX();
        int y = movingObject.getY();
        if (x > 19 && y > 13) {
            if (cultivator.isSelected() && fieldTile.getGrowthState() == 6) {
                fieldTile.cultivateField(gameScene.getMatchfield(), x, y, 1, gameScene.getInformationBox());
            }
            if (seedDrill.isSelected() && fieldTile.getGrowthState() == 1) {
                fieldTile.sowField(gameScene.getMatchfield(), x, y, 1, gameScene.getInformationBox());
            }
            if (harvester.isSelected() && fieldTile.getGrowthState() == 5) {
                fieldTile.harvestField(gameScene.getMatchfield(), x, y, 1, gameScene.getInformationBox(), harvester);
            }
        } else if(x > 8 && x < 19 && y > 13) {
            if (cultivator.isSelected() && fieldTile.getGrowthState2() == 6) {
                fieldTile.cultivateField(gameScene.getMatchfield(), x, y, 2, gameScene.getInformationBox());
            }
            if (seedDrill.isSelected() && fieldTile.getGrowthState2() == 1) {
                fieldTile.sowField(gameScene.getMatchfield(), x, y, 2, gameScene.getInformationBox());
            }
            if (harvester.isSelected() && fieldTile.getGrowthState2() == 5) {
                fieldTile.harvestField(gameScene.getMatchfield(), x, y, 2, gameScene.getInformationBox(), harvester);
            }
        } else if (x > 19 && y > 5 && y < 13) {
            if (cultivator.isSelected() && fieldTile.getGrowthState3() == 6) {
                fieldTile.cultivateField(gameScene.getMatchfield(), x, y, 3, gameScene.getInformationBox());
            }
            if (seedDrill.isSelected() && fieldTile.getGrowthState3() == 1) {
                fieldTile.sowField(gameScene.getMatchfield(), x, y, 3, gameScene.getInformationBox());
            }
            if (harvester.isSelected() && fieldTile.getGrowthState3() == 5) {
                fieldTile.harvestField(gameScene.getMatchfield(), x, y, 3, gameScene.getInformationBox(), harvester);
            }
        }
    }

}
