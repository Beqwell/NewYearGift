import java.util.*;

import sweets.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Gift gift = new Gift();

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
                    System.out.println("Вихід...");
                    break;
                default:
                    System.out.println("Неправильний вибір, спробуйте знову.");
            }
        }
    }

    private static void createCandy() {
        System.out.print("Введіть назву цукерки: ");
        String name = scanner.next();

        System.out.print("Введіть вагу (г): ");
        double weight = scanner.nextDouble();

        System.out.print("Введіть вміст цукру (г): ");
        double sugarContent = scanner.nextDouble();

        System.out.print("Введіть калорійність: ");
        int calories = scanner.nextInt();

        System.out.print("Введіть тип шоколаду (Milk/Dark): ");
        String type = scanner.next();

        Sweet candy = new Chocolate(name, weight, sugarContent, calories, type);
        gift.addSweet(candy);

        System.out.println("Цукерка додана до подарунка.");
    }

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

    private static void calculateTotalWeight() {
        System.out.println("Загальна вага подарунка: " + gift.getTotalWeight() + " грам.");
    }

    private static void sortCandiesBySugar() {
        gift.sortBySugarContent();
        System.out.println("Цукерки відсортовані за вмістом цукру.");
        showAllCandies();
    }

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

    private static void addMultipleCandies() {
        Sweet chocolate1 = new Chocolate("Mars", 50, 31, 250, "Milk");
        Sweet chocolate2 = new Chocolate("Snickers", 60, 35, 280, "Dark");
        Sweet chocolate3 = new Chocolate("Twix", 44, 21, 310, "Milk");
        Sweet chocolate4 = new Chocolate("Bounty", 55, 33, 260, "Milk");

        gift.addSweet(chocolate1);
        gift.addSweet(chocolate2);
        gift.addSweet(chocolate3);
        gift.addSweet(chocolate4);

        System.out.println("Кілька цукерок додано автоматично.");
    }
}
