package gui.controller;

import gameboard.GameValue;
import gameboard.tiles.FieldTile;
import gui.view.GameScene;
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

    public void initGameLoop(GameScene gameScene, FieldTile fieldTile, GameValue gameValue,
                             MovingObjectController movingObjectController){
        gameTimer = new AnimationTimer() {
            private long lastUpdate = 0;
            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 100_000_000) {
                    movingObjectController.moveObject();
                    movingObjectController.proofAction();
                    movingObjectController.proofFieldAction();
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
        growthStageField1 = fieldTile.getGrowthState();
        growthStageField2 = fieldTile.getGrowthState2();
        growthSTageField3 = fieldTile.getGrowthState3();

            if (growthStageField1 > 1 && growthStageField1 < 5) {
                fieldCounter1++;
                if (fieldCounter1 == 50) {
                    growthStageField1++;
                    fieldTile.setGrowthState(growthStageField1);
                    for (int i = 855; i < 915; i++) {
                        gameScene.getMatchfield().getImageViewField1(i).setImage(gameScene.getMatchfield().getCorrectImageField(growthStageField1));
                    }
                    fieldCounter1 = 0;
                }

            }

            if (growthStageField2 > 1 && growthStageField2 < 5) {
                fieldCounter2++;
                if (fieldCounter2 == 50) {
                    growthStageField2++;
                    fieldTile.setGrowthState2(growthStageField2);
                    for (int i = 914; i < 977; i++) {
                        gameScene.getMatchfield().getImageViewField2(i).setImage(gameScene.getMatchfield().getCorrectImageField(growthStageField2));
                    }
                    fieldCounter2 = 0;
                }
            }


            if (growthSTageField3 > 1 && growthSTageField3 < 5) {
                fieldCounter3++;
                if (fieldCounter3 == 50) {
                    growthSTageField3++;
                    fieldTile.setGrowthState3(growthSTageField3);
                    for (int i = 977; i < 1045; i++) {
                        gameScene.getMatchfield().getImageViewField3(i).setImage(gameScene.getMatchfield().getCorrectImageField(growthSTageField3));
                    }
                    fieldCounter3 = 0;
                }
            }
    }

}
