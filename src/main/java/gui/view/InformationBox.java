package gui.view;

import gui.controller.SceneController;
import gui.model.LSButton;
import gui.model.LSTextField;
import javafx.scene.layout.HBox;

import static gui.view.ViewManager.WIDTH;

/**
 * This class implements a VBOX, that contains text fields for all the necessary information that the player needs
 * while playing such as amount of money, time, ... and a button to get back to the menu.
 *
 * @author Judith
 */
public class InformationBox {
    /**
     * HBox that holds all the text fields
     */
    private HBox informationBox = new HBox();
    /**
     * text field to show the player the amount of money
     */
    private LSTextField moneyField;
    /**
     * text field to show the player how much grain is in the silo
     */
    private LSTextField siloField;
    /**
     * text field to show the player how much petrol is in the tank of the tractor
     */
    private LSTextField tractorField;
    /**
     * text field to show the player how much petrol is in the tank of the harvester
     */
    private LSTextField harvesterField;
    /**
     * text field to show the player some news as soon as something important has happened
     */
    private LSTextField newsField;
    /**
     * text field to show the player the day
     */
    private LSTextField timeField;
    /**
     * button whith which the player can save and end the game
     */
    private LSButton saveButton;
    /**
     * object of the class SceneController
     */
    SceneController sceneController = new SceneController();

    /**
     * Constructs an object of the class InformationBox and initializes the box immediately.
     */
    public InformationBox(){
        initializeInformationBox();
    }

    /**
     * This method sets the size and layout of the box and fills the box with text fields and a button with the help
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
     * This method initializes the text fields and buttons and adds them to the informationBox.
     */
    private void fillInformationBox(){
        timeField = new LSTextField("day",40, 150, 0, 0, 16);
        moneyField = new LSTextField("money", 40, 175, 0, 0, 16);
        siloField = new LSTextField("silo",40, 175, 0, 0, 16);
        tractorField = new LSTextField("tractor",40, 175, 0, 0, 14);
        harvesterField = new LSTextField("harvester",40, 175, 0, 0, 14);
        newsField = new LSTextField("news",40, 450, 0, 0, 16);
        saveButton = new LSButton("save & end", 40, 100,750, 0, 12);// menu + dropdown auswahl oder extra feld (Speichern, beenden, hilfe)
        saveButton.setOnMouseClicked(sceneController.setSceneToMenuScene);
        informationBox.getChildren().addAll(timeField, moneyField, siloField, tractorField, harvesterField,
                newsField, saveButton);
    }

    /**
     * Getter for the informationBox.
     *
     * @return the requested informationBox
     */
    protected HBox getInformationBox(){
        return informationBox;
    }

    /**
     * Getter for the newsField.
     *
     * @return the requested newsField
     */
    public LSTextField getNewsField() {
        return newsField;
    }

    /**
     * Getter for the harvesterField.
     *
     * @return the requested harvesterField.
     */
    public LSTextField getHarvesterField() {
        return harvesterField;
    }

    /**
     * Getter for the siloField.
     *
     * @return the requested siloField
     */
    public LSTextField getSiloField() {
        return siloField;
    }

    /**
     * Getter for the moneyField.
     *
     * @return the requested moneyField
     */
    public LSTextField getMoneyField() {
        return moneyField;
    }

    /**
     * Getter for the timeField.
     *
     * @return the requested timeField
     */
    public LSTextField getTimeField() {
        return timeField;
    }

    /**
     * Getter for the tractorField.
     *
      * @return the requested tractorField
     */
    public LSTextField getTractorField() {
        return tractorField;
    }

    /**
     * Getter for the saveButton.
     *
     * @return the requested saveButton
     */
    public LSButton getSaveButton() {
    	return saveButton;
    }
   
}
