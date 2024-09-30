package sweets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Gift {
    private List<Sweet> sweets;

    public Gift() {
        sweets = new ArrayList<>();
    }

    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    public double getTotalWeight() {
        return sweets.stream().mapToDouble(Sweet::getWeight).sum();
    }

    public List<Sweet> getSweets() {
        return sweets;
    }

    public void sortBySugarContent() {
        sweets.sort(Comparator.comparingDouble(Sweet::getSugarContent));
    }

    public List<Sweet> findSweetsBySugarRange(double min, double max) {
        List<Sweet> result = new ArrayList<>();
        for (Sweet sweet : sweets) {
            if (sweet.getSugarContent() >= min && sweet.getSugarContent() <= max) {
                result.add(sweet);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Gift{" + "sweets=" + sweets + '}';
    }
}
