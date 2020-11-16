package SandwichManager;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Order testOrder = new Order();
    Order testOrder1 = new Order();
    Order testOrder2 = new Order();
    Order testOrder3 = new Order();


    ArrayList<Extra> chickenExtras = new ArrayList<Extra>(Collections.singleton(Extra.Olives));
    ArrayList<Extra> beefExtras = new ArrayList<>();
    ArrayList<Extra> fishExras = new ArrayList<Extra>();

    // Sandwich with 1 Extra
    Sandwich chicken = new Chicken(chickenExtras);


    // Sandwich with 7 extras (should not work)
    Sandwich fish = new Fish(fishExras);
   // Sandwich fish1 = new Fish(null);
    Sandwich beef = new Beef(beefExtras);
   // Sandwich beef1 = new Beef(null);


    @Test
    void getPrice() {
    }

    @Test
    void getOrders() {
        // This tests the amount of sandwiches in the order
        testOrder.add(chicken);
        assertEquals(1, testOrder.getOrders().length);
        testOrder.add(fish);
        assertEquals(2, testOrder.getOrders().length);
        testOrder.add(beef);
        assertEquals(3,testOrder.getOrders().length);

        // Works with remove too
        testOrder.remove(1);
        assertEquals(2,testOrder.getOrders().length);
    }

    @Test
    void add() {
        // Tests adding a sandwich with 1 extra added
        assertTrue(testOrder.add(chicken));
        // Tests adding a sandwich with no extras added
        assertTrue(testOrder.add(beef));

        fish.extras.add(Extra.Mayo);
        fish.extras.add(Extra.Mustard);
        fish.extras.add(Extra.Olives);
        fish.extras.add(Extra.Red_Onion);
        fish.extras.add(Extra.Lettuce);
        fish.extras.add(Extra.Cucumbers);
        fish.extras.add(Extra.American_Cheese);

        // Unable to add over 6 extras to a sandwich
        assertFalse(fish.add(fish.extras));
        // Able to add with 6 extras, the error checking for that is done in the sandwich subclasses
        assertTrue(testOrder.add(fish));
    }

    @Test
    void clear() {
    }

    @Test
    void addSame() {
    }

    @Test
    void getLineNumber() {
    }

    @Test
    void getLine() {
    }

    @Test
    void getOLine() {
    }

    @Test
    void remove() {

        // Added a chicken sandwich, removed it, and added a fish sandwich. The correct output shows for the first index.
        testOrder1.add(chicken);
        testOrder1.remove(1);
        testOrder1.add(fish);
        assertEquals("1 Sandwich Type: Fish Price: 12.99 Extras: ",testOrder1.getLine(0));

    }

    @Test
    void reorder() {
    }
}