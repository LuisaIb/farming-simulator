package gui.model;

import gameboard.GameValue;
import gameboard.objects.Harvester;
import gameboard.objects.Tractor;
import gameboard.tiles.Silo;
import gui.view.InformationBox;

/**
 * This class adds listeners to all the Properties that are shown in the gameScene. With the help of this class nobody
 * has to care that the actual values are shown.
 *
 * @author Judith
 */
public class GameInformation {
    /**
     * the InformationBox object of the actual game that is initialized in the constructor
     */
    private final InformationBox INFORMATION_BOX;

    /**
     * This method constructs an object of the class GameInformation. When it is called it gets the actual
     * objects handed over, and it starts to synchronize the information by calling the method
     * synchronizeInformation().
     *
     * @param informationBox the informationBox of the actual gameScene to get access to the newsField
     * @param gameValue the actual object of the class GameValue to get access to the properties
     * @param tractor the actual object of the class Tractor to get access to the property
     * @param harvester the actual object of the class Harvester to get access to the property
     * @param silo the actual object of the class Silo to get access to the property
     */
    public GameInformation(InformationBox informationBox, GameValue gameValue, Tractor tractor, Harvester harvester,
                           Silo silo) {
        INFORMATION_BOX = informationBox;
        synchronizeInformation(gameValue, tractor, harvester, silo);
    }

    /**
     * This method implements listeners to synchronize the information shown in the gameScene with the properties.
     *
     * @param gameValue the actual object of the class GameValue to get access to the properties
     * @param tractor the actual object of the class Tractor to get access to the property
     * @param harvester the actual object of the class Harvester to get access to the property
     * @param silo the actual object of the class Silo to get access to the property
     */
    private void synchronizeInformation(GameValue gameValue, Tractor tractor, Harvester harvester, Silo silo){
        gameValue.cash().addListener((observableValue, number, t1) ->
                INFORMATION_BOX.getMoneyField().setText("money: " + gameValue.getCashAsString()));

        gameValue.day().addListener((observableValue, number, t1) ->
                INFORMATION_BOX.getTimeField().setText("day: " + gameValue.getDayAsString()));

        tractor.petrolTankFillLevel().addListener((observableValue, number, t1) ->
                INFORMATION_BOX.getTractorField().setText("petrol tractor: " + tractor.getPetrolTankFillLevelAsString()));

        harvester.petrolTankFillLevel().addListener((observableValue, number, t1) ->
                INFORMATION_BOX.getHarvesterField().setText("petrol harvester: " + harvester.getPetrolTankFillLevelAsString()));

        silo.capacity().addListener((observableValue, number, t1) ->
                INFORMATION_BOX.getSiloField().setText("corn in silo: " + silo.getFillLevelAsString()));
    }
}
