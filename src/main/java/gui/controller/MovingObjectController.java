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
    }


    private void createButtonActionFunctionality(int column, int row){
        sideControlPane.createActionButtonFunctionality(matchfield, farmer, tractor, harvester, cultivator, dumpTruck,
                seedDrill, column, row, fieldTile, movingObject, gameValue);
    }


    public void moveObject() {
        if (gameController.isRightPressed() && !gameController.isLeftPressed() &&
                !gameController.isUpPressed() && !gameController.isDownPressed()) {
            System.out.println("Rechts ist jetzt als einzige Taste gedrückt?");
            try {
                if (matchfield.getMovingObjectImageView().getRotate() != 270) {
                    matchfield.getMovingObjectImageView().setRotate(270);
                }
                movingObject.moveRight(gameScene);
                matchfield.setTileOfObject(matchfield.getColumnOfMovingObject()+1, matchfield.getRowOfMovingObject());
                if (tractor.isSelected()) {
                    tractor.setPetrolTankFillLevel(tractor.getPetrolTankFillLevel()-1);
                }
                if (harvester.isSelected()) {
                    harvester.setPetrolTankFillLevel(tractor.getPetrolTankFillLevel()-1);
                }
            } catch (MovingExcpetion e) {

            }
            System.out.println("moving right");
        }
        if (gameController.isLeftPressed() && !gameController.isRightPressed() &&
                !gameController.isUpPressed() && !gameController.isDownPressed()) {
            System.out.println("Links ist jetzt als einzige Taste gedrückt?");
            try {
                if (matchfield.getMovingObjectImageView().getRotate() != 90) {
                    matchfield.getMovingObjectImageView().setRotate(90);
                }
                movingObject.moveLeft(gameScene);
                if (tractor.isSelected()) {
                    tractor.setPetrolTankFillLevel(tractor.getPetrolTankFillLevel()-1);
                }
                if (harvester.isSelected()) {
                    harvester.setPetrolTankFillLevel(tractor.getPetrolTankFillLevel()-1);
                }
                matchfield.setTileOfObject(matchfield.getColumnOfMovingObject()-1, matchfield.getRowOfMovingObject());
            } catch (MovingExcpetion e) {

            }
            System.out.println("moving left");
        }
        if (gameController.isUpPressed() && !gameController.isRightPressed() &&
                !gameController.isLeftPressed() && !gameController.isDownPressed()) {
            System.out.println("Hoch ist jetzt als einzige Taste gedrückt?");
            try {
                if (matchfield.getMovingObjectImageView().getRotate() != 180) {
                    matchfield.getMovingObjectImageView().setRotate(180);
                }
                movingObject.moveUp(gameScene);
                if (tractor.isSelected()) {
                    tractor.setPetrolTankFillLevel(tractor.getPetrolTankFillLevel()-1);
                }
                if (harvester.isSelected()) {
                    harvester.setPetrolTankFillLevel(tractor.getPetrolTankFillLevel()-1);
                }
                matchfield.setTileOfObject(matchfield.getColumnOfMovingObject(), matchfield.getRowOfMovingObject()-1);
            } catch (MovingExcpetion e) {

            }
            System.out.println("moving up");
        }
        if (gameController.isDownPressed() && !gameController.isRightPressed() &&
                !gameController.isLeftPressed() && !gameController.isUpPressed()) {
            System.out.println("Runter ist jetzt als einzige Taste gedrückt?");
            try {
                if (matchfield.getMovingObjectImageView().getRotate() != 0) {
                    matchfield.getMovingObjectImageView().setRotate(0);
                }
                movingObject.moveDown(gameScene);
                if (tractor.isSelected()) {
                    tractor.setPetrolTankFillLevel(tractor.getPetrolTankFillLevel()-1);
                }
                if (harvester.isSelected()) {
                    harvester.setPetrolTankFillLevel(tractor.getPetrolTankFillLevel()-1);
                }
                matchfield.setTileOfObject(matchfield.getColumnOfMovingObject(), matchfield.getRowOfMovingObject()+1);
            } catch (MovingExcpetion e) {

            }
            System.out.println("moving down");
        }
    }

    public void proofAction(){
        int x = movingObject.getX();
        int y = movingObject.getY();
        createButtonActionFunctionality(x, y);
        if ((x == 16 || x == 17) && y == 13) {
            gameScene.getSideControlPane().getButtonAction().setDisable(false);
            gameScene.getSideControlPane().getButtonAction().setText("select vehicle");
        } else if (x == 27 && y == 5 && farmer.isSelected()) {
            gameScene.getSideControlPane().getButtonAction().setDisable(false);
            gameScene.getSideControlPane().getButtonAction().setText("buy field");
        } else if (x == 27 && y == 5 && dumpTruck.isSelected()) {
            gameScene.getSideControlPane().getButtonAction().setDisable(false);
            gameScene.getSideControlPane().getButtonAction().setText("sell grain");
        } else if((x == 14 || x == 15) && y == 5 && (tractor.isSelected() || harvester.isSelected())) {
            gameScene.getSideControlPane().getButtonAction().setDisable(false);
            gameScene.getSideControlPane().getButtonAction().setText("fill tank");
        } else if (tractor.isSelected() &&
                ((gameScene.getMatchfield().getMovingObjectImageView().getRotate() == 0 && movingObject.proofPassabilty(x+1, y)) ||
                        gameScene.getMatchfield().getMovingObjectImageView().getRotate() == 90 && movingObject.proofPassabilty(x, y+1) ||
                        gameScene.getMatchfield().getMovingObjectImageView().getRotate() == 180 && movingObject.proofPassabilty(x-1, y) ||
                        gameScene.getMatchfield().getMovingObjectImageView().getRotate() == 270 && movingObject.proofPassabilty(x, y-1))) {
            gameScene.getSideControlPane().getButtonAction().setDisable(false);
            gameScene.getSideControlPane().getButtonAction().setText("exit vehicle");
            if (tractor.isSelected() || !tractor.isAttachement()) {
                sideControlPane.getCultivatorButton().setDisable(true);
                sideControlPane.getDumpTruckButton().setDisable(true);
                sideControlPane.getSeedDrillButton().setDisable(true);
            }
        } else if (farmer.isSelected() && gameScene.getSideControlPane().isTractorExited() &&
                farmer.getX() == gameScene.getSideControlPane().getColumnExitedVehicle() &&
                farmer.getY() == gameScene.getSideControlPane().getRowExitedVehicle()) {
            gameScene.getSideControlPane().getButtonAction().setDisable(false);
            gameScene.getSideControlPane().getButtonAction().setText("enter vehicle");
        } else {
            gameScene.getSideControlPane().getButtonAction().setDisable(true);
            gameScene.getSideControlPane().getButtonAction().setText("");
            if (tractor.isSelected() || !tractor.isAttachement()) {
                sideControlPane.getCultivatorButton().setDisable(true);
                sideControlPane.getDumpTruckButton().setDisable(true);
                sideControlPane.getSeedDrillButton().setDisable(true);
            }
        }
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
