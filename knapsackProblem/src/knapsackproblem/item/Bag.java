package knapsackproblem.item;

public class Bag {

    protected Items items;
    protected int capacity;

    public Bag(int capacity) {
        items = new Items();
        this.capacity = capacity;
    }

    public void add(IItem item) {
        if (items.getTotalWeight() + item.getWeight() <= capacity) {
            items.add(item);
        }
    }

    public Items getItems() {
        return items;
    }

    public boolean contains(IItem item) {
        return items.getItems().contains(item);
    }

    public int getCapacity() {
        return capacity;
    }

    public void print() {
        System.out.println("*Bag*");
        items.print();
        System.out.println("*Summary*");
        System.out.println("Total price:\t" + items.getTotalPrice());
        System.out.println("Total weight:\t" + items.getTotalWeight());
        System.out.println("Capacity:\t" + capacity);
    }

    public void print(String title) {
        System.out.println("\n" + title);
        print();
    }

}
