package knapsackproblem.item;

import java.util.ArrayList;
import java.util.List;

/**
 * Better IItem list - adapter
 *
 * @author Michal
 */
public class Items {

    private final List<IItem> items;

    public Items() {
        items = new ArrayList<>();
    }

    public void add(IItem item) {
        items.add(item);
    }

    public boolean rem(IItem item) {
        return items.remove(item);
    }

    public IItem rem(int index) {
        return items.remove(index);
    }

    public List<IItem> getItems() {
        return items;
    }

    public IItem getItem(int index) {
        return items.get(index);
    }

    public int count() {
        return items.size();
    }

    public int getTotalPrice() {
        return items.stream().map(IItem::getPrice).reduce(0, Integer::sum);
    }

    public int getTotalWeight() {
        return items.stream().map(IItem::getWeight).reduce(0, Integer::sum);
    }

    public void print() {
        items.forEach((i) -> {
            i.print();
        });
    }

    public void print(String caption) {
        System.out.println(caption);
        print();
    }

}
