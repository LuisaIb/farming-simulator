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

public class HelpScene {
    private Pane helpPane = new Pane();
    private Scene helpScene = new Scene(helpPane, WIDTH, HEIGHT);
    private static final String PATH_TO_BACKGROUND_IMAGE = "src/main/java/gui/view/resources/background/field.jpg";

    public HelpScene(){
        initializeHelpPane();
    }

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

    private void initializeText(){
        LSTextField helpText = new LSTextField("Hier kommt der Text hin", HEIGHT-100, WIDTH, 0, 0, 16);
        helpText.setStyle( "-fx-background-color: rgba(255,255,255,0.5);");
        helpPane.getChildren().add(helpText);
    }

    private void initializeButton(){
        SceneController sceneController = new SceneController();
        LSButton buttonBack = new LSButton("Zurueck", 50, 150, WIDTH/2 - 50, HEIGHT-75, 20);
        buttonBack.setOnMouseClicked(sceneController.setSceneToMenuScene);
        helpPane.getChildren().add(buttonBack);
    }

    public Scene getHelpScene(){
        return helpScene;
    }

}
