package gui.view;

import gui.model.ImageManager;
import gui.model.LSButton;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

import static gui.view.ViewManager.HEIGHT;
import static gui.view.ViewManager.WIDTH;

/**
 * This class implements the side pane with the buttons to move around the matchfield and to choose the
 * machine / farmer.
 */
public class SideControlPane {
    private Pane sidePane = new Pane();
    private GridPane machinePane = new GridPane();
    private LSButton farmerButton;
    private LSButton tractorButton;
    private LSButton harvesterButton;
    private LSButton cultivatorButton;
    private LSButton dumpTruckButton;
    private LSButton seedDrillButton;
    private LSButton buttonRight;
    private LSButton buttonLeft;
    private LSButton buttonUp;
    private LSButton buttonDown;
    private LSButton buttonAction;
    private static final int HEIGHT_PANE = 860;
    private static final int WIDTH_PANE = 250;

    /**
     * Construcs an object of the class SideControlPane. It immediately initializes the sidePane.
     *
     * @param farmer - hands the boolean to the method initializeSidePane()
     * @param tractor - hands the boolean to the method initializeSidePane()
     * @param harvester - hands the boolean to the method initializeSidePane()
     * @param cultivator - hands the boolean to the method initializeSidePane()
     * @param dumpTruck - hands the boolean to the method initializeSidePane()
     * @param seedDrill - hands the boolean to the method initializeSidePane()
     */
    protected SideControlPane(boolean farmer, boolean tractor, boolean harvester, boolean cultivator,
                              boolean dumpTruck, boolean seedDrill){
        initializeSidePane(farmer, tractor, harvester, cultivator, dumpTruck, seedDrill);
    }

    /**
     * Sets the size and layout of the pane and creates all the nodes with the help of the other methods of the class.
     *
     * @param farmer - hands the boolean to the method setButtonsDisabled()
     * @param tractor - hands the boolean to the method setButtonsDisabled()
     * @param harvester - hands the boolean to the method setButtonsDisabled()
     * @param cultivator - hands the boolean to the method setButtonsDisabled()
     * @param dumpTruck - hands the boolean to the method setButtonsDisabled()
     * @param seedDrill - hands the boolean to the method setButtonsDisabled()
     */
    private void initializeSidePane(boolean farmer, boolean tractor, boolean harvester, boolean cultivator,
                                    boolean dumpTruck, boolean seedDrill){
        sidePane.setPrefWidth(WIDTH_PANE);
        sidePane.setPrefHeight(HEIGHT_PANE);
        sidePane.setLayoutX(WIDTH - WIDTH_PANE);
        sidePane.setLayoutY(HEIGHT - HEIGHT_PANE);
        createMachinePane();
        fillMachinePaneWithButtons();
        setButtonsDisabled(farmer, tractor, harvester, cultivator, dumpTruck, seedDrill);
        createControlButtons();
    }

    /**
     * Creates the grid pane, that holds the buttons to choose the machine / farmer to move around the field.
     */
    private void createMachinePane(){
        machinePane.setHgap(0);
        machinePane.setVgap(0);
        machinePane.setPrefHeight(HEIGHT * 0.65);
        machinePane.setPrefWidth(WIDTH_PANE);
        machinePane.setGridLinesVisible(false);

        ColumnConstraints colConst = new ColumnConstraints();
        for (int i = 0; i < 2; i++) {
            colConst.setPercentWidth(100 / 2);
            machinePane.getColumnConstraints().add(colConst);
        }

        RowConstraints rowConst = new RowConstraints();
        for (int i = 0; i < 3; i++) {
            rowConst.setPercentHeight(100 / 3);
            machinePane.getRowConstraints().add(rowConst);
        }
    }

    /**
     * Loads the images, initializes the image views and buttons and adds them with the help of the method
     * addToGridPane() to the machinePane.
     */
    private void fillMachinePaneWithButtons(){
        Image imageFarmer = new ImageManager().getImage("../view/resources/farmer/farmerSide.png",
                WIDTH_PANE / 2, WIDTH_PANE / 2, true, false);
        farmerButton = new LSButton(imageFarmer, "farmer",
                HEIGHT_PANE / 3, WIDTH_PANE / 2, 0, 0);
        addToGridPane(farmerButton, 0, 0);

        Image imageTractor = new ImageManager().getImage("../view/resources/machines/tractorSide.png",
                WIDTH_PANE / 2, WIDTH_PANE / 2, true, false);
        tractorButton = new LSButton(imageTractor, "tractor",
                HEIGHT_PANE / 3, WIDTH_PANE / 2, 0, 0);
        addToGridPane(tractorButton, 1, 0);

        Image imageHarvester = new ImageManager().getImage("../view/resources/machines/harvesterSide.png",
                WIDTH_PANE / 2, WIDTH_PANE / 2, true, false);
        harvesterButton = new LSButton(imageHarvester, "harvester",
                HEIGHT_PANE / 3, WIDTH_PANE / 2, 0, 0);
        addToGridPane(harvesterButton, 0, 1);

        Image imageCultivator = new ImageManager().getImage("../view/resources/machines/cultivatorSide.png",
                WIDTH_PANE / 2, WIDTH_PANE / 2, true, false);
        cultivatorButton = new LSButton(imageCultivator, "cultivator",
                HEIGHT_PANE / 3, WIDTH_PANE / 2, 0, 0);
        addToGridPane(cultivatorButton, 1, 1);

        Image imageDumpTruck = new ImageManager().getImage("../view/resources/machines/dumpTruckSide.png",
                WIDTH_PANE / 2, WIDTH_PANE / 2, true, false);
        dumpTruckButton = new LSButton(imageDumpTruck, "drump truck",
                HEIGHT_PANE / 3, WIDTH_PANE / 2, 0, 0);
        addToGridPane(dumpTruckButton, 0, 2);

        Image imageSeedDrill = new ImageManager().getImage("../view/resources/machines/seedDrillSide.png",
                WIDTH_PANE / 2, WIDTH_PANE / 2, true, false);
        seedDrillButton = new LSButton(imageSeedDrill, "Seed Drill",
                HEIGHT_PANE / 3, WIDTH_PANE / 2, 0, 0);
        addToGridPane(seedDrillButton, 1, 2);
    }

    /**
     * Adds the given button to the machinePane at the given column and row index.
     *
     * @param button - button / node that is added to the machinePane
     * @param column - index of the column to which the node ist added
     * @param row - index of the row to which the node ist added
     */
    private void addToGridPane(LSButton button, int column, int row){
        machinePane.setColumnIndex(button, column);
        machinePane.setRowIndex(button, row);
        machinePane.getChildren().add(button);
    }

    /**
     * Sets the buttons of the machinePane disabled, depending on the parameters that are handed to this method.
     * Machines / farmer, that are not in use should be disabled when walking around and able to click when choosing
     * the next machine / farmer.
     *
     * @param farmer - sets the farmerButton disabled if true
     * @param tractor - sets the tractorButton disabled if true
     * @param harvester - sets the harvesterButton disabled if true
     * @param cultivator - sets the cultivatorButton disabled if true
     * @param dumpTruck - sets the dumpTruckButton disabled if true
     * @param seedDrill - sets the seedDrillButton disabled if true
     */
    private void setButtonsDisabled(boolean farmer, boolean tractor, boolean harvester, boolean cultivator,
                                    boolean dumpTruck, boolean seedDrill){
        farmerButton.setDisable(farmer);
        tractorButton.setDisable(tractor);
        harvesterButton.setDisable(harvester);
        cultivatorButton.setDisable(cultivator);
        dumpTruckButton.setDisable(dumpTruck);
        seedDrillButton.setDisable(seedDrill);
    }

    /**
     * Creates the buttons with those the player can move the machine / farmer around the matchfield as well as the
     * button that can be clicked, when some action is possible to do.
     */
    private void createControlButtons(){
        buttonUp = new LSButton("↑", 50, 50,95,HEIGHT/100*70, 20);
        buttonDown = new LSButton("↓", 50, 50, 95, HEIGHT/100*77, 20);
        buttonLeft = new LSButton("←", 50, 50,40,HEIGHT/100*77, 20);
        buttonRight = new LSButton("→", 50, 50,150,HEIGHT/100*77, 20);
        buttonAction = new LSButton("", 50, 150,45,HEIGHT/100*87, 20);
        buttonAction.setDisable(true);
        sidePane.getChildren().addAll(buttonUp, buttonDown, buttonLeft, buttonRight, buttonAction);
    }

    /**
     * Getter for the sidePane.
     *
     * @return - the requested sidePane
     */
    protected Pane getSidePane(){
        return sidePane;
    }

}
