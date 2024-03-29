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
 * This class implements the scene to choose the level of difficulty when starting a new game.
 *
 * @author Judith
 */
public class DifficultyScene {
    /**
     * new Pane that holds the nodes of the difficultyScene
     */
    private Pane difficultyPane =  new Pane();
    /**
     * new scene that shows the difficultyPane
     */
    private Scene difficultyScene = new Scene(difficultyPane, WIDTH, HEIGHT);
    /**
     * String with the path to the background image of the scene
     */
    private static final String PATH_TO_BACKGROUND_IMAGE = "src/main/java/gui/view/resources/background/field.jpg";
    /**
     * object of the class SceneController
     */
    SceneController sceneController = new SceneController();

    /**
     * Constructs an object of the class DifficultyScene. It initializes the difficultyPane with the method
     * initializeDifficultyPane().
     */
    public DifficultyScene(){
        initializeDifficultyPane();
    }

    /**
     * This method sets the style of the difficultyPane and initializes the buttons with the method initializeButtons().
     */
    private void initializeDifficultyPane(){
        difficultyPane.setPrefWidth(WIDTH);
        difficultyPane.setPrefHeight(HEIGHT);
        Image image = new ImageManager().getImage(PATH_TO_BACKGROUND_IMAGE, WIDTH, HEIGHT, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        difficultyPane.setBackground(background);
        LSTextField headline = new LSTextField("please choose level of difficulty",
                50, 500, WIDTH/2-235, 150, 20);
        difficultyPane.getChildren().add(headline);
        initializeButtons();
    }

    /**
     * This method implements the buttons of the scene. Therefore, it uses a VBox.
     */
    private void initializeButtons(){
        VBox difficultyBox = new VBox(10);
        difficultyBox.setLayoutX(WIDTH/2 - 100);
        difficultyBox.setLayoutY(HEIGHT/2 - 150);

        LSButton buttonEasy = new LSButton("easy", 50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonEasy.setOnMouseClicked(sceneController.setSceneToEasyGameScene);
        LSButton buttonMedium = new LSButton("medium", 50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonMedium.setOnMouseClicked(sceneController.setSceneToMediumGameScene);
        LSButton buttonHard = new LSButton("hard",50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonHard.setOnMouseClicked(sceneController.setSceneToHardGameScene);
        LSButton buttonBackToScene = new LSButton("back",50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonBackToScene.setOnMouseClicked(sceneController.setSceneToMenuScene);

        difficultyBox.getChildren().addAll(buttonEasy, buttonMedium, buttonHard, buttonBackToScene);
        difficultyPane.getChildren().add(difficultyBox);
    }

    /**
     * Getter for the difficultyScene.
     * @return the requested difficultyScene.
     */
    public Scene getDifficultyScene(){
        return difficultyScene;
    }

}
