package gui.model;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

/** This class provides buttons with a special design matching the theme of the game.
 *
 * @author Judith Romer
 */
public class LSButton  extends Button {
    /* A variable, that saves the path to the background image of the button in a String. */
    private final String IMAGE_PATH = "src/main/java/gui/model/resources/background.png";

    /** Constructs an object of the class LandwirtschaftssimulatorButton with text on it and a nice background image
     * by using the methode setButtonBackground().
     *
     * @param text - text, that is shown on the button
     * @param height - height of the button, handed to the methods setButtonLayout() and setButtonBackground()
     * @param width - width of the button, handed to the methods setButtonLayout() and setButtonBackground()
     * @param layoutX - distance on the x-axis from the top left corner, handed to the method setButtonLayout()
     * @param layoutY - distance on the y-axis from the top left corner, handed to the method setButtonLayout()
     * @param fontSize - size of the font, handed to the method setButtonFont()
     */
    public LSButton(String text, int height, int width, int layoutX, int layoutY, int fontSize) {
        this.setText(text);
        this.setButtonFont(fontSize);
        this.setButtonBackground(height, width);
        this.setButtonLayout(height, width, layoutX, layoutY);
    }

    /** Constructs an object of the class LandwirtschaftssimulatorButton without text and background image, but with
     * an individualized image, that is given to the method as a parameter.
     *
     * @param image - image, that is shown on the button, handed to the method setButtonBackground()
     * @param height - height of the button, handed to the methods setButtonLayout() and setButtonBackground
     * @param width - width of the button, handed to the methods setButtonLayout() and setButtonBackground
     * @param layoutX - distance on the x-axis from the top left corner, handed to the method setButtonLayout()
     * @param layoutY - distance on the y-axis from the top left corner, handed to the method setButtonLayout()
     */
    public LSButton(Image image, String text, int height, int width, int layoutX, int layoutY) {
        this.setButtonLayout(height, width, layoutX, layoutY);
        this.setButtonBackground(image, height, width);
    }

    /** Sets the font of the button to Verdana and the size of the font to the fontSize.
     *
     * @param fontSize - size of the font on the button
     */
    private void setButtonFont(int fontSize){
        this.setFont(Font.font("Verdana", fontSize));
    }

    /** Defines the size and alignment of the button. The alignment of the text is set to the center.
     *
     * @param height - height of the button
     * @param width - width of the button
     * @param layoutX - distance on the x-axis from the top left corner
     * @param layoutY - distance on the y-axis from the top left corner
     */
    private void setButtonLayout(int height, int width, int layoutX, int layoutY){
        this.setPrefHeight(height);
        this.setPrefWidth(width);
        this.setLayoutX(layoutX);
        this.setLayoutY(layoutY);
        this.setAlignment(Pos.CENTER);
    }

    /** Sets the background image, using the method getImage() of the class ImageManager, the final variable and
     * the parameters. As the method will never be used outside this class, it is private.
     * @param height - height of the image, the same as the button
     * @param width - width of the image, the same as the button
     */
    private void setButtonBackground(int height, int width){
        Image image = new ImageManager().getImage(IMAGE_PATH, width, height, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
    }

    /** Sets the background image, using the image of the parameter. As the method will never be used outside this
     * class, it is private.
     * @param image - image, that is set as background
     * @param height - height of the image, the same as the button
     * @param width - width of the image, the same as the button
     */
    private void setButtonBackground(Image image, int height, int width){
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
    }

}
