package player;

import model.Item;
import model.Room;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private final List<Item> inventory;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You move " + direction + ".");
        } else {
            System.out.println("You can't go that way!");
        }
    }

    public void pickUpItem(String itemName) {
        Item item = currentRoom.removeItem(itemName);
        if (item != null) {
            inventory.add(item);
            System.out.println("You pick up the " + item.getName() + ".");
        } else {
            System.out.println("No item named " + itemName + " here!");
        }
    }

    public List<String> getInventory() {
        List<String> items = new ArrayList<>();
        for (Item item : inventory) {
            items.add(item.getName());
        }
        return items;
    }
}
