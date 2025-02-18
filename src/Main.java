import controller.MUDController;
import model.Item;
import model.Room;
import player.Player;

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room("Stone Chamber", "A small stone chamber.");
        Room room2 = new Room("Dark Hallway", "A dark and creepy hallway.");
        room1.addExit("forward", room2);
        room1.addItem(new Item("sword"));
        room1.addItem(new Item("shield"));
        Player player = new Player(room1);
        MUDController controller = new MUDController(player);
        controller.runGameLoop();
    }
}
