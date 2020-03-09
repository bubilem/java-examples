package karelcli;

import java.util.ArrayList;
import java.util.List;

public class Playground {

    public static final int MAX_X = 10;
    public static final int MAX_Y = 6;

    private List<Item> items;
    private Karel karel;

    public Playground() {
        items = new ArrayList<>();
        karel = new Karel('J');
    }

    public boolean karelInRange() {
        return karel.getCoordinates().getX() >= 0
                && karel.getCoordinates().getX() < MAX_X
                && karel.getCoordinates().getY() > 0
                && karel.getCoordinates().getY() < MAX_Y;
    }

    public void doIt(Command cmd) throws Exception {
        switch (cmd.get()) {
            case "show":
                show();
                break;
            case "krok":
                Coordinates OriginCoords = new Coordinates(karel.getCoordinates());
                karel.step();
                if (!karelInRange()) {
                    karel.setCoordinates(OriginCoords);
                }
                break;
            case "vlevobok":
                karel.turnLeft();
                break;
            case "poloz":
                items.add(new Item('*', new Coordinates(karel.getCoordinates())));
                break;
            case "reset":
                items.clear();
                karel.getCoordinates().setX(0);
                karel.getCoordinates().setY(0);
                karel.setValue('J');
                break;
            default:
                throw new Exception("Unknown command!");
        }
    }

    public void show() {
        char kChar, iChar;
        for (int y = 0; y < MAX_Y; y++) {
            for (int x = 0; x < MAX_X; x++) {
                if (new Coordinates(x, y).equals(karel.getCoordinates())) {
                    kChar = karel.getValue();
                } else {
                    kChar = '-';
                }
                iChar = '-';
                for (Item item : items) {
                    if (new Coordinates(x, y).equals(item.getCoordinates())) {
                        iChar = item.getValue();
                        break;
                    }
                }
                System.out.print(String.valueOf(kChar) + String.valueOf(iChar) + " ");
            }
            System.out.print("\n");
        }
    }

}
