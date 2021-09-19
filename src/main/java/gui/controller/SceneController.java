package gui.controller;

import gui.view.DifficultyScene;
import gui.view.GameScene;
import gui.view.HelpScene;
import gui.view.MenuScene;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;
import simulator.Game;

/**
 * This class implements the methods, that are responsible for the change of the scene.
 *
 * @author Judith
 */
public class SceneController {
    Game game;

    /**
     * This method starts a new game with level of difficulty easy.
     */
    public EventHandler<Event> setSceneToEasyGameScene = event -> {
        // to change the scene the actual stage is needed
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        game = new Game();
        GameScene gameScene = game.createNewGame(1);
        window.setScene(gameScene.getGameScene());
        window.show();
    };

    /**
     * This method starts a new game with level of difficulty medium.
     */
    public EventHandler<Event> setSceneToMediumGameScene = event -> {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        game = new Game();
        GameScene gameScene = game.createNewGame(2);
        window.setScene(gameScene.getGameScene());
        window.show();
    };

    /**
     * This method starts a new game with level of difficulty hard.
     */
    public EventHandler<Event> setSceneToHardGameScene = event -> {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        game = new Game();
        GameScene gameScene = game.createNewGame(3);
        window.setScene(gameScene.getGameScene());
        window.show();
    };

    /**
     * This method reloads the saved game.
     */
    public EventHandler<Event> setSceneToReloadGameScene = event -> {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        game = new Game();
        GameScene gameScene = game.reloadGame();
        window.setScene(gameScene.getGameScene());
        window.show();
    };

    /**
     * This method sets the scene to the scene in which the player chooses the level of difficulty when starting a new
     * game.
     */
    public EventHandler<Event> setSceneToDifficultyScene = event -> {
        DifficultyScene difficultyScene = new DifficultyScene();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(difficultyScene.getDifficultyScene());
        window.show();
    };

    /**
     * This method sets the scene back to the menu scene. It is needed in the difficultyScene and the helpScene for the
     * buttons back.
     */
    public EventHandler<Event> setSceneToMenuScene = event -> {
        MenuScene menuScene = new MenuScene();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene.getMenuScene());
        window.show();
    };

    /**
     * This method sets the scene to the helpScene.
     */
    public EventHandler<Event> setSceneToHelpScene = event -> {
        HelpScene helpScene = new HelpScene();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(helpScene.getHelpScene());
        window.show();
    };

    /**
     * This method ends the game.
     */
    public EventHandler<Event> endGame = event -> {
        Platform.exit();
        System.exit(0);
    };




}
