package gui.controller;

import exceptions.MovingExcpetion;
import gameboard.objects.Harvester;
import gameboard.objects.MovingObject;
import gameboard.objects.Tractor;
import gui.view.GameScene;
import gui.view.Matchfield;

public class MovingObjectController {
    public void moveObject(MovingObject movingObject, Tractor tractor, Harvester harvester, GameScene gameScene,
                           GameController gameController, Matchfield matchfield) {
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

}
