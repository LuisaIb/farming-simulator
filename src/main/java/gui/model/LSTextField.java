package gui.model;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

/** This class provides text fields with a special design matching the theme of the game. The text fields are
 * not editable by the player.
 *
 * @author Judith
 */
public class LSTextField extends TextField {
    /**
     * String with the path to the background image of the text field
     */
    private final String IMAGE_PATH = "src/main/java/gui/model/resources/background.png";

    /**
     * Constructs an object of the class LSTextField. As you can tell by the name of the class, it creates a
     * text field.
     *
     * @param text text, that is shown in the text field
     * @param height height of the text field, handed to the method setTextFieldStyle()
     * @param width width of the text field, handed to the method setTextFieldStyle()
     * @param layoutX distance on the x-axis from the top left corner, handed to the method setTextFieldStyle()
     * @param layoutY distance on the y-axis from the top left corner, handed to the method setTextFieldStyle()
     * @param fontSize size of the font, handed to the method setTextFieldFont()
     */
    public LSTextField(String text, int height, int width, int layoutX, int layoutY, int fontSize) {
        this.setText(text);
        this.setTextFieldFont(fontSize);
        this.setTextFieldStyle(height, width, layoutX, layoutY);
    }

    /**
     * Sets the font of the text field to Verdana and the size of the font to the parameter fontSize.
     *
     * @param fontSize size of the font on the text field
     */
    private void setTextFieldFont(int fontSize){
        this.setFont(Font.font("Verdana", fontSize));
    }

    /**
     * Defines the style of the text field. It makes the text field not editable by the user, sets the background
     * image by using the method getImage() of the class ImageManager, the final variable and the parameters. The
     * alignment of the text is set to the center.
     *
     * @param height height of the text field
     * @param width width of the text field
     * @param layoutX distance on the x-axis from the top left corner
     * @param layoutY distance on the y-axis from the top left corner
     */
    private void setTextFieldStyle(int height, int width, int layoutX, int layoutY){
        this.setEditable(false);
        this.setMouseTransparent(true);
        this.setFocusTraversable(false);
        Image image = new ImageManager().getImage(IMAGE_PATH, width, height, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        this.setBackground(background);
        this.setPrefHeight(height);
        this.setPrefWidth(width);
        this.setLayoutX(layoutX);
        this.setLayoutY(layoutY);
        this.setAlignment(Pos.CENTER);
    }
}
