package gui.controller;

import exceptions.MovingException;
import gameboard.GameValue;
import gameboard.objects.*;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.FieldTile;
import gameboard.tiles.Silo;
import gui.view.GameScene;
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
     * the actual GAME_SCENE object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final GameScene GAME_SCENE;
    /**
     * the actual MovingObject object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final MovingObject MOVING_OBJECT;
    /**
     * the actual GameController object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final GameController GAME_CONTROLLER;
    /**
     * the actual GameValue object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final GameValue GAME_VALUE;
    /**
     * the actual Farmer object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final Farmer FARMER;
    /**
     * the actual Tractor object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final Tractor TRACTOR;
    /**
     * the actual Harvester object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final Harvester HARVESTER;
    /**
     * the actual Cultivator object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final Cultivator CULTIVATOR;
    /**
     * the actual DumpTruck object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final DumpTruck DUMP_TRUCK;
    /**
     * the actual SeedDrill object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final SeedDrill SEED_DRILL;
    /**
     * the actual FieldTile object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final FieldTile FIELD_TILE;
    /**
     * the actual Matchfield object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final Matchfield MATCHFIELD;
    /**
     * the actual SideControlPane object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final SideControlPane SIDE_CONTROL_PANE;
    /**
     * the actual Silo object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final Silo SILO;
    /**
     * the actual CourtTrade object that has been created in the method createNewGame() or reloadGame() in the class Game
     */
    private final CourtTrade COURT_TRADE;
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
        GAME_SCENE = gameScene;
        MOVING_OBJECT = movingObject;
        GAME_CONTROLLER = gameController;
        GAME_VALUE = gameValue;
        FARMER = farmer;
        TRACTOR = tractor;
        HARVESTER = harvester;
        CULTIVATOR = cultivator;
        DUMP_TRUCK = dumpTruck;
        SEED_DRILL = seedDrill;
        FIELD_TILE = fieldTile;
        SILO = silo;
        COURT_TRADE = courtTrade;
        MATCHFIELD = GAME_SCENE.getMatchfield();
        SIDE_CONTROL_PANE = GAME_SCENE.getSideControlPane();
        initializeFunctionality();
    }

    /**
     * This method initializes an object of the class MovingObjectFunctionalityController and hands to the constructor
     * the GAME_SCENE object of the actual game.
     */
    private void initializeFunctionality(){
        mofc = new MovingObjectFunctionalityController(GAME_SCENE);
    }


    /**
     * This method proofs if only one of the directions right, left, up and down is pressed. It calls the method
     * move() and hands it a character depending on the direction in which the moving object is moving.
     */
    public void moveObject() {
        // checking if only one of the directions is pressed because the moving object can not move diagonally
        if (GAME_CONTROLLER.isRightPressed() && !GAME_CONTROLLER.isLeftPressed() &&
                !GAME_CONTROLLER.isUpPressed() && !GAME_CONTROLLER.isDownPressed()) {
            move('r');
        }
        if (GAME_CONTROLLER.isLeftPressed() && !GAME_CONTROLLER.isRightPressed() &&
                !GAME_CONTROLLER.isUpPressed() && !GAME_CONTROLLER.isDownPressed()) {
            move('l');
        }
        if (GAME_CONTROLLER.isUpPressed() && !GAME_CONTROLLER.isRightPressed() &&
                !GAME_CONTROLLER.isLeftPressed() && !GAME_CONTROLLER.isDownPressed()) {
           move('u');
        }
        if (GAME_CONTROLLER.isDownPressed() && !GAME_CONTROLLER.isRightPressed() &&
                !GAME_CONTROLLER.isLeftPressed() && !GAME_CONTROLLER.isUpPressed()) {
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
                MOVING_OBJECT.moveRight(GAME_SCENE);
                moveSuccess = true;
                newX = MATCHFIELD.getColumnOfMovingObject()+1;
                newY = MATCHFIELD.getRowOfMovingObject();
            } catch (MovingException e) {
                // if moving isn't possible there is nothing happening
            }
        }
        if (direction == 'l') {
            try {
                MOVING_OBJECT.moveLeft(GAME_SCENE);
                moveSuccess = true;
                newX = MATCHFIELD.getColumnOfMovingObject()-1;
                newY = MATCHFIELD.getRowOfMovingObject();
            } catch (MovingException e) {
                // if moving isn't possible there is nothing happening
            }
        }
        if (direction == 'u') {
            try {
                MOVING_OBJECT.moveUp(GAME_SCENE);
                moveSuccess = true;
                newX = MATCHFIELD.getColumnOfMovingObject();
                newY = MATCHFIELD.getRowOfMovingObject()-1;
            } catch (MovingException e) {
                // if moving isn't possible there is nothing happening
            }
        }
        if (direction == 'd') {
            try {
                MOVING_OBJECT.moveDown(GAME_SCENE);
                moveSuccess = true;
                newX = MATCHFIELD.getColumnOfMovingObject();
                newY = MATCHFIELD.getRowOfMovingObject()+1;
            } catch (MovingException e) {
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
        MATCHFIELD.setTileOfObject(x, y);
        if (TRACTOR.isSelected()) {
            // the actual GAME_SCENE object has to be handed to the method because when the tank gets too low there is
            // a message shown in the information Box
            TRACTOR.lowPetrolLevel(TRACTOR.getPetrolTankFillLevel()-1, GAME_SCENE);
        }
        if (HARVESTER.isSelected()) {
            HARVESTER.lowPetrolLevel(HARVESTER.getPetrolTankFillLevel()-1, GAME_SCENE);
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
                MATCHFIELD.getMovingObjectImageView().setRotate(270);
                break;
            case 'l':
                MATCHFIELD.getMovingObjectImageView().setRotate(90);
                break;
            case 'u':
                MATCHFIELD.getMovingObjectImageView().setRotate(180);
                break;
            case 'd':
                MATCHFIELD.getMovingObjectImageView().setRotate(0);
                break;
        }
    }

    /**
     * This method proofs, if some action is possible on the tile on which the moving object is standing. If some
     * action is possible the button isn't disabled any longer and the text of the button show what action is possible.
     */
    public void proofAction(){
        // x and y of the moving object as they are needed for the if-else-statements
        int x = MOVING_OBJECT.getX();
        int y = MOVING_OBJECT.getY();
        // initializing the functionality of the action button and handing it all the actual needed objects
        mofc.proofActionButtonFunctionality(x, y, MOVING_OBJECT, GAME_VALUE, FARMER, TRACTOR, HARVESTER, CULTIVATOR,
                DUMP_TRUCK, SEED_DRILL, FIELD_TILE, SILO, COURT_TRADE);
        // rotation needed for unloading from harvester to dump truck
        double rotation = GAME_SCENE.getMatchfield().getMovingObjectImageView().getRotate();

        if ((x == 16 || x == 17) && y == 13) {
            setButtonAction(false, "select vehicle");
        } else if (x == 27 && y == 5 && FARMER.isSelected() && !FIELD_TILE.isOwningField3()) {
            setButtonAction(false, "buy field");
        } else if (x == 27 && y == 5 && DUMP_TRUCK.isSelected() && DUMP_TRUCK.getGrainFillLevel() != 0) {
            setButtonAction(false, "sell grain");
        } else if((x == 14 || x == 15) && y == 5 && (TRACTOR.isSelected() && TRACTOR.getPetrolTankFillLevel() < 200
                || HARVESTER.isSelected() && HARVESTER.getPetrolTankFillLevel() < 200)) {
            setButtonAction(false, "fill tank");
        } else if ((x == 12 || x == 13) && y == 13 && DUMP_TRUCK.isSelected()) {
            if (DUMP_TRUCK.getGrainFillLevel() != 0) {
                // unload from dump truck to silo
                setButtonAction(false, "unload");
            } else if (DUMP_TRUCK.getGrainFillLevel() != DUMP_TRUCK.getGrainTankCapacity()) {
                // load dump truck from silo
                setButtonAction(false, "load");
            }
        // checking if it is possible to exit the vehicle on the left side or if there is a not passable tile
        } else if (TRACTOR.isSelected() && ((rotation == 0 && MOVING_OBJECT.proofPassabilty(x+1, y)) ||
                rotation == 90 && MOVING_OBJECT.proofPassabilty(x, y+1) ||
                rotation == 180 && MOVING_OBJECT.proofPassabilty(x-1, y) ||
                rotation == 270 && MOVING_OBJECT.proofPassabilty(x, y-1))) {
            setButtonAction(false, "exit vehicle");
            if (TRACTOR.isSelected() || !TRACTOR.isAttachement()) {
                SIDE_CONTROL_PANE.getCultivatorButton().setDisable(true);
                SIDE_CONTROL_PANE.getDumpTruckButton().setDisable(true);
                SIDE_CONTROL_PANE.getSeedDrillButton().setDisable(true);
            }
        // proofing if the farmer is standing on the left side of the tractor to enter it again
        } else if (FARMER.isSelected() && mofc.isTractorExited() &&
                x == mofc.getColumnExited() &&
                y == mofc.getRowExited()) {
            setButtonAction(false, "enter vehicle");
        // to unload from harvester to dump truck is has to be on the right side of the dump truck and looking into the
        // same direction
        } else if(HARVESTER.isSelected() && HARVESTER.getGrainTankFillLevel() != 0 &&
                (mofc.getExitedObject() == 5 || mofc.getExitedObject() == 6) &&
                mofc.getRotation() == MATCHFIELD.getMovingObjectImageView().getRotate() &&
                x == mofc.getColumnToFillFromHarvester() &&
                y == mofc.getRowToFillFromHarvester()) {
            setButtonAction(false, "unload");
        // if the player selects the tractor and no attachment and walks away from the barn the buttons of the working
        // devices have to be set disabled
        } else {
            setButtonAction(true, "");
            if (TRACTOR.isSelected() || !TRACTOR.isAttachement()) {
                SIDE_CONTROL_PANE.getCultivatorButton().setDisable(true);
                SIDE_CONTROL_PANE.getDumpTruckButton().setDisable(true);
                SIDE_CONTROL_PANE.getSeedDrillButton().setDisable(true);
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
        GAME_SCENE.getSideControlPane().getButtonAction().setDisable(disabled);
        GAME_SCENE.getSideControlPane().getButtonAction().setText(text);
    }

    /**
     * This method proofs if the right machine or working device is attached to process the field depending on the
     * stage of growth.
     */
    public void proofFieldAction(){
        // column and row of the moving object to proof later, if it is one of the fields
        int x = MOVING_OBJECT.getX();
        int y = MOVING_OBJECT.getY();
        // field 1
        if (x > 19 && y > 13) {
            if (CULTIVATOR.isSelected() && FIELD_TILE.getGrowthState() == 6) {
                // if the field is growth state 6 it has to be cultivated, therefore the cultivator has to be attached
                // to cultivate the field the method cultivateField() of the class fieldTile is called
                FIELD_TILE.cultivateField(GAME_SCENE.getMatchfield(), x, y, 1, GAME_SCENE.getInformationBox());
            }
            if (SEED_DRILL.isSelected() && FIELD_TILE.getGrowthState() == 1) {
                FIELD_TILE.sowField(GAME_SCENE.getMatchfield(), x, y, 1, GAME_SCENE.getInformationBox());
            }
            if (HARVESTER.isSelected() && FIELD_TILE.getGrowthState() == 5) {
                FIELD_TILE.harvestField(GAME_SCENE.getMatchfield(), x, y, 1, GAME_SCENE.getInformationBox(), HARVESTER);
            }
        // field 2
        } else if(x > 8 && x < 19 && y > 13) {
            if (CULTIVATOR.isSelected() && FIELD_TILE.getGrowthState2() == 6) {
                FIELD_TILE.cultivateField(GAME_SCENE.getMatchfield(), x, y, 2, GAME_SCENE.getInformationBox());
            }
            if (SEED_DRILL.isSelected() && FIELD_TILE.getGrowthState2() == 1) {
                FIELD_TILE.sowField(GAME_SCENE.getMatchfield(), x, y, 2, GAME_SCENE.getInformationBox());
            }
            if (HARVESTER.isSelected() && FIELD_TILE.getGrowthState2() == 5) {
                FIELD_TILE.harvestField(GAME_SCENE.getMatchfield(), x, y, 2, GAME_SCENE.getInformationBox(), HARVESTER);
            }
        // field 3
        } else if (x > 19 && y > 5 && y < 13) {
            if (CULTIVATOR.isSelected() && FIELD_TILE.getGrowthState3() == 6) {
                FIELD_TILE.cultivateField(GAME_SCENE.getMatchfield(), x, y, 3, GAME_SCENE.getInformationBox());
            }
            if (SEED_DRILL.isSelected() && FIELD_TILE.getGrowthState3() == 1) {
                FIELD_TILE.sowField(GAME_SCENE.getMatchfield(), x, y, 3, GAME_SCENE.getInformationBox());
            }
            if (HARVESTER.isSelected() && FIELD_TILE.getGrowthState3() == 5) {
                FIELD_TILE.harvestField(GAME_SCENE.getMatchfield(), x, y, 3, GAME_SCENE.getInformationBox(), HARVESTER);
            }
        }
    }

}
