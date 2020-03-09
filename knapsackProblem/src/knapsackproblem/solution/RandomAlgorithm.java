package knapsackproblem.solution;

import java.util.Random;
import knapsackproblem.item.Bag;
import knapsackproblem.item.Items;

public class RandomAlgorithm extends Algorithm {

    public RandomAlgorithm(Items items, int capacity) {
        super(items, capacity);
    }

    @Override
    public Bag run() {
        Random rnd = new Random();
        for (int i = 0; i < rnd.nextInt(items.count()); i++) {
            int index = rnd.nextInt(items.count());
            if (!bag.contains(items.getItem(index))) {
                bag.add(items.getItem(index));
            }
        }
        return bag;
    }

}
