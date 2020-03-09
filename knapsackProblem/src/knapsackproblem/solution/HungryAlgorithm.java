package knapsackproblem.solution;

import knapsackproblem.item.Bag;
import knapsackproblem.item.IItem;
import knapsackproblem.item.Items;

public class HungryAlgorithm extends Algorithm {

    public HungryAlgorithm(Items items, int capacity) {
        super(items, capacity);
    }

    @Override
    public Bag run() {
        items.getItems().forEach((IItem item) -> {
            bag.add(item);
        });
        return bag;
    }

}
