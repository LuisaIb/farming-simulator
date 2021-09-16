package gui.view;

import gui.controller.SceneController;
import gui.model.ImageManager;
import gui.model.LSButton;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import simulator.Game;

import static gui.view.ViewManager.HEIGHT;
import static gui.view.ViewManager.WIDTH;

import datastorage.ObjectToPojo;
import gameboard.objects.Farmer;

/**
 * This class implements the menuScene. This scene is the first scene that is shown, when starting the game. It provides
 * buttons for a new game, load game, save game, help and end game.
 *
 * @author Judith
 */

public class MenuScene {
    private Pane menuPane;
    private Scene menuScene;
    private static final String PATH_TO_BACKGROUND_IMAGE = "src/main/java/gui/view/resources/background/field.jpg";
    private LSButton buttonNewGame;
    private LSButton buttonLoadGame;
    private LSButton buttonSaveGame;
    private LSButton buttonHelp;
    private LSButton buttonEnd;

    /**
     * Constructs an object of the class MenuScene. It initializes the menuPane with the method initializeMenuPane().
     */
    public MenuScene(){
        menuPane = new Pane();
        menuScene = new Scene(menuPane, WIDTH, HEIGHT);
        initializeMenuPane();
    }

    /**
     * This method sets the style of the menuPane and initializes the buttons with the method initializeButtons().
     */
    private void initializeMenuPane(){
        menuPane.setPrefWidth(WIDTH);
        menuPane.setPrefHeight(HEIGHT);
        Image image = new ImageManager().getImage(PATH_TO_BACKGROUND_IMAGE, WIDTH, HEIGHT, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        menuPane.setBackground(background);
        initializeButtons();
    }

    /**
     * This method implements the buttons of the menu. Therefore, it uses a VBox.
     */
    private void initializeButtons(){
        SceneController sceneController = new SceneController();
        VBox menuBox = new VBox(10);
        menuBox.setLayoutX(WIDTH/2 - 100);
        menuBox.setLayoutY(HEIGHT/2 - 150);

        buttonNewGame = new LSButton("Neues Spiel", 50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonNewGame.setOnMouseClicked(sceneController.setSceneToDifficultyScene);
        buttonLoadGame = new LSButton("Spiel laden",50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonLoadGame.setOnMouseClicked(MouseEvent->{
        	ObjectToPojo otp = new ObjectToPojo();
        	otp.toDeserialize();
        });
        buttonLoadGame.setOnMouseClicked(sceneController.setSceneToReloadGameScene);
        buttonSaveGame = new LSButton("Spiel speichern",50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonHelp = new LSButton("Hilfe",50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonHelp.setOnMouseClicked(sceneController.setSceneToHelpScene);
        buttonEnd = new LSButton("Beenden",50, 250, HEIGHT/2,
                WIDTH/2, 20);
        buttonEnd.setOnMouseClicked(sceneController.endGame);

        menuBox.getChildren().addAll(buttonNewGame, buttonLoadGame, buttonSaveGame,
                buttonHelp, buttonEnd);
        menuPane.getChildren().add(menuBox);
    }

    /**
     * Getter for the menuScene.
     *
     * @return the requested menuScene.
     */
    public Scene getMenuScene(){
        return menuScene;
    }

    /**
     * This method helps to set the buttons load game and save game disabled or not. e.g. when the game is played for
     * the first time, the buttons should be disabled as there is nothing to be saved or relaoded.
     *
     * @param reloadGame boolean of the disability of the button loadGame
     * @param saveGame boolean of the disability of the button saveGame
     */
    private void buttonsDisabled(boolean reloadGame, boolean saveGame) {
        buttonLoadGame.setDisable(reloadGame);
        buttonSaveGame.setDisable(saveGame);
    }

    public void buttonFunctionality(Farmer farmer){
        Game game = new Game();
        buttonSaveGame.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
//            game.toSerializeFarmer(farmer);
//            game.toSerializeGame();
//            game.toSerializeLevel();
//            game.toSerializeFieldtiles();
//            game.toSerializeSilo();
//
//           // game.toSerializeCourtTrade();
//
//            game.toSerializeTractor();
//            game.toSerializeHarvester();
//            game.toSerializeCultivator();
//            game.toSerializeDumpTruck();
//            game.toSerializeSeedDrill();
        });
    }
    
   
}
