package gui.controller;

import exceptions.MovingExcpetion;
import gameboard.GameValue;
import gameboard.objects.*;
import gameboard.tiles.FieldTile;
import gui.view.GameScene;
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
    private MovingObjectFunctionalityController movingObjectFunctionalityController;


    public MovingObjectController(GameScene gameScene, MovingObject movingObject, GameController gameController,
                                  GameValue gameValue, Farmer farmer, Tractor tractor, Harvester harvester,
                                  Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill, FieldTile fieldTile){
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
        this.matchfield = gameScene.getMatchfield();
        this.sideControlPane = gameScene.getSideControlPane();
        initializeFunctionality();
    }

    private void initializeFunctionality(){
        movingObjectFunctionalityController = new MovingObjectFunctionalityController(gameScene, movingObject,
                gameValue, farmer, tractor, harvester, cultivator, dumpTruck, seedDrill, fieldTile);
    }


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

    private void movingSuccessful(int x, int y){
        matchfield.setTileOfObject(x, y);
        if (tractor.isSelected()) {
            tractor.setPetrolTankFillLevel(tractor.getPetrolTankFillLevel()-1);
        }
        if (harvester.isSelected()) {
            harvester.setPetrolTankFillLevel(tractor.getPetrolTankFillLevel()-1);
        }
    }

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

    public void proofAction(){
        int x = movingObject.getX();
        int y = movingObject.getY();
        movingObjectFunctionalityController.proofActionButtonFunctionality(x, y);
        if ((x == 16 || x == 17) && y == 13) {
            setButtonAction(false, "select vehicle");
        } else if (x == 27 && y == 5 && farmer.isSelected()) {
            setButtonAction(false, "buy field");
        } else if (x == 27 && y == 5 && dumpTruck.isSelected() && dumpTruck.getGrainFillLevel() != 0) {
            setButtonAction(false, "sell grain");
        } else if((x == 14 || x == 15) && y == 5 && (tractor.isSelected() && tractor.getPetrolTankFillLevel() < 150
                || harvester.isSelected() && harvester.getPetrolTankFillLevel() < 50)) {
            setButtonAction(false, "fill tank");
        } else if (tractor.isSelected() &&
                ((gameScene.getMatchfield().getMovingObjectImageView().getRotate() == 0 && movingObject.proofPassabilty(x+1, y)) ||
                        gameScene.getMatchfield().getMovingObjectImageView().getRotate() == 90 && movingObject.proofPassabilty(x, y+1) ||
                        gameScene.getMatchfield().getMovingObjectImageView().getRotate() == 180 && movingObject.proofPassabilty(x-1, y) ||
                        gameScene.getMatchfield().getMovingObjectImageView().getRotate() == 270 && movingObject.proofPassabilty(x, y-1))) {
            setButtonAction(false, "exit vehicle");
            if (tractor.isSelected() || !tractor.isAttachement()) {
                sideControlPane.getCultivatorButton().setDisable(true);
                sideControlPane.getDumpTruckButton().setDisable(true);
                sideControlPane.getSeedDrillButton().setDisable(true);
            }
        } else if (farmer.isSelected() && movingObjectFunctionalityController.isTractorExited() &&
                farmer.getX() == movingObjectFunctionalityController.getColumnExited() &&
                farmer.getY() == movingObjectFunctionalityController.getRowExited()) {
            setButtonAction(false, "enter vehicle");
        } else {
            setButtonAction(true, "");
            if (tractor.isSelected() || !tractor.isAttachement()) {
                sideControlPane.getCultivatorButton().setDisable(true);
                sideControlPane.getDumpTruckButton().setDisable(true);
                sideControlPane.getSeedDrillButton().setDisable(true);
            }
        }

    }

    private void setButtonAction(boolean disabled, String text){
        gameScene.getSideControlPane().getButtonAction().setDisable(disabled);
        gameScene.getSideControlPane().getButtonAction().setText(text);
    }

    public void proofFieldAction(){
        int x = movingObject.getX();
        int y = movingObject.getY();
        if (x > 19 && y > 13) {
            if (cultivator.isSelected() && fieldTile.getGrowthState() == 6) {

                fieldTile.cultivateField(gameScene.getMatchfield(), x, y, 1);
            }
            if (seedDrill.isSelected() && fieldTile.getGrowthState() == 1) {
                fieldTile.sowField(gameScene.getMatchfield(), x, y, 1);
            }
            if (harvester.isSelected() && fieldTile.getGrowthState() == 5) {
                fieldTile.harvestField(gameScene.getMatchfield(), x, y, 1);
            }
        } else if(x > 8 && x < 19 && y > 13) {
            if (cultivator.isSelected() && fieldTile.getGrowthState2() == 6) {
                fieldTile.cultivateField(gameScene.getMatchfield(), x, y, 2);
            }
            if (seedDrill.isSelected() && fieldTile.getGrowthState2() == 1) {
                fieldTile.sowField(gameScene.getMatchfield(), x, y, 2);
            }
            if (harvester.isSelected() && fieldTile.getGrowthState2() == 5) {
                fieldTile.harvestField(gameScene.getMatchfield(), x, y, 2);
            }
        } else if (x > 19 && y > 5 && y < 13) {
            if (cultivator.isSelected() && fieldTile.getGrowthState3() == 6) {
                fieldTile.cultivateField(gameScene.getMatchfield(), x, y, 3);
            }
            if (seedDrill.isSelected() && fieldTile.getGrowthState3() == 1) {
                fieldTile.sowField(gameScene.getMatchfield(), x, y, 3);
            }
            if (harvester.isSelected() && fieldTile.getGrowthState3() == 5) {
                fieldTile.harvestField(gameScene.getMatchfield(), x, y, 3);
            }
        }
    }

}
