package gui.view;

import gui.controller.MovingObjectController;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import static gui.view.ViewManager.HEIGHT;
import static gui.view.ViewManager.WIDTH;

/**
 * This class implements the game scene. It consists of gridpane for the matchfield, a pane on the right side with
 * buttons for moving around the field and choosing the machine / farmer and a vertical box with all the necessary
 * information the player should see during playing.
 *
 * @author Judith Romer
 */
public class GameScene {
    private Pane gamePane = new Pane();
    private Scene gameScene = new Scene(gamePane, WIDTH, HEIGHT);
    Matchfield matchfield = new Matchfield();
    MovingObjectController movingObjectController = new MovingObjectController();

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
        gamePane.setPrefWidth(WIDTH);
        gamePane.setPrefHeight(HEIGHT);
        initializeInformationBox();
        initializeSideControlPane(farmer, tractor, harvester, cultivator, dumpTruck, seedDrill);
        initializeMatchfield(stageOfGrowthField1, stageOfGrowthField2, stageOfGrowthField3, selectedObject, column, row);

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) ->{
            movingObjectController.setBooleansPressed(event);
        });

        gameScene.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            movingObjectController.setBooleansReleased(event);
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
        InformationBox informationBox = new InformationBox();
        gamePane.getChildren().add(informationBox.getInformationBox());
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
        SideControlPane sideControlPane = new SideControlPane(farmer, tractor, harvester, cultivator, dumpTruck, seedDrill);
        gamePane.getChildren().add(sideControlPane.getSidePane());
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


}
