package sweets;

// Defines a chocolate sweet
public class Chocolate extends Sweet {
    public enum Type {
        MILK, DARK
    }

    private Type type;

    // Chocolate attributes
    public Chocolate(String name, double weight, double sugarContent, int calories, Type type) {
        super(name, weight, sugarContent, calories);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    // Chocolate details
    @Override
    public String toString() {
        return String.format("%s | Вага: %.2f г | Цукор: %.2f г | Калорії: %d | Тип: %s",
                getName(), getWeight(), getSugarContent(), getCalories(), type);
    }
}
