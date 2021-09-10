package gui.controller;

import gui.view.DifficultyScene;
import gui.view.GameScene;
import gui.view.HelpScene;
import gui.view.MenuScene;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import simulator.Game;

/**
 * This class implements the methods, that are responsible for the change of the scene.
 */
public class SceneController {
    private boolean timerInitiated = false;
    Game game = new Game();
    MovingObjectController movingObjectController = new MovingObjectController();

    public EventHandler<Event> setSceneToGameScene = event -> {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        GameScene gameScene = game.createNewGame();
        window.setScene(gameScene.getGameScene());
        window.show();
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

    public EventHandler<Event> setSceneToHelpScene = event -> {
        HelpScene helpScene = new HelpScene();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(helpScene.getHelpScene());
        window.show();
    };

    public EventHandler<Event> endGame = event -> {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        // Abfrage, ob Spiel gespeichert
        // wenn ja, dann nachfragen, ob wirklich beenden
        window.close();
    };


}
