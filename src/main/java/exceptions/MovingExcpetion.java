package exceptions;

import gui.view.InformationBox;

public class MovingExcpetion extends Exception {
    //InformationBox informationBox = new InformationBox();

    public MovingExcpetion(String s) {
        //informationBox.getNewsField().setText(s);
        System.out.println(s);
    }
}
