package sweets;

// Sweet attributes
public abstract class Sweet {
    private String name;
    private double weight;
    private double sugarContent;
    private int calories;

    // Properties
    public Sweet(String name, double weight, double sugarContent, int calories) {
        this.name = name;
        this.weight = weight;
        this.sugarContent = sugarContent;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }
    public double getSugarContent() {
        return sugarContent;
    }
    public int getCalories() {
        return calories;
    }

    // Details
    @Override
    public String toString() {
        return String.format("%s | Вага: %.2f г | Цукор: %.2f г | Калорії: %d",
                name, weight, sugarContent, calories);
    }
}
