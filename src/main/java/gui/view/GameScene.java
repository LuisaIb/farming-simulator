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
     */
    protected void initializeGameScene(){
        gamePane.setPrefWidth(WIDTH);
        gamePane.setPrefHeight(HEIGHT);
        initializeInformationBox();
        initializeSideControlPane();
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
     * This method gets the sideControlPane from the class SideControlPane that implements a Pane with all the buttons
     * to move around the matchfield and to choose the machine / farmer.
     */
    private void initializeSideControlPane(){
        SideControlPane sideControlPane = new SideControlPane(true, false, false, false, false, false);
        gamePane.getChildren().add(sideControlPane.getSidePane());
    }


}
