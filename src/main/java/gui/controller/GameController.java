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
    private int fieldCounter1 = 0;
    private int fieldCounter2 = 0;
    private int fieldCounter3 = 0;
    private int growthStageField1;
    private int growthStageField2;
    private int growthSTageField3;
    private int dayCounter = 0;


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

    /**
     * Setter for the boolean rightPressed.
     *
     * @param rightPressed a boolean value
     */
    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    /**
     * Setter for the boolean leftPressed.
     *
     * @param leftPressed a boolean value
     */
    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    /**
     * Setter for the boolean upPressed.
     *
     * @param upPressed a boolean value
     */
    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }

    /**
     * Setter for the boolean downPressed.
     *
     * @param downPressed a boolean value
     */
    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }

    /**
     * Getter for the boolean rightPressed.
     *
     * @return the requested value of rightPressed
     */
    public boolean isRightPressed() {
        return rightPressed;
    }

    /**
     * Getter for the boolean leftPressed.
     *
     * @return the requested value of leftPressed
     */
    public boolean isLeftPressed() {
        return leftPressed;
    }

    /**
     * Getter for the boolean upPressed.
     *
     * @return the requested value of upPressed
     */
    public boolean isUpPressed() {
        return upPressed;
    }

    /**
     * Getter for the boolean downPressed.
     *
     * @return the requested value of downPressed
     */
    public boolean isDownPressed() {
        return downPressed;
    }

    public void initGameLoop(GameScene gameScene, FieldTile fieldTile, MovingObject movingObject, int selectedObject,
                             GameValue gameValue, SideControlPane sideControlPane, Farmer farmer, Tractor tractor,
                             Harvester harvester, Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill,
                             GameController gameController, MovingObjectController movingObjectController){
        gameTimer = new AnimationTimer() {
            private long lastUpdate = 0;
            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 100_000_000) {
                    //gameScene.moveObject(movingObject, tractor, harvester, gameScene, gameController);
                    movingObjectController.moveObject(movingObject, tractor, harvester, gameScene,
                            gameScene.getGameController(), gameScene.getMatchfield());
                    proofAction(gameScene, movingObject, sideControlPane, farmer, tractor, harvester,
                            cultivator, dumpTruck, seedDrill, fieldTile, gameValue);
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
        fieldCounter1++;
        growthStageField1 = fieldTile.getGrowthState();
        growthStageField2 = fieldTile.getGrowthState2();
        growthSTageField3 = fieldTile.getGrowthState3();
        if (fieldCounter1 == 50) {
            if (growthStageField1 > 1 && growthStageField1 < 5) {
                growthStageField1++;
                fieldTile.setGrowthState(growthStageField1);
                for (int i = 855; i < 915; i++) {
                    gameScene.getMatchfield().getImageViewField1(i).setImage(gameScene.getMatchfield().getCorrectImageField(growthStageField1));
                }
            }

            if (growthStageField2 > 1 && growthStageField2 < 5) {
                growthStageField2++;
                fieldTile.setGrowthState2(growthStageField2);
                for (int i = 914; i < 977; i++) {
                    gameScene.getMatchfield().getImageViewField2(i).setImage(gameScene.getMatchfield().getCorrectImageField(growthStageField2));
                }
            }


            if (growthSTageField3 > 1 && growthSTageField3 < 5) {
                growthSTageField3++;
                fieldTile.setGrowthState3(growthSTageField3);
                for (int i = 977; i < 1045; i++) {
                    gameScene.getMatchfield().getImageViewField3(i).setImage(gameScene.getMatchfield().getCorrectImageField(growthSTageField3));
                }
            }

            fieldCounter1 = 0;
        }
    }

    private void proofAction(GameScene gameScene, MovingObject movingObject, SideControlPane sideControlPane,
                             Farmer farmer, Tractor tractor, Harvester harvester, Cultivator cultivator,
                             DumpTruck dumpTruck, SeedDrill seedDrill, FieldTile fieldTile, GameValue gameValue){
        int x = movingObject.getX();
        int y = movingObject.getY();
        createButtonActionFunctionality(sideControlPane, gameScene.getMatchfield(), farmer, tractor, harvester,
                cultivator, dumpTruck, seedDrill, x, y, fieldTile, movingObject, gameValue);
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

    private void createButtonActionFunctionality(SideControlPane sideControlPane, Matchfield matchfield, Farmer farmer,
                                                 Tractor tractor, Harvester harvester, Cultivator cultivator,
                                                 DumpTruck dumpTruck, SeedDrill seedDrill, int column, int row,
                                                 FieldTile fieldTile, MovingObject movingObject, GameValue gameValue){
        sideControlPane.createActionButtonFunctionality(matchfield, farmer, tractor, harvester, cultivator, dumpTruck,
                seedDrill, column, row, fieldTile, movingObject, gameValue);
    }

}
