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
     * This method returns an image from the path that is give to it in the parameters by using a constructor of
     * the class Image.
     *
     * @param path - path to the image that will be loaded, handed to the constructor of the class Image
     * @param width - sets the width of the image, handed to the constructor of the class Image
     * @param height - sets the height of the image, handed to the constructor of the class Image
     * @param preserveRatio - if the boolean is true, the ratio of the image is preserved otherwise it has the exact
     *                      height and width that is given with the other parameters no matter if the ratio is
     *                      preserved, handed to the constructor of the class Image
     * @param smooth - if the boolean is true a better quality filtering algorithm is used, otherwise a faster one
     *               when scaling the image, handed to the constructor of the class Image
     * @return the requested image
     */
    public Image getImage(String path, double width, double height, boolean preserveRatio, boolean smooth) {
        return image = new Image("file:" + path, width, height, preserveRatio, smooth);
    }

}
