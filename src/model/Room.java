package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Room {
    private final String name;
    private final String description;
    private final List<Item> items;
    private final Map<String, Room> exits;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.exits = new HashMap<>();
    }

    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public boolean hasItem(String itemName) {
        return items.stream().anyMatch(item -> item.getName().equalsIgnoreCase(itemName));
    }

    public Item removeItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room: ").append(name).append("\n").append(description).append("\nItems here: ");
        sb.append(items.isEmpty() ? "None" : items.stream().map(Item::getName).reduce((a, b) -> a + ", " + b).orElse(""));
        return sb.toString();
    }
}
