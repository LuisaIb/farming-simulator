package gui.view;

import gui.model.LSButton;
import gui.model.LSTextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import static gui.view.ViewManager.WIDTH;

/**
 * This class implements a VBOX, that contains text fields for all the necessary information that the player needs
 * while playing such as amount of money, time, ... and a button to get back to the menu.
 */
public class InformationBox {
    private VBox informationBox = new VBox();
    private LSTextField moneyField;
    private LSTextField siloField;
    private LSTextField tractorField;
    private LSTextField harvesterField;
    private LSTextField difficultyField;
    private LSTextField newsField;
    private LSTextField timeField;
    private LSButton menuButton;

    /**
     * Constructs an object of the class InformationBox and initializes the box immediately.
     */
    protected InformationBox(){
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
        moneyField = new LSTextField("Geldbetrag", 40, 175, 0, 0, 16);
        siloField = new LSTextField("Silo Füllstand",40, 175, 0, 0, 16);
        tractorField = new LSTextField("Traktor Tank Füllstand",40, 175, 0, 0, 16);
        harvesterField = new LSTextField("Mähdrescher Tank Füllstand",40, 175, 0, 0, 16);
        difficultyField = new LSTextField("Schwierigkeitsgrad",40, 150, 0, 0, 16);
        newsField = new LSTextField("News",40, 300, 0, 0, 16);
        timeField = new LSTextField("Zeit",40, 150, 0, 0, 16);
        menuButton = new LSButton("Menü", 40, 100,750, 0, 16);

        informationBox.getChildren().addAll(moneyField, siloField, tractorField, harvesterField, difficultyField,
                newsField, timeField, menuButton);
    }

    /**
     * Getter for the informationBox.
     * @return the requested informationBox
     */
    protected VBox getInformationBox(){
        return informationBox;
    }

}
