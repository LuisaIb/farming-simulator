package gui.view;

import exceptions.MovingExcpetion;
import gameboard.objects.Harvester;
import gameboard.objects.MovingObject;
import gameboard.objects.Tractor;
import gui.controller.GameController;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import simulator.Game;

import static gui.view.ViewManager.HEIGHT;
import static gui.view.ViewManager.WIDTH;

/**
 * This class implements the game scene. It consists of a gridpane for the matchfield, a pane on the right side with
 * buttons for moving around the field and choosing the machine / farmer and a vertical box with all the necessary
 * information the player should see during playing.
 *
 * @author Judith Romer
 */
public class GameScene {
    private Pane gamePane;
    private Scene gameScene;
    Matchfield matchfield;
    GameController gameController;
    MovingObject movingObject = new MovingObject();
    InformationBox informationBox;
    SideControlPane sideControlPane;

    /**
     * This method implements all the Nodes for the game scene with the help of the other classes InformationBox,
     * Matchfield, MovingObjectOnMatchfield and SideControlPane.
     *
     * @param farmer - hands the boolean to the method initializeSideControlPane()
     * @param tractor - hands the boolean to the method initializeSideControlPane()
     * @param harvester - hands the boolean to the method initializeSideControlPane()
     * @param cultivator - hands the boolean to the method initializeSideControlPane()
     * @param dumpTruck - hands the boolean to the method initializeSideControlPane()
     * @param seedDrill - hands the boolean to the method initializeSideControlPane()
     * @param stageOfGrowthField1 - hands the integer to the method initializeMatchfield()
     * @param stageOfGrowthField2 - hands the integer to the method initializeMatchfield()
     * @param stageOfGrowthField3 - hands the integer to the method initializeMatchfield()
     * @param selectedObject - integer of the selected moving object that is shown on the matchfield
     * @param column - index of the column to which the image view is set
     * @param row - index of the column to which the image view is set
     */
    public void initializeGameScene(boolean farmer, boolean tractor, boolean harvester, boolean cultivator,
                                       boolean dumpTruck, boolean seedDrill, int stageOfGrowthField1,
                                       int stageOfGrowthField2, int stageOfGrowthField3, int selectedObject,
                                       int column, int row){

        gamePane = new Pane();
        gameScene = new Scene(gamePane, WIDTH, HEIGHT);
        matchfield = new Matchfield();
        gameController = new GameController();
        gamePane.setPrefWidth(WIDTH);
        gamePane.setPrefHeight(HEIGHT);
        initializeInformationBox();
        initializeSideControlPane(farmer, tractor, harvester, cultivator, dumpTruck, seedDrill);
        initializeMatchfield(stageOfGrowthField1, stageOfGrowthField2, stageOfGrowthField3, selectedObject, column, row);
        movingObject.setX(column);
        movingObject.setY(row);
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) ->{
            gameController.setBooleansPressed(event);
        });

        gameScene.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            gameController.setBooleansReleased(event);
        });
    }

    /**
     * Getter for the gameScene.
     * @return the requested gameScene
     */
    public Scene getGameScene(){
        return gameScene;
    }

    /**
     * This method gets the informationBox from the class InformationBox that implements a VBOX with all the information
     * for the player. It adds the box to the gamePane.
     */
    private void initializeInformationBox(){
        informationBox = new InformationBox();
        gamePane.getChildren().add(informationBox.getInformationBox());
    }

    public InformationBox getInformationBox(){
        return informationBox;
    }

    /**
     *
     * This method gets the sideControlPane from the class SideControlPane that implements a Pane with all the buttons
     * to move around the matchfield and to choose the machine / farmer and adds it to the gamePane.
     *
     * @param farmer - hands the boolean to the constructor of the class SideControlPane
     * @param tractor - hands the boolean to the constructor of the class SideControlPane
     * @param harvester - hands the boolean to the constructor of the class SideControlPane
     * @param cultivator - hands the boolean to the constructor of the class SideControlPane
     * @param dumpTruck - hands the boolean to the constructor of the class SideControlPane
     * @param seedDrill - hands the boolean to the constructor of the class SideControlPane
     */
    private void initializeSideControlPane(boolean farmer, boolean tractor, boolean harvester, boolean cultivator,
                                           boolean dumpTruck, boolean seedDrill){
        sideControlPane = new SideControlPane(farmer, tractor, harvester, cultivator, dumpTruck, seedDrill);
        gamePane.getChildren().add(sideControlPane.getSidePane());
    }

    public SideControlPane getSideControlPane(){
        return sideControlPane;
    }

    public Matchfield getMatchfield(){
        return matchfield;
    }

    /**
     * This method gets the matchfield from the class Matchfield that implements the grid pane of the matchfield and
     * adds it to the gamePane.
     *
     * @param stageOfGrowthField1 - hands the integer to the constructor of the class Matchfield
     * @param stageOfGrowthField2 - hands the integer to the constructor of the class Matchfield
     * @param stageOfGrowthField3 - hands the integer to the constructor of the class Matchfield
     * @param selectedObject - integer of the selected moving object that is shown on the matchfield
     * @param column - index of the column to which the image view is set
     * @param row - index of the column to which the image view is set
     */
    private void initializeMatchfield(int stageOfGrowthField1, int stageOfGrowthField2, int stageOfGrowthField3,
                                           int selectedObject, int column, int row){
        matchfield = new Matchfield(stageOfGrowthField1, stageOfGrowthField2, stageOfGrowthField3);
        matchfield.initializeMovingObject(selectedObject, column, row);
        gamePane.getChildren().add(matchfield.getMatchfield());
    }

    public void setField1(int stageOfGrowth){
        matchfield.setField1(stageOfGrowth);
    }

    public void setField2(int stageOfGrowth){
        matchfield.setField2(stageOfGrowth);
    }

    public void setField3(int stageOfGrowth){
        matchfield.setField3(stageOfGrowth);
    }

    public void moveObject(MovingObject movingObject, Tractor tractor, Harvester harvester, GameScene gameScene) {
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
