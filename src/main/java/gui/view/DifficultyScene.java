package gui.view;

import gui.controller.SceneController;
import gui.model.ImageManager;
import gui.model.LSButton;
import gui.model.LSTextField;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import simulator.LevelOfDifficulty;

import static gui.view.ViewManager.WIDTH;
import static gui.view.ViewManager.HEIGHT;

/**
 * This class implements the scene to choose the level of difficulty when starting a new game.
 */

public class DifficultyScene {
    private LSButton buttonEasy;
    private LSButton buttonMedium;
    private LSButton buttonHard;
    private LSButton buttonBackToScene;
    private Pane difficultyPane =  new Pane();
    private Scene difficultyScene = new Scene(difficultyPane, WIDTH, HEIGHT);
    private static final String PATH_TO_BACKGROUND_IMAGE = "src/main/java/gui/view/resources/background/field.jpg";
    SceneController sceneController = new SceneController();
    //LevelOfDifficulty lod = new LevelOfDifficulty();

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
        LSTextField headline = new LSTextField("Bitte waehle den Schwierigkeitsgrad aus",
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

        buttonEasy = new LSButton("Leicht", 50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonEasy.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            //lod.setLevel(1);
            //System.out.println(lod.getLevel());
        });
        buttonEasy.setOnMouseClicked(sceneController.setSceneToGameScene);
        buttonMedium = new LSButton("Mittel", 50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonMedium.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            //lod.setLevel(2);
            //System.out.println(lod.getLevel());
        });
        buttonMedium.setOnMouseClicked(sceneController.setSceneToGameScene);
        buttonHard = new LSButton("Schwer",50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonHard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            //lod.setLevel(3);
            //System.out.println(lod.getLevel());
        });
        buttonHard.setOnMouseClicked(sceneController.setSceneToGameScene);
        buttonBackToScene = new LSButton("Zurueck",50, 250, HEIGHT/2,
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

    //public LevelOfDifficulty getLod(){
    //    return lod;
    //}

}
