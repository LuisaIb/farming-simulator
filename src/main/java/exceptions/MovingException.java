package exceptions;

import gui.view.InformationBox;

/**
 * Exception class that is responsible for the exceptions that are thrown when the player tries to move the moving
 * object off the matchfield.
 */
public class MovingException extends Exception {
    /**
     * Constructor that sets the String of the parameter as text of the news tex field of the information box. This way
     * the player knows what the problem is.
     *
     * @param s a String that is set as text of the news field
     * @param informationBox the InformationBox object of the actual game
     */
    public MovingException(String s, InformationBox informationBox) {
        informationBox.getNewsField().setText(s);
    }
}
