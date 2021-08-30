package gui.view;

import gui.model.ImageManager;
import javafx.stage.Stage;

/**
 * This class initializes the stage and the menuScene as this scene is the first one shown, when the game is starts.
 *
 * @author Judith Romer
 */
public class ViewManager {
    private Stage mainStage = new Stage();
    protected static final int HEIGHT = 800;
    protected static final int WIDTH = 1400;

    /**
     * Initializes the mainStage. It sets the height, width, title and icon as well as the first scene that is shown.
     */
    public void initializeStage(){
        mainStage.setTitle("Landwirtschaftssimulator");
        mainStage.setResizable(false);
        mainStage.getIcons().add(new ImageManager().getImage("../view/resources/machines/tractorSide.png",
                40, 40, false, false));
        initilizeScene();
        mainStage.show();
    }

    /**
     * Initializes the menuScene as first scene shown in the game on the mainStage.
     */
    private void initilizeScene(){
        MenuScene menuScene = new MenuScene();
        mainStage.setScene(menuScene.getMenuScene());
    }




}
