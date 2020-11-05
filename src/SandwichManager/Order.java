package SandwichManager;

import java.util.ArrayList;

/**
 * Creates an ArrayList of Orders with various OrderLines
 */
public class Order implements Customizable {
    public static int lineNumber;
    private ArrayList<OrderLine> orderlines;

    public Order(){
        this.orderlines = new ArrayList<>(0);
        lineNumber = 0;
    }

    /**
     * Runs through orderline to search for the sandwich that needs to be removed
     * @return res which index the item was found at
     */
    public int find(Object s){
        int res = -1; // -1 = not found
        for(int i = 0; i < orderlines.size(); i++){
            if(s.toString().equals(orderlines.get(i).toString())){
                // same element
                return i;
            }
        }
        return res;
    }

    /**
     * Adds sandwiches to the order -- INCOMPLETE
     * @param obj any object of Sandwich
     * @return res if added or not
     */
    @Override
    public boolean add(Object obj) {
        boolean res = false;
        if(obj instanceof Fish){
            // fish
            if(find(obj) != -1){
                System.out.println("Added Sandwich");
                res = true;
            }


        }else if(obj instanceof Chicken){
            // chicken
            if(find(obj) != -1){
                System.out.println("Added Sandwich");
                res = true;
            }

        }else if(obj instanceof Beef){
            // beef
            if(find(obj) != -1){
                System.out.println("Added Sandwich");
                res = true;
            }

        }else{
            System.out.println("This is not a sandwich. Please, try again.");
        }

        return res;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
