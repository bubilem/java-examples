 package knapsackproblem.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import knapsackproblem.item.Bag;
import knapsackproblem.item.Items;
import knapsackproblem.item.RatioItem;

public class GeneticGeneration {

    private int generationSize = 50;

    private List<Bag> bags;
    private List<RatioItem> ratios;

    public GeneticGeneration(Items items, int generationSize) {
        ratios = new ArrayList<>();
        items.getItems().forEach((item) -> {
            ratios.add(new RatioItem(item));
        });
        ratios.sort(Comparator.comparing(RatioItem::getRatio).reversed());

        bags = new ArrayList<>();
        this.generationSize = generationSize;
    }

    public void add(Bag bag) {
        if (bags.size() < generationSize) {
            bags.add(bag);
        }
    }

    public void randomFill(int capacity) {
        Random rnd = new Random();
        for (int i = bags.size(); i < generationSize; i++) {
            Bag rndBag = new Bag(capacity);
            for (int j = 0; j < rnd.nextInt(ratios.size()); j++) {
                int index = rnd.nextInt(ratios.size());
                if (!rndBag.contains(ratios.get(index).getItem())) {
                    rndBag.add(ratios.get(index).getItem());
                }
            }
            add(rndBag);
        }
    }

    public void remBadBags(int count) {
        for (int i = 0; i < count; i++) {
            if (bags.isEmpty()) {
                break;
            }
            bags.remove(findTheWorst());
        }
    }

    public Bag findTheWorst() {
        if (bags.isEmpty()) {
            return null;
        }
        Bag worstBag = bags.get(0);
        if (bags.size() > 1) {
            for (int i = 1; i < bags.size(); i++) {
                if (bags.get(i).getItems().getTotalPrice() < worstBag.getItems().getTotalPrice()) {
                    worstBag = bags.get(i);
                }
            }
        }
        return worstBag;
    }

    public Bag findTheBest() {
        if (bags.isEmpty()) {
            return null;
        }
        Bag bestBag = bags.get(0);
        if (bags.size() > 1) {
            for (int i = 1; i < bags.size(); i++) {
                if (bags.get(i).getItems().getTotalPrice() > bestBag.getItems().getTotalPrice()) {
                    bestBag = bags.get(i);
                }
            }
        }
        return bestBag;
    }

    public int getAvgPrice() {
        if (bags.isEmpty()) {
            return 0;
        }
        int sumPrice = 0;
        for (int i = 1; i < bags.size(); i++) {
            sumPrice += bags.get(i).getItems().getTotalPrice();
        }
        return sumPrice / bags.size();
    }

    public void hybridize(int count) {
        Random rnd = new Random();
        int max = bags.size() - 1;
        for (int i = 0; i < count; i++) {
            if (bags.size() >= generationSize) {
                break;
            }
            add(makeHybride(bags.get(rnd.nextInt(max)), bags.get(rnd.nextInt(max))));
        }
    }

    private Bag makeHybride(Bag parent1, Bag parent2) {
        Bag b = new Bag(parent1.getCapacity());
        for (RatioItem ri : ratios) {
            if (parent1.contains(ri.getItem()) || parent2.contains(ri.getItem())) {
                b.add(ri.getItem());
            }
        }
        return b;
    }

}
