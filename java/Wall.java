import javafx.scene.image.Image;

/**
 * Wall Class: Holds and returns the image, room associated and
 * presence of a door for a wall
 * @author Olivier Chaligne &lt;s2137159@ed.ac.uk&gt;
 * @version 0.1, 28/11/2020
 */

public class Wall {

    // Variable to hold wall image
    private Image wallImage;
    // Wall with a door (true/false)
    private boolean door;

    /**
     * Associate the specified image, room number and door
     * to a specific wall.
     * @param image to associate to the wall
     * @param door to associate to the wall
     */
    public Wall(Image image, boolean door) {
        wallImage = image;
        this.door = door;
    }

    /**
     * Returns the image for the wall.
     */
    public Image getWallImage() {return wallImage;}


    /**
     * Test for presence of a door on the wall.
     */
    public boolean hasDoor() {return door;}
}
