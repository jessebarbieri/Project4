package SandwichManager;

import java.util.ArrayList;

public class Order implements Customizable {
    public static int lineNumber;
    private ArrayList<OrderLine> orderlines;

    public Order(ArrayList<OrderLine> orderlines){
        this.orderlines = new ArrayList<>(0);
        lineNumber = 0;
    }

    /**
     * Runs through orderline to search for the sandwich that needs to be removed
     * @return boolean whether or not the sandwich has been found
     */
    public boolean find(Sandwich s){
        return false;
    }

    /**
     * Gets linenumber (order number)
     * @return int the order number
     */
    public int getLineNumber(){
        lineNumber = lineNumber + 1;
        return lineNumber;
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
