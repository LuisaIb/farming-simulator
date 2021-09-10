package simulator;

import gameboard.objects.*;
import gameboard.tiles.FieldTile;
import gui.controller.MovingObjectController;
import gui.view.GameScene;
import gui.view.Matchfield;

/**
 * @author Isabel
 * @author lbcroj4
 *
 */
public class Game {
    private GameScene gameScene = new GameScene();
    MovingObjectController movingObjectController = new MovingObjectController();
    MovingObject movingObject = new MovingObject();
    Matchfield matchfield;
    private Farmer farmer;
    private Tractor tractor;
    private Harvester harvester;
    private Cultivator cultivator;
    private DumpTruck dumpTruck;
    private SeedDrill seedDrill;
    private FieldTile fieldTile;
    private int selectedObject;

    public GameScene createNewGame(){
        farmer = new Farmer();
        tractor = new Tractor();
        harvester = new Harvester();
        cultivator = new Cultivator();
        dumpTruck = new DumpTruck();
        seedDrill = new SeedDrill();
        fieldTile = new FieldTile();

        gameScene.initializeGameScene(farmer.isSelected(), tractor.isSelected(), harvester.isSelected(),
                cultivator.isSelected(), dumpTruck.isSelected(), seedDrill.isSelected(), fieldTile.getGrowthState(),
                fieldTile.getGrowthState2(), fieldTile.getGrowthState3(), getSelectedObject(), getColumn(), getRow());
        System.out.println(getSelectedObject());
        System.out.println(getColumn());
        System.out.println(getRow());
        movingObjectController.initGameLoop(gameScene);
        return gameScene;
    }

    public int getSelectedObject(){
        if (farmer.isSelected()) {
            selectedObject = 1;
            movingObject = farmer;
        } else if (tractor.isSelected()) {
            selectedObject = 2;
        } else if (harvester.isSelected()) {
            selectedObject = 3;
        }
        return selectedObject;
    }

    public int getRow(){
        selectedObject = getSelectedObject();
        if (selectedObject == 1) {
            return farmer.getY();
        }
        return 0;
    }

    public int getColumn(){
        selectedObject = getSelectedObject();
        if (selectedObject == 1) {
            return farmer.getX();
        }
        return 0;
    }

}
