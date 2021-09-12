package simulator;

import datastorage.information.fromjsonb.GetSavingInformationMovingObject;
import datastorage.information.fromjsonb.GetSavingInformationValue;
import datastorage.jsonb.GetJsonbMovingObject;
import datastorage.jsonb.GetJsonbValue;
import gameboard.GameValue;
import gameboard.tiles.CourtTrade;
import gameboard.tiles.Silo;
import gui.controller.MovingObjectController;
import gameboard.objects.*;
import gameboard.tiles.FieldTile;
import gui.view.GameScene;

/**
 * @author Isabel
 *
 */
public class Game {

    MovingObject movingObject = new MovingObject();
    private Farmer farmer;
    private Tractor tractor;
    private Harvester harvester;
    private Cultivator cultivator;
    private DumpTruck dumpTruck;
    private SeedDrill seedDrill;
    private FieldTile fieldTile;
    private int selectedObject;
    private GameValue gameValue;
    private LevelOfDifficulty levelOfDifficulty;
    private Silo silo;
    private CourtTrade courtTrade;


    public GameScene createNewGame(){
        GameScene gameScene = new GameScene();
        MovingObjectController movingObjectController = new MovingObjectController();
        gameValue = new GameValue();
        silo = new Silo();
        courtTrade = new CourtTrade();
        farmer = new Farmer();
        tractor = new Tractor();
        harvester = new Harvester();
        cultivator = new Cultivator();
        dumpTruck = new DumpTruck();
        seedDrill = new SeedDrill();
        fieldTile = new FieldTile(1, 0 , 2);

        gameScene.initializeGameScene(farmer.isSelected(),tractor.isSelected(),harvester.isSelected(),
                cultivator.isSelected(),dumpTruck.isSelected(),seedDrill.isSelected(),fieldTile.getGrowthState(),
                fieldTile.getGrowthState2(), fieldTile.getGrowthState3(), getSelectedObject(),getColumn(),getRow());
        System.out.println(getSelectedObject());
        System.out.println(getColumn());
        System.out.println(getRow());
        movingObjectController.initGameLoop(gameScene, fieldTile, farmer);
        return gameScene;
    }

    public int getSelectedObject(){
        if(farmer.isSelected()){
            selectedObject=1;
            movingObject=farmer;
        }else if(tractor.isSelected()){
            selectedObject=2;
        }else if(harvester.isSelected()){
            selectedObject=3;
        } else if(cultivator.isSelected()) {
            selectedObject = 4;
        } else if (dumpTruck.isSelected()) {
            selectedObject = 5;
        } else if (seedDrill.isSelected()) {
            selectedObject = 6;
        }
        return selectedObject;
    }

    public int getRow(){
        selectedObject=getSelectedObject();
        if(selectedObject==1){
            return farmer.getY();
        }
        return 0;
    }

    public int getColumn(){
        selectedObject=getSelectedObject();
        if(selectedObject==1){
            return farmer.getX();
        }
        return 0;
    }

    public void saveGame(){
        // all numeric values
        GetJsonbValue gjv = new GetJsonbValue();
        gjv.toSerializeGame();
        gjv.toSerializeLevel();
        gjv.toSerializeFieldtiles();// Exception werfen um speicher vorgan zu pr�fen
        gjv.toSerializeSilo();
        gjv.toSerializeCourtTrade();

        // all position values
        GetJsonbMovingObject gjp = new GetJsonbMovingObject();
        gjp.toSerializeFarmer(farmer);
        gjp.toSerializeTractor();
        gjp.toSerializeHarvester();// Exception
        gjp.toSerializeCultivator();
        gjp.toSerializeDumpTruck();
        gjp.toSerializeSeedDrill();


    }

    public GameScene reloadGame(){
        GameScene gameScene = new GameScene();
        MovingObjectController movingObjectController = new MovingObjectController();
        //all numeric values
        GetSavingInformationValue siv = new GetSavingInformationValue();
        gameValue = siv.GetSavingInformationGame();
        //levelOfDifficulty = siv.GetSavingInformationLevel();
        fieldTile = siv.GetSavingInformationFieldtiles();// Exception
        silo = siv.GetSavingInformationSilo();
        courtTrade = siv.GetSavingInformationCourtTrade();

        // all positions
        GetSavingInformationMovingObject sip = new GetSavingInformationMovingObject();
        farmer = sip.GetSavingInformationFarmer();
        tractor = sip.GetSavingInformationTractor();
        harvester = sip.GetSavingInformationHarvster();// Exception
        cultivator = sip.GetSavingInformationCultivator();
        dumpTruck = sip.GetSavingInformationDumpTruck();
        seedDrill = sip.GetSavingInformationSeedDrill();

        gameScene.initializeGameScene(farmer.isSelected(),tractor.isSelected(),harvester.isSelected(),
                cultivator.isSelected(),dumpTruck.isSelected(),seedDrill.isSelected(),fieldTile.getGrowthState(),
                fieldTile.getGrowthState2(), fieldTile.getGrowthState3(), getSelectedObject(),getColumn(),getRow());
        movingObjectController.initGameLoop(gameScene, fieldTile, farmer);
        return gameScene;
    }

}
