package gui.controller;

import exceptions.MovingExcpetion;
import gameboard.GameValue;
import gameboard.objects.*;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.FieldTile;
import gameboard.tiles.Silo;
import gui.view.GameScene;
import gui.view.InformationBox;
import gui.view.Matchfield;
import gui.view.SideControlPane;

/**
 * This class implements some methods to move around and to process the fields.
 *
 * @author Judith
 */
public class MovingObjectController {
    // declaring some objects of the actual game that are initialized in the constructor
    /**
     * the actual GameScene object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private GameScene gameScene;
    /**
     * the actual MovingObject object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private MovingObject movingObject;
    /**
     * the actual GameController object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private GameController gameController;
    /**
     * the actual GameValue object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private GameValue gameValue;
    /**
     * the actual Farmer object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private Farmer farmer;
    /**
     * the actual Tractor object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private Tractor tractor;
    /**
     * the actual Harvester object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private Harvester harvester;
    /**
     * the actual Cultivator object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private Cultivator cultivator;
    /**
     * the actual DumpTruck object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private DumpTruck dumpTruck;
    /**
     * the actual SeedDrill object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private SeedDrill seedDrill;
    /**
     * the actual FieldTile object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private FieldTile fieldTile;
    /**
     * the actual Matchfield object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private Matchfield matchfield;
    /**
     * the actual SideControlPane object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private SideControlPane sideControlPane;
    /**
     * the actual Silo object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private Silo silo;
    /**
     * the actual CourtTrade object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private CourtTrade courtTrade;
    /**
     * an object of the class MovingObjectFunctionalityController to create some functionality of the moving object
     */
    private MovingObjectFunctionalityController mofc;


    /**
     * Constructor of the class MovingObjectController that initializes some objects and by calling the method
     * initializeFunctionaliy() an object of the class MovingObjectFunctionalityController to make some actions possible.
     *
     * @param gameScene the gameScene object of the actual game
     * @param movingObject the movingObject object of the actual game
     * @param gameController the gameController object of the actual game
     * @param gameValue the gameValue object of the actual game
     * @param farmer the farmer object of the actual game
     * @param tractor the tractor object of the actual game
     * @param harvester the harvester object of the actual game
     * @param cultivator the cultivator object of the actual game
     * @param dumpTruck the dumpTruck object of the actual game
     * @param seedDrill the seedDrill objet of the actual game
     * @param fieldTile the fieldTile object of the actual game
     * @param silo the silo object of the actual game
     * @param courtTrade the courtTrade object of the actual game
     */
    public MovingObjectController(GameScene gameScene, MovingObject movingObject, GameController gameController,
                                  GameValue gameValue, Farmer farmer, Tractor tractor, Harvester harvester,
                                  Cultivator cultivator, DumpTruck dumpTruck, SeedDrill seedDrill, FieldTile fieldTile,
                                  Silo silo, CourtTrade courtTrade){
        this.gameScene = gameScene;
        this.movingObject = movingObject;
        this.gameController = gameController;
        this.gameValue = gameValue;
        this.farmer = farmer;
        this.tractor = tractor;
        this.harvester = harvester;
        this.cultivator = cultivator;
        this.dumpTruck = dumpTruck;
        this.seedDrill = seedDrill;
        this.fieldTile = fieldTile;
        this.silo = silo;
        this.courtTrade = courtTrade;
        this.matchfield = gameScene.getMatchfield();
        this.sideControlPane = gameScene.getSideControlPane();
        initializeFunctionality();
    }

    /**
     * This method initializes an object of the class MovingObjectFunctionalityController and hands to the constructor
     * the gameScene object of the actual game.
     */
    private void initializeFunctionality(){
        mofc = new MovingObjectFunctionalityController(gameScene);
    }


    /**
     * This method proofs if only one of the directions right, left, up and down is pressed. It calls the method
     * move() and hands it a character depending on the direction in which the moving object is moving.
     */
    public void moveObject() {
        // checking if only one of the directions is pressed because the moving object can not move diagonally
        if (gameController.isRightPressed() && !gameController.isLeftPressed() &&
                !gameController.isUpPressed() && !gameController.isDownPressed()) {
            move('r');
        }
        if (gameController.isLeftPressed() && !gameController.isRightPressed() &&
                !gameController.isUpPressed() && !gameController.isDownPressed()) {
            move('l');
        }
        if (gameController.isUpPressed() && !gameController.isRightPressed() &&
                !gameController.isLeftPressed() && !gameController.isDownPressed()) {
           move('u');
        }
        if (gameController.isDownPressed() && !gameController.isRightPressed() &&
                !gameController.isLeftPressed() && !gameController.isUpPressed()) {
            move('d');
        }
    }

    /**
     * This method moves the moving object depending on the direction that is handed to it. If moving is successful it
     * sets the boolean true and the image view of the moving object is set to the new tile with the help of the method
     * movingSuccessful().
     *
     * @param direction to which the player want to move the moving object
     */
    private void move(char direction){
        // method to set the rotation of the image view to the right one
        rotate(direction);
        boolean moveSuccess = false;
        // new values of x and y of the moving object to set the image view
        int newX = 0;
        int newY = 0;
        // checking the character for the direction to move
        if (direction == 'r') {
            try {
                // if moving isn't successful the rest of the try-block will not be performed so there's no need to proof that
                movingObject.moveRight(gameScene);
                moveSuccess = true;
                newX = matchfield.getColumnOfMovingObject()+1;
                newY = matchfield.getRowOfMovingObject();
            } catch (MovingExcpetion e) {
                // if moving isn't possible there is nothing happening
            }
        }
        if (direction == 'l') {
            try {
                movingObject.moveLeft(gameScene);
                moveSuccess = true;
                newX = matchfield.getColumnOfMovingObject()-1;
                newY = matchfield.getRowOfMovingObject();
            } catch (MovingExcpetion e) {
                // if moving isn't possible there is nothing happening
            }
        }
        if (direction == 'u') {
            try {
                movingObject.moveUp(gameScene);
                moveSuccess = true;
                newX = matchfield.getColumnOfMovingObject();
                newY = matchfield.getRowOfMovingObject()-1;
            } catch (MovingExcpetion e) {
                // if moving isn't possible there is nothing happening
            }
        }
        if (direction == 'd') {
            try {
                movingObject.moveDown(gameScene);
                moveSuccess = true;
                newX = matchfield.getColumnOfMovingObject();
                newY = matchfield.getRowOfMovingObject()+1;
            } catch (MovingExcpetion e) {
                // if moving isn't possible there is nothing happening
            }
        }

        if (moveSuccess) {
            movingSuccessful(newX, newY);
        }
    }

    /**
     * If moving is successful the image view of the moving object is set to the new tile and if the tractor or the
     * harvester is selected the tank gets decreased.
     *
     * @param x column to which the moving object is set
     * @param y row to which the moving object is set
     */
    private void movingSuccessful(int x, int y){
        matchfield.setTileOfObject(x, y);
        if (tractor.isSelected()) {
            // the actual gameScene object has to be handed to the method because when the tank gets too low there is
            // a message shown in the information Box
            tractor.lowPetrolLevel(tractor.getPetrolTankFillLevel()-1, gameScene);
        }
        if (harvester.isSelected()) {
            harvester.lowPetrolLevel(harvester.getPetrolTankFillLevel()-1, gameScene);
        }
    }

    /**
     * This method rotates the image view of the moving object depending on the moving direction.
     *
     * @param direction moving direction of the moving object
     */
    private void rotate(char direction){
        switch (direction) {
            case 'r':
                matchfield.getMovingObjectImageView().setRotate(270);
                break;
            case 'l':
                matchfield.getMovingObjectImageView().setRotate(90);
                break;
            case 'u':
                matchfield.getMovingObjectImageView().setRotate(180);
                break;
            case 'd':
                matchfield.getMovingObjectImageView().setRotate(0);
                break;
        }
    }

    /**
     * This method proofs, if some action is possible on the tile on which the moving object is standing. If some
     * action is possible the button isn't disabled any longer and the text of the button show what action is possible.
     */
    public void proofAction(){
        // x and y of the moving object as they are needed for the if-else-statements
        int x = movingObject.getX();
        int y = movingObject.getY();
        // initializing the functionality of the action button and handing it all the actual needed objects
        mofc.proofActionButtonFunctionality(x, y, movingObject, gameValue, farmer, tractor, harvester, cultivator,
                dumpTruck, seedDrill, fieldTile, silo, courtTrade);
        // rotation needed for unloading from harvester to dump truck
        double rotation = gameScene.getMatchfield().getMovingObjectImageView().getRotate();

        if ((x == 16 || x == 17) && y == 13) {
            setButtonAction(false, "select vehicle");
        } else if (x == 27 && y == 5 && farmer.isSelected() && !fieldTile.isOwningField3()) {
            setButtonAction(false, "buy field");
        } else if (x == 27 && y == 5 && dumpTruck.isSelected() && dumpTruck.getGrainFillLevel() != 0) {
            setButtonAction(false, "sell grain");
        } else if((x == 14 || x == 15) && y == 5 && (tractor.isSelected() && tractor.getPetrolTankFillLevel() < 200
                || harvester.isSelected() && harvester.getPetrolTankFillLevel() < 200)) {
            setButtonAction(false, "fill tank");
        } else if ((x == 12 || x == 13) && y == 13 && dumpTruck.isSelected()) {
            if (dumpTruck.getGrainFillLevel() != 0) {
                // unload from dump truck to silo
                setButtonAction(false, "unload");
            } else if (dumpTruck.getGrainFillLevel() != dumpTruck.getGrainTankCapacity()) {
                // load dump truck from silo
                setButtonAction(false, "load");
            }
        // checking if it is possible to exit the vehicle on the left side or if there is a not passable tile
        } else if (tractor.isSelected() && ((rotation == 0 && movingObject.proofPassabilty(x+1, y)) ||
                rotation == 90 && movingObject.proofPassabilty(x, y+1) ||
                rotation == 180 && movingObject.proofPassabilty(x-1, y) ||
                rotation == 270 && movingObject.proofPassabilty(x, y-1))) {
            setButtonAction(false, "exit vehicle");
            if (tractor.isSelected() || !tractor.isAttachement()) {
                sideControlPane.getCultivatorButton().setDisable(true);
                sideControlPane.getDumpTruckButton().setDisable(true);
                sideControlPane.getSeedDrillButton().setDisable(true);
            }
        // proofing if the farmer is standing on the left side of the tractor to enter it again
        } else if (farmer.isSelected() && mofc.isTractorExited() &&
                x == mofc.getColumnExited() &&
                y == mofc.getRowExited()) {
            setButtonAction(false, "enter vehicle");
        // to unload from harvester to dump truck is has to be on the right side of the dump truck and looking into the
        // same direction
        } else if(harvester.isSelected() && harvester.getGrainTankFillLevel() != 0 &&
                (mofc.getExitedObject() == 5 || mofc.getExitedObject() == 6) &&
                mofc.getRotation() == matchfield.getMovingObjectImageView().getRotate() &&
                x == mofc.getColumnToFillFromHarvester() &&
                y == mofc.getRowToFillFromHarvester()) {
            setButtonAction(false, "unload");
        // if the player selects the tractor and no attachment and walks away from the barn the buttons of the working
        // devices have to be set disabled
        } else {
            setButtonAction(true, "");
            if (tractor.isSelected() || !tractor.isAttachement()) {
                sideControlPane.getCultivatorButton().setDisable(true);
                sideControlPane.getDumpTruckButton().setDisable(true);
                sideControlPane.getSeedDrillButton().setDisable(true);
            }
        }
    }

    /**
     * This method helps to set the button action disabled or able to click and to set the text of it.
     *
     * @param disabled boolean to set the action button disabled
     * @param text text that is shown on the action button
     */
    private void setButtonAction(boolean disabled, String text){
        gameScene.getSideControlPane().getButtonAction().setDisable(disabled);
        gameScene.getSideControlPane().getButtonAction().setText(text);
    }

    /**
     * This method proofs if the right machine or working device is attached to process the field depending on the
     * stage of growth.
     */
    public void proofFieldAction(){
        // column and row of the moving object to proof later, if it is one of the fields
        int x = movingObject.getX();
        int y = movingObject.getY();
        // field 1
        if (x > 19 && y > 13) {
            if (cultivator.isSelected() && fieldTile.getGrowthState() == 6) {
                // if the field is growth state 6 it has to be cultivated, therefore the cultivator has to be attached
                // to cultivate the field the method cultivateField() of the class fieldTile is called
                fieldTile.cultivateField(gameScene.getMatchfield(), x, y, 1, gameScene.getInformationBox());
            }
            if (seedDrill.isSelected() && fieldTile.getGrowthState() == 1) {
                fieldTile.sowField(gameScene.getMatchfield(), x, y, 1, gameScene.getInformationBox());
            }
            if (harvester.isSelected() && fieldTile.getGrowthState() == 5) {
                fieldTile.harvestField(gameScene.getMatchfield(), x, y, 1, gameScene.getInformationBox(), harvester);
            }
        // field 2
        } else if(x > 8 && x < 19 && y > 13) {
            if (cultivator.isSelected() && fieldTile.getGrowthState2() == 6) {
                fieldTile.cultivateField(gameScene.getMatchfield(), x, y, 2, gameScene.getInformationBox());
            }
            if (seedDrill.isSelected() && fieldTile.getGrowthState2() == 1) {
                fieldTile.sowField(gameScene.getMatchfield(), x, y, 2, gameScene.getInformationBox());
            }
            if (harvester.isSelected() && fieldTile.getGrowthState2() == 5) {
                fieldTile.harvestField(gameScene.getMatchfield(), x, y, 2, gameScene.getInformationBox(), harvester);
            }
        // field 3
        } else if (x > 19 && y > 5 && y < 13) {
            if (cultivator.isSelected() && fieldTile.getGrowthState3() == 6) {
                fieldTile.cultivateField(gameScene.getMatchfield(), x, y, 3, gameScene.getInformationBox());
            }
            if (seedDrill.isSelected() && fieldTile.getGrowthState3() == 1) {
                fieldTile.sowField(gameScene.getMatchfield(), x, y, 3, gameScene.getInformationBox());
            }
            if (harvester.isSelected() && fieldTile.getGrowthState3() == 5) {
                fieldTile.harvestField(gameScene.getMatchfield(), x, y, 3, gameScene.getInformationBox(), harvester);
            }
        }
    }

}
