// IPPO Assignment 2, Version 0.1, 28/11/2020
import javafx.scene.image.Image;

import java.util.*;

/**
 * Wall Class: Holds and returns the image, room associated and
 * presence of a door for a wall
 * @author Olivier Chaligne &lt;s2137159@ed.ac.uk&gt;
 * @version 0.1, 28/11/2020
 */
public class Room {
    // Variable to hold walls collection
    private LinkedList walls;
    // Variable to hold room number
    private int roomNumber;
    // Variable to hold Item in the room
    private Item itemObject = null;
    // Variable to hold a wall object
    private Wall wall;
    // Variable to hold wall view index
    private int index;



    /**
     * Associate the specified image to the current item.
     *
     * @param item to associate to the room
     * @param walls to associate to the room
     * @param roomNumber to associate to the room
     */
    public Room(Item item, LinkedList walls, int roomNumber)
    {
        itemObject = item;
        this.walls = walls;
        this.roomNumber = roomNumber;
    }
    /**
     * Returns the appropriate wall image according to command
     *
     * @param command selects the next wall left or right
     */
    public Image getWallImage(Controller.Command command) {

        ListIterator<Wall> it = walls.listIterator(index);

        if (command.equals(command.RIGHT)) {

            if(it.hasNext()){
                wall = it.next();
                index = it.nextIndex();
                wall = it.next();
                wall = getWall(index);
                if(!it.hasNext()){
                    index = walls.indexOf(walls.getFirst());
                }

            } else {
                wall = getWall(index);
                index = it.nextIndex();
            }

        } else if (command.equals(command.LEFT)) {

            if (it.hasPrevious()) {
                wall = it.previous();
                index = it.nextIndex();
                wall = getWall(index);
            } else {
                index = walls.indexOf(walls.getLast());
                wall = getWall(index);
            }
        }
         return wall.getWallImage();
    }

    /**
     * Call a specific wall from the walls LinkedList
     *
     * @param index corresponding to the desired wall.
     */
    public Wall getWall(int index) {
        this.index = index;
        wall = (Wall) walls.get(index);
        return wall;
    }

    /**
     * Add an item to the room.
     *
     * @param item to be added
     */
    public void addItem(Item item) {itemObject = item;}

    /**
     * Remove an item from the room.
     *
     */
    public void removeItem() {itemObject = null;}

    /**
     * Return item in the room.
     *
     */
   public Item getItem() {return itemObject;}

    /**
     * Return room number.
     *
     */
    public int currentRoom() {return roomNumber;}

    /**
     * Return current wall.
     *
     */
    public Wall currentWall() {return wall;}

}

