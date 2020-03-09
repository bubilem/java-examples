package knapsackproblem.solution;

import knapsackproblem.item.RatioItem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import knapsackproblem.item.Bag;
import knapsackproblem.item.Items;

public class BetterHungryAlgorithm extends Algorithm {

    List<RatioItem> ratios;

    public BetterHungryAlgorithm(Items items, int capacity) {
        super(items, capacity);
        ratios = new ArrayList<>();
    }

    @Override
    public Bag run() {
        items.getItems().forEach((item) -> {
            ratios.add(new RatioItem(item));
        });
        ratios.sort(Comparator.comparing(RatioItem::getRatio).reversed());
        ratios.forEach((RatioItem ratioItem) -> {
            bag.add(ratioItem.getItem());
        });
        return bag;
    }

}
