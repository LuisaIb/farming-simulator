package gui.view;

import gui.controller.SceneController;
import gui.model.LSButton;
import gui.model.LSTextField;
import javafx.scene.layout.HBox;

import static gui.view.ViewManager.WIDTH;

/**
 * This class implements a VBOX, that contains text fields for all the necessary information that the player needs
 * while playing such as amount of money, time, ... and a button to get back to the menu.
 */
public class InformationBox {
    private HBox informationBox = new HBox();
    private LSTextField moneyField;
    private LSTextField siloField;
    private LSTextField tractorField;
    private LSTextField harvesterField;
    private LSTextField newsField;
    private LSTextField timeField;
    private LSButton menuButton;
    SceneController sceneController = new SceneController();

    /**
     * Constructs an object of the class InformationBox and initializes the box immediately.
     */
    public InformationBox(){
        initializeInformationBox();
    }

    /**
     * This sets the size and layout of the box and fills the box with text fields and a button with the help
     * of the method fillInformationBox().
     */
    private void initializeInformationBox(){
        informationBox.setPrefWidth(WIDTH);
        informationBox.setPrefHeight(40);
        informationBox.setLayoutX(0);
        informationBox.setLayoutY(0);
        fillInformationBox();
    }

    /**
     * This method initializes the text fields an buttons and adds them to the informationBox.
     */
    private void fillInformationBox(){
        timeField = new LSTextField("day",40, 150, 0, 0, 16);
        moneyField = new LSTextField("money", 40, 175, 0, 0, 16);
        siloField = new LSTextField("silo",40, 175, 0, 0, 16);
        tractorField = new LSTextField("tractor",40, 175, 0, 0, 14);
        harvesterField = new LSTextField("harvester",40, 175, 0, 0, 14);
        newsField = new LSTextField("news",40, 450, 0, 0, 16);
        menuButton = new LSButton("save", 40, 100,750, 0, 16);// menu + dropdown auswahl oder extra feld (Speichern, beenden, hilfe)
        menuButton.setOnMouseClicked(sceneController.setSceneToMenuScene);
        informationBox.getChildren().addAll(timeField, moneyField, siloField, tractorField, harvesterField,
                newsField, menuButton);
    }

    /**
     * Getter for the informationBox.
     * @return the requested informationBox
     */
    protected HBox getInformationBox(){
        return informationBox;
    }

    /**
     * @return
     */
    public LSTextField getNewsField() {
        return newsField;
    }

    public LSTextField getHarvesterField() {
        return harvesterField;
    }

    public LSTextField getSiloField() {
        return siloField;
    }

    public LSTextField getMoneyField() {
        return moneyField;
    }

    public LSTextField getTimeField() {
        return timeField;
    }

    public LSTextField getTractorField() {
        return tractorField;
    }

    public LSButton getMenuButton() {
    	return menuButton;
    }
   
}
