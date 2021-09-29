package gui.controller;

import gameboard.GameValue;
import gameboard.tiles.FieldTile;
import gui.view.GameScene;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * This class implements a timer that enables the player to move around, counts the days and makes the fields grow with
 * timer. To move around it proofs, if right, left, up or down is pressed and as long one of these directions is pressed
 * the moving object moves around. The pressed booleans are set in the gameScene.
 *
 * @author Judith
 */
public class GameController {
    // booleans that are needed for moving around
    /**
     * boolean for moving around to check if right is pressed
     */
    private boolean rightPressed;
    /**
     * boolean for moving around to check if left is pressed
     */
    private boolean leftPressed;
    /**
     * boolean for moving around to check if up is pressed
     */
    private boolean upPressed;
    /**
     * boolean for moving around to check if down is pressed
     */
    private boolean downPressed;
    // field counters for growing - as each field starts to grow at a different time we need three of them, one for each
    // field
    /**
     * integer for counting how much time has passed to implement the growing of field 1
     */
    private int fieldCounter1 = 0;
    /**
     * integer for counting how much time has passed to implement the growing of field 2
     */
    private int fieldCounter2 = 0;
    /**
     * integer for counting how much time has passed to implement the growing of field 3
     */
    private int fieldCounter3 = 0;
    // counter for the day in the game
    /**
     * inter for counting how much time has passed to implement the increasing of the day
     */
    private int dayCounter = 0;

    /**
     * This method sets right, left, up or down pressed if the correct key on the keyboard is pressed.
     *
     * @param keyEvent the key that is pressed on the keyboard
     */
    public void setBooleansPressed(KeyEvent keyEvent){
        // checking, if D for right, A for left, W for up or S for down is pressed
        if (keyEvent.getCode().equals(KeyCode.D)) {
            rightPressed = true;
        } else if (keyEvent.getCode().equals(KeyCode.A)){
            leftPressed = true;
        } else if (keyEvent.getCode().equals(KeyCode.W)){
            upPressed = true;
        } else if (keyEvent.getCode().equals(KeyCode.S)){
            downPressed = true;
        }
    }

    /**
     * This method sets right, left up or down released if the key on the keyboard is released.
     *
     * @param keyEvent the key on the keyboard that is released
     */
    public void setBooleansReleased(KeyEvent keyEvent){
        // setting the booleans to false for stopping to move around
        if (keyEvent.getCode().equals(KeyCode.D)) {
            rightPressed = false;
        } else if (keyEvent.getCode().equals(KeyCode.A)){
            leftPressed = false;
        } else if (keyEvent.getCode().equals(KeyCode.W)){
            upPressed = false;
        } else if (keyEvent.getCode().equals(KeyCode.S)){
            downPressed = false;
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

    /**
     * This method implements the timer and with every 100 milliseconds it calls the methods moveObject(), proofAction(),
     * and proofFieldAction() from the class movingObjectController. It also calls the methods dayCounter, that
     * increases the day, and proofFieldCounter() that makes the fields grow.
     *
     * @param gameScene the gameScene object of the actual game
     * @param fieldTile the fieldTile object of the actual game
     * @param gameValue the gameValue object of the actual game
     * @param movingObjectController the movingObjectController of the actual game
     */
    public void initGameLoop(GameScene gameScene, FieldTile fieldTile, GameValue gameValue,
                             MovingObjectController movingObjectController){
        AnimationTimer gameTimer = new AnimationTimer() {
            // local variable to proof the last update in the timer
            private long lastUpdate = 0;
            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 100_000_000) {
                    // methods for moving around, proofing actions when moving around and to process the fields
                    movingObjectController.moveObject();
                    movingObjectController.proofAction();
                    movingObjectController.proofFieldAction();
                    // methods for the day and growing of the fields
                    dayCounter(gameValue);
                    proofFieldCounter(gameScene, fieldTile);
                    lastUpdate = now;
                }
            }
        };
        gameTimer.start();
    }

    /**
     * Everytime this method is called it increments the int dayCounter and if dayCounter reaches 100 it increases the
     * day.
     *
     * @param gameValue the gameValue object of the actual game
     */
    private void dayCounter(GameValue gameValue) {
        dayCounter++;
        if (dayCounter == 100) {
            gameValue.setDay(gameValue.getDay()+1);
            dayCounter = 0;
        }
    }

    /**
     * This method proofs, if the state of growth of all three fields. If it is bigger than one it starts a counter
     * and every time the method is called it increments it. If the counter reaches 500 it
     *
     * @param gameScene the gameScene object of the actual game
     * @param fieldTile the fieldTile object of the actual game
     */
    private void proofFieldCounter(GameScene gameScene, FieldTile fieldTile){
        int growthStateField1 = fieldTile.getGrowthState();
        int growthStateField2 = fieldTile.getGrowthState2();
        int growthStateField3 = fieldTile.getGrowthState3();

        // growing of field 1
        if (growthStateField1 > 1 && growthStateField1 < 5) {
            fieldCounter1++;
            if (fieldCounter1 == 500) {
                growthStateField1++;
                fieldTile.setGrowthState(growthStateField1, gameScene.getInformationBox());
                // indexes of the image on the grid pane
                for (int i = 855; i < 915; i++) {
                    gameScene.getMatchfield().getImageViewField1(i).setImage(gameScene.getMatchfield().getCorrectImageField(growthStateField1));
                }
                fieldCounter1 = 0;
            }
        }

        // growing of field 2
        if (growthStateField2 > 1 && growthStateField2 < 5) {
            fieldCounter2++;
            if (fieldCounter2 == 500) {
                growthStateField2++;
                fieldTile.setGrowthState2(growthStateField2, gameScene.getInformationBox());
                // indexes of the image on the grid pane
                for (int i = 915; i < 975; i++) {
                    gameScene.getMatchfield().getImageViewField2(i).setImage(gameScene.getMatchfield().getCorrectImageField(growthStateField2));
                }
                fieldCounter2 = 0;
            }
        }

        // growing of field 3
        if (growthStateField3 > 1 && growthStateField3 < 5) {
            fieldCounter3++;
            if (fieldCounter3 == 500) {
                growthStateField3++;
                fieldTile.setGrowthState3(growthStateField3, gameScene.getInformationBox());
                // indexes of the image on the grid pane
                for (int i = 975; i < 1045; i++) {
                    gameScene.getMatchfield().getImageViewField3(i).setImage(gameScene.getMatchfield().getCorrectImageField(growthStateField3));
                }
                fieldCounter3 = 0;
            }
        }
    }
}
