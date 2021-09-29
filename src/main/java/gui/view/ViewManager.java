package gui.view;

import gui.model.ImageManager;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This class initializes the stage and the menuScene as this scene is the first one shown, when the game starts.
 *
 * @author Judith
 */
public class ViewManager {
    /**
     * the main stage of the game
     */
    private Stage mainStage = new Stage();
    /**
     * height of the game
     */
    protected static final int HEIGHT = 900;
    /**
     * width of the game
     */
    protected static final int WIDTH = 1400;
    /**
     * menuScene that is shown first on the stage when starting the game
     */
    private MenuScene menuScene;

    /**
     * Initializes the mainStage. It sets the title and icon as well as the first scene that is shown.
     */
    public void initializeStage(){
        mainStage.setTitle("farming simulator");
        mainStage.setResizable(false);
        Image iconImage = new ImageManager().getImage("src/main/java/gui/view/resources/machines/tractorSide.png",
                40, 40, false, false);
        mainStage.getIcons().add(iconImage);
        initilizeScene();
        mainStage.show();
    }

    /**
     * Initializes the menuScene as first scene shown in the game on the mainStage.
     */
    private void initilizeScene(){
        menuScene = new MenuScene();
        mainStage.setScene(menuScene.getMenuScene());
    }

}
