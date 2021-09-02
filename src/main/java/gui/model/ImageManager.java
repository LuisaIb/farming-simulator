package gui.model;

import javafx.scene.image.Image;

/**
 * This class helps to load images. It offers a method, that returns an image.
 *
 * @author Judith Romer
 */
public class ImageManager {
    private Image image;

    /**
     * This method loads and returns an image.
     *
     * @param path - path to the image that will be loaded
     * @param width - sets the width of the image
     * @param height - sets the height of the image
     * @param preserveRatio - if the boolean is true, the ratio of the image is preserved otherwise it has the exact
     *                      height and width that is given with the other parameters no matter if the ratio is
     *                      preserved
     * @param smooth - if the boolean is true a better quality filtering algorithm is used, otherwise a faster one
     *               when scaling the image
     * @return the requested image
     */
    public Image getImage(String path, double width, double height, boolean preserveRatio, boolean smooth) {
        Image image = new Image(getClass().getResourceAsStream(path), width, height, preserveRatio, smooth);
        return image;
    }

}
