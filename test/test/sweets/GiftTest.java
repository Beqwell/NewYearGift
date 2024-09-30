package test.sweets;

import sweets.Gift;
import sweets.Sweet;
import sweets.Chocolate;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GiftTest {

    @Test
    void testGetTotalWeight() {
        Gift gift = new Gift();
        Sweet chocolate1 = new Chocolate("Mars", 50, 30, 250, "Milk");
        Sweet chocolate2 = new Chocolate("Snickers", 60, 35, 280, "Dark");

        gift.addSweet(chocolate1);
        gift.addSweet(chocolate2);

        // Check total weight
        assertEquals(110, gift.getTotalWeight(), 0.01);
    }

    @Test
    void testAddSweets() {
        Gift gift = new Gift();
        Sweet chocolate1 = new Chocolate("Mars", 50, 30, 250, "Milk");
        Sweet chocolate2 = new Chocolate("Twix", 40, 25, 210, "Milk");

        gift.addSweet(chocolate1);
        gift.addSweet(chocolate2);

        // Check the number of sweets in the gift
        assertEquals(2, gift.getSweets().size());
        assertTrue(gift.getSweets().contains(chocolate1));
        assertTrue(gift.getSweets().contains(chocolate2));
    }

    @Test
    void testSortBySugarContent() {
        Gift gift = new Gift();
        Sweet chocolate1 = new Chocolate("Mars", 50, 30, 250, "Milk");
        Sweet chocolate2 = new Chocolate("Snickers", 60, 35, 280, "Dark");
        Sweet chocolate3 = new Chocolate("Twix", 40, 25, 210, "Milk");

        gift.addSweet(chocolate1);
        gift.addSweet(chocolate2);
        gift.addSweet(chocolate3);

        // Sort by sugar content
        gift.sortBySugarContent();

        // Check the sorting order
        List<Sweet> sortedSweets = gift.getSweets();
        assertEquals(chocolate3, sortedSweets.get(0));  // Lowest sugar content (Twix)
        assertEquals(chocolate1, sortedSweets.get(1));  // Mars
        assertEquals(chocolate2, sortedSweets.get(2));  // Highest sugar content (Snickers)
    }

    @Test
    void testFindSweetsBySugarRange() {
        Gift gift = new Gift();
        Sweet chocolate1 = new Chocolate("Mars", 50, 30, 250, "Milk");
        Sweet chocolate2 = new Chocolate("Snickers", 60, 35, 280, "Dark");
        Sweet chocolate3 = new Chocolate("Twix", 40, 25, 210, "Milk");

        gift.addSweet(chocolate1);
        gift.addSweet(chocolate2);
        gift.addSweet(chocolate3);

        // Check finding sweets by sugar range
        List<Sweet> sweetsInRange = gift.findSweetsBySugarRange(26, 36);
        assertEquals(2, sweetsInRange.size());
        assertTrue(sweetsInRange.contains(chocolate1));  // Mars (30)
        assertTrue(sweetsInRange.contains(chocolate2));  // Snickers (35)
    }

    @Test
    void testEmptyGift() {
        Gift gift = new Gift();

        // Check that an empty gift has a weight of 0
        assertEquals(0, gift.getTotalWeight(), 0.01);

        // Check that finding sweets by sugar content in an empty gift returns nothing
        List<Sweet> sweetsInRange = gift.findSweetsBySugarRange(20, 40);
        assertEquals(0, sweetsInRange.size());
    }
}
