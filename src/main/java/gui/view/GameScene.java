package gui.view;

import javafx.scene.Scene;
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

    /**
     * This method implements all the Nodes for the game scene with the help of the other classes InformationBox,
     * Matchfield and SideControlPane.
     *
     * @param farmer - hands the boolean to the method initializeSideControlPane()
     * @param tractor - hands the boolean to the method initializeSideControlPane()
     * @param harvester - hands the boolean to the method initializeSideControlPane()
     * @param cultivator - hands the boolean to the method initializeSideControlPane()
     * @param dumpTruck - hands the boolean to the method initializeSideControlPane()
     * @param seedDrill - hands the boolean to the method initializeSideControlPane()
     */
    protected void initializeGameScene(boolean farmer, boolean tractor, boolean harvester, boolean cultivator,
                                       boolean dumpTruck, boolean seedDrill){
        gamePane.setPrefWidth(WIDTH);
        gamePane.setPrefHeight(HEIGHT);
        initializeInformationBox();
        initializeSideControlPane(farmer, tractor, harvester, cultivator, dumpTruck, seedDrill);
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
     * to move around the matchfield and to choose the machine / farmer.
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


}
