package gui.model;

import gameboard.GameValue;
import gui.view.InformationBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class GameInformation {
    private InformationBox informationBox;

    public GameInformation(InformationBox informationBox, GameValue gameValue) {
        this.informationBox = informationBox;
        bindInformation(gameValue);
    }

    private void bindInformation(GameValue gameValue){
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
    }



}
