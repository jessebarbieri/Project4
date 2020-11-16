/**
 * @author Arya Kulkarni and Jesse Barbieri
 */
package SandwichManager;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit Test Class
 */
class OrderTest {

    Order testOrder = new Order();
    Order testOrder1 = new Order();
    Order testOrder2 = new Order();
    Order testOrder3 = new Order();

    ArrayList<Extra> chickenExtras = new ArrayList<>();
    ArrayList<Extra> beefExtras = new ArrayList<>();
    ArrayList<Extra> fishExtras = new ArrayList<Extra>();
    ArrayList<Extra> fishExrastoLoad = new ArrayList<Extra>();

    // Sandwich with 1 Extra
    Sandwich chickenwithanExtra = new Chicken(chickenExtras);


    // Sandwich for adding 7 extras (should not work)
    Sandwich fishWithExtras = new Fish(fishExrastoLoad);

    Sandwich chicken = new Chicken(chickenExtras);
    Sandwich fish = new Fish(fishExtras);
    Sandwich beef = new Beef(beefExtras);



    @Test
    void getPrice() {
        // Adding each different sandwich with no extras
        testOrder3.add(fish);
        testOrder3.add(chicken);
        testOrder3.add(beef);
        // Compares the total of all three sandwiches with base ingredients to the price of the order
        assertEquals(32.97, testOrder3.getPrice());
        testOrder3.clear();
        // Cleared the order and adding a single sandwich with extras
        beef.extras.add(Extra.American_Cheese);
        beef.extras.add(Extra.Mayo);
        beef.extras.add(Extra.Lettuce);
        testOrder3.add(beef);
        // Comparing the expected price of this sandwich to the order total
        assertEquals(16.96, testOrder3.getPrice());
        testOrder3.clear();
        // After clearing the getPrice() returns 0
        assertEquals(0.00, testOrder3.getPrice());
    }

    @Test
    void getOrders() {
        // This tests the amount of sandwiches in the order after addition
        testOrder.add(chicken);
        assertEquals(1, testOrder.getOrders().length);
        testOrder.add(fish);
        assertEquals(2, testOrder.getOrders().length);
        testOrder.add(beef);
        assertEquals(3,testOrder.getOrders().length);

        // and removal
        testOrder.remove(1);
        assertEquals(2,testOrder.getOrders().length);
        testOrder.remove(1);
        assertEquals(1, testOrder.getOrders().length);
        testOrder.remove(1);
        assertEquals(0,testOrder.getOrders().length);
    }

    @Test
    void add() {
        // Tests adding a sandwich with 1 extra added
        assertTrue(testOrder.add(chickenwithanExtra));
        // Tests adding a sandwich with no extras added
        assertTrue(testOrder.add(beef));

        // Adding extras
        fishWithExtras.extras.add(Extra.Mayo);
        fishWithExtras.extras.add(Extra.Mustard);
        fishWithExtras.extras.add(Extra.Olives);
        fishWithExtras.extras.add(Extra.Red_Onion);
        fishWithExtras.extras.add(Extra.Lettuce);
        fishWithExtras.extras.add(Extra.Cucumbers);
        fishWithExtras.extras.add(Extra.American_Cheese);

        // Unable to add over 6 extras to a sandwich
        assertFalse(fishWithExtras.add(fishWithExtras.extras));
        // Able to add with 6 extras
        assertTrue(testOrder.add(fishWithExtras));
    }

    @Test
    void clear() {
        // Populating testOrder3 with orders
        testOrder3.add(fish);
        testOrder3.add(beef);
        testOrder3.add(chicken);
        // After adding these sandwiches to the order, the size should be 3
        assertEquals(3, testOrder3.getOrders().length);
        testOrder3.clear();
        // After clear method is called, the order size should be 0
        assertEquals(0, testOrder3.getOrders().length);
    }

    @Test
    void addSame() {
        // Add a specific sandwich order with specific extras
        testOrder2.add(fish);
        fish.extras.add(Extra.Lettuce);
        fish.extras.add(Extra.Pickles);
        fish.extras.add(Extra.Mayo);
        assertEquals(1,testOrder2.getOrders().length);
        // Adding the same item as the index given to it
        testOrder2.addSame(0);
        // Testing the order size now
        assertEquals(2, testOrder2.getOrders().length);
        // Seeing if the same order was actually duplicated
        assertEquals("2 Sandwich Type: Fish Price: 18.96 Extras: Lettuce, Pickles, Mayo Basic: Grilled Snapper, Cilantro, Lime", testOrder2.getLine(1));
    }

    @Test
    void getLineNumber() {
        // The purpose of this method is to return the linenumber after a order has been added or removed
        testOrder3.add(chicken);
        assertEquals(1, testOrder3.getLineNumber());
        testOrder3.add(beef);
        testOrder3.add(fish);
        assertEquals(3 ,testOrder3.getLineNumber());
        testOrder3.remove(3);
        assertEquals(2, testOrder3.getLineNumber());
    }

    @Test
    void getLine() {
        // Adding three sandwiches and getting the lines of all three. One of which has a large amount of extras
        testOrder.add(chicken);
        beef.extras.add(Extra.Lettuce);
        beef.extras.add(Extra.Mustard);
        beef.extras.add(Extra.American_Cheese);
        beef.extras.add(Extra.Cucumbers);
        beef.extras.add(Extra.Red_Onion);
        beef.extras.add(Extra.Pickles);
        testOrder.add(beef);
        testOrder.add(fish);
        assertEquals("1 Sandwich Type: Chicken Price: 8.99 Extras:  Basic: Fried Chicken, Spicy Sauce, Pickles", testOrder.getLine(0));
        assertEquals("2 Sandwich Type: Beef Price: 22.93 Extras: Lettuce, Mustard, American_Cheese, Cucumbers, Red_Onion, Pickles Basic: Roast Beef, Provolone Cheese, Mustard", testOrder.getLine(1));
        assertEquals("3 Sandwich Type: Fish Price: 12.99 Extras:  Basic: Grilled Snapper, Cilantro, Lime", testOrder.getLine(2));
    }

    @Test
    void getOLine() {
        // Add a sandwich and see if the line matches the index when the method is called
        testOrder2.add(fish);
        assertEquals("1 Sandwich Type: Fish Price: 12.99 Extras:  Basic: Grilled Snapper, Cilantro, Lime", testOrder2.getOLine(0).toString());
        chicken.extras.add(Extra.American_Cheese);
        chicken.extras.add(Extra.Pickles);
        testOrder2.add(chicken);
        assertEquals("2 Sandwich Type: Chicken Price: 12.97 Extras: American_Cheese, Pickles Basic: Fried Chicken, Spicy Sauce, Pickles", testOrder2.getOLine(1).toString());
        testOrder2.add(beef);
        assertEquals("3 Sandwich Type: Beef Price: 10.99 Extras:  Basic: Roast Beef, Provolone Cheese, Mustard", testOrder2.getOLine(2).toString());
    }

    @Test
    void remove() {
        // Added a chicken sandwich, removed it, and added a fish sandwich. The correct output shows for the first index.
        testOrder1.add(chicken);
        testOrder1.remove(1);
        testOrder1.add(fish);
        assertEquals("1 Sandwich Type: Fish Price: 12.99 Extras:  Basic: Grilled Snapper, Cilantro, Lime",testOrder1.getLine(0));
        assertTrue(testOrder1.remove(1));
        testOrder1.add(beef);
        assertEquals("1 Sandwich Type: Beef Price: 10.99 Extras:  Basic: Roast Beef, Provolone Cheese, Mustard", testOrder1.getLine(0));
        assertTrue(testOrder1.remove(1));
        // After final removal size of the orders should be 0
        assertEquals(0,testOrder1.getOrders().length);
    }

    @Test
    void reorder() {

        // This part shows the current orders numbers
        testOrder2.add(chicken);
        assertEquals(1, testOrder2.getLineNumber());
        testOrder2.add(beef);
        assertEquals(2, testOrder2.getLineNumber());
        testOrder2.add(fish);
        assertEquals(3, testOrder2.getLineNumber());

        // This is the line of the last sandwich, after reorder, the line number changes and this order becomes the 2nd
        assertEquals("3 Sandwich Type: Fish Price: 12.99 Extras:  Basic: Grilled Snapper, Cilantro, Lime", testOrder2.getLine(2));

        // Remove the middle sandwich of with a line number of 2
        testOrder2.remove(1);

        testOrder2.reorder();
        // The same sandwich from above now has a linenumber of 2, where the beef sandwich was removed
        assertEquals("2 Sandwich Type: Fish Price: 12.99 Extras:  Basic: Grilled Snapper, Cilantro, Lime", testOrder2.getLine(1));
    }
}