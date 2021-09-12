package gui.model;

import gameboard.GameValue;
import gameboard.objects.Farmer;
import gameboard.objects.Harvester;
import gameboard.objects.Tractor;
import gui.view.InformationBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class GameInformation {
    private InformationBox informationBox;

    public GameInformation(InformationBox informationBox, GameValue gameValue, Tractor tractor, Harvester harvester) {
        this.informationBox = informationBox;
        bindInformation(gameValue, tractor, harvester);
    }

    private void bindInformation(GameValue gameValue, Tractor tractor, Harvester harvester){
        gameValue.cashProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                informationBox.getMoneyField().setText(gameValue.getCashAsString());
            }
        });

        gameValue.day().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                informationBox.getTimeField().setText(gameValue.getDayAsString());
            }
        });

        tractor.petrolTankFillLevel().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                informationBox.getTractorField().setText(tractor.getPetrolTankFillLevelAsString());
            }
        });

        harvester.petrolTankFillLevel().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                informationBox.getHarvesterField().setText(harvester.getPetrolTankFillLevelAsString());
            }
        });


    }



}
