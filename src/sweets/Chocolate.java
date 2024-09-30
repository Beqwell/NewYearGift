package sweets;

public class Chocolate extends Sweet {
    private String type;

    public Chocolate(String name, double weight, double sugarContent, int calories, String type) {
        super(name, weight, sugarContent, calories);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s | Вага: %.2f г | Цукор: %.2f г | Калорії: %d | Тип: %s",
                getName(), getWeight(), getSugarContent(), getCalories(), type);
    }
}
