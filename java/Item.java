// IPPO Assignment 2, Version 0.1, 28/11/2020
import javafx.scene.image.Image;

/**
 * Item Class: Holds and returns the image for an item
 *
 * @author Olivier Chaligne &lt;s2137159@ed.ac.uk&gt;
 * @version 0.1, 28/11/2020
 */

public class Item {

    // Variable to hold item image
    private Image itemImage;

    /**
     * Associate the specified image to the current item.
     *
     * @param image to associate to the item
     */
    public Item(Image image) {
        itemImage = image;
    }

    /**
     * Returns the image for the item.
     */
    public Image getItemImage() {
        return itemImage;
    }
}

