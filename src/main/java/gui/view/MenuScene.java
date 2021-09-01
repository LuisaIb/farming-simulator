package gui.view;

import gui.model.ImageManager;
import gui.model.LSButton;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import static gui.view.ViewManager.HEIGHT;
import static gui.view.ViewManager.WIDTH;

/**
 * This class implements the menuScene. This scene is the first scene that is shown, when starting the game. It provides
 * buttons for a new game, continue game, load game, sage game, help and end game.
 *
 * @author Judith Romer
 */

public class MenuScene {
    private Pane menuPane = new Pane();
    private Scene menuScene = new Scene(menuPane, WIDTH, HEIGHT);
    private LSButton buttonNewGame;
    private LSButton buttonContinueGame;
    private LSButton buttonLoadGame;
    private LSButton buttonSaveGame;
    private LSButton buttonHelp;
    private LSButton buttonEnd;

    /**
     * Constructs an object of the class MenuScene. It initializes the menuPane with the method initializeMenuPane().
     */
    protected MenuScene(){
        initializeMenuPane();
    }

    /**
     * This method sets the style of the menuPane and initializes the buttons with the method initializeButtons().
     */
    private void initializeMenuPane(){
        menuPane.setPrefWidth(WIDTH);
        menuPane.setPrefHeight(HEIGHT);
        Image image = new ImageManager().getImage("../view/resources/background/field.jpg",
                WIDTH, HEIGHT, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        menuPane.setBackground(background);
        initilizeButtons();
    }

    /**
     * This method implements the buttons of the menu. Therefore it uses a VBox.
     */
    private void initilizeButtons(){
        VBox menuBox = new VBox();
        menuBox.setLayoutX(WIDTH/2 - 100);
        menuBox.setLayoutY(HEIGHT/2 - 150);

        buttonNewGame = new LSButton("Neues Spiel", 50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonContinueGame = new LSButton("Spiel fortsetzen", 50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonLoadGame = new LSButton("Spiel laden",50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonSaveGame = new LSButton("Spiel speichern",50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonHelp = new LSButton("Hilfe",50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonEnd = new LSButton("Beenden",50, 250, HEIGHT/2,
                WIDTH/2, 20);

        menuBox.getChildren().addAll(buttonNewGame, buttonContinueGame, buttonLoadGame, buttonSaveGame,
                buttonHelp, buttonEnd);
        menuPane.getChildren().add(menuBox);
    }

    /**
     * Getter for the MenuScene.
     * @return the requested menuScene.
     */
    protected Scene getMenuScene(){
        return menuScene;
    }
}
