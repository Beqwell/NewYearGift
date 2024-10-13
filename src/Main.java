import java.util.*;
import sweets.*;

// Main application class for managing the gift
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Gift gift = new Gift();

    // Main loop for menu options
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("===== Новорічний подарунок =====");
            System.out.println("1. Створити цукерку");
            System.out.println("2. Показати всі цукерки");
            System.out.println("3. Підрахувати загальну вагу подарунка");
            System.out.println("4. Відсортувати цукерки за вмістом цукру");
            System.out.println("5. Знайти цукерки за вмістом цукру");
            System.out.println("6. Додати кілька цукерок автоматично");
            System.out.println("7. Вийти");
            System.out.print("Оберіть дію: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createCandy();
                    break;
                case 2:
                    showAllCandies();
                    break;
                case 3:
                    calculateTotalWeight();
                    break;
                case 4:
                    sortCandiesBySugar();
                    break;
                case 5:
                    findCandiesBySugar();
                    break;
                case 6:
                    addMultipleCandies();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Неправильний вибір");
            }
        }
    }

    // Creates a new candy and adds it to the gift
    private static void createCandy() {
        System.out.print("Введіть назву цукерки: ");
        String name = scanner.next();
        System.out.print("Введіть вагу: ");
        double weight = scanner.nextDouble();
        System.out.print("Введіть вміст цукру: ");
        double sugarContent = scanner.nextDouble();
        System.out.print("Введіть калорійність: ");
        int calories = scanner.nextInt();
        System.out.print("Введіть тип шоколаду (Milk/Dark): ");
        String typeInput = scanner.next();
        Chocolate.Type type;
        try {
            // Convert user input to Chocolate type and handle invalid input
            type = Chocolate.Type.valueOf(typeInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Неправильний тип шоколаду. Використовуйте Milk або Dark.");
            return;
        }
        Sweet candy = new Chocolate(name, weight, sugarContent, calories, type);
        gift.addSweet(candy);

        System.out.println("Цукерка додана до подарунка.");
    }

    // Displays all candies in the gift
    private static void showAllCandies() {
        if (gift.getSweets().isEmpty()) {
            System.out.println("Подарунок порожній.");
        } else {
            System.out.println("Цукерки в подарунку:");
            for (Sweet sweet : gift.getSweets()) {
                System.out.println(sweet);
            }
        }
    }

    // Displays total weight of the gift
    private static void calculateTotalWeight() {
        System.out.println("Загальна вага подарунка: " + gift.getTotalWeight() + " грам.");
    }

    // Sorts candies by sugar and shows them
    private static void sortCandiesBySugar() {
        gift.sortBySugarContent();
        System.out.println("Цукерки відсортовані за вмістом цукру.");
        showAllCandies();
    }

    // Finds candies by sugar range
    private static void findCandiesBySugar() {
        System.out.print("Введіть мінімальний вміст цукру: ");
        double minSugar = scanner.nextDouble();
        System.out.print("Введіть максимальний вміст цукру: ");
        double maxSugar = scanner.nextDouble();

        List<Sweet> foundCandies = gift.findSweetsBySugarRange(minSugar, maxSugar);
        if (foundCandies.isEmpty()) {
            System.out.println("Цукерки з таким вмістом цукру не знайдено.");
        } else {
            System.out.println("Знайдено цукерки:");
            for (Sweet sweet : foundCandies) {
                System.out.println(sweet);
            }
        }
    }

    // Adds predefined candies automatically
    private static void addMultipleCandies() {
        Sweet chocolate1 = new Chocolate("Mars", 50, 31, 250, Chocolate.Type.MILK);
        Sweet chocolate2 = new Chocolate("Snickers", 60, 35, 280, Chocolate.Type.DARK);
        Sweet chocolate3 = new Chocolate("Twix", 44, 21, 310, Chocolate.Type.MILK);
        Sweet chocolate4 = new Chocolate("Bounty", 55, 33, 260, Chocolate.Type.MILK);

        gift.addSweet(chocolate1);
        gift.addSweet(chocolate2);
        gift.addSweet(chocolate3);
        gift.addSweet(chocolate4);
        System.out.println("Кілька цукерок додано автоматично.");
    }
}
