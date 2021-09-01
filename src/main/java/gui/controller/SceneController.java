package gui.controller;

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
}
