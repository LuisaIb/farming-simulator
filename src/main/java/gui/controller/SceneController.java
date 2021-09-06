package gui.controller;

import gui.view.DifficultyScene;
import gui.view.MenuScene;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * This class implements the methods, that are responsible for the change of the scene.
 */
public class SceneController {
    private boolean timerInitiated = false;

    public EventHandler<Event> setSceneToGameScene = event -> {
        // Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        // GameScene initialisieren
        // timerInitiated = true;
        // window.setScene(gameScene.getGameScene());
        // window.show();
    };

    public EventHandler<Event> setSceneToDifficultyScene = event -> {
        DifficultyScene difficultyScene = new DifficultyScene();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(difficultyScene.getDifficultyScene());
        window.show();
    };

    public EventHandler<Event> setSceneToMenuScene = event -> {
        MenuScene menuScene = new MenuScene();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene.getMenuScene());
        window.show();
    };



}
