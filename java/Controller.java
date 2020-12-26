// IPPO Assignment 2, Version 0.1, 28/11/2020


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.util.*;

/**
 * Application controller Class -
 *
 * @author Olivier Chaligne &lt;s2137159@ed.ac.uk&gt;
 * @version 0.1, 28/11/2020
 */

public class Controller {

    @FXML private Button ButtonLeft;
    @FXML private Button ButtonRight;
    @FXML private Button ButtonDoor;
    @FXML private Button PickItem;
    @FXML private Button PutItem;
    @FXML private ImageView RoomView;
    @FXML private ImageView ItemView;

    // Variable to store carried item
    private Item basket;
    // Variable to store the current room
    private Room currentRoom;
    // Variable to store the next room to load
    private Room nextRoom;
    // Variable to store a view index
    private int viewIndex;
    // Maps to store the relations between the rooms and doors
    private HashMap<Room,Room> floorPlan;
    private HashMap<Room,Integer>roomViewPlan;
    private HashMap<Wall,Room> corridorPlan;
    private HashMap<Wall,Room> room3Plan;
    private HashMap<Room, Integer> room3PlanView;
    //LinkedList to store the walls in a room
    private LinkedList<Wall> walls;


    /**
     * Initialise the items, walls, rooms and the first view.
     *
     */
    public void initialisation()
    {
        Image image1 = new Image("/items/cat.png");
        Image image2 = new Image("/items/egg.png");
        Image image3 = new Image("/items/basket.png");
        Item item1 = new Item(image1);
        Item item2 = new Item(image2);
        Item item3 = new Item(image3);

        Image ImgWall1 = new Image("/rooms/room0N.jpg");
        Image ImgWall2 = new Image("/rooms/room0E.jpg");
        Image ImgWall3 = new Image("/rooms/room0S.jpg");
        Image ImgWall4 = new Image("/rooms/room0W.jpg");
        Image ImgWall5 = new Image("/rooms/room0W2.jpg");
        Image ImgWall6 = new Image("/rooms/room1N.jpg");
        Image ImgWall7 = new Image("/rooms/room1E.jpg");
        Image ImgWall8 = new Image("/rooms/room1S.jpg");
        Image ImgWall9 = new Image("/rooms/room1W.jpg");
        Image ImgWall10 = new Image("/rooms/room2N.jpg");
        Image ImgWall11 = new Image("/rooms/room2E.jpg");
        Image ImgWall12 = new Image("/rooms/room2S.jpg");
        Image ImgWall13 = new Image("/rooms/room2W.jpg");
        Image ImgWall14 = new Image("/rooms/room3N.jpg");
        Image ImgWall15 = new Image("/rooms/room3E.jpg");
        Image ImgWall16 = new Image("/rooms/room3S.jpg");
        Image ImgWall17 = new Image("/rooms/room3W.jpg");
        Image ImgWall18 = new Image("/rooms/room4N.jpg");
        Image ImgWall19 = new Image("/rooms/room4S.jpg");
        Image ImgWall20 = new Image("/rooms/room5N.jpg");
        Image ImgWall21 = new Image("/rooms/room5E.jpg");
        Image ImgWall22 = new Image("/rooms/room5S.jpg");
        Image ImgWall23 = new Image("/rooms/room5W.jpg");

        Wall wall1 = new Wall(ImgWall1,true);
        Wall wall2 = new Wall(ImgWall2,true);
        Wall wall3 = new Wall(ImgWall3,false);
        Wall wall4 = new Wall(ImgWall4,true);
        Wall wall5 = new Wall(ImgWall5,true);
        Wall wall6 = new Wall(ImgWall6,false);
        Wall wall7 = new Wall(ImgWall7,false);
        Wall wall8 = new Wall(ImgWall8,true);
        Wall wall9 = new Wall(ImgWall9,false);
        Wall wall10 = new Wall(ImgWall10,false);
        Wall wall11 = new Wall(ImgWall11,false);
        Wall wall12 = new Wall(ImgWall12,true);
        Wall wall13 = new Wall(ImgWall13,false);
        Wall wall14 = new Wall(ImgWall14,false);
        Wall wall15 = new Wall(ImgWall15,false);
        Wall wall16 = new Wall(ImgWall16,true);
        Wall wall17 = new Wall(ImgWall17,true);
        Wall wall18 = new Wall(ImgWall18,false);
        Wall wall19 = new Wall(ImgWall19,true);
        Wall wall20 = new Wall(ImgWall20,false);
        Wall wall21 = new Wall(ImgWall21,false);
        Wall wall22 = new Wall(ImgWall22,true);
        Wall wall23 = new Wall(ImgWall23,false);

        walls = new LinkedList<>();
        walls.add(0,wall1);
        walls.add(1,wall2);
        walls.add(2,wall3);
        walls.add(3,wall4);
        walls.add(4,wall5);
        Room room0 = new Room(item1,walls,0);

        walls = new LinkedList<>();
        walls.add(0,wall6);
        walls.add(1,wall7);
        walls.add(2,wall8);
        walls.add(3,wall9);
        Room room1 = new Room(item2,walls,1);

        walls = new LinkedList<>();
        walls.add(0,wall10);
        walls.add(1,wall11);
        walls.add(2,wall12);
        walls.add(3,wall13);
        Room room2 = new Room(null,walls,2);

        walls = new LinkedList<>();
        walls.add(0,wall14);
        walls.add(1,wall15);
        walls.add(2,wall16);
        walls.add(3,wall17);
        Room room3 = new Room(item3,walls,3);

        walls = new LinkedList<>();
        walls.add(0,wall18);
        walls.add(1,wall19);
        Room room4 = new Room(null,walls,4);

        walls = new LinkedList<>();
        walls.add(0,wall20);
        walls.add(1,wall21);
        walls.add(2,wall22);
        walls.add(3,wall23);
        Room room5 = new Room(null,walls,5);

        floorPlan = new HashMap<>();
        floorPlan.put(room1,room0);
        floorPlan.put(room2,room0);
        floorPlan.put(room3,room0);
        floorPlan.put(room4,room0);
        floorPlan.put(room5,room3);

        roomViewPlan = new HashMap<>();
        roomViewPlan.put(room1,0);
        roomViewPlan.put(room2,1);
        roomViewPlan.put(room3,4);
        roomViewPlan.put(room4,2);
        roomViewPlan.put(room5,1);

        room3Plan = new HashMap<>();
        room3Plan.put(wall17,room5);
        room3Plan.put(wall16,room0);

        room3PlanView = new HashMap<>();
        room3PlanView.put(room5,0);
        room3PlanView.put(room0,4);

        corridorPlan = new HashMap<>();
        corridorPlan.put(wall1,room4);
        corridorPlan.put(wall2,room3);
        corridorPlan.put(wall3,null);
        corridorPlan.put(wall4,room1);
        corridorPlan.put(wall5,room2);

        //Start in room 0 main hub
        currentRoom = room0;
        showImage(currentRoom.getWall(0).getWallImage());
        showCurrentItems();

    }
    /**
     * Handling of the GUI button events: turn left or right,
     * go through a door, pick or put an item from/in a room.
     */
    public enum Command
    {
        RIGHT, LEFT
    }

    public void leftClicked()
   {
       Command command = Command.LEFT;
       Image wallImage = currentRoom.getWallImage(command);
       showImage(wallImage);
    }

    public void rightClicked()
    {
        Command command = Command.RIGHT;
        Image wallImage = currentRoom.getWallImage(command);
        showImage(wallImage);
    }

    public void doorClicked() {

        Wall wall = currentRoom.currentWall();
        if (wall.hasDoor()) {
            ItemView.setImage(null);
            if (currentRoom.currentRoom() == 0) {
                nextRoom = corridorPlan.get(wall);
                viewIndex = 0;

            } else if (currentRoom.currentRoom() == 3) {
                nextRoom = room3Plan.get(wall);
                viewIndex = room3PlanView.get(nextRoom);

            } else {
                nextRoom = floorPlan.get(currentRoom);
                viewIndex = roomViewPlan.get(currentRoom);

            }
            currentRoom = nextRoom;
            wall = currentRoom.getWall(viewIndex);
            Image wallImage = wall.getWallImage();
            showImage(wallImage);
            showCurrentItems();
        }
    }

    public void pickItem()
    {
        if (currentRoom.getItem() != null && basket == null) {
            basket = currentRoom.getItem();
            currentRoom.removeItem();
            setItemsInRoom(null);
        }
    }

    public void putItem()
    {
        if (currentRoom.getItem() == null) {
            currentRoom.addItem(basket);
            basket = null;
            showCurrentItems();
        }
    }

    /**
     * Display the image of an item stored in a room.
     *
     */
    public void showCurrentItems()
    {
        if (currentRoom.getItem() != null){
            Item itemInRoom = currentRoom.getItem();
            Image itemImage = itemInRoom.getItemImage();
            setItemsInRoom(itemImage);
        }
     }

    /**
     * Display the specified wall image in the ImageView.
     *
     * @param image the name of the selected item
     */
    public void showImage(Image image)
    {
        RoomView.setImage(image);
    }

    /**
     * Display the specified item image in the ItemView.
     *
     * @param itemImage the image associated to the selected item
     */
    public void setItemsInRoom(Image itemImage)
    {
        ItemView.setImage(itemImage);
    }

}