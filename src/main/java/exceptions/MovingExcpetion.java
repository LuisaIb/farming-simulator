package exceptions;

import gui.view.InformationBox;

public class MovingExcpetion extends Exception {

    public MovingExcpetion(String s, InformationBox informationBox) {
        informationBox.getNewsField().setText(s);
    }
}
