package gui.controller;

import gameboard.GameValue;
import gameboard.objects.*;
import gameboard.tiles.FieldTile;
import gui.view.GameScene;
import gui.view.Matchfield;
import gui.view.SideControlPane;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameController {
    private AnimationTimer gameTimer;
    private boolean rightPressed;
    private boolean leftPressed;
    private boolean upPressed;
    private boolean downPressed;
    private int fieldCounter = 0;
    private int growthStageField1;
    private int growthStageField2;
    private int growthSTageField3;
    private int dayCounter = 0;
    private int actualObject;
    private int tractorCounter = 0;
    private int harvesterCounter = 0;


    public void setBooleansPressed(KeyEvent keyEvent){
        if (keyEvent.getCode().equals(KeyCode.D)) {
            rightPressed = true;
            System.out.println("right pressed");
        } else if (keyEvent.getCode().equals(KeyCode.A)){
            leftPressed = true;
            System.out.println("left pressed");
        } else if (keyEvent.getCode().equals(KeyCode.W)){
            upPressed = true;
            System.out.println("up pressed");
        } else if (keyEvent.getCode().equals(KeyCode.S)){
            downPressed = true;
            System.out.println("down pressed");
        }
    }

    public void setBooleansReleased(KeyEvent keyEvent){
        if (keyEvent.getCode().equals(KeyCode.D)) {
            rightPressed = false;
            System.out.println("right released");
        } else if (keyEvent.getCode().equals(KeyCode.A)){
            leftPressed = false;
            System.out.println("left released");
        } else if (keyEvent.getCode().equals(KeyCode.W)){
            upPressed = false;
            System.out.println("up released");
        } else if (keyEvent.getCode().equals(KeyCode.S)){
            downPressed = false;
            System.out.println("down released");
        }
    }

    public void initGameLoop(GameScene gameScene, FieldTile fieldTile, MovingObject movingObject, int selectedObject, GameValue gameValue, SideControlPane sideControlPane, Farmer farmer,
                            Tractor tractor, Harvester harvester, Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill){
        gameTimer = new AnimationTimer() {
            private long lastUpdate = 0;
            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 100_000_000) {
                    gameScene.moveObject(movingObject, tractor, harvester, gameScene);
                    proofAction(gameScene, movingObject, selectedObject, sideControlPane, farmer, tractor, harvester,
                            cultivator, dumpTruck, seedDrill, fieldTile, gameTimer);
                    lastUpdate = now;
                    DayCounter(gameValue);
                    proofFieldCounter(gameScene, fieldTile);
                }
            }
        };
        gameTimer.start();
    }

    private void DayCounter(GameValue gameValue) {
        dayCounter++;
        if (dayCounter == 50) {
            gameValue.setDay(gameValue.getDay()+1);
            System.out.println(gameValue.getDay());
            dayCounter = 0;
        }
    }

    private void proofFieldCounter(GameScene gameScene, FieldTile fieldTile){
        fieldCounter++;
        growthStageField1 = fieldTile.getGrowthState();
        growthStageField2 = fieldTile.getGrowthState2();
        growthSTageField3 = fieldTile.getGrowthState3();
        if (fieldCounter == 50) {
            if (growthStageField1 > 1 && growthStageField1 < 5) {
                growthStageField1++;
                fieldTile.setGrowthState(growthStageField1);
                for (int i = 855; i < 915; i++) {
                    gameScene.getMatchfield().getImageViewField1(i).setImage(gameScene.getMatchfield().getCorrectImageField(growthStageField1));
                }
            }
            if (growthStageField2 > 1 && growthStageField2 < 5) {
                fieldTile.setGrowthState2(growthStageField2+1);
            }
            if (growthSTageField3 > 1 && growthSTageField3 < 5) {
                fieldTile.setGrowthState3(growthSTageField3+1);
                gameScene.setField3(growthSTageField3+1);
            }
            fieldCounter = 0;
        }
    }


    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }

    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }


    private void proofAction(GameScene gameScene, MovingObject movingObject, int selectedObject, SideControlPane sideControlPane, Farmer farmer,
                            Tractor tractor, Harvester harvester, Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill, FieldTile fieldTile,
                             AnimationTimer gameTimer){
        int x = movingObject.getX();
        int y = movingObject.getY();
        createButtonActionFunctionality(sideControlPane, gameScene.getMatchfield(), farmer, tractor, harvester,
                cultivator, dumpTruck, seedDrill, x, y, fieldTile, movingObject, gameTimer);
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
        } else if (x > 19 && y > 13) {
            if (cultivator.isSelected() && fieldTile.getGrowthState() == 6) {
                fieldTile.cultivateField1(gameScene.getMatchfield(), x, y);
            }
            if (seedDrill.isSelected() && fieldTile.getGrowthState() == 1) {
                fieldTile.sowField1(gameScene.getMatchfield(), x, y);
            }
            if (harvester.isSelected() && fieldTile.getGrowthState() == 5) {
                fieldTile.harvestField1(gameScene.getMatchfield(), x, y);
            }
        } else if (tractor.isSelected() || harvester.isSelected()) {
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
    }

    private void createButtonActionFunctionality(SideControlPane sideControlPane, Matchfield matchfield, Farmer farmer,
                                                 Tractor tractor, Harvester harvester, Cultivator cultivator,
                                                 DumpTruck dumpTruck, SeedDrill seedDrill, int column, int row,
                                                 FieldTile fieldTile, MovingObject movingObject, AnimationTimer gameTimer){
        sideControlPane.createActionButtonFunctionality(matchfield, farmer, tractor, harvester, cultivator, dumpTruck,
                seedDrill, column, row, fieldTile, movingObject);
    }

}
