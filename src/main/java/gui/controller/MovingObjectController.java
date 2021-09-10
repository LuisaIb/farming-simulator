package gui.controller;

import exceptions.MovingExcpetion;
import gameboard.objects.MovingObject;
import gui.view.GameScene;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import simulator.Game;

public class MovingObjectController {
    private AnimationTimer gameTimer;
    private boolean rightPressed;
    private boolean leftPressed;
    private boolean upPressed;
    private boolean downPressed;
    MovingObject movingObject = new MovingObject();

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

    public void moveObject(GameScene gameScene) throws MovingExcpetion {
        if (rightPressed && !leftPressed && !upPressed && !downPressed) {
            System.out.println("Rechts ist jetzt als einzige Taste gedrückt?");
            movingObject.moveRight();
            System.out.println("moving right");
        }
        if (leftPressed && !rightPressed && !upPressed && !downPressed) {
            System.out.println("Links ist jetzt als einzige Taste gedrückt?");
            movingObject.moveLeft();
            System.out.println("moving left");
        }
        if (upPressed && !rightPressed && !leftPressed && !downPressed) {
            System.out.println("Hoch ist jetzt als einzige Taste gedrückt?");
            movingObject.moveUp();
            System.out.println("moving up");
        }
        if (downPressed && !rightPressed && !leftPressed && !upPressed) {
            System.out.println("Runter ist jetzt als einzige Taste gedrückt?");
            movingObject.moveDown();
            System.out.println("moving down");
        }
    }



    public void initGameLoop(GameScene gameScene){
        gameTimer = new AnimationTimer() {
            private long lastUpdate = 0;
            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 100_000_000) {
                    try {
                        moveObject(gameScene);
                        System.out.println("Rechts gedrückt: " + rightPressed);
                        System.out.println("Links gedrückt: " + leftPressed);
                        System.out.println("Hoch gedrückt: " + upPressed);
                        System.out.println("Runter gedrückt: " + downPressed);
                    } catch (MovingExcpetion e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        gameTimer.start();
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
}
