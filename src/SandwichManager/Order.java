package SandwichManager;

import java.util.ArrayList;

/**
 * Creates an ArrayList of Orders with various OrderLines
 */
public class Order implements Customizable {
    public static int lineNumber;
    private ArrayList<OrderLine> orderlines;

    public Order(ArrayList<OrderLine> orderlines){
        this.orderlines = new ArrayList<>(0);
        lineNumber = 0;
    }

    /**
     * Runs through orderline to search for the sandwich that needs to be removed
     * @return int which index the item was found at
     */
    public int find(Sandwich s){
        int res = -1; // -1 = not found
        for(int i = 0; i < orderlines.size(); i++){
            if(s.toString().equals(orderlines.get(i).toString())){
                // same element
                return i;
            }
        }
        return res;
    }


    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
