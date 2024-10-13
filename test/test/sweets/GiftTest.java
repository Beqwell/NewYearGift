package test.sweets;

import sweets.Gift;
import sweets.Sweet;
import sweets.Chocolate;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

// Tests for Gift class
class GiftTest {

    // Test for total weight calculation
    @Test
    void testGetTotalWeight() {
        Gift gift = new Gift();
        Sweet chocolate1 = new Chocolate("Mars", 50, 30, 250, "Milk");
        Sweet chocolate2 = new Chocolate("Snickers", 60, 35, 280, "Dark");
        gift.addSweet(chocolate1);
        gift.addSweet(chocolate2);
        assertEquals(110, gift.getTotalWeight(), 0.01);
    }

    // Test for adding sweets
    @Test
    void testAddSweets() {
        Gift gift = new Gift();
        Sweet chocolate1 = new Chocolate("Mars", 50, 30, 250, "Milk");
        Sweet chocolate2 = new Chocolate("Twix", 40, 25, 210, "Milk");
        gift.addSweet(chocolate1);
        gift.addSweet(chocolate2);
        assertEquals(2, gift.getSweets().size());
        assertTrue(gift.getSweets().contains(chocolate1));
        assertTrue(gift.getSweets().contains(chocolate2));
    }

    // Test for sorting by sugar content
    @Test
    void testSortBySugarContent() {
        Gift gift = new Gift();
        Sweet chocolate1 = new Chocolate("Mars", 50, 30, 250, "Milk");
        Sweet chocolate2 = new Chocolate("Snickers", 60, 35, 280, "Dark");
        Sweet chocolate3 = new Chocolate("Twix", 40, 25, 210, "Milk");
        gift.addSweet(chocolate1);
        gift.addSweet(chocolate2);
        gift.addSweet(chocolate3);
        gift.sortBySugarContent();
        List<Sweet> sortedSweets = gift.getSweets();
        assertEquals(chocolate3, sortedSweets.get(0));
        assertEquals(chocolate1, sortedSweets.get(1));
        assertEquals(chocolate2, sortedSweets.get(2));
    }

    // Test for finding sweets in sugar range
    @Test
    void testFindSweetsBySugarRange() {
        Gift gift = new Gift();
        Sweet chocolate1 = new Chocolate("Mars", 50, 30, 250, "Milk");
        Sweet chocolate2 = new Chocolate("Snickers", 60, 35, 280, "Dark");
        Sweet chocolate3 = new Chocolate("Twix", 40, 25, 210, "Milk");
        gift.addSweet(chocolate1);
        gift.addSweet(chocolate2);
        gift.addSweet(chocolate3);
        List<Sweet> sweetsInRange = gift.findSweetsBySugarRange(26, 36);
        assertEquals(2, sweetsInRange.size());
        assertTrue(sweetsInRange.contains(chocolate1));
        assertTrue(sweetsInRange.contains(chocolate2));
    }

    // Test for an empty gift
    @Test
    void testEmptyGift() {
        Gift gift = new Gift();
        assertEquals(0, gift.getTotalWeight(), 0.01);
        assertEquals(0, gift.getSweets().size());
    }
}
