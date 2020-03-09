package knapsackproblem.solution;

import knapsackproblem.item.Bag;
import knapsackproblem.item.Items;

public class GeneticAlgorithm extends Algorithm {

    private static final int BAGS_IN_GENERATION = 60;
    private static final int GENERATION_COUNT = 5000;

    public GeneticAlgorithm(Items items, int capacity) {
        super(items, capacity);
    }

    @Override
    public Bag run() {
        System.out.println("id\tavg\tbest");
        GeneticGeneration generation = new GeneticGeneration(items, BAGS_IN_GENERATION);
        generation.randomFill(bag.getCapacity());
        int badTimes = 0;
        double lastAvgPrice = 0;
        for (int g = 1; g <= GENERATION_COUNT; g++) {
            generation.remBadBags(15);
            generation.hybridize(10);
            generation.randomFill(bag.getCapacity());
            if (generation.getAvgPrice() <= lastAvgPrice + 100) {
                badTimes++;
            } else {
                badTimes -= 5;
            }
            badTimes = (badTimes <= 0) ? 0 : badTimes;
            if (badTimes > 100 && g < GENERATION_COUNT - (GENERATION_COUNT/4)) {
                generation.remBadBags((int) (BAGS_IN_GENERATION / 2));
                generation.hybridize(10);
                generation.randomFill(bag.getCapacity());
                badTimes = 0;
                System.out.print("HOT ");
            }
            //System.out.print(badTimes + " ");
            //System.out.println(g + "\t" + generation.getAvgPrice() + "\t" + generation.findTheBest().getItems().getTotalPrice());
            lastAvgPrice = generation.getAvgPrice();
        }
        System.out.print("\n");
        bag = generation.findTheBest();
        return bag;
    }

}
