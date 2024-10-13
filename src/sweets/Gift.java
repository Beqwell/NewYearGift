package sweets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Manages a collection of sweets in a gift
public class Gift {
    private List<Sweet> sweets;

    public Gift() {
        sweets = new ArrayList<>();
    }

    // Adds a sweet to the gift
    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    // Calculates total weight
    public double getTotalWeight() {
        return sweets.stream().mapToDouble(Sweet::getWeight).sum();
    }

    public List<Sweet> getSweets() {
        return sweets;
    }

    // Sorts sweets by sugar content
    public void sortBySugarContent() {
        sweets.sort(Comparator.comparingDouble(Sweet::getSugarContent));
    }

    // Finds sweets by sugar range using Stream API
    public List<Sweet> findSweetsBySugarRange(double min, double max) {
        return sweets.stream()
                .filter(sweet -> sweet.getSugarContent() >= min && sweet.getSugarContent() <= max)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Gift{" + "sweets=" + sweets + '}';
    }
}
