package knapsackproblem.item;

import knapsackproblem.item.IItem;

public class RatioItem {

    private final IItem item;

    public RatioItem(IItem item) {
        this.item = item;
    }

    public double getRatio() {
        return item.getPrice() / item.getWeight();
    }

    public IItem getItem() {
        return item;
    }
}
