package gui.view;

import gui.controller.SceneController;
import gui.model.ImageManager;
import gui.model.LSButton;
import gui.model.LSTextField;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;


import static gui.view.ViewManager.WIDTH;
import static gui.view.ViewManager.HEIGHT;

/**
 * This class implements the helpScene which shows an image with text on it to help the player understand the game.
 *
 * @author Judith
 */
public class HelpScene {
    /**
     * new pane that holds all the nodes of the helpScene
     */
    private Pane helpPane = new Pane();
    /**
     * new scene that show the helpPane
     */
    private Scene helpScene = new Scene(helpPane, WIDTH, HEIGHT);
    /**
     * String with the path to the background image
     */
    private static final String PATH_TO_BACKGROUND_IMAGE = "src/main/java/gui/view/resources/background/field.jpg";

    /**
     * Constructs an object of this class an initializes the helpPane with the method initializeHelpPane().
     */
    public HelpScene(){
        initializeHelpPane();
    }

    /**
     * This method initializes the helpPane. It sets the background image and the size and implements the help text
     * and the button to get back to the menuScene with the help of the method initializeText() and initializeButton().
     */
    private void initializeHelpPane(){
        helpPane.setPrefWidth(WIDTH);
        helpPane.setPrefHeight(HEIGHT);
        Image image = new ImageManager().getImage(PATH_TO_BACKGROUND_IMAGE, WIDTH, HEIGHT, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        helpPane.setBackground(background);
        initializeText();
        initializeButton();
    }

    /**
     * This method implements the help text. The background image of the empty text field is set to the helpText image.
     */
    private void initializeText(){
        LSTextField helpText = new LSTextField("", HEIGHT-100, WIDTH, 0, 0, 16);
        Image image = new ImageManager().getImage("src/main/java/gui/view/resources/background/helpText.png",
                1400, 800, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        helpText.setBackground(background);
        helpPane.getChildren().add(helpText);
    }

    /**
     * This method implements the button that makes it possible to go back to the menuScene.
     */
    private void initializeButton(){
        SceneController sceneController = new SceneController();
        LSButton buttonBack = new LSButton("back", 50, 150, WIDTH/2 - 50, HEIGHT-75, 20);
        buttonBack.setOnMouseClicked(sceneController.setSceneToMenuScene);
        helpPane.getChildren().add(buttonBack);
    }

    /**
     * Getter for the helpScene.
     *
     * @return the requested helpScene
     */
    public Scene getHelpScene(){
        return helpScene;
    }

}
